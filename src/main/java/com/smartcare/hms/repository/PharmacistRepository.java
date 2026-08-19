package com.smartcare.hms.repository;

import com.smartcare.hms.entity.Pharmacist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PharmacistRepository extends JpaRepository<Pharmacist, Integer> {
    Optional<Pharmacist> findByPharmacistNumber(String pharmacistNumber);
    Optional<Pharmacist> findByLicenseNumber(String licenseNumber);
}