package com.auction.model;

public class Bidder extends User {
    public Bidder(String username, String password, String displayName) {
        super(username, password, displayName, UserRole.BIDDER);
    }
}
