package com.smartcare.hms.repository;

import com.smartcare.hms.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    // To search by Patient Number
    Optional<Patient> findByPatientNumber(String patientNumber);

    // To search by NIC number
    Optional<Patient> findByNicNumber(String nicNumber);

    // To search by name
    List<Patient> findByFullNameContainingIgnoreCase(String fullName);

    // To search by contact number/mobile number
    Optional<Patient> findByContactNumber(String contactNumber);


    List<Patient> findByBloodGroupBgId(int bgId);
}
