package de.example.discountshop.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.example.discountshop.repo.OrderRepository;
import de.example.discountshop.repo.ProductCatalog;

@Configuration
public class ServiceConfig {

  @Bean
  public PricingService pricingService(ProductCatalog catalog) {
    return new PricingService(catalog);
  }

  @Bean
  public OrderService orderService(OrderRepository orders, PricingService pricing) {
    return new OrderService(orders, pricing);
  }
}
