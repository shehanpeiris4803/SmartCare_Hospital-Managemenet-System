package com.smartcare.hms.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "doctor")
@PrimaryKeyJoinColumn(name = "user_id")
public class Doctor extends User {

    @Column(name = "medical_license_number", unique = true, nullable = false, length = 50)
    private String medicalLicenseNumber;

    @Column(name = "doctor_number", unique = true, nullable = false, length = 20)
    private String doctorNumber;

    @Column(name = "specialization", nullable = false, length = 100)
    private String specialization;

    @Column(name = "qualification", nullable = false, length = 100)
    private String qualification;

    @Column(name = "consultation_fee", nullable = false)
    private double consultationFee;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    @JsonIgnoreProperties("headDoctor")
    private Department department;

    public Doctor() {
        this.setRole("DOCTOR");
    }

    public String getMedicalLicenseNumber() {
        return medicalLicenseNumber;
    }

    public void setMedicalLicenseNumber(String medicalLicenseNumber) {
        this.medicalLicenseNumber = medicalLicenseNumber;
    }

    public String getDoctorNumber() {
        return doctorNumber;
    }

    public void setDoctorNumber(String doctorNumber) {
        this.doctorNumber = doctorNumber;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}