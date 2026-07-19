package in.soumyo;


import org.springframework.stereotype.Component;

@Component
public class Order {
    Payment payMthd;

    Order (Payment payMthd) {
        this.payMthd = payMthd;
    }

    void placeOrder() {
        payMthd.pay();

        System.out.println("Order Placed");
    }

    void orderList() {
        System.out.println("List of your orders.");
    }
}
