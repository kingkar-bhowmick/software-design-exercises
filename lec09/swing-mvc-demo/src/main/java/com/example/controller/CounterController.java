package com.example.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.example.model.CounterModel;

public class CounterController implements ActionListener {

    private final CounterModel model;

    public CounterController(CounterModel model) {
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        switch (cmd) {
            case "INC" -> model.increment();
            case "RESET" -> model.reset();
            default -> {
            }
        }
    }
}
