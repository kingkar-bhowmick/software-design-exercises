package com.example.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.example.model.CounterListener;
import com.example.model.CounterModel;

public class CounterView extends JPanel implements CounterListener {

    private final CounterModel model;

    private final JLabel valueLabel = new JLabel("0", SwingConstants.CENTER);
    private final JButton incrementButton = new JButton("+1");
    private final JButton resetButton = new JButton("Reset");

    public CounterView(CounterModel model) {
        this.model = model;
        initUi();
    }

    private void initUi() {
        setLayout(new BorderLayout(10, 10));

        JLabel titleLabel = new JLabel("Swing Counter (klassisches MVC)", SwingConstants.CENTER);
        valueLabel.setFont(valueLabel.getFont().deriveFont(32f));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.add(incrementButton);
        buttonPanel.add(resetButton);

        add(titleLabel, BorderLayout.NORTH);
        add(valueLabel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void setController(ActionListener controller) {
        incrementButton.setActionCommand("INC");
        resetButton.setActionCommand("RESET");

        incrementButton.addActionListener(controller);
        resetButton.addActionListener(controller);
    }

    @Override
    public void counterChanged() {
        int current = model.getValue();
        valueLabel.setText(Integer.toString(current));
    }
}