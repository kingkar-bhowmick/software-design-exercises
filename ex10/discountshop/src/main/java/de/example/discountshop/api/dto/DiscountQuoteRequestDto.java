package de.example.discountshop.api.dto;

import jakarta.validation.constraints.NotBlank;

public record DiscountQuoteRequestDto(@NotBlank String couponCode) {
}
