package de.example.discountshop.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import org.junit.jupiter.api.Test;

import de.example.discountshop.domain.OrderItem;
import de.example.discountshop.domain.OrderStatus;
import de.example.discountshop.repo.InMemoryOrderRepository;
import de.example.discountshop.repo.OrderRepository;
import de.example.discountshop.repo.ProductCatalog;
import de.example.discountshop.service.error.OrderNotFoundException;

class OrderServiceTest {

  private final ProductCatalog catalog = new ProductCatalog();
  private final PricingService pricing = new PricingService(catalog);
  private final OrderRepository orders = new InMemoryOrderRepository();
  private final OrderService service = new OrderService(orders, pricing);

  @Test
  void createOrder_initializesOrderWithCreatedStatusAndZeroTotals() {
    var order = service.createOrder();

    assertNotNull(order.getId());
    assertEquals(OrderStatus.CREATED, order.getStatus());
    assertEquals(0, order.getSubtotalCents());
    assertEquals(0, order.getDiscountCents());
    assertEquals(0, order.getTotalCents());
    assertTrue(order.getItems().isEmpty());
  }

  @Test
  void getOrder_unknownId_throwsOrderNotFound() {
    assertThrows(OrderNotFoundException.class, () -> service.getOrder(UUID.randomUUID()));
  }

  @Test
  void addItem_updatesSubtotalAndTotalWithoutDiscount() {
    var order = service.createOrder();
    var updated = service.addItem(order.getId(), new OrderItem("P2", 2)); // 6998

    assertEquals(1, updated.getItems().size());
    assertEquals(6998, updated.getSubtotalCents());
    assertEquals(0, updated.getDiscountCents());
    assertEquals(6998, updated.getTotalCents());
  }
}
