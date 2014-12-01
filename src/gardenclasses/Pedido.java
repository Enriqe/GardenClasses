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
    Pedido(int pi , int ci , int ancho , int largo, int d , int m , int a){
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
        productos.add(p);
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
}
