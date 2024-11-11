package co.edu.uniquindio.ahorcado.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import co.edu.uniquindio.ahorcado.Model.Costumer;
import co.edu.uniquindio.ahorcado.Model.Observer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javax.swing.*;

public class CostumerViewController implements Observer {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button A_bt;

    @FXML
    private Button B_bt;

    @FXML
    private Button C_bt;

    @FXML
    private Button D_bt;

    @FXML
    private Button E_bt;

    @FXML
    private Button F_bt;

    @FXML
    private Button G_bt;

    @FXML
    private Button H_bt;

    @FXML
    private Button I_bt;

    @FXML
    private Button J_bt;

    @FXML
    private Button K_bt;

    @FXML
    private Button L_bt;

    @FXML
    private Button M_bt;

    @FXML
    private Button NY_bt;

    @FXML
    private Button N_bt;

    @FXML
    private Button O_bt;

    @FXML
    private Button P_bt;

    @FXML
    private Button Q_bt;

    @FXML
    private Button R_bt;

    @FXML
    private Button S_bt;

    @FXML
    private Button T_bt;

    @FXML
    private Button U_bt;

    @FXML
    private Button V_bt;

    @FXML
    private Button W_bt;

    @FXML
    private Button X_bt;

    @FXML
    private Button Y_bt;

    @FXML
    private Button Z_bt;

    @FXML
    private Label status_lb;

    @FXML
    private Label word_lb;

    private char lastCharacter;

    private String word;

    private Costumer costumer;

    private int remainingAttemptsCounter;

    @FXML
    void sendA(ActionEvent event) {
        try {
            costumer.sendletter('A');
            lastCharacter = 'A';
            A_bt.setDisable(true);
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    @FXML
    void sendB(ActionEvent event) {
        try {
            costumer.sendletter('B');
            lastCharacter = 'B';
            B_bt.setDisable(true);
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    @FXML
    void sendC(ActionEvent event) {
        try {
            costumer.sendletter('C');
            lastCharacter = 'C';
            C_bt.setDisable(true);
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    @FXML
    void sendD(ActionEvent event) {
        try {
            costumer.sendletter('D');
            lastCharacter = 'D';
            D_bt.setDisable(true);
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    @FXML
    void sendE(ActionEvent event) {
        try {
            costumer.sendletter('E');
            lastCharacter = 'E';
            E_bt.setDisable(true);
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    @FXML
    void sendF(ActionEvent event) {
        try {
            costumer.sendletter('F');
            lastCharacter = 'F';
            F_bt.setDisable(true);
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    @FXML
    void sendG(ActionEvent event) {
        try {
            costumer.sendletter('G');
            lastCharacter = 'G';
            G_bt.setDisable(true);
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    @FXML
    void sendH(ActionEvent event) {
        try {
            costumer.sendletter('H');
            lastCharacter = 'H';
            H_bt.setDisable(true);
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    @FXML
    void sendI(ActionEvent event) {
        try {
            costumer.sendletter('I');
            lastCharacter = 'I';
            I_bt.setDisable(true);
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    @FXML
    void sendJ(ActionEvent event) {
        try {
            costumer.sendletter('J');
            lastCharacter = 'J';
            J_bt.setDisable(true);
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    @FXML
    void sendK(ActionEvent event) {
        try {
            costumer.sendletter('K');
            lastCharacter = 'K';
            K_bt.setDisable(true);
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    @FXML
    void sendL(ActionEvent event) {
        try {
            costumer.sendletter('L');
            lastCharacter = 'L';
            L_bt.setDisable(true);
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    @FXML
    void sendM(ActionEvent event) {
        try {
            costumer.sendletter('M');
            lastCharacter = 'M';
            M_bt.setDisable(true);
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    @FXML
    void sendN(ActionEvent event) {
        try {
            costumer.sendletter('N');
            lastCharacter = 'N';
            N_bt.setDisable(true);
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    @FXML
    void sendNY(ActionEvent event) {
        try {
            costumer.sendletter('Ñ');
            lastCharacter = 'Ñ';
            NY_bt.setDisable(true);
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    @FXML
    void sendO(ActionEvent event) {
        try {
            costumer.sendletter('O');
            lastCharacter = 'O';
            O_bt.setDisable(true);
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    @FXML
    void sendP(ActionEvent event) {
        try {
            costumer.sendletter('P');
            lastCharacter = 'P';
            P_bt.setDisable(true);
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    @FXML
    void sendQ(ActionEvent event) {
        try {
            costumer.sendletter('Q');
            lastCharacter = 'Q';
            Q_bt.setDisable(true);
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    @FXML
    void sendR(ActionEvent event) {
        try {
            costumer.sendletter('R');
            lastCharacter = 'R';
            R_bt.setDisable(true);
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    @FXML
    void sendS(ActionEvent event) {
        try {
            costumer.sendletter('S');
            lastCharacter = 'S';
            S_bt.setDisable(true);
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    @FXML
    void sendT(ActionEvent event) {
        try {
            costumer.sendletter('T');
            lastCharacter = 'T';
            T_bt.setDisable(true);
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    @FXML
    void sendU(ActionEvent event) {
        try {
            costumer.sendletter('U');
            lastCharacter = 'U';
            U_bt.setDisable(true);
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    @FXML
    void sendV(ActionEvent event) {
        try {
            costumer.sendletter('V');
            lastCharacter = 'V';
            V_bt.setDisable(true);
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    @FXML
    void sendW(ActionEvent event) {
        try {
            costumer.sendletter('W');
            lastCharacter = 'W';
            W_bt.setDisable(true);
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    @FXML
    void sendX(ActionEvent event) {
        try {
            costumer.sendletter('X');
            lastCharacter = 'X';
            X_bt.setDisable(true);
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    @FXML
    void sendY(ActionEvent event) {
        try {
            costumer.sendletter('Y');
            lastCharacter = 'Y';
            Y_bt.setDisable(true);
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    @FXML
    void sendZ(ActionEvent event) {
        try {
            costumer.sendletter('Z');
            lastCharacter = 'Z';
            Z_bt.setDisable(true);
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    @FXML
    void initialize() {
        try{
            costumer = new Costumer(111, this);
            new Thread(costumer).start();
            Thread.sleep(100);

            initializeWidgets();
            status_lb.setText("Conectado.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error inicializando el cliente", "Error", JOptionPane.ERROR_MESSAGE);
            status_lb.setText("Error inicializando el cliente.");
            e.printStackTrace();
        }
    }

    private void initializeWidgets() {

        word_lb.setText(initializeWord());
        A_bt.setDisable(false);
        B_bt.setDisable(false);
        C_bt.setDisable(false);
        D_bt.setDisable(false);
        E_bt.setDisable(false);
        F_bt.setDisable(false);
        G_bt.setDisable(false);
        H_bt.setDisable(false);
        I_bt.setDisable(false);
        J_bt.setDisable(false);
        K_bt.setDisable(false);
        L_bt.setDisable(false);
        M_bt.setDisable(false);
        N_bt.setDisable(false);
        NY_bt.setDisable(false);
        O_bt.setDisable(false);
        P_bt.setDisable(false);
        Q_bt.setDisable(false);
        R_bt.setDisable(false);
        S_bt.setDisable(false);
        T_bt.setDisable(false);
        U_bt.setDisable(false);
        V_bt.setDisable(false);
        W_bt.setDisable(false);
        X_bt.setDisable(false);
        Y_bt.setDisable(false);
        Z_bt.setDisable(false);
    }

    private String initializeWord() {
        return "*".repeat(word.length());
    }

    @Override
    public void update(boolean correct) {
        if(correct) {
            Platform.runLater(() -> {
                String newWord = word_lb.getText();

                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == (lastCharacter)) {
                        newWord = newWord.substring(0, i) + lastCharacter + newWord.substring(i + 1);
                        word_lb.setText(newWord);
                    }
                }

                if (!newWord.contains("*")) {
                    status_lb.setText("Conexiones cerradas.");
                }
            });
        } else {
            Platform.runLater(() -> {
                if(remainingAttemptsCounter >= 6) {
                    status_lb.setText("Conexiones cerradas.");
                }
                remainingAttemptsCounter++;
            });

        }
    }

    public void setWord(String word) {
        this.word = word;
        System.out.println(word);
        word_lb.setText(initializeWord());
    }
}
