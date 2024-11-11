module co.edu.uniquindio.ahorcado {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens co.edu.uniquindio.ahorcado to javafx.fxml;
    exports co.edu.uniquindio.ahorcado;
    exports co.edu.uniquindio.ahorcado.Controllers;
    opens co.edu.uniquindio.ahorcado.Controllers to javafx.fxml;
}