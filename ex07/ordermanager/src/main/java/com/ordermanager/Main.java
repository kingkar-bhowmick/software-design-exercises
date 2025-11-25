package com.ordermanager;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("ORD-2025-00123", "Muster GmbH",
                        new BigDecimal("229.70"), new BigDecimal("10.00")),
                new Order("ORD-2025-00124", "Beispiel AG",
                        new BigDecimal("99.90"), new BigDecimal("0.00")),
                new Order("ORD-2025-00125", "Anna Schulz",
                        new BigDecimal("59.50"), new BigDecimal("5.00")));

        OrderJsonRepository repository = new OrderJsonRepository();
        try {
            for (int i = 0; i < orders.size(); i++) {
                Path filePath = Path.of("order_" + (i + 1) + ".json");
                repository.writeOrder(filePath, orders.get(i));
                System.out.println("Order written to " + filePath.toAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}