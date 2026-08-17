package com.smartcare.hms.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private int roomId;

    @Column(name = "room_number", unique = true, nullable = false, length = 20)
    private String roomNumber;

    @Column(name = "ward_number", nullable = false, length = 20)
    private String wardNumber;

    @Column(name = "status", nullable = false, length = 20)
    private String status; // Status can be AVAILABLE, OCCUPIED, or MAINTENANCE

    // Default constructor
    public Room() {
        this.status = "AVAILABLE";
    }

    // Getters and Setters
    public int getRoomId() { return roomId; }
    public void setRoomId(int roomId) { this.roomId = roomId; }

    public String getRoomNumber() { return roomNumber; }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }

    public String getWardNumber() { return wardNumber; }
    public void setWardNumber(String wardNumber) { this.wardNumber = wardNumber; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}