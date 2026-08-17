package com.smartcare.hms.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "treatment")
public class Treatment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "treatment_id")
    private int treatmentId;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @Column(name = "diagnosis", nullable = false, columnDefinition = "TEXT")
    private String diagnosis;

    @Column(name = "prescription", columnDefinition = "TEXT")
    private String prescription;

    @Column(name = "treatment_notes", columnDefinition = "TEXT")
    private String treatmentNotes;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "treatment_date", nullable = false)
    private Date treatmentDate;

    public Treatment() {
        this.treatmentDate = new Date();
    }

    public int getTreatmentId() { return treatmentId; }
    public void setTreatmentId(int treatmentId) { this.treatmentId = treatmentId; }
    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }
    public Doctor getDoctor() { return doctor; }
    public void setDoctor(Doctor doctor) { this.doctor = doctor; }
    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }
    public String getPrescription() { return prescription; }
    public void setPrescription(String prescription) { this.prescription = prescription; }
    public String getTreatmentNotes() { return treatmentNotes; }
    public void setTreatmentNotes(String treatmentNotes) { this.treatmentNotes = treatmentNotes; }
    public Date getTreatmentDate() { return treatmentDate; }
    public void setTreatmentDate(Date treatmentDate) { this.treatmentDate = treatmentDate; }
}