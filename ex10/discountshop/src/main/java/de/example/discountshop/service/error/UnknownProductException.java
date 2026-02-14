package de.example.discountshop.service.error;

public class UnknownProductException extends RuntimeException {

  private final String productId;

  public UnknownProductException(String productId) {
    super("Unknown product: " + productId);
    this.productId = productId;
  }

  public String productId() {
    return productId;
  }
}
