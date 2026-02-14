package de.example.discountshop.service;

public class CouponPolicy {

  public static final String WELCOME10 = "WELCOME10";

  private CouponPolicy() {
  }

  public static boolean isKnown(String code) {
    return WELCOME10.equalsIgnoreCase(code);
  }
}
