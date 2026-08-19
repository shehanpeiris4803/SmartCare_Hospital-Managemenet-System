package payment;

import org.springframework.stereotype.Component;

@Component
public class CardPayment implements PaymentProcessor {

    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing Card Payment of amount: " + amount);
        return true;
    }

    @Override
    public String getPaymentType() {
        return "CARD";
    }
}