package com.auction.shared.model;

public class Admin extends User {
    public Admin(String username, String password, String displayName) {
        super(username, password, displayName, UserRole.ADMIN);
    }
}
