
public class Main {
public static void main(String[] args) {


ConcreteObservable weather = new ConcreteObservable();


Observer a = new ConcreteObserver(weather, "Display A");
Observer b = new ConcreteObserver(weather, "Display B");
weather.addObserver(a);
weather.addObserver(b);

// Neuer Observer, der eine Warnung ausgibt, wenn die Temperatur unter 20 Grad fällt ( Optionale aufgabe von 3)
Observer c = new TemperatureWarningObserver(weather, "WarningObserver", 20.0);

weather.addObserver(a);
weather.addObserver(b);
weather.addObserver(c);


weather.setTemperature(21.5);
weather.setTemperature(22.0);
weather.removeObserver(a);
weather.setTemperature(19.8);



// Zweite Domäne aus der optionalen Aufgabe 3 (z.B. Aktienkurs, News Feed)

System.out.println("\n--- Stock Market Domain ---\n");

ConcreteObservableStockmarket stockMarketUSA = new ConcreteObservableStockmarket();

Observer msciWorld = new ConcreteObserverStockMarket(stockMarketUSA, "MSCI World");
Observer snp500 = new ConcreteObserverStockMarket(stockMarketUSA, "S&P500");

stockMarketUSA.addObserver(msciWorld);
stockMarketUSA.addObserver(snp500);

// Beispiel-Preisupdates für das Aktienmarkt-Observable
stockMarketUSA.setPrice(4200.5);
stockMarketUSA.setPrice(4210.3);
stockMarketUSA.removeObserver(snp500);
stockMarketUSA.setPrice(4195.8);


}
}
