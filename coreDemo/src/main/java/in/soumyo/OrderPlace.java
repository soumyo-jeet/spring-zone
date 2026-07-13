package in.soumyo;

import in.soumyo.notifications.WhatsappNotification;

public class OrderPlace {
    int amt;
    WhatsappNotification notifiaction = new WhatsappNotification();

    OrderPlace(int amt) {
        this.amt = amt;
    }

    void notifyUser () {
        notifiaction.notify(this.amt);
    }
}
