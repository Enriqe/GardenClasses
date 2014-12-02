/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gardenclasses;

import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;

/**
 *
 * @author frankcanseco
 */
public class Sistema {
    Cliente cActual;
    LinkedList<Cliente> clientes;
    LinkedList<Producto> productosDisponibles;
    LinkedList<Pedido> pedidos;
    Sistema(){
        clientes = new LinkedList();
        productosDisponibles = new LinkedList();
        pedidos = new LinkedList();
    }
    void Guardar(){
        String texto="";
        for(Cliente c: clientes){
            texto = texto.concat("$\n");
            texto = texto.concat(c.generaStringCliente());
            texto = texto.concat("\n");
        }
        try
        {
        //Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor
        File archivo=new File("Clientes.txt");
        //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
        FileWriter escribir=new FileWriter(archivo,true);
        //Escribimos en el archivo con el metodo write 
        escribir.write(texto);
        //Cerramos la conexion
        escribir.close();
        }
        //Si existe un problema al escribir cae aqui
        catch(Exception e)
        {
        System.out.println("Error al escribir");
        }
    }
}
