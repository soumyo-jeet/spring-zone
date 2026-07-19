package in.soumyo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
// object will be created only when it's invoked, IOC doesn't create it eagerly.
public class Payment {
    Order order;

    Payment (Order order) {
        this.order = order;
    }

    void pay () {
        System.out.println("Payment done");

        order.orderList();
    }
}
