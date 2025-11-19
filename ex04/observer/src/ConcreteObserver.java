public class ConcreteObserver implements Observer {

    // TODO: Referenz auf ConcreteObservable und evtl. Name/ID
    ConcreteObservable subject; //Referenz auf ConcreteObservable
    String name; //Name/ID des Observers

    //Konstruktor mit Referenz auf ConcreteObservable und Name/ID
    public ConcreteObserver(
        /* ConcreteObservable subject, String name */ConcreteObservable subject,String name) {
              /* TODO */
             this.subject =subject; //Zuweisung der Referenz auf ConcreteObservable ( "this" bedeutet die aktuelle objectinstanz)
           this.name  = name; //Zuweisung des Namens/ID                       
    

    }

    //Update Methode, die bei Benachrichtigung aufgerufen wird
    @Override
    public void update() {

        //wenn das Subject null ist, wird eine NullPointerException geworfen
        /* TODO */
        if(subject == null){
            throw new NullPointerException("Subject is null");
        }

        //Ausgabe der neuen Temperatur
    System.out.print("Observer " + name + ": ");
    System.out.println("The new Temperature is: "  + subject.getTemperature() + " (Updated just now)");

    }

    public void warnUpdate() {
        System.out.print("Observer " + name + ": ");
        System.out.println("Warning! Significant temperature change detected: " + subject.getTemperature());
    }
}