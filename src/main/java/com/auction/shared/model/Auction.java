package com.auction.shared.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.math.BigDecimal;

public class Auction extends Entity {
    private Item item;
    private String sellerId;
    private String sellerName;
    private BigDecimal currentPrice;
    private AuctionStatus status;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String leadingBidderId;
    private String leadingBidderName;
    private String winnerBidderId;
    private String winnerBidderName;
    private final List<BidTransaction> bidHistory = new ArrayList<>();

    public Auction(Item item, String sellerId, String sellerName, LocalDateTime startTime, LocalDateTime endTime) {
        super();
        this.item = Objects.requireNonNull(item, "item");
        this.sellerId = requireNotBlank(sellerId, "sellerId");
        this.sellerName = requireNotBlank(sellerName, "sellerName");
        this.startTime = Objects.requireNonNull(startTime, "startTime");
        this.endTime = Objects.requireNonNull(endTime, "endTime");
        this.currentPrice = item.getStartingPrice();
        this.status = AuctionStatus.OPEN;
    }

    public synchronized void updateStatus() {
        if (status == AuctionStatus.PAID || status == AuctionStatus.CANCELED) {
            return;
        }

        LocalDateTime now = LocalDateTime.now();
        if (now.isBefore(startTime)) {
            status = AuctionStatus.OPEN;
        } else if (!now.isAfter(endTime)) {
            status = AuctionStatus.RUNNING;
        } else {
            status = AuctionStatus.FINISHED;
            if (leadingBidderId != null) {
                winnerBidderId = leadingBidderId;
                winnerBidderName = leadingBidderName;
            }
        }
    }

    public synchronized boolean canAcceptBid() {
        updateStatus();
        LocalDateTime now = LocalDateTime.now();
        return status == AuctionStatus.RUNNING
                && !now.isBefore(startTime)
                && !now.isAfter(endTime);
    }

    public synchronized boolean placeBid(String bidderId, String bidderName, double bidAmount, boolean automaticBid) {
        if (bidderId == null || bidderId.isBlank() || bidAmount <= 0 || !canAcceptBid()) {
            return false;
        }

        if (bidAmount <= currentPrice) {
            return false;
        }

        currentPrice = bidAmount;
        leadingBidderId = bidderId.trim();
        leadingBidderName = bidderName == null || bidderName.isBlank() ? null : bidderName.trim();
        bidHistory.add(new BidTransaction(
                null,
                null,
                getId(),
                leadingBidderId,
                bidAmount,
                LocalDateTime.now(),
                automaticBid
        ));
        return true;
    }

    public synchronized void finishAuction() {
        status = AuctionStatus.FINISHED;
        if (leadingBidderId != null) {
            winnerBidderId = leadingBidderId;
            winnerBidderName = leadingBidderName;
        }
    }

    public synchronized void markAsPaid() {
        if (status == AuctionStatus.FINISHED) {
            status = AuctionStatus.PAID;
        }
    }

    public synchronized void cancelAuction() {
        status = AuctionStatus.CANCELED;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = Objects.requireNonNull(item, "item");
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = requireNotBlank(sellerId, "sellerId");
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = requireNotBlank(sellerName, "sellerName");
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public AuctionStatus getStatus() {
        return status;
    }

    public void setStatus(AuctionStatus status) {
        this.status = Objects.requireNonNull(status, "status");
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = Objects.requireNonNull(startTime, "startTime");
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = Objects.requireNonNull(endTime, "endTime");
    }

    public String getLeadingBidderId() {
        return leadingBidderId;
    }

    public String getLeadingBidderName() {
        return leadingBidderName;
    }

    public String getWinnerBidderId() {
        return winnerBidderId;
    }

    public String getWinnerBidderName() {
        return winnerBidderName;
    }

    public List<BidTransaction> getBidHistory() {
        return List.copyOf(bidHistory);
    }

    public boolean hasBids() {
        return !bidHistory.isEmpty();
    }

    public boolean isOpen() {
        return status == AuctionStatus.OPEN;
    }

    public boolean isRunning() {
        return status == AuctionStatus.RUNNING;
    }

    public boolean isFinished() {
        return status == AuctionStatus.FINISHED;
    }

    private static String requireNotBlank(String value, String field) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(field + " cannot be blank");
        }
        return value.trim();
    }
}