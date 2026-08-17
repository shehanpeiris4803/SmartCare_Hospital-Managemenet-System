package com.smartcare.hms.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private int departmentId;

    @Column(name = "department_name", nullable = false, length = 45)
    private String departmentName;

    @Column(name = "location", length = 100)
    private String location;

    @OneToOne
    @JoinColumn(name = "head_doctor_id")
    @JsonIgnoreProperties("department")
    private Doctor headDoctor;

    public Department() {}

    public int getDepartmentId() { return departmentId; }
    public void setDepartmentId(int departmentId) { this.departmentId = departmentId; }

    public String getDepartmentName() { return departmentName; }
    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public Doctor getHeadDoctor() { return headDoctor; }
    public void setHeadDoctor(Doctor headDoctor) { this.headDoctor = headDoctor; }
}