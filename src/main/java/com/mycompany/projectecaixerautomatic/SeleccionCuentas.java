package com.mycompany.projectecaixerautomatic;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class SeleccionCuentas {
    @FXML
    Button principal;
    @FXML
    Button ahorros;
    @FXML
    Label mensajepop;
    @FXML
    Label mensaje;

    @FXML
    public void initialize() {
        mensajepop.setText(App.nom);

    }

    public void seleccionarcuenta(ActionEvent event) throws IOException {
        boolean cuenta;
        if (event.getSource() == principal) {
            cuenta = true;
            App.cuentas = cuenta;
            mensaje.setText("CUENTA PRINCIPAL");
            App.setRoot("terciary");
        } else if (event.getSource() == ahorros) {
            cuenta = false;
            mensaje.setText("CUENTA AHORROS");
            App.cuentas = cuenta;
            App.setRoot("cuarto");
        }
    }
}
