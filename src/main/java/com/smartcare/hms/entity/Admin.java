package com.smartcare.hms.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "admin")
@PrimaryKeyJoinColumn(name = "user_id")
public class Admin extends User {

    @Column(name = "access_level", length = 50)
    private String accessLevel;

    public Admin() {
        this.setRole("ADMIN");
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }
}