package com.nmcnpm.model.impl;

import com.nmcnpm.model.abs.BaseUser;

public class Admin extends BaseUser {
    private String adminBadge;

    // Getters and Setters
    public String getAdminBadge() {
        return adminBadge;
    }

    public void setAdminBadge(String adminBadge) {
        this.adminBadge = adminBadge;
    }
}
