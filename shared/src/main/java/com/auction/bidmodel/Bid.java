package com.auction.bidmodel;

import java.time.LocalDateTime;

public class Bid {
    private String id;
    private String auctionId;
    private String bidderId;
    private double bidAmount;
    private LocalDateTime bidTime;
    private boolean automaticBid;

    public Bid(String id, String auctionId, String bidderId, double bidAmount, LocalDateTime bidTime, boolean automaticBid) {
        this.id = id;
        this.auctionId = auctionId;
        this.bidderId = bidderId;
        this.bidAmount = bidAmount;
        this.bidTime = bidTime;
        this.automaticBid = automaticBid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(String auctionId) {
        this.auctionId = auctionId;
    }

    public String getBidderId() {
        return bidderId;
    }

    public void setBidderId(String bidderId) {
        this.bidderId = bidderId;
    }

    public double getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(double bidAmount) {
        this.bidAmount = bidAmount;
    }

    public LocalDateTime getBidTime() {
        return bidTime;
    }

    public void setBidTime(LocalDateTime bidTime) {
        this.bidTime = bidTime;
    }

    public boolean getAutomaticBid() {
        return automaticBid;
    }

    public void setAutomaticBid(boolean automaticBid) {
        this.automaticBid = automaticBid;
    }
}
