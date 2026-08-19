package payment;

import org.springframework.stereotype.Component;

@Component("ONLINE")
public class OnlinePayment implements PaymentProcessor {

    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing online transfer of Rs." + amount);
        return true;
    }

    @Override
    public String getPaymentType() {
        return "ONLINE";
    }
}