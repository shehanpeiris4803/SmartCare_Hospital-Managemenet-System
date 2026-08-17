package com.smartcare.hms.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "manager")
@PrimaryKeyJoinColumn(name = "user_id")
public class Manager extends User {

    @Column(name = "management_level", length = 50)
    private String managementLevel;

    public Manager() {
        this.setRole("MANAGER");
    }

    public String getManagementLevel() {
        return managementLevel;
    }

    public void setManagementLevel(String managementLevel) {
        this.managementLevel = managementLevel;
    }
}