package com.smartcare.hms.service;

import com.smartcare.hms.entity.Appointment;
import com.smartcare.hms.entity.Doctor;
import com.smartcare.hms.entity.Patient;
import com.smartcare.hms.repository.AppointmentRepository;
import com.smartcare.hms.repository.DoctorRepository;
import com.smartcare.hms.repository.PatientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public AppointmentService(AppointmentRepository appointmentRepository,
                              DoctorRepository doctorRepository,
                              PatientRepository patientRepository) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    @Transactional
    public Appointment saveAppointment(Appointment appointment) {
        int doctorId = appointment.getDoctor().getUserId();
        int patientId = appointment.getPatient().getUserId();
        Date appointmentDate = appointment.getAppointmentDate();
        String consultationRoom = appointment.getConsultationRoom();

        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        // Check if the doctor is already booked with a SCHEDULED status at this time
        long doctorClashCount = appointmentRepository.countByDoctorUserIdAndAppointmentDateAndStatus(doctorId, appointmentDate, "SCHEDULED");
        if (doctorClashCount > 0) {
            throw new RuntimeException("Appointment clash: Doctor already has a scheduled appointment at this time.");
        }

        // Check if the room is already booked with a SCHEDULED status at this time
        long roomClashCount = appointmentRepository.countByConsultationRoomAndAppointmentDateAndStatus(consultationRoom, appointmentDate, "SCHEDULED");
        if (roomClashCount > 0) {
            throw new RuntimeException("Appointment clash: Consultation room is already booked at this time.");
        }

        // Check if the patient already has a scheduled appointment at this time
        long patientClashCount = appointmentRepository.countByPatientUserIdAndAppointmentDateAndStatus(patientId, appointmentDate, "SCHEDULED");
        if (patientClashCount > 0) {
            throw new RuntimeException("Appointment clash: Patient already has a scheduled appointment at this time.");
        }

        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setQueueNumber(1);
        appointment.setStatus("SCHEDULED");

        LocalDateTime localDateTime = appointment.getAppointmentDate().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        String formattedDateTime = localDateTime.format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        appointment.setAppointmentNumber("APT-" + formattedDateTime);

        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> getAppointmentById(int id) {
        return appointmentRepository.findById(id);
    }

    public List<Appointment> getAppointmentsByPatient(int patientId) {
        return appointmentRepository.findByPatientUserId(patientId);
    }

    public List<Appointment> getAppointmentsByDoctor(int doctorId) {
        return appointmentRepository.findByDoctorUserId(doctorId);
    }
}