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

    public void initialize(){
        System.out.println(App.nuevobanco.toString());
    }
    
    public void login() throws IOException {
    String[] usuarios = {"InakiAlonso","UnaiGomez", "AbdeZafzafi", "RaulFonts","IsmaelPolanco"};
    String[] passwords = {"ialonso", "ugomez", "azafzafi", "rfonts","ipolanco"};
    String user = usuario.getText();
    String password = contraseña.getText();
    App.nom = user;
    
    
    //VALIDACION DE LECTURA DE USUARIOS Y CONTRASEÑAS
            for (var i = 0; i < App.getbanco().getListaclientes().size(); i++) {                
                if (App.getbanco().getListaclientes().get(i).equals(user)&& App.getbanco().getListaclientes().get(i).equals(password)) {
                    System.out.println("FUNCIONA");
                }
            }
            
    //ERROR INICIO DE SESIÓN
            for (int i = 0; i< App.getbanco().getListaclientes().size(); i++){
                
                //algun campo vacio
                if (user.equals("") || password.equals("")) {
                    mensaje.setText("Rellena todos los campos");
                }
                
                else if (!App.getbanco().getListaclientes().get(i).equals(user) || !App.getbanco().getListaclientes().get(i).equals(password)){
                    intentos++;
                    mensaje.setText("Error, has introducido los valores \nincorrectamente "+intentos+" vez/ces"); 
                    if (intentos == 3) {
                        usuario.setEditable(false);
                        contraseña.setEditable(false);
                        mensaje.setText("Error, has introducido los valores \nincorrectamente demasiadas veces");
                    }
                }
                break;
                
            }
    }
}       