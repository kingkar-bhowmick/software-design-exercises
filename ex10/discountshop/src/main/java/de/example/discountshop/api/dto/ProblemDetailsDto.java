package de.example.discountshop.api.dto;

import java.util.List;

public record ProblemDetailsDto(
    String type,
    String title,
    int status,
    String detail,
    String instance,
    List<FieldErrorDto> errors) {
  public record FieldErrorDto(String field, String message) {
  }
}
