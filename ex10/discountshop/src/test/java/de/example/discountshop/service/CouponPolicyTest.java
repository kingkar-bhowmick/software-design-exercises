package de.example.discountshop.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CouponPolicyTest {

  @Test
  void isKnown_acceptsWelcome10_caseInsensitive() {
    assertTrue(CouponPolicy.isKnown("WELCOME10"));
    assertTrue(CouponPolicy.isKnown("welcome10"));
    assertTrue(CouponPolicy.isKnown("WeLcOmE10"));
  }

  @Test
  void isKnown_rejectsUnknownCodes() {
    assertFalse(CouponPolicy.isKnown(""));
    assertFalse(CouponPolicy.isKnown("WELCOME"));
    assertFalse(CouponPolicy.isKnown("WELCOME11"));
  }
}
