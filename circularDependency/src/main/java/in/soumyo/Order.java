package in.soumyo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class Order {
    Payment payMthd;

    // add a proxy of the payment class not the real object as dependency
    Order (@Lazy Payment payMthd) {
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
