/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gardenclasses;

/**
 *
 * @author frankcanseco
 */
public class Producto {
    int id;
    String nombre;
    double precio;
    int posicionX;
    int posicionY;
    int cantidadDisponible;
    Producto(int i, String n , double p, int x , int y , int c){
        this.id = i;
        this.nombre = n;
        this.precio = p;
        this.posicionX = x;
        this.posicionY = y;
        this.cantidadDisponible = c;
    }
    
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void addCantidadDisponible(int cantidad) {
        this.cantidadDisponible += cantidad;
    }
}
