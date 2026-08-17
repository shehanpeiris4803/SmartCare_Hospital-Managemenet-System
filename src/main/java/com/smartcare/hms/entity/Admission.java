package com.smartcare.hms.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "admission")
public class Admission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admission_id")
    private int admissionId;

    @Column(name = "admission_number", unique = true, nullable = false, length = 20)
    private String admissionNumber;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @Column(name = "ward_number", nullable = false, length = 20)
    private String wardNumber;

    @Column(name = "room_number", length = 20)
    private String roomNumber;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "admission_date", nullable = false)
    private Date admissionDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "discharge_date")
    private Date dischargeDate;

    @Column(name = "admission_reason", columnDefinition = "TEXT")
    private String admissionReason;

    @Column(name = "discharge_notes", columnDefinition = "TEXT")
    private String dischargeNotes;

    @Column(name = "status", nullable = false, length = 30)
    private String status;

    // Default constructor with default status
    public Admission() {
        this.status = "ADMITTED";
        this.admissionDate = new Date();
    }

    // Getters and Setters
    public int getAdmissionId() { return admissionId; }
    public void setAdmissionId(int admissionId) { this.admissionId = admissionId; }

    public String getAdmissionNumber() { return admissionNumber; }
    public void setAdmissionNumber(String admissionNumber) { this.admissionNumber = admissionNumber; }

    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }

    public String getWardNumber() { return wardNumber; }
    public void setWardNumber(String wardNumber) { this.wardNumber = wardNumber; }

    public String getRoomNumber() { return roomNumber; }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }

    public Date getAdmissionDate() { return admissionDate; }
    public void setAdmissionDate(Date admissionDate) { this.admissionDate = admissionDate; }

    public Date getDischargeDate() { return dischargeDate; }
    public void setDischargeDate(Date dischargeDate) { this.dischargeDate = dischargeDate; }

    public String getAdmissionReason() { return admissionReason; }
    public void setAdmissionReason(String admissionReason) { this.admissionReason = admissionReason; }

    public String getDischargeNotes() { return dischargeNotes; }
    public void setDischargeNotes(String dischargeNotes) { this.dischargeNotes = dischargeNotes; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}