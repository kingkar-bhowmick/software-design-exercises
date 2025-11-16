package shop.billing.export;

import shop.billing.Invoice;

//Neue Klasse HtmlRenderer implementiert das InvoiceRenderer Interface
public class HtmlRenderer implements InvoiceRenderer
 {
    

    public byte[] render(Invoice inv){

        //Rückgabe des HTML formatierten Strings als Byte Array
      return ("HTML(" + inv.number() + ")").getBytes();
     }
    
}
