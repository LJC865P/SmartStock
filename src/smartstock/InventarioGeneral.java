package smartstock;

/**
 * InventarioGeneral - Arreglo tridimensional.
 *
 * Dimensión 1: Sucursal (3)
 * Dimensión 2: Categoría (5)
 * Dimensión 3: Productos por categoría (20)
 */
public class InventarioGeneral {

    private static final int MAX_SUCURSALES = 3;
    private static final int MAX_CATEGORIAS = 5;
    private static final int MAX_PRODUCTOS = 20;

    // [Sucursal][Categoría][Producto]
    private Producto[][][] inventario =
            new Producto[MAX_SUCURSALES]
                         [MAX_CATEGORIAS]
                         [MAX_PRODUCTOS];

    // Cantidad de productos por sucursal y categoría
    private int[][] contadores =
            new int[MAX_SUCURSALES]
                   [MAX_CATEGORIAS];

    /**
     * Registrar un producto en una sucursal y categoría.
     */
    public void registrarDatos(
            int sucursal,
            int categoria,
            Producto producto) {

        if (producto == null) {

            System.out.println(
                    "Error: No se puede registrar un producto nulo.");
            return;

        }

        if (sucursal < 0 || sucursal >= MAX_SUCURSALES) {

            System.out.println(
                    "Error: Sucursal fuera de rango.");
            return;

        }

        if (categoria < 0 || categoria >= MAX_CATEGORIAS) {

            System.out.println(
                    "Error: Categoría fuera de rango.");
            return;

        }

        int pos = contadores[sucursal][categoria];

        if (pos >= MAX_PRODUCTOS) {

            System.out.println(
                    "Error: No caben más productos en esta categoría.");
            return;

        }

        inventario[sucursal][categoria][pos] = producto;

        contadores[sucursal][categoria]++;

        System.out.println(
                "Producto registrado correctamente.");
    }

    /**
     * Buscar producto por nombre en todo el inventario.
     */
    public void consultarInventario(String nombre) {

        if (nombre == null || nombre.trim().isEmpty()) {

            System.out.println(
                    "Error: Nombre inválido.");
            return;

        }

        for (int s = 0; s < MAX_SUCURSALES; s++) {

            for (int c = 0; c < MAX_CATEGORIAS; c++) {

                for (int p = 0; p < contadores[s][c]; p++) {

                    if (inventario[s][c][p]
                            .getNombre()
                            .equalsIgnoreCase(nombre)) {

                        System.out.println(
                                "Producto encontrado: "
                                        + nombre
                                        + " | Sucursal: " + s
                                        + " | Categoría: " + c);

                        return;

                    }

                }

            }

        }

        System.out.println(
                "No se encontró el producto: " + nombre);
    }

    /**
     * Actualizar un producto.
     */
    public void actualizarDatos(
            int sucursal,
            int categoria,
            int posicion,
            Producto nuevoProducto) {

        if (nuevoProducto == null) {

            System.out.println(
                    "Error: El producto no puede ser nulo.");
            return;

        }

        if (sucursal < 0 || sucursal >= MAX_SUCURSALES
                || categoria < 0 || categoria >= MAX_CATEGORIAS
                || posicion < 0
                || posicion >= contadores[sucursal][categoria]) {

            System.out.println(
                    "Error: Posición inválida.");
            return;

        }

        inventario[sucursal][categoria][posicion]
                = nuevoProducto;

        System.out.println(
                "Producto actualizado correctamente.");
    }

    /**
     * Mostrar toda la estructura tridimensional.
     */
    public void recorrerEstructura() {

        System.out.println(
                "\n========== INVENTARIO GENERAL (3D) ==========");

        for (int s = 0; s < MAX_SUCURSALES; s++) {

            System.out.println(
                    "\nSucursal " + s + ":");

            for (int c = 0; c < MAX_CATEGORIAS; c++) {

                if (contadores[s][c] > 0) {

                    System.out.println(
                            "  Categoría " + c + ":");

                    for (int p = 0;
                         p < contadores[s][c];
                         p++) {

                        Producto producto =
                                inventario[s][c][p];

                        System.out.println(
                                "    ID: "
                                        + producto.getId()
                                        + " | Nombre: "
                                        + producto.getNombre()
                                        + " | Precio: $"
                                        + producto.getPrecio()
                                        + " | Stock: "
                                        + producto.getStock());

                    }

                }

            }

        }

    }

}
