package com.smartcare.hms.repository;

import com.smartcare.hms.entity.Admission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdmissionRepository extends JpaRepository<Admission, Integer> {

    // Find admission by unique admission number
    Optional<Admission> findByAdmissionNumber(String admissionNumber);

    // Find admissions by patient user id
    List<Admission> findByPatientUserId(int userId);

    // Find admissions by status
    List<Admission> findByStatus(String status);
}