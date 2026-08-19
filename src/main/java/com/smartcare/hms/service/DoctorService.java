package com.smartcare.hms.service;

import com.smartcare.hms.entity.Doctor;
import com.smartcare.hms.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Transactional
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Optional<Doctor> getDoctorById(int userId) {
        return doctorRepository.findById(userId);
    }

    public Optional<Doctor> getDoctorByNumber(String doctorNumber) {
        return doctorRepository.findByDoctorNumber(doctorNumber);
    }

    public Optional<Doctor> getDoctorByMedicalLicenseNumber(String medicalLicenseNumber) {
        return doctorRepository.findByMedicalLicenseNumber(medicalLicenseNumber);
    }

    public List<Doctor> searchDoctorsByName(String name) {
        return doctorRepository.findByFullNameContainingIgnoreCase(name);
    }

    public List<Doctor> getDoctorsByDepartment(int departmentId) {
        return doctorRepository.findByDepartmentDepartmentId(departmentId);
    }
}
