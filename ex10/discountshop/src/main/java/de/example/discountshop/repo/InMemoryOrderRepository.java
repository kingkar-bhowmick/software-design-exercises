package de.example.discountshop.repo;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import de.example.discountshop.domain.Order;

public class InMemoryOrderRepository implements OrderRepository {

  private final Map<UUID, Order> store = new ConcurrentHashMap<>();

  @Override
  public Order save(Order order) {
    store.put(order.getId(), order);
    return order;
  }

  @Override
  public Optional<Order> findById(UUID id) {
    return Optional.ofNullable(store.get(id));
  }
}
