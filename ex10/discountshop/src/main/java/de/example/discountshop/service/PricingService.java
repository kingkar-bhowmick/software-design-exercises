package de.example.discountshop.service;

import de.example.discountshop.domain.Order;
import de.example.discountshop.domain.OrderItem;
import de.example.discountshop.repo.ProductCatalog;
import de.example.discountshop.service.error.UnknownCouponException;
import de.example.discountshop.service.error.UnknownProductException;

public class PricingService {

  private final ProductCatalog catalog;

  public PricingService(ProductCatalog catalog) {
    this.catalog = catalog;
  }

  public int subtotalCents(Order order) {
    int sum = 0;
    for (OrderItem item : order.getItems()) {
      var product = catalog.findById(item.productId())
          .orElseThrow(() -> new UnknownProductException(item.productId()));
      sum += product.unitPriceCents() * item.quantity();
    }
    return sum;
  }

  public DiscountQuote quote(Order order, String couponCode) {
    if (!CouponPolicy.isKnown(couponCode)) {
      throw new UnknownCouponException(couponCode);
    }

    int subtotal = subtotalCents(order);
    int discount = 0;
    boolean applied = false;
    String reason = null;

    // WELCOME10: 10% wenn subtotal >= 5000
    if (subtotal >= 5000) {
      discount = (int) Math.floor(subtotal * 0.10);
      applied = true;
    } else {
      reason = "minTotal not reached";
    }
    int total = subtotal - discount;

    return new DiscountQuote(order.getId().toString(), couponCode.toUpperCase(), subtotal, discount, total, applied,
        reason);
  }
}
