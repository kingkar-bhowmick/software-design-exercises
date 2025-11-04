package shop.checkout;

public class CheckoutService {


    /*Wird geloescht*/
    public String checkout(Cart cart) {
        int subtotal = 0;
        for (CartItem it : cart.items()) {
            subtotal += it.unitPriceCents() * it.quantity();
        }
        int discount = (subtotal >= 10_000) ? (int) (subtotal * 0.10) : 0;
        int tax = (int) ((subtotal - discount) * 0.19);
        int total = subtotal - discount + tax;

        String summary = "Subtotal: " + cents(subtotal) + ", " +
                "Discount: " + cents(discount) + ", " +
                "Tax: " + cents(tax) + ", " +
                "Total: " + cents(total);

        System.out.println("[LOGINFO] checkout total=" + total);

        return summary;
    }

    private String cents(int c) {
        return String.format("%.2f €", c / 100.0);
    }
}


