package in.soumyo.notifications;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("email")
public class EmailNotification implements NotificationInterface{

    @Override
    public void sendNotification (int amt) {
        System.out.println("Notification of palcing order, amount " + amt + " has been sent through email");
    }
}
