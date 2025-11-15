package com.shop.pricing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class PriceCalculatorTest {

    @Test
    void gross_appliesVatRate() {
        PriceCalculator calc = new PriceCalculator(0.20);
        assertEquals(120.0, calc.gross(100.0), 1e-9);
    }

    @Test
    void gross_throwsOnNegativeNet() {
        PriceCalculator calc = new PriceCalculator(0.19);
        assertThrows(IllegalArgumentException.class, () -> calc.gross(-1.0));
    }

    @Test
    void constructor_rejectsNegativeVat() {
        assertThrows(IllegalArgumentException.class, () -> new PriceCalculator(-0.01));
    }
}