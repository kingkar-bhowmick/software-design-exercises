package com.example.productapi.domain;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final Map<Long, Product> store = new ConcurrentHashMap<>();
    private final AtomicLong idSeq = new AtomicLong(1000);

    public List<Product> findAll() {
        return store.values().stream()
                .sorted(Comparator.comparingLong(Product::getId))
                .toList();
    }

    public Product findById(long id) {
        return store.get(id); // returns null if not found (intentionally simple)
    }

    public Product create(Product input) {
        long id = idSeq.incrementAndGet();
        Product created = new Product(id, input.getName(), input.getPrice());
        store.put(id, created);
        return created;
    }

    public Product update(long id, Product input) {
        // simplistic: overwrite if present, otherwise create "new" at that id
        Product updated = new Product(id, input.getName(), input.getPrice());
        store.put(id, updated);
        return updated;
    }

    public void delete(long id) {
        store.remove(id);
    }
}
