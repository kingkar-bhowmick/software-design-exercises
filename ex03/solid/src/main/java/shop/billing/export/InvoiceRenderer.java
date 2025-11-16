package shop.billing.export;

import shop.billing.Invoice;

//Interface InvoiceRenderer erstellt (Schnittstellen einführen (DIP))
public interface InvoiceRenderer {
    

     byte[] render(Invoice inv);
}
