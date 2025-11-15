package shop.checkout;

 public class PriceCalculator{

  public String checkout(Cart cart) {
  int subtotal = 0;
  for (CartItem it : cart.items()) {
  subtotal += it.unitPriceCents() * it.quantity();
  }
  int discount = (subtotal >= 10_000) ? (int)(subtotal * 0.10) : 0; // 10% ab 100,00€
  int tax = (int)((subtotal - discount) * 0.19); // 19% MwSt.
  int total = subtotal - discount + tax;
 
  
  RecieptFormatter formatter = new RecieptFormatter();
  

  return formatter.summary(subtotal,discount,tax,total);






  }
  
}

