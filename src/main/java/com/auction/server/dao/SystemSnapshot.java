package com.auction.server.dao;

import com.auction.shared.model.Auction;
import com.auction.shared.model.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SystemSnapshot implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<User> users;
    private List<Auction> auctions;

    private int nextUserId = 1;
    private int nextAuctionId = 1;
    private int nextBidId = 1;

    public SystemSnapshot() {
        this.users = new ArrayList<>();
        this.auctions = new ArrayList<>();
    }

    public int getNextBidId() {
        return nextBidId;
    }

    public void setNextBidId(int nextBidId) {
        this.nextBidId = nextBidId;
    }

    public int getNextAuctionId() {
        return nextAuctionId;
    }

    public void setNextAuctionId(int nextAuctionId) {
        this.nextAuctionId = nextAuctionId;
    }

    public int getNextUserId() {
        return nextUserId;
    }

    public void setNextUserId(int nextUserId) {
        this.nextUserId = nextUserId;
    }

    public List<Auction> getAuctions() {
        return auctions;
    }

    public void setAuctions(List<Auction> auctions) {
        this.auctions = auctions;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
