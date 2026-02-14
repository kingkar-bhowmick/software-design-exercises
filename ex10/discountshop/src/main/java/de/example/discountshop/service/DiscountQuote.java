package de.example.discountshop.service;

public record DiscountQuote(
        String orderId,
        String couponCode,
        int subtotalCents,
        int discountCents,
        int totalCents,
        boolean applied,
        String reason) {
}
