package in.soumyo.notifications;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary // When there is a confution of selecting a dependency class during auto-injection, it will be selected
public class WhatsappNotification implements NotificationInterface{
    @Override
    public void sendNotification (int amt) {
        System.out.println("Notification of palcing order, amount " + amt + " has been sent through whatsapp");
    }
}
