package com.smartcare.hms.repository;

import com.smartcare.hms.entity.Laboratory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LaboratoryRepository extends JpaRepository<Laboratory, Integer> {

    List<Laboratory> findByPatientUserId(int patientId);

    List<Laboratory> findByTestStatus(String testStatus);

    @Query("SELECT l FROM Laboratory l JOIN l.patient p WHERE p.fullName LIKE %:keyword% OR p.patientNumber LIKE %:keyword%")
    List<Laboratory> searchLabTestsByPatient(@Param("keyword") String keyword);
}