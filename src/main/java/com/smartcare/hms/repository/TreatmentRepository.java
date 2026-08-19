package com.smartcare.hms.repository;

import com.smartcare.hms.entity.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatment, Integer> {
    List<Treatment> findByPatientUserId(int patientId);
    List<Treatment> findByDoctorUserId(int doctorId);
}