package de.example.discountshop.repo;

import java.util.Optional;
import java.util.UUID;

import de.example.discountshop.domain.Order;

public interface OrderRepository {

  Order save(Order order);

  Optional<Order> findById(UUID id);
}
