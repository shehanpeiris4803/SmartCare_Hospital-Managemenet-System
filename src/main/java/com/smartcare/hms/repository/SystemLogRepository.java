package com.smartcare.hms.repository;

import com.smartcare.hms.entity.SystemLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SystemLogRepository extends JpaRepository<SystemLog, Integer> {
    List<SystemLog> findByUserUserId(int userId);
    List<SystemLog> findByAction(String action);
}
