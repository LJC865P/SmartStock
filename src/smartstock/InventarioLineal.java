package smartstock;

public class InventarioLineal {

    private Producto[] productos = new Producto[350]; // Arreglo de productos, y se pueden almacenar hasta 350
                                                      // pociciones.

    private int cantidadProductos = 0; // Son la cantidad de productos en el inventario, este inicia en 0.
    private int siguienteId = 1;

    private boolean estaVacio() { // Para verificar si el inventario esta vacio.
        return cantidadProductos == 0;
    }

    private boolean estaLleno() {// Para verificar si el inventario esta lleno.
        return cantidadProductos == productos.length;
    }

    // ============ Agregar Producto ================

    public void agregarProducto(Producto producto) {// Con este agregamos los productos.

        producto.setId(siguienteId);// Asignamos el id al producto y luego incrementamos el siguienteId
        siguienteId++; // para el próximo producto.

        // Validacion de los casos limintes
        if (producto == null) {
            System.out.println("Error, no se puede agregar un producto nulo");
            return;
        }
        if (estaLleno()) {
            System.out.println("El inventario esta lleno, no se pueden agregar mas productos.");
            return;
        }

        if (cantidadProductos < productos.length) {
            productos[cantidadProductos] = producto;
            cantidadProductos++;

        } else {
            System.out.println("El inventario esta lleno, no se puede agregar mas productos.");
        }

    }

    // ============= Para mostrar el Inventario, ================
    // y con formato tipo hoja de exel para identificar mejor. :v
    public void mostrarProductos() {
        if (estaVacio()) {
            System.out.println("El inventario esta vacio, no hay productos");
            return;
        }

        System.out.println("+------+--------------------------+----------+--------+");
        System.out.println("| ID   | NOMBRE                   | PRECIO   | STOCK  |");
        System.out.println("+------+--------------------------+----------+--------+");

        for (int i = 0; i < cantidadProductos; i++) {

            System.out.printf("| %-4d | %-24s | %-8.2f | %-6d |%n",
                    productos[i].getId(),
                    productos[i].getNombre(),
                    productos[i].getPrecio(),
                    productos[i].getStock());
        }

        System.out.println("+------+--------------------------+----------+--------+");
    }

    // ====================== Mostrar la Cantidad de Productos =====================

    public void MostrarCantidadProductos() {// Metodo para mostrar la cantidad de productos en el inventario.
        System.out.println("Cantidad de productos en el invetario: " + cantidadProductos);

    }

    public int cantidadProductos() { // Metodo para obtener la cantidad de productos en el inventario.
        return cantidadProductos;
    }

    // ====================== Actualizar Producto =====================
    public void actualizarProducto(int id, String nuevoNombre, double nuevoPrecio, int nuevoStock) {

        // Validacion de los casos limites
        if (estaVacio()) {
            System.out.println("El inventario esta vacio, no hay productos para actualizar.");
            return;
        }

        for (int i = 0; i < cantidadProductos; i++) {

            if (productos[i].getId() == id) {
                productos[i].setNombre(nuevoNombre);
                productos[i].setPrecio(nuevoPrecio);
                productos[i].setStock(nuevoStock);
                System.out.println("Producto con ID " + id + " actualizado correctamente.");
                return;
            }
        }
        System.out.println("Producto con ID " + id + " no encontrado.");
    }

    // ====================== Eliminar Producto =====================
    public void eliminarProducto(int id) {
        if (estaVacio()) {
            System.out.println("El inventario esta vacio, no hay productos para eliminar.");
            return;
        }

        for (int i = 0; i < cantidadProductos; i++) {
            if (productos[i].getId() == id) {
                // Desplazar los productos hacia la izquierda para llenar el espacio vacío
                for (int j = i; j < cantidadProductos - 1; j++) {
                    productos[j] = productos[j + 1];
                }
                productos[cantidadProductos - 1] = null; // Limpiar la última posición
                cantidadProductos--;
                System.out.println("Producto con ID " + id + " eliminado correctamente.");
                return;
            }
        }
        System.out.println("Producto con ID " + id + " no encontrado.");
    }

    // ====================== MODULO 2: BUSQUEDA Y ORDENAMIENTO
    // ======================

    // ====================== Busqueda Secuencial =====================

    public Producto buscarSecuencial(int id) {// Busqueda secuencial por codigo. Recorre el arreglo posicion por
                                              // posicion.
        if (estaVacio()) {
            System.out.println("El inventario esta vacio, no hay nada que buscar.");
            return null;
        }

        if (id <= 0) {
            System.out.println("El id debe ser mayor que cero");
            return null;
        }

        for (int i = 0; i < cantidadProductos; i++) {
            if (productos[i].getId() == id) {
                return productos[i]; // Lo encontro, no sigue revisando.
            }
        }

        System.out.println("El producto con ID " + id + " no se encuentra en el inventario.");
        return null; // Reviso todo el inventario y no estaba.

    }

    // ====================== Busqueda Secuencial por Nombre =====================
    public Producto buscarSecuencialPorNombre(String nombre) {// Busqueda secuencial por nombre. Recorre el arreglo
                                                              // posicion por posicion.
        if (estaVacio()) {
            System.out.println("El inventario esta vacio, no hay nada que buscar.");
            return null;
        }

        for (int i = 0; i < cantidadProductos; i++) {
            if (productos[i].getNombre().equalsIgnoreCase(nombre)) {
                return productos[i]; // Lo encontro, no sigue revisando.
            }
        }

        System.out.println("El producto con nombre \"" + nombre + "\" no se encuentra en el inventario.");
        return null; // Reviso todo el inventario y no estaba.
    }

    // ====================== Ordenamiento Burbuja por ID =====================
    public void ordenarBurbuja() {
        if (estaVacio()) {
            System.out.println("El inventario esta vacio, no hay productos para ordenar.");
            return;
        }

        if (cantidadProductos < 2) {
            System.out.println("No hay suficientes productos para ordenar.");
            return;
        }

        for (int i = 0; i < cantidadProductos - 1; i++) {
            for (int j = 0; j < cantidadProductos - i - 1; j++) {
                if (productos[j].getId() > productos[j + 1].getId()) {
                    // Intercambiar productos[j] y productos[j + 1]
                    Producto temp = productos[j];
                    productos[j] = productos[j + 1];
                    productos[j + 1] = temp;
                }
            }
        }
        System.out.println("Inventario ordenado por ID usando el método de burbuja.");
    }

    // ====================== Ordenamiento Burbuja por Nombre =====================
    public void ordenarBurbujaPorNombre() {

        if (estaVacio()) {

            System.out.println("El inventario está vacío.");
            return;

        }

        if (cantidadProductos == 1) {

            System.out.println("Solo existe un producto.");
            return;

        }

        for (int i = 0; i < cantidadProductos - 1; i++) {

            for (int j = 0; j < cantidadProductos - 1 - i; j++) {

                if (productos[j].getNombre().compareToIgnoreCase(
                        productos[j + 1].getNombre()) > 0) {

                    Producto temporal = productos[j];

                    productos[j] = productos[j + 1];

                    productos[j + 1] = temporal;

                }

            }

        }

        System.out.println(
                "Productos ordenados correctamente por nombre.");
    }

    // ====================== Busqueda Binaria =====================

    public Producto buscarBinaria(int id) {
        if (estaVacio()) {
            System.out.println("El inventario está vacío, no hay productos para buscar.");
            return null;
        }

        if (id <= 0) {
            System.out.println("El ID debe ser mayor que cero.");
            return null;
        }

        // Asegurarse de que el inventario esté ordenado por ID antes de realizar la
        // búsqueda binaria
        ordenarBurbuja();

        int izquierda = 0;
        int derecha = cantidadProductos - 1;
        
        while (izquierda <= derecha) {// Mientras haya elementos por revisar se seguira ejecutando el ciclo.

            int medio = (izquierda + derecha) / 2; // Calcular el índice del elemento medio

            int idMedio = productos[medio].getId(); // Obtener el ID del producto en la posición media

            if (idMedio == id) { // Si el ID del producto medio es igual al ID buscado, se ha encontrado el producto

                return productos[medio];

            }

            if (id > idMedio) { // Si el ID buscado es mayor que el ID del producto medio, se busca en la mitad derecha

                izquierda = medio + 1;

            } else {

                derecha = medio - 1;

            }

        }

        System.out.println(
                "No existe un producto con ID: " + id);

        return null;
    }

    // ======================Ordenamiento por Insercion =====================
    /**
     * 
     */
    public void ordenarPorInsercion() {
        if (estaVacio()) {
            System.out.println("El inventario está vacío, no hay productos para ordenar.");
            return;
        }

        if (cantidadProductos < 2) {
            System.out.println("No hay suficientes productos para ordenar.");
            return;
        }

        for (int i = 1; i < cantidadProductos; i++) { // Comenzamos desde el segundo elemento, ya que el primer elemento se considera ordenado
            Producto actual = productos[i];
            int j = i - 1;

            while (j >= 0 && productos[j].getNombre().compareToIgnoreCase( actual.getNombre()) > 0) {// Comparamos el nombre del producto actual con los productos ordenados a la izquierda

            productos[j + 1] = productos[j]; // Desplazamos el producto ordenado hacia la derecha

            j--;

        }
            productos[j + 1] = actual; // Insertamos el producto actual en la posición correcta
        }

        System.out.println("Inventario ordenado por ID usando el método de inserción.");
    }

    // ====================== Ordenamiento por Seleccion =====================
    public void ordenarSeleccionPorNombre() {
        if (estaVacio()){
            System.out.println("El inventario está vacío, no hay productos para ordenar.");
            return;
        }

        if (cantidadProductos < 2 ){

            System.out.println("No hay suficientes productos para ordenar.");
            return;
        }

        for (int i = 0; i < cantidadProductos - 1; i++){
            int indiceMinimo = i;
            for (int j = i + 1;  j < cantidadProductos; j++){
                if (productos[j].getNombre().compareToIgnoreCase(productos[indiceMinimo].getNombre()) < 0){
                    indiceMinimo = j;
                }
            }
            // Intercambiar los productos
            Producto temp = productos[i];
            productos[i] = productos[indiceMinimo];
            productos[indiceMinimo] = temp;
        }
        System.out.println("Inventario ordenado por nombre usando el método de selección." );

    }

}
