
//Ein neu Observer, der eine Warnung ausgibt, wenn die Temperatur unter einen bestimmten Schwellenwert fällt
public class TemperatureWarningObserver implements Observer {

    private ConcreteObservable subject;
    private String name;
    private double threshold;

    public TemperatureWarningObserver(ConcreteObservable subject, String name, double threshold) {
        this.subject = subject;
        this.name = name;
        this.threshold = threshold;
    }

    @Override
    public void update() {
        if (subject == null) {
            throw new NullPointerException("Subject is null");
        }

        double t = subject.getTemperature();
        if (t < threshold) {
            System.out.print("Observer " + name + ": ");
            System.out.println("Warning! Temperature below " + threshold + "°C: " + t);
        }
    }
}
