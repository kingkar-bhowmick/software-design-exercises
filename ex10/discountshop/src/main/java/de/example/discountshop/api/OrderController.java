package de.example.discountshop.api;

import java.net.URI;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import de.example.discountshop.api.dto.AddItemRequestDto;
import de.example.discountshop.api.dto.DiscountQuoteRequestDto;
import de.example.discountshop.api.dto.DiscountQuoteResponseDto;
import de.example.discountshop.api.dto.OrderResponseDto;
import de.example.discountshop.domain.OrderItem;
import de.example.discountshop.service.OrderService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/orders")
public class OrderController {

  private final OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @PostMapping
  public ResponseEntity<OrderResponseDto> createOrder(UriComponentsBuilder ucb) {
    // 201 + Location
    var order = orderService.createOrder();
    URI location = ucb.path("/orders/{id}").buildAndExpand(order.getId().toString()).toUri();
    return ResponseEntity.created(location).body(ApiMapper.toDto(order));
  }

  @GetMapping("/{id}")
  public ResponseEntity<OrderResponseDto> getOrder(@PathVariable UUID id) {
    // 200 oder 404 (404 wird im ApiExceptionHandler gemappt)
    var order = orderService.getOrder(id);
    return ResponseEntity.ok(ApiMapper.toDto(order));
  }

  @PostMapping("/{id}/items")
  public ResponseEntity<OrderResponseDto> addItem(
      @PathVariable UUID id,
      @Valid @RequestBody AddItemRequestDto req,
      UriComponentsBuilder ucb) {
    // Diskussion: Statuscode/Location (201 vs 200; Location optional)
    var order = orderService.addItem(id, new OrderItem(req.productId(), req.quantity()));
    URI location = ucb.path("/orders/{id}").buildAndExpand(order.getId().toString()).toUri();
    return ResponseEntity.created(location).body(ApiMapper.toDto(order));
  }

  @PostMapping("/{id}/discount-quotes")
  public ResponseEntity<DiscountQuoteResponseDto> quoteDiscount(
      @PathVariable UUID id,
      @Valid @RequestBody DiscountQuoteRequestDto req) {
    var quote = orderService.quoteDiscount(id, req.couponCode());
    return ResponseEntity.ok(ApiMapper.toDto(quote));
  }
}
