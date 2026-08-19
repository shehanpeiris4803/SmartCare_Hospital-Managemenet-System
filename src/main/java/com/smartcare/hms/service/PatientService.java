package com.smartcare.hms.service;

import com.smartcare.hms.entity.Patient;
import com.smartcare.hms.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Transactional
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatientById(int id) {
        return patientRepository.findById(id);
    }

    public Optional<Patient> getPatientByNic(String nicNumber) {
        return patientRepository.findByNicNumber(nicNumber);
    }

    public Optional<Patient> getPatientByPatientNumber(String patientNumber) {
        return patientRepository.findByPatientNumber(patientNumber);
    }

    public List<Patient> searchPatientsByName(String name) {
        return patientRepository.findByFullNameContainingIgnoreCase(name);
    }

    public Optional<Patient> getPatientByContactNumber(String contactNumber) {
        return patientRepository.findByContactNumber(contactNumber);
    }

    // Modified row (BgId replaced BloodGroupId)
    public List<Patient> getPatientsByBloodGroupId(int bloodGroupId) {
        return patientRepository.findByBloodGroupBgId(bloodGroupId);
    }
}
