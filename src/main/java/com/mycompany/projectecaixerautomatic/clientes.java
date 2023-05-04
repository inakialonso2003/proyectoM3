/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectecaixerautomatic;

import java.util.ArrayList;

/**
 * Constructor de la clase clientes
 * Inicializa el nombre, la contraseña y el ID del usuario, y crea una lista
 * vacía de cuentas.
 * 
 * @author Iñaki Alonso Ballesta
 */
public class clientes {
    private String nombre;
    private String contrasena;
    private ArrayList<cuentas> cuentaclientes;
    private int IDusuario;

    /**
     * 
     * @param nombre     El nombre del cliente.
     * @param contrasena La contraseña del cliente.
     * @param IDusuario  El ID del usuario del cliente.
     */
    public clientes(String nombre, String contrasena, int IDusuario) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.cuentaclientes = new ArrayList<cuentas>();
        this.IDusuario = IDusuario;
    }

    /**
     * Getters y setters
     * 
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * 
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * 
     * @return
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * 
     * @param contrasena
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * 
     * @return
     */
    public ArrayList<cuentas> getCuentaclientes() {
        return cuentaclientes;
    }

    /**
     * 
     * @param cuentaclientes
     */
    public void setCuentaclientes(ArrayList<cuentas> cuentaclientes) {
        this.cuentaclientes = cuentaclientes;
    }

    /**
     * 
     * @return
     */
    public int getIDusuario() {
        return IDusuario;
    }

    /**
     * 
     * @param IDusuario
     */
    public void setIDusuario(int IDusuario) {
        this.IDusuario = IDusuario;
    }

    /**
     * Añade una cuenta a la lista de cuentas del cliente.
     * 
     * @param cuenta El objeto cuenta que se va a añadir.
     */
    public void añadircuenta(cuentas cuenta) {
        cuentaclientes.add(cuenta);
    }
}
