/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gardenclasses;

import java.util.LinkedList;

/**
 *
 * @author frankcanseco
 */
public class Pedido {
    int pedidoId;
    int clienteId;
    int estado;
    LinkedList<Producto> productos;
    int anchoJardin;
    int largoJardin;
    int Dia;
    int Mes;
    int Ano;
    String productosPendientes;
    public Pedido(String s){
        s=s.replaceAll("(\\r|\\n)", "");
        pedidoId = Integer.parseInt(s.substring(s.indexOf("P")+1, s.indexOf("C")));
        s=(s.substring(s.indexOf("C")));
        clienteId = Integer.parseInt(s.substring(s.indexOf("C")+1, s.indexOf("E")));
        s=(s.substring(s.indexOf("E")));
        estado = Integer.parseInt(s.substring(s.indexOf("E")+1, s.indexOf("D")));
        s=(s.substring(s.indexOf("D")));
        Dia = Integer.parseInt(s.substring(s.indexOf("D")+1, s.indexOf("M")));
        s=(s.substring(s.indexOf("M")));
        Mes = Integer.parseInt(s.substring(s.indexOf("M")+1, s.indexOf("A")));
        s=(s.substring(s.indexOf("A")));
        Ano = Integer.parseInt(s.substring(s.indexOf("A")+1, s.indexOf("L")));
        s=(s.substring(s.indexOf("L")));
        largoJardin = Integer.parseInt(s.substring(s.indexOf("L")+1, s.indexOf("A")));
        s=(s.substring(s.indexOf("A")));
        anchoJardin = Integer.parseInt(s.substring(s.indexOf("A")+1, s.indexOf("P")));
        s=(s.substring(s.indexOf("P")));
        productos = new LinkedList();
        productosPendientes =s;
    }
    public Pedido(int pi , int ci , int ancho , int largo, int d , int m , int a){
        this.pedidoId = pi;
        this.clienteId=ci;
        this.anchoJardin = ancho;
        this.largoJardin = largo;
        productos = new LinkedList();
        this.Ano = a;
        this.Mes = m;
        this.Dia = d;
        this.estado = 1;
    }
    public void agregarProducto(Producto p)
    {
        productos.push(p);
    }
    
    public double calcularTotal()
    {
       double total = 0;
       for(Producto p: productos)
       {
           total += p.getPrecio();
       }
       return total;
    }
    public String getProductosPendientes(){
        return productosPendientes;
    }
    public String infoPedido(){
        String s="P";
        s=s.concat(Integer.toString(pedidoId));
        s=s.concat("C");
        s=s.concat(Integer.toString(clienteId));
        s=s.concat("E");
        s=s.concat(Integer.toString(estado));
        s=s.concat("D");
        s=s.concat(Integer.toString(Dia));
        s=s.concat("M");
        s=s.concat(Integer.toString(Mes));
        s=s.concat("A");
        s=s.concat(Integer.toString(Ano));
        s=s.concat("L");
        s=s.concat(Integer.toString(largoJardin));
        s=s.concat("A");
        s=s.concat(Integer.toString(anchoJardin));
        for (Producto p: productos){
            s=s.concat("P");
            s=s.concat(Integer.toString(p.getId()));
        }
        s=s.concat("P");
        return s;
    }

    public int getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(int pedidoId) {
        this.pedidoId = pedidoId;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getAnchoJardin() {
        return anchoJardin;
    }

    public void setAnchoJardin(int anchoJardin) {
        this.anchoJardin = anchoJardin;
    }

    public int getLargoJardin() {
        return largoJardin;
    }

    public void setLargoJardin(int largoJardin) {
        this.largoJardin = largoJardin;
    }

    public int getDia() {
        return Dia;
    }

    public void setDia(int Dia) {
        this.Dia = Dia;
    }

    public int getMes() {
        return Mes;
    }

    public void setMes(int Mes) {
        this.Mes = Mes;
    }

    public int getAno() {
        return Ano;
    }

    public void setAno(int Ano) {
        this.Ano = Ano;
    }
    
}
