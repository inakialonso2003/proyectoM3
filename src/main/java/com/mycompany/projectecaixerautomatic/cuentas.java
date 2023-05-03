
package com.mycompany.projectecaixerautomatic;

public class cuentas {
    
        private int numcuenta;
        private String tipocuenta;
        private double saldocuenta;

    public cuentas(int numcuenta, String tipocuenta, double saldocuenta) {
        this.numcuenta = numcuenta;
        this.tipocuenta = tipocuenta;
        this.saldocuenta = saldocuenta;
    }

    public int getNumcuenta() {
        return numcuenta;
    }

    public void setNumcuenta(int numcuenta) {
        this.numcuenta = numcuenta;
    }

    public String getTipocuenta() {
        return tipocuenta;
    }

    public void setTipocuenta(String tipocuenta) {
        this.tipocuenta = tipocuenta;
    }

    public double getSaldocuenta() {
        return saldocuenta;
    }

    public void setSaldocuenta(double saldocuenta) {
        this.saldocuenta = saldocuenta;
    }

    @Override
    public String toString() {
        return "cuentas{" + "numcuenta=" + numcuenta + ", tipocuenta=" + tipocuenta + ", saldocuenta=" + saldocuenta + '}';
    }
    
        

   
    
}
