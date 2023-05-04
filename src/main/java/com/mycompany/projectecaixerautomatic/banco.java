/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectecaixerautomatic;

import java.util.ArrayList;

/**
 *
 * La clase banco representa un banco dentro del proyecyo
 * Esta clase contiene el nombre del banco y una lista de clientes que pertenecen al banco.
 * Además, proporciona métodos para gestionar los clientes, como agregar clientes y buscar clientes por nombre.
 * @author Iñaki Alonso Bellesta
 */

/**
 * Constructor de la clase `banco`.
 * Inicializa el nombre del banco y crea una lista vacía de clientes.
 *
 * @param nombrebanco El nombre del banco.
 */
public class banco {

    private String nombrebanco;
    private ArrayList<clientes> listaclientes;

    /**
     * 
     * @param nombrebanco
     */
    public banco(String nombrebanco) {
        this.nombrebanco = nombrebanco;
        this.listaclientes = new ArrayList<clientes>();
    }

    /**
     * Getters y setters
     * 
     * @return
     */
    public String getNombrebanco() {
        return nombrebanco;
    }

    /**
     * 
     * @param nombrebanco
     */
    public void setNombrebanco(String nombrebanco) {
        this.nombrebanco = nombrebanco;
    }

    /**
     * 
     * @return
     */
    public ArrayList<clientes> getListaclientes() {
        return listaclientes;
    }

    /**
     * 
     * @param listaclientes
     */
    public void setListaclientes(ArrayList<clientes> listaclientes) {
        this.listaclientes = listaclientes;
    }

    /**
     * Añade un cliente a la lista de clientes del banco.
     *
     * @param cliente El objeto cliente que se va a añadir.
     */
    public void añadircliente(clientes cliente) {
        listaclientes.add(cliente);
    }

    /**
     * Busca un cliente en la lista de clientes por su nombre.
     *
     * @param nombreCliente El nombre del cliente que se desea buscar.
     * @return El objeto cliente si se encuentra en la lista, de lo contrario,
     *         devuelve null.
     */
    public clientes buscarClientePorNombre(String nombreCliente) {
        for (clientes cliente : listaclientes) {
            if (cliente.getNombre().equals(nombreCliente)) {
                return cliente;
            }
        }
        return null; // Devuelve null si no se encontró el cliente
    }

    /**
     * Devuelve una representación en cadena de la información del banco y sus
     * clientes.
     *
     * @return Una cadena que representa al banco y su lista de clientes.
     */
    @Override
    public String toString() {
        return "banco{" + "nombrebanco=" + nombrebanco + ", listaclientes=" + listaclientes.toString() + '}';
    }

}
