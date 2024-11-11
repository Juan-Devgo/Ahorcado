package co.edu.uniquindio.ahorcado.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import co.edu.uniquindio.ahorcado.Model.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import javax.swing.*;

public class ServerViewController implements Observer {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button change_word_bt;

    @FXML
    private ImageView ahorcado_imgV;

    @FXML
    private Label remaining_attempts_lb;

    @FXML
    private Label status_lb;

    @FXML
    private Label word_lb;

    private Server server;

    private char lastCharacter;

    private static final Image attempt_0 = new Image(ServerViewController.class.getResource("/Images/attempt_0.jpg").toExternalForm());
    private static final Image attempt_1 = new Image(ServerViewController.class.getResource("/Images/attempt_1.jpg").toExternalForm());
    private static final Image attempt_2 = new Image(ServerViewController.class.getResource("/Images/attempt_2.jpg").toExternalForm());
    private static final Image attempt_3 = new Image(ServerViewController.class.getResource("/Images/attempt_3.jpg").toExternalForm());
    private static final Image attempt_4 = new Image(ServerViewController.class.getResource("/Images/attempt_4.jpg").toExternalForm());
    private static final Image attempt_5 = new Image(ServerViewController.class.getResource("/Images/attempt_5.jpg").toExternalForm());
    private static final Image attempt_6 = new Image(ServerViewController.class.getResource("/Images/attempt_6.jpg").toExternalForm());
    private static final Image attempt_7 = new Image(ServerViewController.class.getResource("/Images/attempt_7.jpg").toExternalForm());

    @FXML
    void initialize() {
        try {
            server = new Server(this);
            new Thread(server).start();

            status_lb.setText("Servidor en línea.");
            initializeWidgets();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error inicializando el servidor", "Error", JOptionPane.ERROR_MESSAGE);
            status_lb.setText("Error inicializando el servidor.");
            e.printStackTrace();
        }
    }

    private String initializeWord() {
        return "*".repeat(server.getGame().getWord().length());
    }

    private void initializeWidgets() {
        ahorcado_imgV.setImage(attempt_0);
        remaining_attempts_lb.setText(String.valueOf(7));
        remaining_attempts_lb.setTextFill(Color.BLACK);
        word_lb.setText(initializeWord());
    }

    @Override
    public void update(boolean correct) {
        if(correct) {
            Platform.runLater(() -> {
                String newWord = word_lb.getText();
                String word = server.getGame().getWord();

                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == (lastCharacter)) {
                        newWord = newWord.substring(0, i) + lastCharacter + newWord.substring(i + 1);
                        word_lb.setText(newWord);
                    }
                }

                if (!newWord.contains("*")){
                    JOptionPane.showMessageDialog(null, "Has ganado!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("Cerrando conexiones.");
                    server.closeSockets();
                    JOptionPane.showMessageDialog(null, "Conexión cerrada", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                    status_lb.setText("Conexiones cerradas.");
                    remaining_attempts_lb.setText("Has ganado!");
                    remaining_attempts_lb.setTextFill(Color.GREEN);
                }
            });
        } else {
            Platform.runLater(() -> {
                int remainingAttempts = Integer.parseInt(remaining_attempts_lb.getText()) - 1;
                remaining_attempts_lb.setText(String.valueOf(remainingAttempts));
                if(remainingAttempts > 0) {
                    switch (remainingAttempts) {
                        case 1:
                            ahorcado_imgV.setImage(attempt_6);
                            break;
                        case 2:
                            ahorcado_imgV.setImage(attempt_5);
                            break;
                        case 3:
                            ahorcado_imgV.setImage(attempt_4);
                            remaining_attempts_lb.setTextFill(Color.RED);
                            break;
                        case 4:
                            ahorcado_imgV.setImage(attempt_3);
                            break;
                        case 5:
                            ahorcado_imgV.setImage(attempt_2);
                            break;
                        case 6:
                            ahorcado_imgV.setImage(attempt_1);
                        default:
                            break;
                    }
                } else {
                    ahorcado_imgV.setImage(attempt_7);
                    JOptionPane.showMessageDialog(null, "Has perdido :( Palabra: " + server.getGame().getWord(), "Game Over", JOptionPane.WARNING_MESSAGE);
                    System.out.println("Cerrando conexiones.");
                    server.closeSockets();
                    JOptionPane.showMessageDialog(null, "Conexión cerrada", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                    status_lb.setText("Conexiones cerradas.");
                }
            });
        }
    }

    //Setters
    public void setLastCharacter(char lastCharacter) {
        this.lastCharacter = lastCharacter;
    }
}