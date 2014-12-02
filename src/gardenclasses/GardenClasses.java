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
public class GardenClasses {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Sistema s = new Sistema();
        s.clientes.push(new Cliente("Frank", "Canseco", "Cumbres", "frankcanseco",
                            "canseco", "frank.canseco@gmail.com", 1, 88808787));
        s.Guardar();
       /* Pedido p;
        p = new Pedido(1,0,40,50,17,06,1994);
        p.agregarProducto(new Producto(1,"planta",1.0,1,1,1));
        String s;
        s = p.infoPedido();
        System.out.println(p.infoPedido());
        System.out.println(p.getProductosPendientes());
        p=new Pedido(s);
        System.out.println(p.infoPedido());
        System.out.println(p.getProductosPendientes());
               */
    }
    
}
