/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gardenclasses;

import java.util.Scanner;

/**
 *
 * @author Enrique
 */
public class GardenClasses {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Boolean login;
        Sistema s = new Sistema();
        s.Cargar();
        System.out.println("Bienvenido a Garden!");
        System.out.println("Teclea 1 si eres usuario nuevo, y 2 si ya estas registrado, 0 para salir.");
        String menuIn = in.next();

        if(menuIn == "1"){
            System.out.println("Registro: ");
            System.out.println("Ingresa la siguiente infromacion para registrarte: ");
            System.out.print("Nombre: ");
            String nombre = in.next();
            System.out.print("Apellido: ");
            String apellido = in.next();
            System.out.print("Direccion: ");
            String direccion = in.next();
            System.out.print("Nombre de usuario: ");
            String usuario = in.next();
            System.out.print("Contraseña: ");
            String password = in.next();
            String password2;
            do{
                System.out.print("Confirmar contraseña: ");
                password2 = in.next();
            }while(password2!=password);
            System.out.print("Mail: ");
            String mail = in.next();
            System.out.print("Telefono: ");
            String tel = in.next();
            int telefono = Integer.parseInt(tel);

            s.agregarUsuario(nombre, apellido, direccion, usuario, password, mail, telefono);
            System.out.println("¡Gracias " + nombre +"! Hemos terminado de registrarte");
            menuIn = "2";
        }
        if(menuIn == "2"){
            System.out.println("Ingresa tu usuario y contraseña para ingresar: ");
            System.out.print("Usuario: ");
            String user = in.next();
            System.out.print("Contraseña: ");
            String pass = in.next();
            login = s.login(user, pass);
            if(!login){
                do{
                    System.out.println("Combinacion invalida, intenta de nuevo: ");
                    System.out.print("Usuario: ");
                    user = in.next();
                    System.out.print("Contraseña: ");
                    pass = in.next();
                    login = s.login(user, pass);
                }while(!login);
            }
        }
        //mostrar productos
        //crear pedido
        //

        /*0 salir, login, registro
        1 (si es admin: agregar producto, aumentarInventario,) mostrar productos, abrirPedido, borrarPedido
        2. mostrar pedido, 2agregar a pedido, 1mostrar productos, borrar pedido*/
        while(s.getEstado()>=0){
            System.out.println("¡Login exitoso! Bienvenido al portal de Garden, teclea el numero "
                    + "correspondiente a la accion que deseas hacer.");
            System.out.println("1 - Mostrar productos\n"
                    + "2 - Abrir un pedido\n"
                    + "3 - Borrar un pedido\n"
                    + "0 - Salir\n"
                    + "9 - Opciones admin");
            menuIn = in.next();
            if(menuIn=="9"){
                System.out.println("1 - Agregar producto\n"
                        + "2 - Modificar cantidades en inventario\n"
                        + "0 - Salir");
                menuIn = in.next();
                if(menuIn=="1"){
                    //nombre, precio, cantidad
                    System.out.println("Ingresar nombre de nuevo producto");
                    String nom = in.next();
                    System.out.println("Ingresar precio de nuevo producto");
                    String pr = in.next();
                    int precio = Integer.parseInt(pr);
                    System.out.println("Ingresar cantidad de nuevo producto");
                    String cant = in.next();
                    int cantidad = Integer.parseInt(cant);
                    s.agregarProducto(nom, precio, cantidad);
                }
                if(menuIn=="2"){
                    System.out.println("Ingrese el id del producto que quiere aumentar.");
                    String idS = in.next();
                    int id = Integer.parseInt(idS);
                    System.out.println("Ingrese la cantidad de productos que quiere aumentar.");
                    String cant = in.next();
                    int cantidad = Integer.parseInt(cant);
                    s.aumentarInventario(id, cantidad);
                }


            }
            if(menuIn=="1"){
                s.mostrarProductos();
            }
            if(menuIn=="2"){
                s.abrirPedido();
                do{
                    System.out.println("MENU PEDIDO.");
                    System.out.println("1 - Mostrar productos\n"
                            + "2 - Agregar producto a pedido\n"
                            + "3 - Mostrar pedido\n"
                            + "4 - Borrar pedido\n"
                            + "0 - Salir");
                    menuIn = in.next();
                    if(menuIn=="1"){
                        s.mostrarProductos();
                    }
                    if(menuIn=="2"){
                        System.out.println("Ingrese el id del producto que quiere agregar.");
                        String idS = in.next();
                        int id = Integer.parseInt(idS);
                        System.out.println("Ingrese la cantidad de productos que quiere agregar.");
                        String cant = in.next();
                        int cantidad = Integer.parseInt(cant);
                        s.agregarAPedido(id, cantidad);
                    }
                    if(menuIn=="3"){
                        s.mostrarPedido();
                    }
                    if(menuIn=="4"){
                        s.borrarPedido();
                    }
                }while(s.getEstado()>1);
            }
            if(menuIn=="3"){
                s.borrarPedido();
            }


        }

        s.Guardar();
        in.close();
    }
    
}
