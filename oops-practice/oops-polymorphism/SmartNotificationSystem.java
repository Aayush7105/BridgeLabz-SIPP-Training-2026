abstract class Notification {

    private final String recipientName;
    private final String message;

    Notification(String recipientName, String message) {
        this.recipientName = recipientName;
        this.message = message;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public String getMessage() {
        return message;
    }

    public abstract void sendNotification();
}

class EmailNotification extends Notification {

    EmailNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    @Override
    public void sendNotification() {
        System.out.println(
            "Email sent to " + getRecipientName() + ": " + getMessage()
        );
    }
}

class SMSNotification extends Notification {

    SMSNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    @Override
    public void sendNotification() {
        System.out.println(
            "SMS sent to " + getRecipientName() + ": " + getMessage()
        );
    }
}

class PushNotification extends Notification {

    PushNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    @Override
    public void sendNotification() {
        System.out.println(
            "Push notification sent to " + getRecipientName() + ": " + getMessage()
        );
    }
}

public class SmartNotificationSystem {

    public static void main(String[] args) {
        Notification[] notifications = {
            new EmailNotification("Aarav", "Your monthly report is ready."),
            new SMSNotification("Diya", "Your OTP is 482913."),
            new PushNotification("Kabir", "Your order has been delivered.")
        };

        sendAllNotifications(notifications);
    }

    public static void sendAllNotifications(Notification[] notifications) {
        System.out.println("Sent notifications:");

        for (Notification notification : notifications) {
            notification.sendNotification();
        }
    }
}
