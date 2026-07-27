package in.soumyo;

import in.soumyo.notifications.NotificationInterface;
import in.soumyo.notifications.SMSNotification;
import in.soumyo.notifications.WhatsappNotification;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLOutput;

public class Main {
    static void main() {
        // IOC container configuration
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // All the classes have Component annotation are now beans of the ioc container
        OrderPlace order = context.getBean(OrderPlace.class);

        order.place();
        order.notifyUser();
    }
}
