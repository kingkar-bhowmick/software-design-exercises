package shop.notification;

public class MailNotifier {
    public void notify(Message msg) {
        System.out.println("MAIL -> " + msg.to());
    }
}
