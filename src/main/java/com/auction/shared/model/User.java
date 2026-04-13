package com.auction.shared.model;

import java.util.Objects;

public abstract class User extends Entity {

    private final String username;
    private String password;
    private String displayName;
    private final UserRole role;

    protected User(String username, String password, String displayName, UserRole role) {
        super();
        this.username = requireNotBlank(username, "username");
        this.password = requireNotBlank(password, "password");
        this.displayName = requireNotBlank(displayName, "displayName");
        this.role = Objects.requireNonNull(role, "role");
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDisplayName() {
        return displayName;
    }

    public UserRole getRole() {
        return role;
    }

    public boolean passwordMatches(String rawPassword) {
        return password.equals(rawPassword);
    }

    public void setPassword(String password) {
        this.password = requireNotBlank(password, "password");
    }

    public void setDisplayName(String displayName) {
        this.displayName = requireNotBlank(displayName, "displayName");
    }

    private String requireNotBlank(String value, String field) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(field + " cannot be blank");
        }
        return value.trim();
    }
}
