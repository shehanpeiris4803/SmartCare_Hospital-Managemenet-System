package com.smartcare.hms.service;

import com.smartcare.hms.entity.Pharmacist;
import com.smartcare.hms.repository.PharmacistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PharmacistService {

    @Autowired
    private PharmacistRepository pharmacistRepository;

    @Transactional
    public Pharmacist savePharmacist(Pharmacist pharmacist) {
        return pharmacistRepository.save(pharmacist);
    }

    public List<Pharmacist> getAllPharmacists() {
        return pharmacistRepository.findAll();
    }

    public Optional<Pharmacist> getPharmacistById(int userId) {
        return pharmacistRepository.findById(userId);
    }

    public Optional<Pharmacist> getPharmacistByNumber(String pharmacistNumber) {
        return pharmacistRepository.findByPharmacistNumber(pharmacistNumber);
    }

    public Optional<Pharmacist> getPharmacistByLicenseNumber(String licenseNumber) {
        return pharmacistRepository.findByLicenseNumber(licenseNumber);
    }
}