package shop.notification;

//MailNotifier jetzt implementiert das Notifier Interface
public class MailNotifier implements Notifier {
    public void notify(Message msg) {
        System.out.println("MAIL -> " + msg.to());
    }
}
