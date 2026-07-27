package in.soumyo.springBootCoreDemo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements ApplicationRunner {
    Order order;

    public Runner(Order order) {
        this.order = order;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        order.printOrderProps();
        order.placeOrder();
    }
}
