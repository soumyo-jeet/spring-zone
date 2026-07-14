package in.soumyo;

import in.soumyo.notifications.NotificationInterface;
import in.soumyo.notifications.SMSNotification;
import in.soumyo.notifications.WhatsappNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderPlace {
    private int amt;
    private SMSNotification notification;

//    OrderPlace(NotificationInterface notification, int amt) {
//        // this.notifiaction = notifiaction;
//        this.amt = amt;+
//    }

    // Automatically injected smsnotification by spring
    @Autowired
    public OrderPlace(SMSNotification notification) {
        this.notification = notification;
    }

    void place() {
        System.out.println("Order placed for amount " + this.amt);
    }

    void notifyUser () {
        notification.sendNotification(this.amt);
    }
}
