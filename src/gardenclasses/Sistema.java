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

    Sistema() {
        clientes = new LinkedList();
        productosDisponibles = new LinkedList();
        pedidos = new LinkedList();
        estado = 0;
    }

    public Boolean login(String Usuario, String Password) {
        for (Cliente c : clientes) {
            if (c.getUsuario().equals(Usuario)) {
                if (c.getPassword().equals(Password)) {
                    estado = 1;
                    cActual = c;
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

    public Boolean abrirPedido() {
        for (Pedido p : pedidos) {
            if (p.getClienteId() == (this.cActual.getClienteId())) {
                estado = 2;
                pActual = p;
                return true;
            }
        }
        JOptionPane.showMessageDialog(null,
                "El usuario no tiene jardines ni pedidos creados");
        return false;
    }
    public void agregarProducto(String n , double p, int c){
        if (cActual.getClienteId()==1){
            int tam = productosDisponibles.size();
            tam +=1;
            productosDisponibles.push(new Producto(tam,n,p,0,0,c));
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
            Boolean noEncontro = true;
            for (Producto p: pActual.productos){
                if (p.getId()==id){
                    p.addCantidadDisponible(cant);
                    noEncontro = false;
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
    
    public void modificarInventario(int id, int cant){

        boolean aux = false;
        for (int x = 0; x < productosDisponibles.size(); x++) {
            if (id == productosDisponibles.get(x).getId()) {
                productosDisponibles.get(x).addCantidadDisponible(cant);
                aux = true;
                break;
            }
        }
        if (!aux) {
            JOptionPane.showMessageDialog(null, "El producto es incorrecto. No existe el id.");
        }
    }

    public void crearPedido(int ancho , int largo, int d , int m , int a) {
        //tinee que validar que no haya pedidos creados
        boolean pedidoExistente = false;
        for (int x = 0; x < pedidos.size(); x++) {
            Pedido aux = (Pedido) pedidos.get(x);
            if (cActual.getClienteId() == aux.getClienteId()) {
                pedidoExistente = true;
                System.out.println("Ya tienes un pedido existente");
                break;
            }
        }
        if (!pedidoExistente) {
            pedidos.push(new Pedido(pedidos.getLast().getPedidoId()+1, cActual.getClienteId(), ancho , largo, d , m , a));
        }
    }

    public void mostrarPedido() {
            System.out.println("ID Pedido: "+pActual.getPedidoId());
            System.out.println("Ancho: "+pActual.getAnchoJardin()+" Largo: "+pActual.getLargoJardin());
            System.out.println("Lista de Productos:");
            for (Producto p: pActual.productos){
            Producto aux = p;
            System.out.println(aux.getId() + " " + aux.getNombre() + " $" + aux.getPrecio() + " " + aux.getCantidadDisponible());
            }
            double iva = pActual.calcularTotal()*.16;
            System.out.println("SubTotal: "+pActual.calcularTotal());
            System.out.println("IVA: "+iva);
            System.out.println("Total: "+pActual.calcularTotal()+iva);
    }
    
    public void checarProductos() {
        for (int x = 0; x < productosDisponibles.size(); x++) {
            Producto aux = (Producto) productosDisponibles.get(x);
            System.out.println(aux.getId() + " " + aux.getNombre() + " $" + aux.getPrecio() + " " + aux.getCantidadDisponible());
        }
    }

    public void salir() {
        estado = -1;
    }
    public void logout(){
        estado = 0;
    }
    
    public void cerrarPedido(){
        estado = 1;
    }

    public void cancelarPedido() {
        for (int x = 0; x < pedidos.size(); x++) {
            Pedido aux = (Pedido) pedidos.get(x);
            if (cActual.getClienteId() == aux.getClienteId()) {
                pedidos.remove(x);
                break;
            }
        }
        estado = 1;
    }

    public void agregarUsuario(String nom, String apel, String direc, String usuar,
                            String pass, String correo, int tel) {

        boolean clienteExistente = false;
        for (int x = 0; x < clientes.size(); x++) {
            if (clientes.get(x).getUsuario() == usuar) {
                clienteExistente = true;
                JOptionPane.showMessageDialog(null, "Ya tienes un usuario.");
                break;
            }
            if (!clienteExistente) {
                clientes.push(new Cliente( nom, apel, direc, usuar,
                            pass, correo, clientes.size() + 1, tel));
            }
        }
    }

    public int getEstado() {
        return this.estado;
    }


    public void Cargar() {
        String texto, aux;
        try {
            //Creamos un archivo FileReader que obtiene lo que tenga el archivo
            FileReader lector = new FileReader("Clientes.txt");

            //El contenido de lector se guarda en un BufferedReader
            BufferedReader contenido = new BufferedReader(lector);

            //Con el siguiente ciclo extraemos todo el contenido del objeto "contenido" y lo mostramos
            while ((texto = contenido.readLine()) != null) {
                aux = "";
                while ((texto = contenido.readLine()) != null && !texto.equals("&")) {
                    aux = aux.concat(texto);
                }
                clientes.push(new Cliente(aux));
            }
        } //Si se causa un error al leer cae aqui
        catch (Exception e) {
            System.out.println("Error al leer");
        }
        try {
            //Creamos un archivo FileReader que obtiene lo que tenga el archivo
            FileReader lector = new FileReader("Productos.txt");

            //El contenido de lector se guarda en un BufferedReader
            BufferedReader contenido = new BufferedReader(lector);

            //Con el siguiente ciclo extraemos todo el contenido del objeto "contenido" y lo mostramos
            while ((texto = contenido.readLine()) != null) {
                aux = "";
                while ((texto = contenido.readLine()) != null && !texto.equals("&")) {
                    aux = aux.concat(texto);
                }
                productosDisponibles.push(new Producto(aux));
            }
        } //Si se causa un error al leer cae aqui
        catch (Exception e) {
            System.out.println("Error al leer");
        }
        Pedido p;
        String sp;
        int prod;
        try {
            //Creamos un archivo FileReader que obtiene lo que tenga el archivo
            FileReader lector = new FileReader("Pedidos.txt");

            //El contenido de lector se guarda en un BufferedReader
            BufferedReader contenido = new BufferedReader(lector);

            //Con el siguiente ciclo extraemos todo el contenido del objeto "contenido" y lo mostramos
            while ((texto = contenido.readLine()) != null) {
                aux = "";
                while ((texto = contenido.readLine()) != null && !texto.equals("&")) {
                    aux = aux.concat(texto);
                }
                p = new Pedido(aux);
                sp = p.getProductosPendientes();
                while (sp.length() > 1) {
                    sp = sp.substring(1);
                    prod = Integer.parseInt(sp.substring(0, sp.indexOf("P")));
                    sp = (sp.substring(sp.indexOf("P")));
                    p.agregarProducto(productosDisponibles.get(prod - 1));
                }
                pedidos.push(p);
            }
        } //Si se causa un error al leer cae aqui
        catch (Exception e) {
            System.out.println("Error al leer");
        }
    }

    public void Guardar() {
        String texto = "";
        for (Cliente c : clientes) {
            texto = texto.concat("&\n");
            texto = texto.concat(c.generaStringCliente());
            texto = texto.concat("\n");
        }
        try {
            //Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor
            File archivo = new File("Clientes.txt");
            //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
            BufferedWriter escribir = new BufferedWriter(new FileWriter(archivo));
            //Escribimos en el archivo con el metodo write 
            escribir.write(texto);
            //Cerramos la conexion
            escribir.close();
        } //Si existe un problema al escribir cae aqui
        catch (Exception e) {
            System.out.println("Error al escribir");
        }
        texto = "";
        for (Pedido p : pedidos) {
            texto = texto.concat("&\n");
            texto = texto.concat(p.infoPedido());
            texto = texto.concat("\n");
        }
        try {
            //Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor
            File archivo = new File("Pedidos.txt");
            //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
            BufferedWriter escribir = new BufferedWriter(new FileWriter(archivo));
            //Escribimos en el archivo con el metodo write 
            escribir.write(texto);
            //Cerramos la conexion
            escribir.close();
        } //Si existe un problema al escribir cae aqui
        catch (Exception e) {
            System.out.println("Error al escribir");
        }
        texto = "";
        for (Producto p : productosDisponibles) {
            texto = texto.concat("&\n");
            texto = texto.concat(p.generaInfo());
            texto = texto.concat("\n");
        }
        try {
            //Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor
            File archivo = new File("Productos.txt");
            //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
            BufferedWriter escribir = new BufferedWriter(new FileWriter(archivo));
            //Escribimos en el archivo con el metodo write 
            escribir.write(texto);
            //Cerramos la conexion
            escribir.close();
        } //Si existe un problema al escribir cae aqui
        catch (Exception e) {
            System.out.println("Error al escribir");
        }
    }
}
