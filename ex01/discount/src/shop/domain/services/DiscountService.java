package shop.domain.services;

import shop.domain.cart.Cart;

public class DiscountService {

    public double calculateTotal(Cart cart) {
        double discount = 0.0;

        // VIP-Rabatt: 10%
        if (cart.isVip) {
            discount = cart.subtotal * 0.10;
        }

        // Neukunden-Rabatt: 5%
        if (cart.isNewCustomer) {
            discount = cart.subtotal * 0.05;
        }

        // Mengenrabatt
        if (cart.itemCount >= 20) {
            discount = cart.subtotal * 0.05; // 5% ab 20 Stück
        } else if (cart.itemCount >= 10) {
            discount = cart.subtotal * 0.03; // 3% ab 10 Stück
        }

        // Coupon-Rabatt: 7%
        if (cart.hasCoupon) {
            discount = cart.subtotal * 0.07;
        }

        double total = cart.subtotal - discount;
        if (total < 0.0) {
            total = 0.0;
        }
        return total;
    }
}
