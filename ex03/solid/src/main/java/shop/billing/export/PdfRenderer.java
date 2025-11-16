package shop.billing.export;

import shop.billing.Invoice;

//PdfRenderer jetzt implementiert das InvoiceRenderer Interface
public class PdfRenderer implements InvoiceRenderer {
    public byte[] render(Invoice inv) {
        return ("PDF(" + inv.number() + ")").getBytes();
    }
}
