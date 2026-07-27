package in.soumyo.notifications;

public class SMSNotification implements NotificationInterface{
    @Override
    public void sendNotification (int amt) {
        System.out.println("Notification of palcing order, amount " + amt + " has been sent through sms");
    }
}
