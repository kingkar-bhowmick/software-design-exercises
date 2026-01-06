package de.example.discountshop.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import de.example.discountshop.api.dto.ProblemDetailsDto;
import de.example.discountshop.service.error.OrderNotFoundException;
import de.example.discountshop.service.error.UnknownCouponException;
import de.example.discountshop.service.error.UnknownProductException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ApiExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ProblemDetailsDto> handleValidation(MethodArgumentNotValidException ex,
      HttpServletRequest request) {
    List<ProblemDetailsDto.FieldErrorDto> errors = ex.getBindingResult().getFieldErrors().stream()
        .map(this::toFieldError)
        .toList();

    var body = new ProblemDetailsDto(
        "urn:problem-type:validation-error",
        "Validation failed",
        400,
        "One or more fields are invalid.",
        request.getRequestURI(),
        errors);
    return ResponseEntity.badRequest().body(body);
  }

  @ExceptionHandler(OrderNotFoundException.class)
  public ResponseEntity<ProblemDetailsDto> handleOrderNotFound(OrderNotFoundException ex, HttpServletRequest request) {
    var body = new ProblemDetailsDto(
        "urn:problem-type:order-not-found",
        "Order not found",
        404,
        ex.getMessage(),
        request.getRequestURI(),
        null);
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
  }

  @ExceptionHandler(UnknownProductException.class)
  public ResponseEntity<ProblemDetailsDto> handleUnknownProduct(UnknownProductException ex,
      HttpServletRequest request) {
    var body = new ProblemDetailsDto(
        "urn:problem-type:unknown-product",
        "Unknown product",
        400,
        ex.getMessage(),
        request.getRequestURI(),
        null);
    return ResponseEntity.badRequest().body(body);
  }

  @ExceptionHandler(UnknownCouponException.class)
  public ResponseEntity<ProblemDetailsDto> handleUnknownCoupon(UnknownCouponException ex, HttpServletRequest request) {
    var body = new ProblemDetailsDto(
        "urn:problem-type:unknown-coupon",
        "Unknown coupon",
        400,
        ex.getMessage(),
        request.getRequestURI(),
        null);
    return ResponseEntity.badRequest().body(body);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ProblemDetailsDto> handleFallback(Exception ex, HttpServletRequest request) {
    var body = new ProblemDetailsDto(
        "urn:problem-type:internal-error",
        "Internal Server Error",
        500,
        "Unexpected error.",
        request.getRequestURI(),
        null);
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
  }

  private ProblemDetailsDto.FieldErrorDto toFieldError(FieldError fe) {
    return new ProblemDetailsDto.FieldErrorDto(fe.getField(), fe.getDefaultMessage());
  }
}
