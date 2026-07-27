package in.soumyo;

import in.soumyo.notifications.NotificationInterface;
import in.soumyo.notifications.SMSNotification;
import in.soumyo.notifications.WhatsappNotification;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        NotificationInterface notification1 = new SMSNotification();
        NotificationInterface notification2 = new WhatsappNotification();

        OrderPlace order = new OrderPlace(notification2, 450);
        order.notifyUser();
    }
}
