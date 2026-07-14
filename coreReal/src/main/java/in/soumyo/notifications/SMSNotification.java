package in.soumyo.notifications;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component
//@Qualifier("sms")
public class SMSNotification implements NotificationInterface{
    @Override
    public void sendNotification (int amt) {
        System.out.println("Notification of palcing order, amount " + amt + " has been sent through sms");
    }
}
