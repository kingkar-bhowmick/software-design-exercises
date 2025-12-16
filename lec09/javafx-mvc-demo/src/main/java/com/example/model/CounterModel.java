package com.example.model;

public class CounterModel {

    private int value = 0;

    public int getValue() {
        return value;
    }

    public void increment() {
        for (int i = value; i < 10; i++) {
            value++;
        break; }
    }

    public void decrement() {
        if (value > 0) {
            value--;
        }

    }

    public void reset() {
        value = 0;
    }
}
