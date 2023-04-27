package com.mycompany.projectecaixerautomatic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
//
public class App extends Application {
    
    static clientes sesion;
    
    static banco nuevobanco;
    
    public static banco getbanco(){
        return nuevobanco;
    }
    
    static clientes cliente1;
    static clientes cliente2;
    
    
    
    
    private static Scene scene;

    static String nom;
    static boolean cuentas;
    @Override
    public void start(Stage stage) throws IOException {
        
        nuevobanco= new banco("CAIXABANK");
        cliente1 = new clientes("inaki","inaki",01);
        cliente2 = new clientes("isma","isma",02);
        cliente1.añadircuenta(new cuentas(01,"Ahorros",2000));
        cliente2.añadircuenta(new cuentas(02,"Principal",1560));
        cliente2.añadircuenta(new cuentas(03,"Ahorros",3000));
        cliente1.añadircuenta(new cuentas(04,"Principal",1800));
        nuevobanco.añadircliente(cliente1);
        nuevobanco.añadircliente(cliente2);
        
  
        
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}