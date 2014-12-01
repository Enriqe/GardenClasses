/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gardenclasses;

/**
 *
 * @author Enrique
 */

public class Cliente {
    
	public String nombre, apellido, direccion, usuario, password, mail;
	public int clienteId, telefono;

    public Cliente(){
    	nombre = "default";
    	apellido = "default";
    	direccion = "default";
    	usuario = "default";
    	password = "default";
    	mail = "default@ejemplo.com";
    	clienteId = 0000;
    	telefono = 00000000;
    }

    public Cliente(String nom, String apel, String direc, String usuar,
                            String pass, String correo, int idCliente, int tel){
    	nombre = nom;
    	apellido = apel;
    	direccion = direc;
    	usuario = usuar;
    	password = pass;
    	mail = correo;
    	clienteId = idCliente;
    	telefono = tel;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
