package shop.checkout;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CheckoutService {


    //Eine Klasse eine Anderungsgründe haben (SRP)
    //Deswegen ist alle funktion, in jeweilige Klasse ausgelagert.
    public String checkout(Cart cart) {

         //Preisberechnung in eigene Klasse ausgelagert
        PriceCalculator calculator = new PriceCalculator();
             

    return calculator.calulate(cart);
    }



}
        /* 
         * public static void main(String[] args) {

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
        */

    



