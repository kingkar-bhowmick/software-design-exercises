package de.example.discountshop.api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record AddItemRequestDto(@NotBlank String productId, @Min(1) int quantity) {
}
