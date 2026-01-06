package de.example.discountshop.repo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

  @Bean
  public ProductCatalog productCatalog() {
    return new ProductCatalog();
  }

  @Bean
  public OrderRepository orderRepository() {
    return new InMemoryOrderRepository();
  }
}
