package com.ordermanager;

import java.math.BigDecimal;

public class Order {

    private String id;
    private String customerName;
    private BigDecimal totalAmount;
    private BigDecimal discount;

    // TODO: Leerer Konstruktor für Jackson

    // TODO: Voll-Argument-Konstruktor

    // TODO: Getter/Setter für alle Felder

    // TODO (optional): equals und hashCode überschreiben

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", customerName='" + customerName + '\'' +
                ", totalAmount=" + totalAmount +
                ", discount=" + discount +
                '}';
    }
}