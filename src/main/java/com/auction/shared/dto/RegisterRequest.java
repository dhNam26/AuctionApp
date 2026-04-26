package com.auction.shared.dto;
import com.auction.shared.model.UserRole;
import java.io.Serializable;

public class RegisterRequest implements Serializable {
    private String displayName;
    private String username;
    private String password;
    private UserRole role;

    private static final long serialVersionUID = 1L;

    public RegisterRequest() {}

    public RegisterRequest(String displayName, String username, String password, UserRole role) {
        this.displayName = displayName;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
