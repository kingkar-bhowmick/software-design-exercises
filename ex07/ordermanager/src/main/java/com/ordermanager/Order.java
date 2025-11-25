package com.ordermanager;

import java.math.BigDecimal;

public class Order {

    private String id;
    private String customerName;
    private BigDecimal totalAmount;
    private BigDecimal discount;

    // TODO: Leerer Konstruktor für Jackson
    public Order () {

    }


    // TODO: Voll-Argument-Konstruktor

    public Order(String id, String CustomerName, BigDecimal totalAmount,BigDecimal discount){
        this.id = id;
        this.customerName = CustomerName;
        this.totalAmount = totalAmount;
        this.discount = discount;



    }

    // TODO: Getter/Setter für alle Felder

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerName(){
        return customerName;
    }

    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }

    public BigDecimal getTotalAmount(){
        return totalAmount;
    }

    public void setTotalAmount (BigDecimal totalAmount){
        this.totalAmount = totalAmount;
    }

    public BigDecimal getDiscount(){
        return discount;
    }

    public void setDiscount (BigDecimal discount){
        this.discount = discount;
    }

    

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