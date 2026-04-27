package com.auction.server.service;

import com.auction.server.dao.DataStore;
import com.auction.server.dao.FileDataStore;
import com.auction.server.dao.SystemSnapshot;
import com.auction.shared.dto.UserSession;
import com.auction.shared.exception.AuthenticationException;
import com.auction.shared.model.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AuctionManager {
    private static volatile AuctionManager instance = null;

    private DataStore dataStore;
    private SystemSnapshot snapshot;

    private AuctionManager() {
        this.dataStore = new FileDataStore();
        this.snapshot = dataStore.load();
    }

    public static AuctionManager getInstance() {
        if (instance == null) {
            synchronized (AuctionManager.class) {
                if (instance == null) {
                    instance = new AuctionManager();
                }
            }
        }
        return instance;
    }

    private void saveData() {
        dataStore.save(snapshot);
    }

    public synchronized void register(String username, String password, String displayName, UserRole role) throws AuthenticationException {
        for (User user : snapshot.getUsers()) {
            if (user.getUsername().equals(username)) {
                throw new AuthenticationException("Tên đăng nhập đã tồn tại: " + username);
            }
        }

        User newUser;
        if (role == UserRole.BIDDER) {
            newUser = new Bidder(username, password, displayName);
        } else if (role == UserRole.SELLER) {
            newUser = new Seller(username, password, displayName);
        } else if (role == UserRole.ADMIN) {
            newUser = new Admin(username, password, displayName);
        } else {
            throw new AuthenticationException("Vai trò không hợp lệ");
        }

        snapshot.getUsers().add(newUser);

        saveData();
    }

    public synchronized UserSession login(String username, String password) throws AuthenticationException {
        for (User user : snapshot.getUsers()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return new UserSession(user.getId(), user.getUsername(), user.getDisplayName(), user.getRole());
            }
        }
        throw new AuthenticationException("Tên đăng nhập hoặc mật khẩu không chính xác");
    }

    public synchronized Auction createAuction(Item item, String sellerId, String sellerName, LocalDateTime startTime, LocalDateTime endTime) {
        if (item == null || sellerName == null || sellerId == null) {
            throw new IllegalArgumentException("Sản phẩm và người bán không được để trống!");
        }

        if (endTime.isBefore(startTime)) {
            throw new IllegalArgumentException("Thời gian kết thúc không thể trước thời gian bắt đầu!");
        }

        Auction newAuction = new Auction(item, sellerId, sellerName, startTime, endTime);

        snapshot.setNextAuctionId(snapshot.getNextAuctionId() + 1);

        snapshot.getAuctions().add(newAuction);

        saveData();

        System.out.println("Đã tạo thành công phiên đấu giá cho món hàng: " + item.getName());
        return newAuction;
    }

    public synchronized boolean placeBid(String auctionId, String bidderId, BigDecimal bidAmount, LocalDateTime bidTime, boolean automaticBid) {
        Auction targetAuction = null;

        for (Auction auction : snapshot.getAuctions()) {
            if (auction.getId().equals(auctionId)) {
                targetAuction = auction;
                break;
            }
        }

        if (targetAuction == null) {
            System.err.println("Lỗi: Không tìm thấy phiên đấu giá có ID = " + auctionId);
            return false;
        }

        LocalDateTime now = LocalDateTime.now();
        if (now.isBefore(targetAuction.getStartTime())) {
            System.err.println("Lỗi: Phiên đấu giá chưa bắt đầu!");
            return false;
        }
        if (now.isAfter(targetAuction.getEndTime())) {
            System.err.println("Lỗi: Phiên đấu giá đã kết thúc!");
            return false;
        }

        BigDecimal currentPrice = targetAuction.getCurrentPrice();

        if (bidAmount.compareTo(currentPrice) <= 0) {
            System.err.println("Lỗi: Giá đặt (" + bidAmount + ") phải lớn hơn giá hiện tại (" + currentPrice + ")");
            return false;
        }

        BidTransaction newBid = new BidTransaction(auctionId, bidderId, bidAmount, bidTime, automaticBid);

        targetAuction.getBidHistory().add(newBid);

        targetAuction.setCurrentPrice(bidAmount);

        saveData();

        System.out.println("Đã đặt giá thành công: " + bidAmount);
        return true;
    }
}
