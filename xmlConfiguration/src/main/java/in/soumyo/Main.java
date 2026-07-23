package in.soumyo;

import java.lang.module.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // get bean by type --> breaks when two beans of same class exist in the ioc container
        OrderService order = context.getBean(OrderService.class);

        // get bean by id --> works even if there exist more than 1 beans of same class since there ids are different
        OrderService order2 =
                (OrderService) context.getBean("orderService"); // type conversion reqd

        PaymentService payment =
                context.getBean("paymentService", PaymentService.class); // no conversion reqd





        order.placeOrder();
    }
}
