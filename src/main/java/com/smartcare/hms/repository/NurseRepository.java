
package com.smartcare.hms.repository;

import com.smartcare.hms.entity.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NurseRepository extends JpaRepository<Nurse, Integer> {
    Optional<Nurse> findByNurseNumber(String nurseNumber);
    List<Nurse> findByWardAssigned(String wardAssigned);
}
