package de.example.discountshop.api;

import java.util.stream.Collectors;

import de.example.discountshop.api.dto.DiscountQuoteResponseDto;
import de.example.discountshop.api.dto.OrderItemDto;
import de.example.discountshop.api.dto.OrderResponseDto;
import de.example.discountshop.domain.Order;
import de.example.discountshop.service.DiscountQuote;

public class ApiMapper {

  public static OrderResponseDto toDto(Order order) {
    var items = order.getItems().stream()
        .map(i -> new OrderItemDto(i.productId(), i.quantity()))
        .collect(Collectors.toList());

    return new OrderResponseDto(
        order.getId().toString(),
        order.getStatus().name(),
        items,
        order.getSubtotalCents(),
        order.getDiscountCents(),
        order.getTotalCents());
  }

  public static DiscountQuoteResponseDto toDto(DiscountQuote quote) {
    return new DiscountQuoteResponseDto(
        quote.orderId(),
        quote.couponCode(),
        quote.subtotalCents(),
        quote.discountCents(),
        quote.totalCents(),
        quote.applied(),
        quote.reason());
  }
}
