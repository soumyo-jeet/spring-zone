package in.soumyo.springBootCoreDemo;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Component;

@Component
public class Order {
    Payment payment;
    OrderProperties orderProperties;

    public Order (Payment payment, OrderProperties orderProperties) {
        this.payment = payment;
        this.orderProperties = orderProperties;
    }

    void placeOrder () {
        this.payment.pay();
        System.out.println("Order placed.");
    }

    void printOrderProps () {
        System.out.println("Market: " + orderProperties.market
                + "Delay: " + orderProperties.delayTime
        );
    }
}
