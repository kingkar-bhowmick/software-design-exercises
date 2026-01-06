package de.example.discountshop.service.error;

public class UnknownCouponException extends RuntimeException {

  private final String couponCode;

  public UnknownCouponException(String couponCode) {
    super("Unknown coupon: " + couponCode);
    this.couponCode = couponCode;
  }

  public String couponCode() {
    return couponCode;
  }
}
