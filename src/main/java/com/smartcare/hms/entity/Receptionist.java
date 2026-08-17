package com.smartcare.hms.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "receptionist")
@PrimaryKeyJoinColumn(name = "user_id")
public class Receptionist extends User {

    @Column(name = "receptionist_number", unique = true, nullable = false, length = 20)
    private String receptionistNumber;

    @Column(name = "desk_number", length = 10)
    private String deskNumber;

    public Receptionist() {
        this.setRole("RECEPTIONIST");
    }

    public String getReceptionistNumber() {
        return receptionistNumber;
    }

    public void setReceptionistNumber(String receptionistNumber) {
        this.receptionistNumber = receptionistNumber;
    }

    public String getDeskNumber() {
        return deskNumber;
    }

    public void setDeskNumber(String deskNumber) {
        this.deskNumber = deskNumber;
    }
}