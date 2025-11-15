package shop.checkout;


class RecieptFormatter{

    public String summary(int subtotal, int discount, int tax, int total) {
 String reciept = "Subtotal: " + cents(subtotal) + ", " +
  "Discount: " + cents(discount) + ", " +
  "Tax: " + cents(tax) + ", " +
  "Total: " + cents(total);

  
  LogginConsole logger = new LogginConsole();
    logger.log(String.valueOf(total));

  return reciept;
    }


private String cents(int c) {
  return String.format("%.2f €", c / 100.0);
  }

}
