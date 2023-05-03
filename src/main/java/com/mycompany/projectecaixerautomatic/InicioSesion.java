package com.mycompany.projectecaixerautomatic;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class InicioSesion {
    @FXML
    TextField usuario;
    @FXML
    PasswordField contraseña;
    @FXML
    Label mensaje;
    @FXML
    Button login;
    int intentos = 0;

    public void initialize() {
        System.out.println(App.nuevobanco.toString());
    }

    public void login() throws IOException {
        String user = usuario.getText();
        String password = contraseña.getText();
        App.nom = user;
        int intentos = 0;
        // VALIDACION DE LECTURA DE USUARIOS Y CONTRASEÑAS
        boolean inicioSesionExitoso;
        if (user.trim().isEmpty() || password.trim().isEmpty()) {
            mensaje.setText("Por favor, rellene todos los campos");
            return;
        }
        for (var i = 0; i < App.getbanco().getListaclientes().size(); i++) {
            clientes cliente = App.getbanco().getListaclientes().get(i);
            if (cliente.getNombre().equals(user) && cliente.getContrasena().equals(password)) {
                inicioSesionExitoso = true;
                break;
            }
        }
    }
}