public class ConcreteObserverStockMarket implements Observer {

    // Referenz auf das stockmarket-Observable und Name/ID
    ConcreteObservableStockmarket subject; // Referenz auf ConcreteObservableStockmarket
    String name; // Name/ID des Observers

    // Konstruktor mit Referenz auf ConcreteObservableStockmarket und Name/ID
    public ConcreteObserverStockMarket(ConcreteObservableStockmarket subject, String name) {
        this.subject = subject; // Zuweisung der Referenz auf ConcreteObservableStockmarket
        this.name = name; // Zuweisung des Namens/ID
    }

    // Update-Methode, die bei Benachrichtigung aufgerufen wird
    @Override
    public void update() {
        // Wenn das Subject null ist, wird eine NullPointerException geworfen
        if (subject == null) {
            throw new NullPointerException("Subject is null");
        }

        // Ausgabe des neuen Aktienpreises
        System.out.print("Observer " + name + ": ");
        System.out.println("The new price is: " + subject.getPrice() + " (Updated just now)");
    }
}