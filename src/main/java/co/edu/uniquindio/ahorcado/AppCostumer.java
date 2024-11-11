package co.edu.uniquindio.ahorcado;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppCostumer extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AppCostumer.class.getResource("costumer-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 340, 240);
        stage.setTitle("Enviar Letras");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}