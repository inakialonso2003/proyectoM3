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

    /**
     * La clase seleccioncuentas gestiona la seleccion de cuentas en la aplicacion
     * Permite a los usuarios seleccionar la cuenta que desean operar y redirige a
     * la pantalla correspondiente
     * 
     * @author Iñaki Alonso Ballesta
     */
    @FXML
    public void initialize() {
        mensajepop.setText(App.nom);

    }

    /**
     * Método que se ejecuta cuando el usuario hace clic en el botón "cuenta1".
     * Redirige al usuario a la pantalla de la cuenta 1.
     *
     * @param event El evento que representa el clic en el botón.
     * @throws IOException Si ocurre un error al cargar la interfaz de usuario.
     */
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
