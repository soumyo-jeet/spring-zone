package in.soumyo.springBootCoreDemo;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Component;

@Component
public class Payment {
    void pay () {
        System.out.println("Payment done.");
    }
}
