
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
         
         /* 
         InventarioLineal inventario = new InventarioLineal();
         
         inventario.agregarProducto(new Producto("Frijoles Diana", 3800, 50));
         inventario.agregarProducto(new Producto("Arroz Diana", 4500, 100));
         inventario.agregarProducto(new Producto("Aceite de Girasol", 12000, 20));
         inventario.agregarProducto(new Producto("Leche Aplina", 5400, 30));
         inventario.agregarProducto(new Producto("Sal Refisal", 1500, 60));
         inventario.agregarProducto(new Producto("Azucar Rio Paila", 3000, 80));
         inventario.agregarProducto(new Producto("Salchicha Zenu", 10800, 5));
         inventario.agregarProducto(new Producto("Jamon Zenu", 19800, 24));
         inventario.agregarProducto(new Producto("Salchicha Rica", 1800, 52));
         inventario.agregarProducto(new Producto("Col cafe", 18000, 15));
         inventario.agregarProducto(new Producto("Pan Hamburguesa", 13800, 5));

        inventario.mostrarProductos();
        */

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

        /*
        InventarioGeneral general = new InventarioGeneral();

        general.registrarDatos(0,0,new Producto("Arroz",4500,20));
        general.recorrerEstructura();
        */


        // =====================================================
        // INVENTARIO PRINCIPAL
        // =====================================================

        InventarioLineal inventario = new InventarioLineal();

        Producto p1 =
                new Producto(
                        "Arroz Diana",
                        4500,
                        100);

        Producto p2 =
                new Producto(
                        "Frijoles Diana",
                        3800,
                        50);

        Producto p3 =
                new Producto(
                        "Leche Alpina",
                        5400,
                        30);

        Producto p4 =
                new Producto(
                        "Sal Refisal",
                        1500,
                        60);

        // Se asignan IDs automáticos
        inventario.agregarProducto(p1);
        inventario.agregarProducto(p2);
        inventario.agregarProducto(p3);
        inventario.agregarProducto(p4);

        System.out.println("\n===== INVENTARIO PRINCIPAL =====");

        inventario.mostrarProductos();

        // =====================================================
        // LISTA SIMPLE
        // =====================================================

        System.out.println("\n===== LISTA SIMPLE =====");

        ListaProductos lista =
                new ListaProductos();

        lista.insertarFinal(p1);
        lista.insertarFinal(p2);
        lista.insertarFinal(p3);
        lista.insertarInicio(p4);

        lista.recorrerLista();

        System.out.println("\nBuscar ID 3");

        Producto encontrado =
                lista.buscarProducto(3);

        if (encontrado != null) {

            encontrado.mostrarInformacion();

        } else {

            System.out.println(
                    "Producto no encontrado.");

        }

        System.out.println("\nEliminar ID 2");

        lista.eliminarProducto(2);

        lista.recorrerLista();

        // =====================================================
        // LISTA DOBLE
        // =====================================================

        System.out.println("\n===== LISTA DOBLE =====");

        ListaProductoDoble doble =
                new ListaProductoDoble();

        doble.insertarFinal(p1);
        doble.insertarFinal(p2);
        doble.insertarFinal(p3);
        doble.insertarInicio(p4);

        System.out.println("\nRecorrido hacia adelante:");

        doble.recorrerAdelante();

        System.out.println("\nRecorrido hacia atrás:");

        doble.recorrerAtras();

        System.out.println(
                "\nEliminar ID 4 y ID 3");

        doble.eliminarProducto(4);

        doble.eliminarProducto(3);

        System.out.println(
                "\nLista doble actual:");

        doble.recorrerAdelante();
    }

    
}