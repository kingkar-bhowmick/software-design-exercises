package com.example.model;

public class CounterModel {

    private int value = 0;

    public int getValue() {
        return value;
    }

    public void increment() {
        value++;
    }

    public void reset() {
        value = 0;
    }
}
