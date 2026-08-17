package com.smartcare.hms.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private int appointmentId;

    @Column(name = "appointment_number", unique = true, nullable = false, length = 20)
    private String appointmentNumber;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "appointment_date", nullable = false)
    private Date appointmentDate;

    @Column(name = "queue_number", nullable = false)
    private int queueNumber;

    @Column(name = "consultation_room", nullable = false, length = 45)
    private String consultationRoom;

    @Column(name = "reason", columnDefinition = "TEXT")
    private String reason;

    @Column(name = "status", nullable = false, length = 30)
    private String status;

    public Appointment() {
        this.status = "SCHEDULED";
    }

    public int getAppointmentId() { return appointmentId; }
    public void setAppointmentId(int appointmentId) { this.appointmentId = appointmentId; }

    public String getAppointmentNumber() { return appointmentNumber; }
    public void setAppointmentNumber(String appointmentNumber) { this.appointmentNumber = appointmentNumber; }

    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }

    public Doctor getDoctor() { return doctor; }
    public void setDoctor(Doctor doctor) { this.doctor = doctor; }

    public Date getAppointmentDate() { return appointmentDate; }
    public void setAppointmentDate(Date appointmentDate) { this.appointmentDate = appointmentDate; }

    public int getQueueNumber() { return queueNumber; }
    public void setQueueNumber(int queueNumber) { this.queueNumber = queueNumber; }

    public String getConsultationRoom() { return consultationRoom; }
    public void setConsultationRoom(String consultationRoom) { this.consultationRoom = consultationRoom; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}