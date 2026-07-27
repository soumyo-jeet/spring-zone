package in.soumyo;

import in.soumyo.notifications.NotificationInterface;
import in.soumyo.notifications.SMSNotification;
import in.soumyo.notifications.WhatsappNotification;

public class OrderPlace {
    int amt;
    NotificationInterface notifiaction;

    OrderPlace(NotificationInterface notifiaction, int amt) {
        this.notifiaction = notifiaction;
        this.amt = amt;
    }

    void notifyUser () {
        notifiaction.sendNotification(this.amt);
    }
}
