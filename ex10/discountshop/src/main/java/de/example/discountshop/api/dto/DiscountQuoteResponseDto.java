package de.example.discountshop.api.dto;

public record DiscountQuoteResponseDto(
        String orderId,
        String couponCode,
        int subtotalCents,
        int discountCents,
        int totalCents,
        boolean applied,
        String reason) {
}
