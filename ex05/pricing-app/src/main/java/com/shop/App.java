package com.shop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.shop.pricing.PriceCalculator;

public class App {
  private static final Logger log = LoggerFactory.getLogger(App.class);

  public static void main(String[] args) {
    log.info("Starting pricing app...");
    PriceCalculator calc = new PriceCalculator(0.19); // 19% MwSt
    double net = 120.0;
    double gross = calc.gross(net);
    log.info("Net: {}, VAT rate: {}, Gross: {}", net, calc.getVatRate(), gross);
    log.debug("Done.");
  }
}