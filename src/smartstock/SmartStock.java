
package smartstock;

/**
 *
 * @author josep LJCPEREZ865 Y LJC865
 */
public class SmartStock {

    public static void main(String[] args) {
        // Solo el llamado de las clases y todo lo principal

        /*
          Producto arroz = new Producto(1, "Arroz", 4500, 100); //Prueba de la clase
          producto.
          arroz.mostrarInformacion();
          System.out.println("--------------------");//Fin de prueba de clase producto.
         */

        System.out.println();

        InventarioLineal inventario = new InventarioLineal();

        inventario.agregarProducto(new Producto("Frijoles Diana", 3800, 50));
        inventario.agregarProducto(new Producto("Arroz Diana", 4500, 100));
        inventario.agregarProducto(new Producto("Aceite de Girasol", 12000, 20));
        inventario.agregarProducto(new Producto("Leche Aplina", 5400, 30));
        inventario.agregarProducto(new Producto("Sal Refisal", 1500, 60));
        inventario.agregarProducto(new Producto("Azucar Rio Paila", 3000, 80));

        inventario.mostrarProductos();

        /*
          // Pueba de Actualizacion de Inventario
          System.out.println("\nANTES DE ACTUALIZAR:");
          inventario.mostrarProductos();
          
          inventario.actualizarProducto(
          2,
          "Leche Entera",
          4200,
          25);
          
          System.out.println("\nDESPUÉS DE ACTUALIZAR:");
          inventario.mostrarProductos();
         */

        /*
          // Prueba de Eliminacion de Inventario
          System.out.println("\nANTES DE ELIMINAR:");
          inventario.mostrarProductos();
          
          inventario.eliminarProducto(2);
          
          System.out.println("\nDESPUÉS DE ELIMINAR:");
          
          inventario.mostrarProductos();
         */

        // ---------- MODULO 2: BUSQUEDA ----------

        /*
          //Busqueda secuancial por id
          System.out.println("\nBusqueda secuencial del codigo 4:");
          Producto productoEncontrado = inventario.buscarSecuencial(4);
          if (productoEncontrado != null) {
          System.out.println("Producto encontrado:");
          productoEncontrado.mostrarInformacion();
          } else {
          System.out.println("Producto no encontrado.");
          }
          
          //Busqueda secuancial por Nombre
          System.out.println("\nBusqueda secuencial del nombre 'Sal Refisal':");
          Producto productoEncontradoPorNombre =
          inventario.buscarSecuencialPorNombre("Sal Refisal");
          if (productoEncontradoPorNombre != null) {
          System.out.println("Producto encontrado:");
          productoEncontradoPorNombre.mostrarInformacion();
          } else {
          System.out.println("Producto no encontrado.");
          }
         */

        // ---------- MODULO 2: ORDENAMIENTO ----------

        // Pueba de ordenamiento burbuja por nombre
        /* 
        System.out.println("\nANTES DE ORDENAR POR NOMBRE: \n");

        inventario.ordenarBurbujaPorNombre();
        System.out.println("\nDESPUÉS DE ORDENAR POR NOMBRE:");
        inventario.mostrarProductos();

        // Pueba de ordenamiento burbuja por id
        System.out.println("\nANTES DE ORDENAR POR ID: \n");
        inventario.ordenarBurbuja();
        System.out.println("\nDESPUÉS DE ORDENAR POR ID:");
        inventario.mostrarProductos();
        */

        // ----------- Modulo 2 Busqueda Binaria -----------

        /* 
        System.out.println("\nBusqueda binaria del codigo 4:");
        Producto productoEncontrado = inventario.buscarBinaria(4);
        if (productoEncontrado != null) {
            System.out.println("Producto encontrado:");
            productoEncontrado.mostrarInformacion();
        } else {
            System.out.println("Producto no encontrado.");
        }
        */

        // ----------- Ordenamiento por Insercion -----------
        /* 
        System.out.println("\nANTES DE ORDENAR POR INSERCION: \n");
        inventario.mostrarProductos();
        System.out.println();
        inventario.ordenarPorInsercion();
        System.out.println("\nDESPUÉS DE ORDENAR POR INSERCION:");
        inventario.mostrarProductos();
        */

        // ----------- Ordenamiento por Seleccion -----------
        /* 
        System.out.println("\nANTES DE ORDENAR POR SELECCION: \n");
        inventario.mostrarProductos();
        inventario.ordenarSeleccionPorNombre();
        System.out.println("\nDESPUÉS DE ORDENAR POR SELECCION:");
        inventario.mostrarProductos();

        */

        // ============ MODULO 3: INVENTARIO POR SUCURSALES y General ============

        InventarioGeneral general = new InventarioGeneral();

        general.registrarDatos(0,0,new Producto("Arroz",4500,20));
        general.recorrerEstructura();
    }

}
