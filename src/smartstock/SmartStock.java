
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

       inventario.agregarProducto(new Producto(1, "Arroz", 4500, 100));
       inventario.agregarProducto(new Producto(2, "Frijoles Diana", 3800, 50));
       inventario.agregarProducto(new Producto(3, "Leche Aplina", 5400, 30));
       inventario.agregarProducto(new Producto(4, "Aceite de Girasol", 12000, 20));
       inventario.agregarProducto(new Producto(5, "Azucar Rio Paila", 3000, 80));
       inventario.agregarProducto(new Producto(6, "Sal Refisal", 1500, 60));

       inventario.mostrarProductos();
       
    }
    
}
