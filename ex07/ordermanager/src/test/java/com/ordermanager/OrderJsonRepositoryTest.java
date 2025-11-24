package com.ordermanager;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class OrderJsonRepositoryTest {

    @Test
    void writeAndReadOrder_roundtrip() throws IOException {
        Order order = new Order(
                "ORD-2025-00123",
                "Muster GmbH",
                new BigDecimal("229.70"),
                new BigDecimal("10.00"));

        Path tempFile = Files.createTempFile("order", ".json");
        OrderJsonRepository repository = new OrderJsonRepository();

        repository.writeOrder(tempFile, order);
        Order loaded = repository.readOrder(tempFile);

        assertNotNull(loaded);
        assertEquals(order.getId(), loaded.getId());
        assertEquals(order.getCustomerName(), loaded.getCustomerName());
        assertEquals(order.getTotalAmount(), loaded.getTotalAmount());
        assertEquals(order.getDiscount(), loaded.getDiscount());
    }
}
