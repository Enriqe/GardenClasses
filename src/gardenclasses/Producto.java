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
    public Producto(String s){
        s=s.replaceAll("(\\r|\\n)", "");
        id = Integer.parseInt(s.substring(s.indexOf("I")+1, s.indexOf("$")));
        s=(s.substring(s.indexOf("$")));
        nombre = (s.substring(s.indexOf("$")+1, s.indexOf("%")));
        s=(s.substring(s.indexOf("%")));
        precio = Double.parseDouble(s.substring(s.indexOf("%")+1, s.indexOf("X")));
        s=(s.substring(s.indexOf("X")));
        posicionX = Integer.parseInt(s.substring(s.indexOf("X")+1, s.indexOf("Y")));
        s=(s.substring(s.indexOf("Y")));
        posicionY = Integer.parseInt(s.substring(s.indexOf("Y")+1, s.indexOf("C")));
        s=(s.substring(s.indexOf("C")));
        cantidadDisponible = Integer.parseInt(s.substring(s.indexOf("C")+1, s.indexOf("D")));
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
    public String generaInfo(){
        String s="I";
        s=s.concat(Integer.toString(id));
        s=s.concat("$");
        s=s.concat(nombre);
        s=s.concat("%");
        s=s.concat(Double.toString(precio));
        s=s.concat("X");
        s=s.concat(Integer.toString(posicionX));
        s=s.concat("Y");
        s=s.concat(Integer.toString(posicionY));
        s=s.concat("C");
        s=s.concat(Integer.toString(cantidadDisponible));
        s=s.concat("D");
        return s;
    }
}
