package in.soumyo.springBootCoreDemo;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Component;

@Component
public class Order {
    Payment payment;

    public Order (Payment payment) {
        this.payment = payment;
    }

    void placeOrder () {
        this.payment.pay();
        System.out.println("Order placed.");
    }
}
