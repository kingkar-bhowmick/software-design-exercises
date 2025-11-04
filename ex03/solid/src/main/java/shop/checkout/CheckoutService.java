package shop.checkout;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CheckoutService {


    /*Wird geloescht und entkoppelt*/
    /*public String checkout(Cart cart) {
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
        return String.format("%.2f €", c / 100.0);*/



        //Mock Test 

    public static void main(String[] args) {

        //(String productCode, int unitPriceCents, int quantity)
        

        // Create a list of CartItems
ArrayList < CartItem > itemList = new ArrayList< CartItem >();
        itemList.add(new CartItem("A001", 5000, 1));
        itemList.add(new CartItem("B002", 3000, 2));
        itemList.add(new CartItem("C003", 2000, 3));

        // Create a Cart and add all the items to it
    Cart cart = new Cart(itemList);


    // Use the PriceCalculator to checkout the cart
        PriceCalculator calculator = new PriceCalculator();
       calculator.checkout(cart);


    }


    }



