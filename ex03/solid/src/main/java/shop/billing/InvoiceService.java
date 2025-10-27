package shop.billing;

import shop.billing.export.PdfRenderer;
import shop.notification.MailNotifier;
import shop.notification.Message;

public class InvoiceService {
    public byte[] exportAndNotify(Invoice inv, String recipient) {
        PdfRenderer renderer = new PdfRenderer();
        MailNotifier notifier = new MailNotifier();

        byte[] pdf = renderer.render(inv);
        notifier.notify(new Message(recipient, "Your Invoice", "See attachment", pdf));
        return pdf;
    }
}
