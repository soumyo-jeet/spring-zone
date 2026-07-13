package in.soumyo;

import in.soumyo.notifications.NotificationInterface;
import in.soumyo.notifications.SMSNotification;
import in.soumyo.notifications.WhatsappNotification;
import org.springframework.stereotype.Component;

@Component
public class OrderPlace {
    int amt;
    // NotificationInterface notifiaction;

//    OrderPlace(NotificationInterface notification, int amt) {
//        // this.notifiaction = notifiaction;
//        this.amt = amt;
//    }

    void place() {
        System.out.println("Order placed for amount " + this.amt);
    }

//    void notifyUser () {
//        notifiaction.sendNotification(this.amt);
//    }
}
