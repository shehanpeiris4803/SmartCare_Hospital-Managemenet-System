package com.smartcare.hms.controller;

import com.smartcare.hms.entity.Treatment;
import com.smartcare.hms.repository.TreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/treatments")
public class TreatmentController {

    @Autowired
    private TreatmentRepository treatmentRepository;

    @PostMapping
    public ResponseEntity<Treatment> recordTreatment(@RequestBody Treatment treatment) {
        return ResponseEntity.ok(treatmentRepository.save(treatment));
    }

    @GetMapping
    public ResponseEntity<List<Treatment>> getAllTreatments() {
        return ResponseEntity.ok(treatmentRepository.findAll());
    }
}