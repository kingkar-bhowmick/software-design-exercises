package com.example.viewmodel;

import com.example.model.CounterModel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class CounterViewModel {

    private final CounterModel model;

    // UI-geeignete Repräsentation des Zählerwerts
    private final IntegerProperty counterValue = new SimpleIntegerProperty();

    public CounterViewModel(CounterModel model) {
        this.model = model;
        counterValue.set(model.getValue());
    }

    // Read-only Property für die View
    public ReadOnlyIntegerProperty counterValueProperty() {
        return counterValue;
    }

    private void syncFromModel() {
        counterValue.set(model.getValue());
    }

    // „Controller-Logik“ wandert hierher:
    public void increment() {
        model.increment();
        syncFromModel();
    }

    public void reset() {
        model.reset();
        syncFromModel();
    }
}