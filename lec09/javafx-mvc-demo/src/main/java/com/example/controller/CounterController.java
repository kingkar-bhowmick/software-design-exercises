package com.example.controller;

import com.example.model.CounterModel;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CounterController {

    private final CounterModel model = new CounterModel();

    @FXML
    private Label valueLabel;

    @FXML
    private void initialize() {
        // Wird aufgerufen, nachdem FXML geladen ist
        updateView();
    }

    @FXML
    private void onIncrement() {
        model.increment();
        updateView();
    }
    @FXML
    private void onDecrement() {
        model.decrement();
        updateView();
    }

    @FXML
    private void onReset() {
        model.reset();
        updateView();
    }

    private void updateView() {
        valueLabel.setText(Integer.toString(model.getValue()));
    }
}
