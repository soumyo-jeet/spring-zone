package in.soumyo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Payment {
    @Autowired
    Order order;

    void pay () {
        System.out.println("Payment done");

        order.orderList();
    }
}
