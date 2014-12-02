/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gardenclasses;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author frankcanseco
 */
public class Sistema {
    Cliente cActual;
    Pedido pActual;
    int estado;
    LinkedList<Cliente> clientes;
    LinkedList<Producto> productosDisponibles;
    LinkedList<Pedido> pedidos;
    Sistema(){
        clientes = new LinkedList();
        productosDisponibles = new LinkedList();
        pedidos = new LinkedList();
        estado = 0;
    }
    public Boolean login(String Usuario,String Password){
        for (Cliente c:clientes){
            if(c.getUsuario().equals(Usuario)){
                if (c.getPassword().equals(Password)){
                    estado = 1;
                    cActual=c;
                    return true;
                }
                JOptionPane.showMessageDialog(null,
    "Wrong Password");
                return false;
            }
        }
        JOptionPane.showMessageDialog(null,
    "User does not exist");
        return false;
    }
    public Boolean abrirPedido (){
        for (Pedido p:pedidos){
            if(p.getClienteId()==(this.cActual.getClienteId())){
                estado=2;
                pActual = p;
                return true;
            }
        }
        JOptionPane.showMessageDialog(null,
    "El usuario no tiene jardines ni pedidos creados");
        return false;
    }
    public void agregarProducto(String n , double p, int x , int y , int c){
        if (cActual.getClienteId()==1){
            int tam = productosDisponibles.size();
            tam +=1;
            productosDisponibles.push(new Producto(tam,n,p,x,y,c));
        }
        else{
            JOptionPane.showMessageDialog(null,
            "No eres administrador");
        }
    }
    public void agregarAPedido(int id , int cant){
        if(id>productosDisponibles.size()){
            JOptionPane.showMessageDialog(null,
    "No existe ese producto");
            return;
        }
        if (cant>productosDisponibles.get(id-1).getCantidadDisponible()){
            JOptionPane.showMessageDialog(null,
    "No hay cantidad suficiente disponible para su pedido");
        }
        else{
            Boolean noEncontro = false;
            for (Producto p: pActual.productos){
                if (p.getId()==id){
                    p.addCantidadDisponible(cant);
                }
            }
            if(noEncontro){
                Producto p = productosDisponibles.get(id-1);
                p.setCant(cant);
                pActual.productos.push(p);
            }
            for (Producto q : productosDisponibles){
                if (q.getId()==id){
                    q.addCantidadDisponible(-cant);
                }
            }
        }
    }
    public void crearPedido(){
        //tinee que validar que no haya pedidos creados
    }
    public void mostrarPedido(){
        
    }
    public void mostrarProductos(){
        
    }
    public void salir(){
        estado = -1;
    }
    public void logout(){
        estado = 0;
    }
    public void borrarPedido(){
        
    }
    public void agregarUsuario(){
        
    }
    public int getEstado(){
        return this.estado;
    }
    public void Cargar(){
        String texto,aux;
        try
            {
            //Creamos un archivo FileReader que obtiene lo que tenga el archivo
            FileReader lector=new FileReader("Clientes.txt");

            //El contenido de lector se guarda en un BufferedReader
            BufferedReader contenido=new BufferedReader(lector);

            //Con el siguiente ciclo extraemos todo el contenido del objeto "contenido" y lo mostramos
            while((texto=contenido.readLine())!=null)
            {
                aux = "";
                while((texto=contenido.readLine())!=null && !texto.equals("&")){
                    aux = aux.concat(texto);
                }
                clientes.push(new Cliente(aux));
            }
            }

            //Si se causa un error al leer cae aqui
            catch(Exception e)
            {
            System.out.println("Error al leer");
            }
        try
            {
            //Creamos un archivo FileReader que obtiene lo que tenga el archivo
            FileReader lector=new FileReader("Productos.txt");

            //El contenido de lector se guarda en un BufferedReader
            BufferedReader contenido=new BufferedReader(lector);

            //Con el siguiente ciclo extraemos todo el contenido del objeto "contenido" y lo mostramos
            while((texto=contenido.readLine())!=null)
            {
                aux = "";
                while((texto=contenido.readLine())!=null && !texto.equals("&")){
                    aux = aux.concat(texto);
                }
                productosDisponibles.push(new Producto(aux));
            }
            }

            //Si se causa un error al leer cae aqui
            catch(Exception e)
            {
            System.out.println("Error al leer");
            }
        Pedido p;
        String sp;
        int prod;
        try
            {
            //Creamos un archivo FileReader que obtiene lo que tenga el archivo
            FileReader lector=new FileReader("Pedidos.txt");

            //El contenido de lector se guarda en un BufferedReader
            BufferedReader contenido=new BufferedReader(lector);

            //Con el siguiente ciclo extraemos todo el contenido del objeto "contenido" y lo mostramos
            while((texto=contenido.readLine())!=null)
            {
                aux = "";
                while((texto=contenido.readLine())!=null && !texto.equals("&")){
                    aux = aux.concat(texto);
                }
                p = new Pedido(aux);
                sp = p.getProductosPendientes();
                while(sp.length()>1){
                    sp=sp.substring(1);
                    prod = Integer.parseInt(sp.substring(0, sp.indexOf("P")));
                    sp=(sp.substring(sp.indexOf("P")));
                    p.agregarProducto(productosDisponibles.get(prod-1));
                }
                pedidos.push(p);
            }
            }

            //Si se causa un error al leer cae aqui
            catch(Exception e)
            {
            System.out.println("Error al leer");
            }
    }
    public void Guardar(){
        String texto="";
        for(Cliente c: clientes){
            texto = texto.concat("&\n");
            texto = texto.concat(c.generaStringCliente());
            texto = texto.concat("\n");
        }
        try
        {
        //Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor
        File archivo=new File("Clientes.txt");
        //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
        BufferedWriter escribir = new BufferedWriter(new FileWriter(archivo));
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
        texto="";
        for(Pedido p: pedidos){
            texto = texto.concat("&\n");
            texto = texto.concat(p.infoPedido());
            texto = texto.concat("\n");
        }
        try
        {
        //Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor
        File archivo=new File("Pedidos.txt");
        //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
        BufferedWriter escribir = new BufferedWriter(new FileWriter(archivo));
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
        texto="";
        for(Producto p: productosDisponibles){
            texto = texto.concat("&\n");
            texto = texto.concat(p.generaInfo());
            texto = texto.concat("\n");
        }
        try
        {
        //Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor
        File archivo=new File("Productos.txt");
        //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
        BufferedWriter escribir = new BufferedWriter(new FileWriter(archivo));
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
