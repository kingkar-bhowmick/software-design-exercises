package com.example;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.example.controller.CounterController;
import com.example.model.CounterModel;
import com.example.view.CounterView;

public class MainApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainApp::createAndShowGui);
    }

    private static void createAndShowGui() {
        CounterModel model = new CounterModel();
        CounterView view = new CounterView(model);
        CounterController controller = new CounterController(model);

        model.addListener(view);
        view.setController(controller);

        JFrame frame = new JFrame("MVC mit Swing (klassisch)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(view);

        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
