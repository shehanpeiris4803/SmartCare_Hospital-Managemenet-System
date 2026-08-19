package com.smartcare.hms.controller;

import com.smartcare.hms.entity.Doctor;
import com.smartcare.hms.exception.ResourceNotFoundException;
import com.smartcare.hms.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public ResponseEntity<?> addDoctor(@RequestBody Doctor doctor) {
        if (doctor.getConsultationFee() <= 0) {
            return ResponseEntity.badRequest().body("Consultation fee must be greater than zero.");
        }
        return ResponseEntity.ok(doctorService.saveDoctor(doctor));
    }

    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable int id) {
        Doctor doctor = doctorService.getDoctorById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id: " + id));
        return ResponseEntity.ok(doctor);
    }
}
