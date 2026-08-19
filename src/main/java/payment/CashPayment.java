package payment;

import org.springframework.stereotype.Component;

@Component("CASH")
public class CashPayment implements PaymentProcessor {

    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing cash payment of Rs." + amount);
        return true;
    }

    @Override
    public String getPaymentType() {
        return "CASH";
    }
}