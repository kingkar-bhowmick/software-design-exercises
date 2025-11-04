package shop.checkout;


class RecieptFormatter{

    public String summary(Cart cart){

        String summary = "Subtotal: " + cents(cart.subtotal) + ", " +
                "Discount: " + cents(discount) + ", " +
                "Tax: " + cents(tax) + ", " +
                "Total: " + cents(total);

                return summary;
    }

}
