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
    
    //generar string de cliente, generar cliente de un string
    public String generaStringCliente(){
        String genString = this.nombre + "$" + this.apellido + "$" 
                + this.direccion + "$" + this.usuario + "$" + this.password +
                "$" + this.mail + "$" + String.valueOf(this.clienteId) + "$" +
                String.valueOf(this.telefono) + "$$";
        return genString;
    }
        
    //generar cliente de un string
   public void generaClienteDeString(String in){
        String subString = "";
        int count = 0;
        boolean done = false;
        
        for(int i = 0; i<in.length();i++){
            if(in.charAt(i) =='$'){
                count++;
                done = true;
                i++;
            }
            if(done){
                if(count == 1){
                    this.nombre = subString;
                }
                else if (count == 2){
                    this.apellido = subString;
                }
                else if (count == 3) {
                    this.direccion = subString;
                }
                else if (count == 4){
                    this.usuario = subString;
                }
                else if (count == 5){
                    this.password = subString;
                }
                else if (count == 6){
                    this.mail = subString;
                }
                else if (count == 7){
                    this.clienteId = Integer.parseInt(subString);
                }
                else if (count == 8){
                    this.telefono = Integer.parseInt(subString);
                }
                subString = "";
                done = false;
            }
            subString += in.charAt(i);
        }
    }
}
