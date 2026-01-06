package com.example.productapi.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.productapi.domain.Product;
import com.example.productapi.domain.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    // GET /products
    @GetMapping
    public List<Product> list() {
        return service.findAll();
    }

    // GET /products/{id}
    @GetMapping("/{id}")
    public Product get(@PathVariable long id) {
        return service.findById(id);
    }

    // POST /products
    @PostMapping
    public Product create(@RequestBody Product product) {
        return service.create(product);
    }

    // PUT /products/{id}
    @PutMapping("/{id}")
    public Product update(@PathVariable long id, @RequestBody Product product) {
        return service.update(id, product);
    }

    // DELETE /products/{id}
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }
}
