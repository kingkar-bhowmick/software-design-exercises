package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class CounterModel {

    private int value = 0;

    private final List<CounterListener> listeners = new ArrayList<>();

    public int getValue() {
        return value;
    }

    public void increment() {
        value++;
        notifyListeners();
    }

    public void reset() {
        value = 0;
        notifyListeners();
    }

    public void addListener(CounterListener listener) {
        listeners.add(listener);
    }

    public void removeListener(CounterListener listener) {
        listeners.remove(listener);
    }

    private void notifyListeners() {
        for (CounterListener l : listeners) {
            l.counterChanged();
        }
    }
}
