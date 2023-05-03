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
public class banco {

    private String nombrebanco;
    private ArrayList<clientes> listaclientes;

    public banco(String nombrebanco) {
        this.nombrebanco = nombrebanco;
        this.listaclientes = new ArrayList<clientes>();
    }

    public String getNombrebanco() {
        return nombrebanco;
    }

    public void setNombrebanco(String nombrebanco) {
        this.nombrebanco = nombrebanco;
    }

    public ArrayList<clientes> getListaclientes() {
        return listaclientes;
    }

    public void setListaclientes(ArrayList<clientes> listaclientes) {
        this.listaclientes = listaclientes;
    }

    public void añadircliente(clientes cliente) {
        listaclientes.add(cliente);
    }

    public clientes buscarClientePorNombre(String nombreCliente) {
        for (clientes cliente : listaclientes) {
            if (cliente.getNombre().equals(nombreCliente)) {
                return cliente;
            }
        }
        return null; // Devuelve null si no se encontró el cliente
    }

    @Override
    public String toString() {
        return "banco{" + "nombrebanco=" + nombrebanco + ", listaclientes=" + listaclientes.toString() + '}';
    }

}
