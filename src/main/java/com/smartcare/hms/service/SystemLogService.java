package com.smartcare.hms.service;

import com.smartcare.hms.entity.SystemLog;
import com.smartcare.hms.entity.User;
import com.smartcare.hms.repository.SystemLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SystemLogService {

    @Autowired
    private SystemLogRepository systemLogRepository;

    @Transactional
    public void saveLog(User user, String action, String description) {
        SystemLog log = new SystemLog();
        log.setUser(user);
        log.setAction(action);
        log.setDescription(description);
        systemLogRepository.save(log);
    }

    public List<SystemLog> getAllLogs() {
        return systemLogRepository.findAll();
    }

    public List<SystemLog> getLogsByUser(int userId) {
        return systemLogRepository.findByUserUserId(userId);
    }

    public List<SystemLog> getLogsByAction(String action) {
        return systemLogRepository.findByAction(action);
    }
}