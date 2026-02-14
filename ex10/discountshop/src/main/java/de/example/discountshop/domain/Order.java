package de.example.discountshop.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {

  private final UUID id;
  private OrderStatus status;
  private final List<OrderItem> items;
  private int subtotalCents;
  private int discountCents;
  private int totalCents;

  public Order(UUID id) {
    this.id = id;
    this.status = OrderStatus.CREATED;
    this.items = new ArrayList<>();
    recalcTotals(0, 0, 0);
  }

  public UUID getId() {
    return id;
  }

  public OrderStatus getStatus() {
    return status;
  }

  public void setStatus(OrderStatus status) {
    this.status = status;
  }

  public List<OrderItem> getItems() {
    return items;
  }

  public int getSubtotalCents() {
    return subtotalCents;
  }

  public int getDiscountCents() {
    return discountCents;
  }

  public int getTotalCents() {
    return totalCents;
  }

  public void addItem(OrderItem item) {
    items.add(item);
  }

  public void recalcTotals(int subtotalCents, int discountCents, int totalCents) {
    this.subtotalCents = subtotalCents;
    this.discountCents = discountCents;
    this.totalCents = totalCents;
  }
}
