package shop;

import shop.domain.cart.Cart;
import shop.domain.services.DiscountService;

public class Main {

    public static void main(String[] args) {
        // Warenkorb: 12 Artikel, 100 € Warenwert, VIP + Coupon
        Cart cart = new Cart(
                12, // itemCount
                100.0, // subtotal
                true, // isVip
                false, // isNewCustomer
                true // hasCoupon
        );

        DiscountService service = new DiscountService();
        double total = service.calculateTotal(cart);

        System.out.println("Subtotal: " + cart.subtotal);
        System.out.println("Endpreis (mit Rabattlogik): " + total);
    }
}
