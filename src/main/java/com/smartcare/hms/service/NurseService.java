package com.smartcare.hms.service;

import com.smartcare.hms.entity.Nurse;
import com.smartcare.hms.repository.NurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class NurseService {

    @Autowired
    private NurseRepository nurseRepository;

    @Transactional
    public Nurse saveNurse(Nurse nurse) {
        return nurseRepository.save(nurse);
    }

    public List<Nurse> getAllNurses() {
        return nurseRepository.findAll();
    }

    public Optional<Nurse> getNurseById(int userId) {
        return nurseRepository.findById(userId);
    }

    public Optional<Nurse> getNurseByNumber(String nurseNumber) {
        return nurseRepository.findByNurseNumber(nurseNumber);
    }

    public List<Nurse> getNursesByWard(String wardAssigned) {
        return nurseRepository.findByWardAssigned(wardAssigned);
    }
}