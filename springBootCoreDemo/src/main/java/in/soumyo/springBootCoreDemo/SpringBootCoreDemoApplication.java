package in.soumyo.springBootCoreDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootCoreDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context =
		SpringApplication.run(SpringBootCoreDemoApplication.class, args);

		Order order = context.getBean(Order.class);
		order.placeOrder();
	}

}
