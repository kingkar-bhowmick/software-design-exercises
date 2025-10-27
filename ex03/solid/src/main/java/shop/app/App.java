package shop.app;

import java.util.List;

import shop.billing.Invoice;
import shop.billing.InvoiceService;
import shop.checkout.Cart;
import shop.checkout.CartItem;
import shop.checkout.CheckoutService;

public class App {

    public static void main(String[] args) {
        runCheckoutDemo();
        runInvoiceDemo();
    }

    private static void runCheckoutDemo() {
        CheckoutService service = new CheckoutService();
        Cart cart = new Cart(List.of(
                new CartItem("A-100", 1500, 2),
                new CartItem("B-200", 3250, 1),
                new CartItem("C-300", 990, 5)
        ));

        String summary = service.checkout(cart);
        System.out.println(summary);
    }

    private static void runInvoiceDemo() {
        InvoiceService app = new InvoiceService();
        byte[] pdf = app.exportAndNotify(new Invoice("INV-123"), "customer@example.com");
        System.out.println("Generated doc bytes: " + new String(pdf));
    }
}
