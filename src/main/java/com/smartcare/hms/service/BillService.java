package com.smartcare.hms.service;

import com.smartcare.hms.entity.Bill;
import com.smartcare.hms.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    @Transactional
    public Bill saveBill(Bill bill) {
        return billRepository.save(bill);
    }

    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    public Optional<Bill> getBillById(int id) {
        return billRepository.findById(id);
    }

    public List<Bill> getBillsByPatient(int patientId) {
        return billRepository.findByPatientUserId(patientId);
    }

    public List<Bill> getBillsByStatus(String paymentStatus) {
        return billRepository.findByPaymentStatus(paymentStatus);
    }

    public List<Bill> searchBillsByPatient(String keyword) {
        return billRepository.searchBillsByPatient(keyword);
    }
}

