package smartstock;
/**
 * InventarioGeneral - Arreglo tridimensional.
 * 
 * Organiza productos por sucursal y categoría usando un arreglo 3D de Strings.
 * Dimensión 1: Sucursal (3)
 * Dimensión 2: Categoría (5)
 * Dimensión 3: Productos por categoría (20)
 */
public class InventarioGeneral {
    private static final int MAX_SUCURSALES = 3;
    private static final int MAX_CATEGORIAS = 5;
    private static final int MAX_PRODUCTOS = 20;
    // Arreglo tridimensional: [sucursal][categoría][producto]
    private String[][][] inventario = new String[MAX_SUCURSALES][MAX_CATEGORIAS][MAX_PRODUCTOS];
    // Cuántos productos hay en cada sucursal-categoría
    private int[][] contadores = new int[MAX_SUCURSALES][MAX_CATEGORIAS];
    //Registrar un producto en una sucursal y categoría
    public void registrarDatos(int sucursal, int categoria, String producto) {
        if (sucursal < 0 || sucursal >= MAX_SUCURSALES) {
            System.out.println("Error: Sucursal fuera de rango.");
            return;
        }
        if (categoria < 0 || categoria >= MAX_CATEGORIAS) {
            System.out.println("Error: Categoría fuera de rango.");
            return;
        }
        int pos = contadores[sucursal][categoria];
        if (pos >= MAX_PRODUCTOS) {
            System.out.println("Error: No caben más productos en esta categoría.");
            return;
        }
        inventario[sucursal][categoria][pos] = producto;
        contadores[sucursal][categoria]++;
    }
    //Buscar un producto por nombre en todo el inventario
    public void consultarInventario(String nombre) {
        for (int s = 0; s < MAX_SUCURSALES; s++) {
            for (int c = 0; c < MAX_CATEGORIAS; c++) {
                for (int p = 0; p < contadores[s][c]; p++) {
                    if (inventario[s][c][p].equals(nombre)) {
                        System.out.println("Encontrado: " + nombre
                                + " en sucursal " + s + ", categoría " + c);
                        return;
                    }
                }
            }
        }
        System.out.println("No encontrado: " + nombre);
    }
    //Actualizar el nombre de un producto
    public void actualizarDatos(int sucursal, int categoria, int posicion, String nuevoNombre) {
        if (sucursal < 0 || sucursal >= MAX_SUCURSALES
                || categoria < 0 || categoria >= MAX_CATEGORIAS
                || posicion < 0 || posicion >= contadores[sucursal][categoria]) {
            System.out.println("Error: Posición inválida.");
            return;
        }
        inventario[sucursal][categoria][posicion] = nuevoNombre;
    }
    //Recorrer y mostrar toda la estructura
    public void recorrerEstructura() {
        System.out.println("\n--- Inventario General (3D) ---");
        for (int s = 0; s < MAX_SUCURSALES; s++) {
            System.out.println("\nSucursal " + s + ":");
            for (int c = 0; c < MAX_CATEGORIAS; c++) {
                if (contadores[s][c] > 0) {
                    System.out.println("  Categoría " + c + ":");
                    for (int p = 0; p < contadores[s][c]; p++) {
                        System.out.println("    - " + inventario[s][c][p]);
                    }
                }
            }
        }
    }
}