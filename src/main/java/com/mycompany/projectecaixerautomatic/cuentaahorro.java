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


public class cuentaahorro {
    
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
    @FXML
    Button realizaroperacion;
    
    
    //CUENTAS CON SU RESPECTIVO DINERO
    String[] usuarios = {"InakiAlonso","UnaiGomez", "AbdeZafzafi", "RaulFonts","IsmaelPolanco"};
    int[] dinero= {48234,36539,28673,7895,2};
    
    //INITIALIZE
    @FXML
    public void initialize(){
        mensajepop.setText(App.nom);
        for(int i=0;i<usuarios.length;i++){
            if((App.nom).equals(usuarios[i])){
                saldoactual.setText(dinero[i]+" €");
            }
        }
        operaciones.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == retirar) {
                txtoperation.setText("Retirar");
            } else if (newValue == ingresar) {
                txtoperation.setText("Ingresar");
            } else if (newValue == transferir) {
                txtoperation.setText("Transferir");
            }
        });
        
    }
    public void seleccionaroperacion(){
        String ingresos;
        int ingreso;
        int ingresototal;
        if (ingresar.isSelected()){
            for(int i=0;i<usuarios.length;i++){
            if((App.nom).equals(usuarios[i])){
                ingresos=operar.getText();
                ingreso = Integer.parseInt(ingresos);
                ingresototal=dinero[i]+ingreso;
                dinero[i]=ingresototal;
                saldoactual.setText(dinero[i]+" €");
                
            }
        }
        }
        String retiros;
        int retiro;
        int retirototal;
        if (retirar.isSelected()){
            for(int i=0;i<usuarios.length;i++){
            if((App.nom).equals(usuarios[i])){
                retiros=operar.getText();
                retiro = Integer.parseInt(retiros);
                retirototal=dinero[i]-retiro;
                dinero[i]=retirototal;
                saldoactual.setText(dinero[i]+" €");
                
            }
            }
        }
        if (transferir.isSelected()){
        
        }
    }
}
