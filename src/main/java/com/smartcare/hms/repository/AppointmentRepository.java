
package com.smartcare.hms.repository;

import com.smartcare.hms.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    Optional<Appointment> findByAppointmentNumber(String appointmentNumber);

    List<Appointment> findByPatientUserId(int patientId);

    List<Appointment> findByDoctorUserId(int doctorId);

    List<Appointment> findByStatus(String status);

    // Check if the doctor has a SCHEDULED appointment at this time
    long countByDoctorUserIdAndAppointmentDateAndStatus(int doctorId, Date appointmentDate, String status);

    // Check if the room has a SCHEDULED appointment at this time
    long countByConsultationRoomAndAppointmentDateAndStatus(String consultationRoom, Date appointmentDate, String status);

    // Check if the patient already has a SCHEDULED appointment at this time
    long countByPatientUserIdAndAppointmentDateAndStatus(int patientId, Date appointmentDate, String status);
}
