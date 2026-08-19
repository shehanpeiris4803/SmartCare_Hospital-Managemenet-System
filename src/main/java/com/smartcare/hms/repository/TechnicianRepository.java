package com.smartcare.hms.repository;

import com.smartcare.hms.entity.Technician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TechnicianRepository extends JpaRepository<Technician, Integer> {
    Optional<Technician> findByTechnicianNumber(String technicianNumber);
}

