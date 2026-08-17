package com.smartcare.hms.controller;

import com.smartcare.hms.entity.Admission;
import com.smartcare.hms.service.AdmissionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admissions")
public class AdmissionController {

    private final AdmissionService admissionService;

    public AdmissionController(AdmissionService admissionService) {
        this.admissionService = admissionService;
    }

    @PostMapping("/admit")
    public ResponseEntity<Admission> admitPatient(@RequestBody Admission admission, @RequestParam String roomNumber) {
        return ResponseEntity.ok(admissionService.admitPatient(admission, roomNumber));
    }

    @PutMapping("/discharge/{id}")
    public ResponseEntity<Admission> dischargePatient(@PathVariable int id, @RequestParam String dischargeNotes) {
        return ResponseEntity.ok(admissionService.dischargePatient(id, dischargeNotes));
    }

    @GetMapping
    public ResponseEntity<List<Admission>> getAllAdmissions() {
        return ResponseEntity.ok(admissionService.getAllAdmissions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admission> getAdmissionById(@PathVariable int id) {
        return ResponseEntity.ok(admissionService.getAdmissionById(id));
    }

    @GetMapping("/patient/{userId}")
    public ResponseEntity<List<Admission>> getAdmissionsByPatient(@PathVariable int userId) {
        return ResponseEntity.ok(admissionService.getAdmissionsByPatientUserId(userId));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Admission>> getAdmissionsByStatus(@PathVariable String status) {
        return ResponseEntity.ok(admissionService.getAdmissionsByStatus(status));
    }
}