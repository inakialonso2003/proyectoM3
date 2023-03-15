
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
    
    //CUENTAS CON SU RESPECTIVO DINERO
    String[] usuarios = {"InakiAlonso","UnaiGomez", "AbdeZafzafi", "RaulFonts","IsmaelPolanco"};
    int[] dinero= {2908,2442,1223,5565,1};
    
    //INITIALIZE
    @FXML
    public void initialize(){
        mensajepop.setText(App.nom);
        for(int i=0;i<usuarios.length;i++){
            if((App.nom).equals(usuarios[i])){
                saldoactual.setText(dinero);
            }
        }
    }
    
    //PROGRAMA PRINCIPAL
    public void seleccioncuenta(){
     
    }
}
