package shop.checkout;

//Implementierung des Logging Interface (DIP)
public class LogginConsole implements Logging {

//Methode zur Konsolenausgabe des Gesamtpreises
    @Override
 public void log(String total){

 System.out.println("[LOGINFO] checkout total=" + total);

 }



}
