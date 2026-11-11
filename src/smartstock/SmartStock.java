
package smartstock;

/**
 *
 * @author josep LJCPEREZ865 Y LJC865
 */
public class SmartStock {

    
    public static void main(String[] args) {
       //Solo el llamado de las clases y todo lo principal

        /* 
       Producto arroz = new Producto(1, "Arroz", 4500, 100); //Prueba de la clase producto.
       arroz.mostrarInformacion();
       System.out.println("--------------------");//Fin de prueba de clase producto.
       */

       System.out.println();

       InventarioLineal inventario = new InventarioLineal();

       inventario.agregarProducto(new Producto("Arroz Diana", 4500, 100));
       inventario.agregarProducto(new Producto("Frijoles Diana", 3800, 50));
       inventario.agregarProducto(new Producto("Leche Aplina", 5400, 30));
       inventario.agregarProducto(new Producto("Aceite de Girasol", 12000, 20));
       inventario.agregarProducto(new Producto("Azucar Rio Paila", 3000, 80));
       inventario.agregarProducto(new Producto("Sal Refisal", 1500, 60));

       inventario.mostrarProductos();
       
    }
    
}
