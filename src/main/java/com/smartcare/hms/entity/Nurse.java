package com.smartcare.hms.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "nurse")
@PrimaryKeyJoinColumn(name = "user_id")
public class Nurse extends User {

    @Column(name = "nurse_number", unique = true, nullable = false, length = 20)
    private String nurseNumber;

    @Column(name = "ward_assigned", length = 50)
    private String wardAssigned;

    public Nurse() {
        this.setRole("NURSE");
    }

    public String getNurseNumber() {
        return nurseNumber;
    }

    public void setNurseNumber(String nurseNumber) {
        this.nurseNumber = nurseNumber;
    }

    public String getWardAssigned() {
        return wardAssigned;
    }

    public void setWardAssigned(String wardAssigned) {
        this.wardAssigned = wardAssigned;
    }
}