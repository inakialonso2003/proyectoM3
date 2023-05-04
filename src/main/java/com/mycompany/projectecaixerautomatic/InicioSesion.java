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

/**
 * La clase iniciosesion gestiona el inicio de sesion de los usuarios en la
 * aplicacion.
 * Permite verificar las credenciales de los usuarios y redirigilos a la
 * interfaz correspondiente
 * 
 * @author Iñaki Alonso Ballesta
 */
public class InicioSesion {
    @FXML
    Button cambiarcontraseña;
    @FXML
    TextField usuario;
    @FXML
    PasswordField contraseña;
    @FXML
    Label mensaje;
    @FXML
    Button login;
    int intentos = 0;

    /**
     * Método que se ejecuta al inicializar el controlador de la vista.
     * Se pueden agregar aquí operaciones de inicialización adicionales si es
     * necesario.
     */
    public void initialize() {
        System.out.println(App.nuevobanco.toString());
        cambiarcontraseña.setOnAction(event -> {
            try {
                App.setRoot("cambiarcontraseña");
            } catch (IOException ex) {
                System.out.println("Error al cargar la vista cambiarcontraseña.fxml");
            }
        });
    }

    /**
     * Método que se ejecuta cuando el usuario hace clic en el botón
     * "iniciarsesion".
     * Verifica las credenciales y redirige al usuario a la pantalla correspondiente
     * si las credenciales son válidas.
     *
     * @param event El evento que representa el clic en el botón.
     * @throws IOException Si ocurre un error al cargar la interfaz de usuario.
     */
    public void login() throws IOException {
        String user = usuario.getText();
        String password = contraseña.getText();
        App.nom = user;
        // VALIDACION DE LECTURA DE USUARIOS Y CONTRASEÑAS
        boolean inicioSesionExitoso = false;
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
        if (inicioSesionExitoso) {
            App.setRoot("secondary");
        } else {
            intentos++;
            mensaje.setText("algo va mal :C has fallado " + intentos + " vez/ces");
            if (intentos == 3) {
                login.setDisable(true);
            }
        }
        App.nombreUsuario = user;
    }
}
