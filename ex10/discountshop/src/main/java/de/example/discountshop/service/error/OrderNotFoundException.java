package de.example.discountshop.service.error;

import java.util.UUID;

public class OrderNotFoundException extends RuntimeException {

  private final UUID orderId;

  public OrderNotFoundException(UUID orderId) {
    super("Order not found: " + orderId);
    this.orderId = orderId;
  }

  public UUID orderId() {
    return orderId;
  }
}
