package in.soumyo;

public class OrderService {
    PaymentService payment;

//    OrderService(PaymentService payment) {
//        this.payment = payment;
//    }

    public void setPayment(PaymentService payment) {
        this.payment = payment;
    }

    void placeOrder () {
        this.payment.pay();
        System.out.println("Order placed");
    }
}
