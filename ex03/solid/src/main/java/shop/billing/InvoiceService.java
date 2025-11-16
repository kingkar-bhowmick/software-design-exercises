package shop.billing;

import shop.billing.export.*;
import shop.billing.export.*;
import shop.notification.*;
import shop.notification.*;

public class InvoiceService {


    public InvoiceService(InvoiceRenderer r, Notifier n) {

        
    }

    public byte[] exportAndNotify(Invoice inv, String recipient) {
        PdfRenderer renderer = new PdfRenderer();
        MailNotifier notifier = new MailNotifier();

        byte[] pdf = renderer.render(inv);
        notifier.notify(new Message(recipient, "Your Invoice", "See attachment", pdf));
        return pdf;
    }
}
