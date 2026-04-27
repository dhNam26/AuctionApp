package com.auction.server.service;

import com.auction.server.dao.DataStore;
import com.auction.server.dao.FileDataStore;
import com.auction.server.dao.SystemSnapshot;
import com.auction.shared.dto.UserSession;
import com.auction.shared.exception.AuthenticationException;
import com.auction.shared.model.*;

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
}
