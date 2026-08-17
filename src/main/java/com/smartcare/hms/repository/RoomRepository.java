package com.smartcare.hms.repository;

import com.smartcare.hms.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

    List<Room> findByStatus(String status);

    @Query(value = "SELECT * FROM room WHERE room_number = :roomNumber FOR UPDATE", nativeQuery = true)
    Optional<Room> findByRoomNumberWithLock(@Param("roomNumber") String roomNumber);
}