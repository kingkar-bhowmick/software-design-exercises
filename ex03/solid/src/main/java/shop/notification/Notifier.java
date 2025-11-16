package shop.notification;

//Interaface wurde erstellt (Schnittstellen einführen (DIP))
public interface Notifier {
    
    //Methode notify deklariert
    void notify(Message msg); 
}
