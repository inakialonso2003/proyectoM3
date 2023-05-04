
/**
 * La clase cuentas representa una cuenta bancaria en el proyecto
 * Almacena información sobre el número de cuenta, tipo de cuenta y saldo de cuenta.
 * Además, permite realizar operaciones básicas como ingresar y retirar fondos.
 */
package com.mycompany.projectecaixerautomatic;

public class cuentas {

    private int numcuenta;
    private String tipocuenta;
    private double saldocuenta;

    /**
     * Constructor de la clase `cuentas`.
     *
     * @param numcuenta   Número de la cuenta.
     * @param tipocuenta  Tipo de cuenta (por ejemplo, "Ahorros" o "Principal").
     * @param saldocuenta Saldo inicial de la cuenta.
     */
    public cuentas(int numcuenta, String tipocuenta, double saldocuenta) {
        this.numcuenta = numcuenta;
        this.tipocuenta = tipocuenta;
        this.saldocuenta = saldocuenta;
    }

    /**
     * Método para ingresar fondos a la cuenta.
     *
     * @param monto Monto a ingresar en la cuenta.
     */
    public void ingresar(double monto) {
        this.saldocuenta += monto;
    }

    /**
     * Método para retirar fondos de la cuenta.
     *
     * @param monto Monto a retirar de la cuenta.
     * @throws IllegalArgumentException Si el monto a retirar es mayor al saldo
     *                                  disponible.
     */
    public void retirar(double monto) {
        if (monto <= this.saldocuenta) {
            this.saldocuenta -= monto;
        } else {
            throw new IllegalArgumentException("El monto a retirar es mayor al saldo disponible");
        }
    }

    /**
     * 
     * @return
     */
    public int getNumcuenta() {
        return numcuenta;
    }

    /**
     * 
     * @param numcuenta
     */
    public void setNumcuenta(int numcuenta) {
        this.numcuenta = numcuenta;
    }

    /**
     * 
     * @return
     */
    public String getTipocuenta() {
        return tipocuenta;
    }

    /**
     * 
     * @param tipocuenta
     */
    public void setTipocuenta(String tipocuenta) {
        this.tipocuenta = tipocuenta;
    }

    /**
     * 
     * @return
     */
    public double getSaldocuenta() {
        return saldocuenta;
    }

    /**
     * 
     * @param saldocuenta
     */
    public void setSaldocuenta(double saldocuenta) {
        this.saldocuenta = saldocuenta;
    }

    @Override
    public String toString() {
        return "cuentas{" + "numcuenta=" + numcuenta + ", tipocuenta=" + tipocuenta + ", saldocuenta=" + saldocuenta
                + '}';
    }

    /**
     * Método para transferir fondos entre cuentas.
     *
     * @param cantidad        Monto a transferir.
     * @param cuentaPrincipal La cuenta a la que se transferirán los fondos.
     */
    public void transferir(double cantidad, cuentas cuentaPrincipal) {
    }

}
