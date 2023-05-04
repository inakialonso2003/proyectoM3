package com.mycompany.projectecaixerautomatic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * La clase cuentaahorro representa la loguca de la interfaz grafica de usuario
 * para la cuenta de ahorro en el proyecto.
 * Permite realizar operaciones como ingresar, retirar y transferir fondos en la
 * cuenta de ahorro.
 * Además, permite cambiar entre cuentas y ccerrar sesion.
 */
public class cuentaahorro {
    @FXML
    TextField transferirusuario;
    @FXML
    Button seleccionarcuenta;
    @FXML
    Button cerrarsesion;
    @FXML
    RadioButton cuentaalternativa;
    @FXML
    Button realizaroperacion;
    @FXML
    Label mensajepop;
    @FXML
    TextField saldoactual;
    @FXML
    RadioButton retirar;
    @FXML
    RadioButton ingresar;
    @FXML
    RadioButton transferir;
    @FXML
    ToggleGroup operaciones;
    @FXML
    Label txtoperation;
    @FXML
    TextField operar;

    private cuentas cuentaAhorro;
    private cuentas cuentaPrincipal;

    /**
     * Método de inicializacion para configurar los elementos de la interfaz gráfica
     * de usarui y ccargar los datos de la cuenta de ahorro.
     */
    @FXML
    public void initialize() {
        transferir.setOnAction(e -> transferirusuario.setEditable(true));
        clientes cliente = null;
        for (int i = 0; i < App.getbanco().getListaclientes().size(); i++) {
            if (App.nombreUsuario.equals(App.getbanco().getListaclientes().get(i).getNombre())) {
                cliente = App.getbanco().getListaclientes().get(i);
                break;
            }
        }
        if (cliente != null) {
            for (cuentas cuenta : cliente.getCuentaclientes()) {
                if (cuenta.getTipocuenta().equals("Ahorros")) {
                    cuentaAhorro = cuenta;
                } else if (cuenta.getTipocuenta().equals("Principal")) {
                    cuentaPrincipal = cuenta;
                }
            }
        }
        if (cuentaAhorro != null) {
            saldoactual.setText(String.valueOf(cuentaAhorro.getSaldocuenta()));
        }
    }

    /**
     * Método para realizar las operaciones de ingreso, retiro y trensferencia en la
     * cuenta de ahorro.
     */
    @FXML
    private void realizarOperacion() {
        if (cuentaAhorro == null) {
            mensajepop.setText("Error: No se encontró la cuenta.");
            return;
        }
        double cantidad;
        try {
            cantidad = Double.parseDouble(operar.getText());
        } catch (NumberFormatException e) {
            mensajepop.setText("Error: La cantidad ingresada no es válida.");
            return;
        }
        if (cantidad <= 0) {
            mensajepop.setText("Error: La cantidad ingresada debe ser mayor a cero.");
            return;
        }

        if (ingresar.isSelected()) {
            cuentaAhorro.ingresar(cantidad);
            mensajepop.setText("Se ha ingresado " + cantidad + " euros en la cuenta.");
        } else if (retirar.isSelected()) {
            if (cuentaAhorro.getSaldocuenta() >= cantidad) {
                cuentaAhorro.retirar(cantidad);
                mensajepop.setText("Se ha retirado " + cantidad + " euros de la cuenta.");
            } else {
                mensajepop.setText("Error: No hay suficiente saldo en la cuenta.");
            }
        } else if (transferir.isSelected()) {
            try {
                cantidad = Double.parseDouble(operar.getText());
            } catch (NumberFormatException e) {
                mensajepop.setText("Error: La cantidad ingresada no es válida.");
                return;
            }
            if (cantidad <= 0) {
                mensajepop.setText("Error: La cantidad ingresada debe ser mayor a cero.");
                return;
            }
            clientes clienteAhorro = null;
            for (clientes cliente : App.getbanco().getListaclientes()) {
                for (cuentas cuenta : cliente.getCuentaclientes()) {
                    if (cuenta.equals(cuentaAhorro)) {
                        clienteAhorro = cliente;
                        break;
                    }
                }
            }
            if (clienteAhorro == null) {
                mensajepop.setText("Error: No se encontró el cliente de la cuenta de ahorros.");
                return;
            }
            cuentas cuentaPrincipal = null;
            for (clientes cliente : App.getbanco().getListaclientes()) {
                if (cliente.getNombre().equals(transferirusuario.getText())) {
                    for (cuentas cuenta : cliente.getCuentaclientes()) {
                        if (cuenta.getTipocuenta().equals("Principal")) {
                            cuentaPrincipal = cuenta;
                            break;
                        }
                    }
                    break;
                }
            }
            if (cuentaPrincipal == null) {
                mensajepop.setText("Error: No se encontró la cuenta principal del usuario especificado.");
                return;
            }
            if (cuentaAhorro.getSaldocuenta() >= cantidad) {
                cuentaAhorro.retirar(cantidad);
                cuentaPrincipal.ingresar(cantidad);
                saldoactual.setText(String.valueOf(cuentaAhorro.getSaldocuenta()));
                mensajepop.setText("Se ha transferido " + cantidad + " euros a la cuenta principal de "
                        + transferirusuario.getText() + ".");
            } else {
                mensajepop.setText("Error: No hay suficiente saldo en la cuenta de ahorros.");
            }
        } else if (cuentaalternativa.isSelected()) {
            double monto = Double.parseDouble(operar.getText());
            if (cuentaAhorro.getSaldocuenta() >= monto) {
                cuentaAhorro.setSaldocuenta(cuentaAhorro.getSaldocuenta() - monto);
                cuentaPrincipal.setSaldocuenta(cuentaPrincipal.getSaldocuenta() + monto);
                saldoactual.setText(String.valueOf(cuentaAhorro.getSaldocuenta()));
                mensajepop.setText("Transferencia exitosa.");
                operar.setText("");
            } else {
                mensajepop.setText("Error: fondos insuficientes.");
            }
        }
        saldoactual.setText(String.valueOf(cuentaAhorro.getSaldocuenta()));
        operar.clear();
        System.out.println(cuentaPrincipal.getSaldocuenta());
    }

    /**
     * Métpdp para cambiar a la vista de la cuenta principal.
     * 
     * @param event El evento de accion que desencadena este método
     * @throws IOException si ocurre un error al cargar la vista de la cuenta
     *                     principal
     */
    @FXML
    private void SeleccionarCuenta(ActionEvent event) throws IOException {
        App.setRoot("secondary");
    }

    /**
     * Método para cerrar sesión y volver a la pantalla de inicio de sesión.
     *
     * @param event El evento de acción que desencadena este método.
     * @throws IOException Si ocurre un error al cargar la vista de inicio de
     *                     sesión.
     */
    @FXML
    private void CerrarSesion(ActionEvent event) throws IOException {
        App.setRoot("primary");
    }

}
