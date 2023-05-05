package com.mycompany.projectecaixerautomatic;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * La clase cambiarcontraseña representa el controlador para la
 * funcionalidad de cambio de contraseña
 * Esta clase maneja la lógica para validad y cambiar la contraseña de
 * un usuario utilizando la información ingresada en la interfaz gráfica
 * 
 * @author Iñaki Alonso Ballesta
 * 
 */
public class cambiarcontraseña {

    @FXML
    public Button seleccionusuario;

    @FXML
    public TextField usuario;

    @FXML
    public TextField contraseña;

    @FXML
    public TextField contraseñanueva;

    @FXML
    public TextField repetircontraseña;

    /**
     * Método de inicialización. Se ejecuta automáticamente después de cargar la
     * interfaz gráfica.
     */
    @FXML
    public void initialize() {

    }

    /**
     * Método para cambiar la contraseña del usuario en función de la información
     * ingresada en la interfaz gráfica.
     * Realiza las validaciones necesarias para asegurar que el usuario, la
     * contraseña y la nueva contraseña sean válidos.
     */
    public void cambiarContraseña() {
        String usuarioIngresado = usuario.getText();
        String contraseñaIngresada = contraseña.getText();
        String nuevaContraseña = contraseñanueva.getText();
        String repetirContraseña = repetircontraseña.getText();

        /**
         * Obtener el cliente correspondiente al usuario ingresado
         */
        clientes cliente = App.getbanco().buscarClientePorNombre(usuarioIngresado);

        if (cliente == null) {
            /**
             * El usuario ingresado no existe
             */
            System.out.println("El usuario ingresado no existe");
            return;
        }

        /**
         * Verificar la contraseña del usuario
         */
        if (!cliente.getContrasena().equals(contraseñaIngresada)) {
            /**
             * La contraseña ingresada no coincide con la contraseña del usuario
             */
            System.out.println("La contraseña ingresada es incorrecta");
            return;
        }
        /**
         * Verificar la contraseña del usuario
         */
        if (!nuevaContraseña.equals(repetirContraseña)) {
            /**
             * Las nuevas contraseñas no coinciden
             */
            System.out.println("Las nuevas contraseñas no coinciden");
            return;
        }

        /**
         * Cambiar la contraseña del usuario
         */
        cliente.setContrasena(nuevaContraseña);
        System.out.println("La contraseña ha sido cambiada con éxito");
    }

    /**
     * 
     * @param event
     * @throws IOException
     */
    @FXML
    private void seleccionarcuenta(ActionEvent event) throws IOException {
        App.setRoot("primary");
    }

}
