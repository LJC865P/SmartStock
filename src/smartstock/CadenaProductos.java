package smartstock;

/**
 * CadenaProductos — Manejo de cadenas de texto (Strings).
 *
 * Aplica operaciones sobre cadenas para:
 * - Validar formato de códigos de productos.
 * - Buscar productos mediante coincidencias de texto.
 * - Concatenar información descriptiva para etiquetas o reportes.
 */
public class CadenaProductos {

    /**
     * Valida que un código de producto cumpla con el formato esperado.
     * Ejemplo válido: no nulo, no vacío, entre 2 y 10 caracteres alfanuméricos.
     */
    public boolean validarCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            System.out.println("Error: El código no puede ser nulo ni estar vacío.");
            return false;
        }

        String limpio = codigo.trim();

        if (limpio.length() < 2 || limpio.length() > 10) {
            System.out.println("Error: El código debe tener entre 2 y 10 caracteres.");
            return false;
        }

        return true;
    }

    /**
     * Busca productos dentro de un arreglo cuyo nombre contenga el texto buscado (búsqueda parcial).
     * No distingue entre mayúsculas y minúsculas.
     */
    public void buscarTexto(String texto, Producto[] productos, int total) {
        if (texto == null || texto.trim().isEmpty()) {
            System.out.println("Error: El texto de búsqueda no puede estar vacío.");
            return;
        }

        if (productos == null || total <= 0) {
            System.out.println("No hay productos disponibles para buscar.");
            return;
        }

        String buscado = texto.trim().toLowerCase();
        boolean encontrado = false;

        System.out.println("\nResultados de búsqueda para: \"" + texto + "\"");
        System.out.println("+------+--------------------------+----------+--------+");
        System.out.println("| ID   | NOMBRE                   | PRECIO   | STOCK  |");
        System.out.println("+------+--------------------------+----------+--------+");

        for (int i = 0; i < total; i++) {
            if (productos[i] != null && productos[i].getNombre().toLowerCase().contains(buscado)) {
                System.out.printf("| %-4d | %-24s | %-8.2f | %-6d |%n",
                        productos[i].getId(),
                        productos[i].getNombre(),
                        productos[i].getPrecio(),
                        productos[i].getStock());
                encontrado = true;
            }
        }

        System.out.println("+------+--------------------------+----------+--------+");

        if (!encontrado) {
            System.out.println("No se encontraron coincidencias.");
        }
    }

    /**
     * Une el nombre, precio y stock de un producto en una sola cadena descriptiva.
     */
    public String concatenarDescripcion(Producto p) {
        if (p == null) {
            return "Producto: [Nulo]";
        }

        return "COD-" + p.getId() + " | " + p.getNombre().toUpperCase()
                + " | Precio: $" + String.format("%.2f", p.getPrecio())
                + " | Existencias: " + p.getStock() + " uds.";
    }
}
