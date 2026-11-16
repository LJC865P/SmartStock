package smartstock;

public class InventarioSucursales {

    // Tamaños máximos de la tabla de stock
    private static final int MAX_PRODUCTOS = 350;
    private static final int MAX_BODEGAS = 3;

    // Fila = producto, columna = bodega. Guarda la cantidad en stock.
    private int[][] stock = new int[MAX_PRODUCTOS][MAX_BODEGAS];

    // Cuántos productos están registrados en la tabla
    private int cantidadProductos = 0;

    //Metodo que ya tenias: registra stock de un producto en una bodega
    public void registrarProductoSucursal(int idProducto, int idBodega, int cantidad) {

        if (cantidad < 0) {// Validación de cantidad negativa
            System.out.println("Error: La cantidad no puede ser negativa.");
            return;
        }
        int fila = idProducto - 1; // Ajuste para índice de arreglo
        int columna = idBodega;

        if (fila < 0 || fila >= MAX_PRODUCTOS || columna < 0 || columna >= MAX_BODEGAS) {
            System.out.println("Error: ID de producto o bodega fuera de rango.");
            return;
        }
        stock[fila][columna] += cantidad;

        //Actualizar el contador si es un producto nuevo
        if (fila >= cantidadProductos) {
            cantidadProductos = fila + 1;
        }
    }

    //Consultar cuanto stock hay de un producto en una bodega
    public int consultarExistencias(int idProducto, int idBodega) {
        int fila = idProducto - 1;
        int columna = idBodega;

        if (fila < 0 || fila >= MAX_PRODUCTOS || columna < 0 || columna >= MAX_BODEGAS) {
            System.out.println("Error: ID de producto o bodega fuera de rango.");
            return -1;
        }

        return stock[fila][columna];
    }

    //Cambiar la cantidad de stock de un producto en una bodega
    public void actualizarExistencias(int idProducto, int idBodega, int nuevaCantidad) {
        
        if(nuevaCantidad < 0){
    System.out.println(
        "La cantidad no puede ser negativa."
    );
    return;
}
        int fila = idProducto - 1;
        int columna = idBodega;

        if (fila < 0 || fila >= MAX_PRODUCTOS || columna < 0 || columna >= MAX_BODEGAS) {
            System.out.println("Error: ID de producto o bodega fuera de rango.");
            return;
        }

        stock[fila][columna] = nuevaCantidad;
    }

    //Recorrer y mostrar toda la matriz de inventario
    public void recorrerMatriz(int totalProductos) {
        if (totalProductos <= 0) {
            System.out.println("No hay productos para mostrar.");
            return;
        }

        System.out.println("\n--- Inventario por Sucursales ---");
        System.out.println("+----------+----------+----------+----------+");
        System.out.println("| Producto | Bodega 0 | Bodega 1 | Bodega 2 |");
        System.out.println("+----------+----------+----------+----------+");

        for (int i = 0; i < totalProductos; i++) {
            System.out.printf("| %-8d | %-8d | %-8d | %-8d |%n",
                    (i + 1), stock[i][0], stock[i][1], stock[i][2]);
        }

        System.out.println("+----------+----------+----------+----------+");
    }
}
    