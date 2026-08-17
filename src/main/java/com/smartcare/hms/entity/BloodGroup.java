package com.smartcare.hms.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "blood_group")
public class BloodGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bg_id")
    private int bgId;

    @Column(name = "bg_name", nullable = false, length = 45)
    private String bgName;

    public BloodGroup() {
    }

    public int getBgId() {
        return bgId;
    }

    public void setBgId(int bgId) {
        this.bgId = bgId;
    }

    public String getBgName() {
        return bgName;
    }

    public void setBgName(String bgName) {
        this.bgName = bgName;
    }
}