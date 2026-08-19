package com.smartcare.hms.service;

import com.smartcare.hms.entity.Technician;
import com.smartcare.hms.repository.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TechnicianService {

    @Autowired
    private TechnicianRepository technicianRepository;

    @Transactional
    public Technician saveTechnician(Technician technician) {
        return technicianRepository.save(technician);
    }

    public List<Technician> getAllTechnicians() {
        return technicianRepository.findAll();
    }

    public Optional<Technician> getTechnicianById(int id) {
        return technicianRepository.findById(id);
    }

    public Optional<Technician> getTechnicianByNumber(String technicianNumber) {
        return technicianRepository.findByTechnicianNumber(technicianNumber);
    }
}