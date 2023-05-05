package com.mycompany.projectecaixerautomatic;

public class billetes {
    private int b500;
    private int b200;
    private int b100;
    private int b50;
    private int b20;
    private int b10;
    private int b5;
    private boolean operacion;

    public billetes() {
        this.b500 = 1000;
        this.b20 = 1000;
        this.b100 = 1000;
        this.b50 = 1000;
        this.b20 = 1000;
        this.b10 = 1000;
        this.b5 = 8000;
        this.operacion = true;
    }

    public int getBillete500() {
        return b500;
    }

    public void setBillete500(int billete500) {
        this.b500 = billete500;
    }

    public int getBillete200() {
        return b200;
    }

    public void setBillete200(int billete200) {
        this.b200 = billete200;
    }

    public int getBillete100() {
        return b100;
    }

    public void setBillete100(int billete100) {
        this.b100 = billete100;
    }

    public int getBillete50() {
        return b50;
    }

    public void setBillete50(int billete50) {
        this.b50 = billete50;
    }

    public int getBillete20() {
        return b20;
    }

    public void setBillete20(int billete20) {
        this.b20 = billete20;
    }

    public int getBillete10() {
        return b10;
    }

    public void setBillete10(int billete10) {
        this.b10 = billete10;
    }

    public int getBillete5() {
        return b5;
    }

    public void setBillete5(int billete5) {
        this.b5 = billete5;
    }

    public boolean isOperacion() {
        return operacion;
    }

    public void setOperacion(boolean operacion) {
        this.operacion = operacion;
    }

    /**
     * Ingresa billetes en el cajero.
     * 
     * @param denominacion La denominación del billete a ingresar.
     * @param cantidad     La cantidad de billetes a ingresar.
     */
    public void ingresarBilletes(int denominacion, int cantidad) {
        switch (denominacion) {
            case 500:
                b500 += cantidad;
                break;
            case 200:
                b200 += cantidad;
                break;
            case 100:
                b100 += cantidad;
                break;
            case 50:
                b50 += cantidad;
                break;
            case 20:
                b20 += cantidad;
                break;
            case 10:
                b10 += cantidad;
                break;
            case 5:
                b5 += cantidad;
                break;
            default:
                break;
        }
    }

    /**
     * Retira billetes del cajero.
     * 
     * @param denominacion La denominación del billete a retirar.
     * @param cantidad     La cantidad de billetes a retirar.
     */
    public void retirarBilletes(int denominacion, int cantidad) {
        operacion = true;
        switch (denominacion) {
            case 500:
                if (App.Billetes.b500 - cantidad >= 0) {
                    b500 -= cantidad;
                    break;
                }

            case 200:
                if (App.Billetes.b200 - cantidad >= 0) {
                    b200 -= cantidad;
                    break;
                }
            case 100:
                if (App.Billetes.b100 - cantidad >= 0) {
                    b100 -= cantidad;
                    break;
                }
            case 50:
                if (App.Billetes.b50 - cantidad >= 0) {
                    b50 -= cantidad;
                    break;
                }
            case 20:
                if (App.Billetes.b20 - cantidad >= 0) {
                    b20 -= cantidad;
                    break;
                }
            case 10:
                if (App.Billetes.b10 - cantidad >= 0) {
                    b10 -= cantidad;
                    break;
                }
            case 5:
                if (App.Billetes.b5 - cantidad >= 0) {
                    b5 -= cantidad;
                    break;
                }
            default:
                break;
        }
    }

    /**
     * Devuelve una representación en cadena del objeto Cajero.
     * 
     * @return Una cadena que representa al objeto Cajero.
     */
    @Override
    public String toString() {
        return "Cajero{" + "500€=" + b500 + ", 200€=" + b200 + ", 100€=" + b100 + ", 50€=" + b50
                + ", 20€=" + b20 + ", 10€=" + b10 + ", 5€=" + b5 + '}';
    }

}
