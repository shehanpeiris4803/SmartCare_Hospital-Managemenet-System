package com.smartcare.hms.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "pharmacist")
@PrimaryKeyJoinColumn(name = "user_id")
public class Pharmacist extends User {

    @Column(name = "pharmacist_number", unique = true, nullable = false, length = 20)
    private String pharmacistNumber;

    @Column(name = "license_number", unique = true, nullable = false, length = 50)
    private String licenseNumber;

    public Pharmacist() {
        this.setRole("PHARMACIST");
    }

    public String getPharmacistNumber() {
        return pharmacistNumber;
    }

    public void setPharmacistNumber(String pharmacistNumber) {
        this.pharmacistNumber = pharmacistNumber;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
}