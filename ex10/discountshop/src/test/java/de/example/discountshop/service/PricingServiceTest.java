package de.example.discountshop.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import org.junit.jupiter.api.Test;

import de.example.discountshop.domain.Order;
import de.example.discountshop.domain.OrderItem;
import de.example.discountshop.repo.ProductCatalog;
import de.example.discountshop.service.error.UnknownCouponException;
import de.example.discountshop.service.error.UnknownProductException;

class PricingServiceTest {

  private final ProductCatalog catalog = new ProductCatalog();
  private final PricingService pricing = new PricingService(catalog);

  @Test
  void subtotalCents_sumsUnitPriceTimesQuantity() {
    var order = new Order(UUID.randomUUID());
    order.addItem(new OrderItem("P1", 1)); // 1999
    order.addItem(new OrderItem("P2", 2)); // 2*3499 = 6998
    assertEquals(1999 + 6998, pricing.subtotalCents(order));
  }

  @Test
  void subtotalCents_unknownProduct_throws() {
    var order = new Order(UUID.randomUUID());
    order.addItem(new OrderItem("PX", 1));
    assertThrows(UnknownProductException.class, () -> pricing.subtotalCents(order));
  }

  @Test
  void quote_unknownCoupon_throws() {
    var order = new Order(UUID.randomUUID());
    order.addItem(new OrderItem("P2", 2));
    assertThrows(UnknownCouponException.class, () -> pricing.quote(order, "NOPE"));
  }

  @Test
  void quote_welcome10_appliesIfMinTotalReached() {
    var order = new Order(UUID.randomUUID());
    order.addItem(new OrderItem("P2", 2)); // 6998 >= 5000
    var quote = pricing.quote(order, "WELCOME10");

    assertEquals(order.getId().toString(), quote.orderId());
    assertEquals("WELCOME10", quote.couponCode());
    assertEquals(6998, quote.subtotalCents());
    assertTrue(quote.applied());
    assertNull(quote.reason());

    // floor(6998 * 0.10) = 699
    assertEquals(699, quote.discountCents());
    assertEquals(6299, quote.totalCents());
  }

  @Test
  void quote_welcome10_notAppliedIfMinTotalNotReached() {
    var order = new Order(UUID.randomUUID());
    order.addItem(new OrderItem("P1", 2)); // 3998 < 5000
    var quote = pricing.quote(order, "WELCOME10");

    assertEquals(3998, quote.subtotalCents());
    assertFalse(quote.applied());
    assertEquals("minTotal not reached", quote.reason());
    assertEquals(0, quote.discountCents());
    assertEquals(3998, quote.totalCents());
  }
}
