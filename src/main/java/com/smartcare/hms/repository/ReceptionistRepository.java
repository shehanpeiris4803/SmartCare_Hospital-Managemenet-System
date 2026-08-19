
package com.smartcare.hms.repository;

import com.smartcare.hms.entity.Receptionist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReceptionistRepository extends JpaRepository<Receptionist, Integer> {
    Optional<Receptionist> findByReceptionistNumber(String receptionistNumber);
    List<Receptionist> findByDeskNumber(String deskNumber);
}
