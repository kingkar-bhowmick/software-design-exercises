package de.example.discountshop.api.dto;

import java.util.List;

public record OrderResponseDto(
        String id,
        String status,
        List<OrderItemDto> items,
        int subtotalCents,
        int discountCents,
        int totalCents) {
}
