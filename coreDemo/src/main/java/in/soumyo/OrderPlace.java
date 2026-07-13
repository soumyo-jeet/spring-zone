package in.soumyo;

import in.soumyo.notifications.NotificationInterface;
import in.soumyo.notifications.SMSNotification;
import in.soumyo.notifications.WhatsappNotification;

public class OrderPlace {
    int amt;
    NotificationInterface notifiaction = new SMSNotification();

    OrderPlace(int amt) {
        this.amt = amt;
    }

    void notifyUser () {
        notifiaction.sendNotification(this.amt);
    }
}
