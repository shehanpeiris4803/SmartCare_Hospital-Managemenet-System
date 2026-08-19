package com.smartcare.hms.controller;

import com.smartcare.hms.entity.Laboratory;
import com.smartcare.hms.repository.LaboratoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/laboratory")
public class LaboratoryController {

    @Autowired
    private LaboratoryRepository laboratoryRepository;

    @PostMapping
    public ResponseEntity<Laboratory> addLabTest(@RequestBody Laboratory laboratory) {
        return ResponseEntity.ok(laboratoryRepository.save(laboratory));
    }

    @GetMapping
    public ResponseEntity<List<Laboratory>> getAllLabTests() {
        return ResponseEntity.ok(laboratoryRepository.findAll());
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Laboratory>> getLabTestsByPatient(@PathVariable int patientId) {
        return ResponseEntity.ok(laboratoryRepository.findByPatientUserId(patientId));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Laboratory>> getLabTestsByStatus(@PathVariable String status) {
        return ResponseEntity.ok(laboratoryRepository.findByTestStatus(status));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Laboratory>> searchLabTestsByPatient(@RequestParam String keyword) {
        return ResponseEntity.ok(laboratoryRepository.searchLabTestsByPatient(keyword));
    }
}