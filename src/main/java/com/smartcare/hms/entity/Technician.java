package com.smartcare.hms.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "technician")
@PrimaryKeyJoinColumn(name = "user_id")
public class Technician extends User {

    @Column(name = "technician_number", unique = true, nullable = false, length = 20)
    private String technicianNumber;

    @Column(name = "specialization", length = 100)
    private String specialization;

    public Technician() {
        this.setRole("TECHNICIAN");
    }

    public String getTechnicianNumber() { return technicianNumber; }
    public void setTechnicianNumber(String technicianNumber) { this.technicianNumber = technicianNumber; }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
}