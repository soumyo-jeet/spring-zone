package in.soumyo;

import org.springframework.stereotype.Component;

@Component
public class Payment {
    Order order;

    Payment(Order order) {
        this.order = order;
    }

    void pay () {
        System.out.println("Payment done");

        order.orderList();
    }
}
