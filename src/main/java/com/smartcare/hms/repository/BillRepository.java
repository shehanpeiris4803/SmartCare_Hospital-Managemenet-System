package com.smartcare.hms.repository;

import com.smartcare.hms.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {

    List<Bill> findByPatientUserId(int patientId);

    List<Bill> findByPaymentStatus(String paymentStatus);

    @Query("SELECT b FROM Bill b JOIN b.patient p WHERE " +
            "CAST(p.userId AS string) = :keyword OR " +
            "p.fullName LIKE %:keyword% OR " +
            "p.patientNumber LIKE %:keyword% OR " +
            "p.nicNumber LIKE %:keyword%")
    List<Bill> searchBillsByPatient(@Param("keyword") String keyword);
}



