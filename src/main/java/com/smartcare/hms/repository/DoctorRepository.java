package com.smartcare.hms.repository;

import com.smartcare.hms.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    // Search by Doctor Number
    Optional<Doctor> findByDoctorNumber(String doctorNumber);

    // Search by MedicalLicenseNumber
    Optional<Doctor> findByMedicalLicenseNumber(String medicalLicenseNumber);

    // Search by name
    List<Doctor> findByFullNameContainingIgnoreCase(String fullName);

    // Find doctors by department
    List<Doctor> findByDepartmentDepartmentId(int departmentId);
}
