package com.shop.pricing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PriceCalculator {
    private static final Logger log = LoggerFactory.getLogger(PriceCalculator.class);

    private final double vatRate;

    public PriceCalculator(double vatRate) {
        if (vatRate < 0)
            throw new IllegalArgumentException("vatRate < 0");
        this.vatRate = vatRate;
    }

    public double getVatRate() {
        return vatRate;
    }

    public double gross(double net) {
        if (net < 0) {
            log.warn("Negative net price: {}", net);
            throw new IllegalArgumentException("net < 0");
        }
        double result = net * (1.0 + vatRate);
        log.debug("gross(net={}, vatRate={}) = {}", net, vatRate, result);
        return result;
    }
}
