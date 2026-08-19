package com.smartcare.hms.service;

import com.smartcare.hms.entity.Bill;
import com.smartcare.hms.entity.Payment;
import com.smartcare.hms.repository.BillRepository;
import com.smartcare.hms.repository.PaymentRepository;
import com.smartcare.hms.service.payment.PaymentProcessor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final BillRepository billRepository;
    private final Map<String, PaymentProcessor> paymentProcessors;

    public PaymentService(PaymentRepository paymentRepository, BillRepository billRepository, Map<String, PaymentProcessor> paymentProcessors) {
        this.paymentRepository = paymentRepository;
        this.billRepository = billRepository;
        this.paymentProcessors = paymentProcessors;
    }

    @Transactional
    public Payment processAndSavePayment(Payment payment) {
        String method = payment.getPaymentMethod();

        // Find the correct payment processor based on the method
        PaymentProcessor processor = paymentProcessors.values().stream()
                .filter(p -> p.getPaymentType().equalsIgnoreCase(method))
                .findFirst()
                .orElse(null);

        if (processor != null) {
            boolean success = processor.processPayment(payment.getPaymentAmount());
            if (!success) {
                throw new RuntimeException("Payment processing failed.");
            }
        } else {
            throw new RuntimeException("Invalid payment method.");
        }

        // Fetch the target bill using billId
        Bill bill = billRepository.findById(payment.getBill().getBillId())
                .orElseThrow(() -> new RuntimeException("Bill not found"));

        // Calculate current remaining balance
        double currentBalance = bill.getTotalAmount() - bill.getPaidAmount();

        // Validate if payment amount exceeds the remaining balance
        if (payment.getPaymentAmount() > currentBalance) {
            throw new RuntimeException("Payment amount (" + payment.getPaymentAmount() +
                    ") exceeds the remaining balance (" + currentBalance + ").");
        }

        // Update paid amount and remaining balance
        double newPaidAmount = bill.getPaidAmount() + payment.getPaymentAmount();
        bill.setPaidAmount(newPaidAmount);

        double newBalance = bill.getTotalAmount() - newPaidAmount;
        bill.setBalance(newBalance);

        // Update payment status automatically
        if (newBalance == 0) {
            bill.setPaymentStatus("PAID");
        } else {
            bill.setPaymentStatus("PENDING");
        }

        // Save updated bill information
        billRepository.save(bill);

        // Link bill to payment and save
        payment.setBill(bill);
        return paymentRepository.save(payment);
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
}