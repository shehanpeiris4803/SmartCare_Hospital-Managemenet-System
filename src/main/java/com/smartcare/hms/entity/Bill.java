package com.smartcare.hms.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bill")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private int billId;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "bill_date", nullable = false)
    private Date billDate;

    @Column(name = "total_amount", nullable = false)
    private double totalAmount;

    @Column(name = "paid_amount", nullable = false)
    private double paidAmount = 0.0;

    @Column(name = "balance", nullable = false)
    private double balance = 0.0;

    @Column(name = "payment_status", nullable = false, length = 30)
    private String paymentStatus;

    public Bill() {
    }

    public int getBillId() { return billId; }
    public void setBillId(int billId) { this.billId = billId; }

    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }

    public Date getBillDate() { return billDate; }
    public void setBillDate(Date billDate) { this.billDate = billDate; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public double getPaidAmount() { return paidAmount; }
    public void setPaidAmount(double paidAmount) { this.paidAmount = paidAmount; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }
}