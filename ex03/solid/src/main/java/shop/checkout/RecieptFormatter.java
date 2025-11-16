package shop.checkout;

//Formatierung des Kassenbons in eigene Klasse ausgelagert (SRP)

public class RecieptFormatter{

  //Methode zur Formatierung des Kassenbons
    public String summary(int subtotal, int discount, int tax, int total) {
 String reciept = "Subtotal: " + cents(subtotal) + ", " +
  "Discount: " + cents(discount) + ", " +
  "Tax: " + cents(tax) + ", " +
  "Total: " + cents(total);

  
  LogginConsole logger = new LogginConsole();
    logger.log(String.valueOf(total));

  return reciept;

  
    }


private String cents(int c) {
  return String.format("%.2f €", c / 100.0);
  }

}
