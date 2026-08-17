package com.smartcare.hms.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "laboratory")
public class Laboratory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lab_test_id")
    private int labTestId;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @Column(name = "test_name", nullable = false, length = 100)
    private String testName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "test_date", nullable = false)
    private Date testDate;

    @Column(name = "test_result", columnDefinition = "TEXT")
    private String testResult;


    @ManyToOne
    @JoinColumn(name = "technician_id")
    private Technician technician;

    @Column(name = "test_status", nullable = false, length = 30)
    private String testStatus;

    public Laboratory() {
        this.testStatus = "PENDING";
    }

    public int getLabTestId() { return labTestId; }
    public void setLabTestId(int labTestId) { this.labTestId = labTestId; }

    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }

    public String getTestName() { return testName; }
    public void setTestName(String testName) { this.testName = testName; }

    public Date getTestDate() { return testDate; }
    public void setTestDate(Date testDate) { this.testDate = testDate; }

    public String getTestResult() { return testResult; }
    public void setTestResult(String testResult) { this.testResult = testResult; }

    public Technician getTechnician() { return technician; }
    public void setTechnician(Technician technician) { this.technician = technician; }

    public String getTestStatus() { return testStatus; }
    public void setTestStatus(String testStatus) { this.testStatus = testStatus; }
}