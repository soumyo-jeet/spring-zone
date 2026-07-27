package in.soumyo.springBootCoreDemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Component;

@Component
public class Payment {
    String type;

    // Autowiring injection from application.properties
    @Value("${payment.limit}")
    int limit;

    // Injecting values from application.properties through constructor
    Payment(@Value("${payment.type}") String type) {
        this.type = type;
    }

    void pay () {
        System.out.println("Payment done with "
                + type
                + " method"
                + " and with a limit of "
                + limit);
    }
}
