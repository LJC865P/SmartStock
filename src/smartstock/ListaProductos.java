package smartstock;

public class ListaProductos {

    private Nodo cabeza;
    private int tamano = 0;
    

    private boolean estaVacia() {
        return cabeza == null;
    }

    public void insertarInicio(Producto producto) {
        if (producto == null) {
            System.out.println("Error, no se puede agregar un producto nulo");
            return;
        }
        

        Nodo nuevo = new Nodo(producto);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
        tamano++;
    }

    public void insertarFinal(Producto producto) {
        if (producto == null) {
            System.out.println("Error, no se puede agregar un producto nulo");
            return;
        }
       

        Nodo nuevo = new Nodo(producto);
        if (estaVacia()) {
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        tamano++;
    }

    public boolean eliminarProducto(int id) {

        if (id <= 0){

            System.out.println("ID invalido, no se puede eliminar un producto con ID negativo o cero.");
            return false;
        }
        
        if (estaVacia()) {
            System.out.println("La lista esta vacia, no hay nada que eliminar.");
            return false;
        }

        if (cabeza.dato.getId() == id) {
            cabeza = cabeza.siguiente;
            tamano--;
            return true;
        }

        Nodo actual = cabeza;
        while (actual.siguiente != null && actual.siguiente.dato.getId() != id) {
            actual = actual.siguiente;
        }

        if (actual.siguiente == null) {
            System.out.println("Producto no encontrado, no se elimino nada.");
            return false;
        }

        actual.siguiente = actual.siguiente.siguiente;
        tamano--;
        return true;
    }

    public void recorrerLista() {
        if (estaVacia()) {
            System.out.println("La lista esta vacia, no hay productos");
            return;
        }

        System.out.println("+------+--------------------------+----------+--------+");
        System.out.println("| ID   | NOMBRE                   | PRECIO   | STOCK  |");
        System.out.println("+------+--------------------------+----------+--------+");

        Nodo actual = cabeza;
        while (actual != null) {
            System.out.printf("| %-4d | %-24s | %-8.2f | %-6d |%n",
                    actual.dato.getId(),
                    actual.dato.getNombre(),
                    actual.dato.getPrecio(),
                    actual.dato.getStock());
            actual = actual.siguiente;
        }

        System.out.println("+------+--------------------------+----------+--------+");
    }

    public Producto buscarProducto(int id) {
        if (id < 0) {
            System.out.println("ID invalido");
            return null;
        }

        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.dato.getId() == id) {
                return actual.dato;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    public int getTamano() {
        return tamano;
    }
}
