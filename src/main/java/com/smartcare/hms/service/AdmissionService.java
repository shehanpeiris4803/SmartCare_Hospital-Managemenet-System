package com.smartcare.hms.service;

import com.smartcare.hms.entity.Admission;
import com.smartcare.hms.entity.Room;
import com.smartcare.hms.repository.AdmissionRepository;
import com.smartcare.hms.repository.RoomRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AdmissionService {

    private final AdmissionRepository admissionRepository;
    private final RoomRepository roomRepository;

    public AdmissionService(AdmissionRepository admissionRepository, RoomRepository roomRepository) {
        this.admissionRepository = admissionRepository;
        this.roomRepository = roomRepository;
    }

    @Transactional
    public Admission admitPatient(Admission admission, String roomNumber) {
        int userId = admission.getPatient().getUserId();

        // Checking if the patient is already admitted
        List<Admission> existingAdmissions = admissionRepository.findByPatientUserId(userId);
        boolean hasActiveAdmission = existingAdmissions.stream()
                .anyMatch(a -> "ADMITTED".equalsIgnoreCase(a.getStatus()));

        if (hasActiveAdmission) {
            throw new RuntimeException("Patient is already admitted. Please discharge the patient first.");
        }

        Room room = roomRepository.findByRoomNumberWithLock(roomNumber)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        if (!room.getStatus().equalsIgnoreCase("AVAILABLE")) {
            throw new RuntimeException("Room is not available for allocation.");
        }

        room.setStatus("OCCUPIED");
        roomRepository.save(room);

        admission.setRoomNumber(room.getRoomNumber());
        admission.setWardNumber(room.getWardNumber());
        admission.setStatus("ADMITTED");
        admission.setAdmissionNumber("ADM-" + System.currentTimeMillis());

        return admissionRepository.save(admission);
    }

    @Transactional
    public Admission dischargePatient(int admissionId, String dischargeNotes) {
        Admission admission = admissionRepository.findById(admissionId)
                .orElseThrow(() -> new RuntimeException("Admission record not found"));

        if (admission.getStatus().equals("DISCHARGED")) {
            throw new RuntimeException("Patient is already discharged");
        }

        Room room = roomRepository.findByRoomNumberWithLock(admission.getRoomNumber())
                .orElseThrow(() -> new RuntimeException("Room not found"));

        room.setStatus("AVAILABLE");
        roomRepository.save(room);

        admission.setStatus("DISCHARGED");
        admission.setDischargeDate(new Date());
        admission.setDischargeNotes(dischargeNotes);

        return admissionRepository.save(admission);
    }

    public List<Admission> getAllAdmissions() {
        return admissionRepository.findAll();
    }

    public Admission getAdmissionById(int id) {
        return admissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admission record not found"));
    }

    public List<Admission> getAdmissionsByPatientUserId(int userId) {
        return admissionRepository.findByPatientUserId(userId);
    }

    public List<Admission> getAdmissionsByStatus(String status) {
        return admissionRepository.findByStatus(status);
    }
}