package com.mycompany.projectecaixerautomatic;

import java.io.IOException;
import java.util.Arrays;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class cuentaprincipal {

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

    private cuentas cuentaPrincipal;
    private cuentas cuentaAhorro;

    // INITIALIZE
    @FXML
    public void initialize() {
        clientes cliente = null;
        for (int i = 0; i < App.getbanco().getListaclientes().size(); i++) {
            if (App.nombreUsuario.equals(App.getbanco().getListaclientes().get(i).getNombre())) {
                cliente = App.getbanco().getListaclientes().get(i);
                break;
            }
        }
        if (cliente != null) {
            for (cuentas cuenta : cliente.getCuentaclientes()) {
                if (cuenta.getTipocuenta().equals("Principal")) {
                    cuentaPrincipal = cuenta;
                } else if (cuenta.getTipocuenta().equals("Ahorros")) {
                    cuentaAhorro = cuenta;
                }
            }
        }
        if (cuentaPrincipal != null) {
            saldoactual.setText(String.valueOf(cuentaPrincipal.getSaldocuenta()));
        }
    }

    // REALIZAR OPERACION
    @FXML
    private void realizarOperacion() {
        if (cuentaPrincipal == null) {
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
            cuentaPrincipal.ingresar(cantidad);
            mensajepop.setText("Se ha ingresado " + cantidad + " euros en la cuenta.");
        } else if (retirar.isSelected()) {
            if (cuentaPrincipal.getSaldocuenta() >= cantidad) {
                cuentaPrincipal.retirar(cantidad);
                mensajepop.setText("Se ha retirado " + cantidad + " euros de la cuenta.");
            } else {
                mensajepop.setText("Error: No hay suficiente saldo en la cuenta.");
            }
        } else if (transferir.isSelected()) {
            mensajepop.setText("Función no implementada.");

        } else if (cuentaalternativa.isSelected()) {
            double monto = Double.parseDouble(operar.getText());
            if (cuentaPrincipal.getSaldocuenta() >= monto) {
                cuentaPrincipal.setSaldocuenta(cuentaPrincipal.getSaldocuenta() - monto);
                cuentaAhorro.setSaldocuenta(cuentaAhorro.getSaldocuenta() + monto);
                saldoactual.setText(String.valueOf(cuentaPrincipal.getSaldocuenta()));
                mensajepop.setText("Transferencia exitosa.");
                operar.setText("");
            } else {
                mensajepop.setText("Error: fondos insuficientes.");
            }
        }
        saldoactual.setText(String.valueOf(cuentaPrincipal.getSaldocuenta()));
        operar.clear();
        System.out.println(cuentaAhorro.getSaldocuenta());
    }

    @FXML
    private void SeleccionarCuenta(ActionEvent event) throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void CerrarSesion(ActionEvent event) throws IOException {
        App.setRoot("primary");
    }
}
