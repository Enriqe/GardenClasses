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
        System.out.println("Teclea 1 si eres usuario nuevo, y 2 si ya estas registrado");
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
            String telefono = in.next();

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
        
        s.Guardar();
    }
    
}
