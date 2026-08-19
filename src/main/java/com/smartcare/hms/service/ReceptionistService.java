package com.smartcare.hms.service;

import com.smartcare.hms.entity.Receptionist;
import com.smartcare.hms.repository.ReceptionistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ReceptionistService {

    @Autowired
    private ReceptionistRepository receptionistRepository;

    @Transactional
    public Receptionist saveReceptionist(Receptionist receptionist) {
        return receptionistRepository.save(receptionist);
    }

    public List<Receptionist> getAllReceptionists() {
        return receptionistRepository.findAll();
    }

    public Optional<Receptionist> getReceptionistById(int userId) {
        return receptionistRepository.findById(userId);
    }

    public Optional<Receptionist> getReceptionistByNumber(String receptionistNumber) {
        return receptionistRepository.findByReceptionistNumber(receptionistNumber);
    }

    public List<Receptionist> getReceptionistsByDesk(String deskNumber) {
        return receptionistRepository.findByDeskNumber(deskNumber);
    }
}
