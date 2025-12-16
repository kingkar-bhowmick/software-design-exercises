package com.example;

import com.example.model.CounterModel;
import com.example.view.CounterView;
import com.example.viewmodel.CounterViewModel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        CounterModel model = new CounterModel();
        CounterViewModel viewModel = new CounterViewModel(model);

        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/counter-view.fxml"));

        // ControllerFactory injiziert das ViewModel in die View
        loader.setControllerFactory(type -> {
            if (type == CounterView.class) {
                return new CounterView(viewModel);
            }
            try {
                return type.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        Scene scene = new Scene(loader.load(), 300, 200);
        stage.setTitle("JavaFX MVVM Counter");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}