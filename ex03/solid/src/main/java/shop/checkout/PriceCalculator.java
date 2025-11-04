package shop.checkout;

 public class PriceCalculator{

public int checkout(Cart cart) {
        int subtotal = 0;
        for (CartItem it : cart.items()) {
            subtotal += it.unitPriceCents() * it.quantity();
        }
        int discount = (subtotal >= 10_000) ? (int) (subtotal * 0.10) : 0;
        int tax = (int) ((subtotal - discount) * 0.19);
        int total = subtotal - discount + tax;

        return total;

    }

}