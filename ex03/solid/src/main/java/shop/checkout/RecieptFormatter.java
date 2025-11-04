package shop.checkout;


class RecieptFormatter{

    public void summary(int subtotal, int discount, int tax, int total) {
 String reciept = "Subtotal: " + cents(subtotal) + ", " +
  "Discount: " + cents(discount) + ", " +
  "Tax: " + cents(tax) + ", " +
  "Total: " + cents(total);
      
  System.out.println(reciept);
  
  LogginConsole logger = new LogginConsole();
    logger.log(String.valueOf(total));
    }


private String cents(int c) {
  return String.format("%.2f €", c / 100.0);
  }

}
