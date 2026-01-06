package de.example.discountshop.service;

import java.util.UUID;

import de.example.discountshop.domain.Order;
import de.example.discountshop.domain.OrderItem;
import de.example.discountshop.repo.OrderRepository;
import de.example.discountshop.service.error.OrderNotFoundException;

public class OrderService {

  private final OrderRepository orders;
  private final PricingService pricing;

  public OrderService(OrderRepository orders, PricingService pricing) {
    this.orders = orders;
    this.pricing = pricing;
  }

  public Order createOrder() {
    var order = new Order(UUID.randomUUID());
    return orders.save(order);
  }

  public Order getOrder(UUID id) {
    return orders.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
  }

  public Order addItem(UUID orderId, OrderItem item) {
    // Übung: Wenn Order bereits PRICED => 409 Conflict (Mapping im API-Layer)
    var order = getOrder(orderId);
    order.addItem(item);

    // Totals aktualisieren: Subtotal sichtbar machen (ohne Coupon-Anwendung)
    int subtotal = pricing.subtotalCents(order);
    order.recalcTotals(subtotal, 0, subtotal);

    orders.save(order);
    return order;
  }

  public DiscountQuote quoteDiscount(UUID orderId, String couponCode) {
    var order = getOrder(orderId);
    return pricing.quote(order, couponCode);
  }
}
