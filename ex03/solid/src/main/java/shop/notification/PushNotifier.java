package shop.notification;

//Zusatzlich erstellte Klasse PushNotifier implementiert das Notifier Interface
public class PushNotifier implements Notifier {
    
    //Implementierung der notify Methode
    public void notify(Message msg){

        //Ausgabe der Push Benachrichtigung nur -> anstelle der Mail Benachrichtigung wurde Push Notification ausgegeben
         System.out.println("Push Notification -> " + msg.to());
    }
}
