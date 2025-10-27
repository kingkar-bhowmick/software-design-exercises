package shop.billing.export;

import shop.billing.Invoice;

public class PdfRenderer {
    public byte[] render(Invoice inv) {
        return ("PDF(" + inv.number() + ")").getBytes();
    }
}
