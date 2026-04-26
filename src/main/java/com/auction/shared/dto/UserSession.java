package com.auction.shared.dto;

import com.auction.shared.model.UserRole;

import java.io.Serializable;

public class UserSession implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long userId;
    private String username;
    private String displayName;
    private UserRole role;

    public UserSession() {}

    public UserSession(Long userId, String username, String displayName, UserRole role) {
        this.userId = userId;
        this.username = username;
        this.displayName = displayName;
        this.role = role;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
