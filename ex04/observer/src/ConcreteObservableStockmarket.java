import java.util.*;

// ConcreteObservableStockmarket implementiert Observable für das Aktienmarkt-Domain
public class ConcreteObservableStockmarket implements Observable {

    // Liste der registrierten Observer und ein Beispielzustand: price (double)
    private List<Observer> observers;
    private double price;

    // Konstruktor
    public ConcreteObservableStockmarket() {
        observers = new ArrayList<>();
    }


   

    //Oberver wurde hinzugefügt, entfernt und benachrichtigt
    @Override
    public void addObserver(Observer o) {
        /* TODO */
        //Observers wurde in list hinzugefügt
        observers.add(o);
    }

    
    @Override
    public void removeObserver(Observer o) {
        /* TODO */

        //Observer wurde aus der list entfernt
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        /* TODO */

        //Alle Observer in der Liste werden benachrichtigt, indem die update Methode aufgerufen wird
        for (Observer o : observers)
        {
            //Benachrichtigung der Observer über Iteration von alle Observer in der Liste
            o.update();

           
        }
    }

    // TODO: Getter/Setter für den Zustand (z. B. getTemperature/setTemperature)

    // Getter für den Preis (Beispielzustand)
    public double getPrice() {
        return price;
    }

    // Setter für den Preis und Benachrichtigung der Observer bei Änderung
    public void setPrice(double p) {
        price = p; // Setzen des neuen Preises
        notifyObservers(); // Benachrichtigung der Observer bei Änderung
    }

}
