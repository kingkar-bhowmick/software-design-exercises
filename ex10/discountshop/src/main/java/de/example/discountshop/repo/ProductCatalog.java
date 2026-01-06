package de.example.discountshop.repo;

import java.util.List;
import java.util.Optional;

import de.example.discountshop.domain.Product;

public class ProductCatalog {

  private final List<Product> products = List.of(
      new Product("P1", "Notebook Sleeve", 1999),
      new Product("P2", "USB-C Hub", 3499),
      new Product("P3", "Mechanical Keyboard", 8999));

  public List<Product> findAll() {
    return products;
  }

  public Optional<Product> findById(String id) {
    return products.stream().filter(p -> p.id().equals(id)).findFirst();
  }
}
