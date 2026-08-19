package com.smartcare.hms.controller;

import com.smartcare.hms.entity.Bill;
import com.smartcare.hms.service.BillService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bills")
public class BillController {

    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @PostMapping
    public ResponseEntity<Bill> saveBill(@RequestBody Bill bill) {
        if (bill.getTotalAmount() < 0) {
            throw new RuntimeException("Bill amounts cannot be negative.");
        }
        return ResponseEntity.ok(billService.saveBill(bill));
    }

    @GetMapping
    public ResponseEntity<List<Bill>> getAllBills() {
        return ResponseEntity.ok(billService.getAllBills());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bill> getBillById(@PathVariable int id) {
        Bill bill = billService.getBillById(id)
                .orElseThrow(() -> new RuntimeException("Bill not found"));
        return ResponseEntity.ok(bill);
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Bill>> getBillsByPatient(@PathVariable int patientId) {
        return ResponseEntity.ok(billService.getBillsByPatient(patientId));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Bill>> getBillsByStatus(@PathVariable String status) {
        return ResponseEntity.ok(billService.getBillsByStatus(status));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Bill>> searchBills(@RequestParam String keyword) {
        return ResponseEntity.ok(billService.searchBillsByPatient(keyword));
    }
}
