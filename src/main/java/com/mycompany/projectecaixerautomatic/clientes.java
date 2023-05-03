/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectecaixerautomatic;

import java.util.ArrayList;

/**
 *
 * @author 28-12-20
 */
public class clientes {
    private String nombre;
    private String contrasena;
    private ArrayList<cuentas> cuentaclientes;
    private int IDusuario;

    public clientes(String nombre, String contrasena, int IDusuario) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.cuentaclientes = new ArrayList<cuentas>();
        this.IDusuario = IDusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public ArrayList<cuentas> getCuentaclientes() {
        return cuentaclientes;
    }

    public void setCuentaclientes(ArrayList<cuentas> cuentaclientes) {
        this.cuentaclientes = cuentaclientes;
    }

    public int getIDusuario() {
        return IDusuario;
    }

    public void setIDusuario(int IDusuario) {
        this.IDusuario = IDusuario;
    }

    public void añadircuenta(cuentas cuenta) {
        cuentaclientes.add(cuenta);
    }
}
