package com.example.view;

import com.example.viewmodel.CounterViewModel;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CounterView {

    private final CounterViewModel viewModel;

    @FXML
    private Label valueLabel;

    @FXML
    private Button resetButton;

    public CounterView(CounterViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @FXML
    private void initialize() {
        // Binding: Label-Text spiegelt automatisch den Wert aus dem ViewModel
        valueLabel.textProperty().bind(
                viewModel.counterValueProperty().asString());

        // Beispiel für weiteres Binding:
        // Reset-Button ist deaktiviert, wenn der Zähler 0 ist
        resetButton.disableProperty().bind(
                viewModel.counterValueProperty().isEqualTo(0));
    }

    @FXML
    private void onIncrement() {
        viewModel.increment();
    }

    @FXML
    private void onReset() {
        viewModel.reset();
    }
}
