package shop.domain.cart;

public class Cart {

    public int itemCount; // Anzahl der Artikel im Warenkorb
    public double subtotal; // Summe der Waren (ohne Rabatt)
    public boolean isVip; // VIP-Kunde?
    public boolean isNewCustomer; // Neukunde?
    public boolean hasCoupon; // Hat einen gültigen Coupon?

    public Cart(int itemCount, double subtotal, boolean isVip, boolean isNewCustomer, boolean hasCoupon) {
        this.itemCount = itemCount;
        this.subtotal = subtotal;
        this.isVip = isVip;
        this.isNewCustomer = isNewCustomer;
        this.hasCoupon = hasCoupon;
    }
}
