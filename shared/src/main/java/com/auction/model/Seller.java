package com.auction.model;

public class Seller extends User {
    public Seller(String username, String password, String displayName) {
        super(username, password, displayName, UserRole.SELLER);
    }
}
