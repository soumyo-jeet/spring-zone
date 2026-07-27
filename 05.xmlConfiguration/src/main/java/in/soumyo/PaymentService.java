package in.soumyo;

public class PaymentService {
    String mode;

    public PaymentService (String mode) {
        this.mode = mode;
    }
    void pay () {
        System.out.println("Bill Payed. In " + this.mode + " method" );
    }
}
