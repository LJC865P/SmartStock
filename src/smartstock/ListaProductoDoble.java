package smartstock;

public class ListaProductoDoble {

    private NodoDoble cabeza;
    private NodoDoble cola;
    private int tamano = 0;
    

    private boolean estaVacia() {
        return cabeza == null;
    }

    public void insertarInicio(Producto producto) {
        if (producto == null) {
            System.out.println("Error, no se puede agregar un producto nulo");
            return;
        }
        ;

        NodoDoble nuevo = new NodoDoble(producto);
        if (estaVacia()) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
            cabeza = nuevo;
        }
        tamano++;
    }

    public void insertarFinal(Producto producto) {
        if (producto == null) {
            System.out.println("Error, no se puede agregar un producto nulo");
            return;
        }
        

        NodoDoble nuevo = new NodoDoble(producto);
        if (estaVacia()) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            nuevo.anterior = cola;
            cola.siguiente = nuevo;
            cola = nuevo;
        }
        tamano++;
    }

    public void recorrerAdelante() {
        if (estaVacia()) {
            System.out.println("La lista esta vacia, no hay productos");
            return;
        }

        encabezado();
        NodoDoble actual = cabeza;
        while (actual != null) {
            fila(actual.dato);
            actual = actual.siguiente;
        }
        pie();
    }

    public void recorrerAtras() {
        if (estaVacia()) {
            System.out.println("La lista esta vacia, no hay productos");
            return;
        }

        encabezado();
        NodoDoble actual = cola;
        while (actual != null) {
            fila(actual.dato);
            actual = actual.anterior;
        }
        pie();
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

        NodoDoble actual = cabeza;
        while (actual != null && actual.dato.getId() != id) {
            actual = actual.siguiente;
        }

        if (actual == null) {
            System.out.println("Producto no encontrado, no se elimino nada.");
            return false;
        }

        if (actual.anterior != null) {
            actual.anterior.siguiente = actual.siguiente;
        } else {
            cabeza = actual.siguiente;
        }

        if (actual.siguiente != null) {
            actual.siguiente.anterior = actual.anterior;
        } else {
            cola = actual.anterior;
        }

        tamano--;
        return true;
    }

    public int getTamano() {
        return tamano;
    }

    private void encabezado() {
        System.out.println("+------+--------------------------+----------+--------+");
        System.out.println("| ID   | NOMBRE                   | PRECIO   | STOCK  |");
        System.out.println("+------+--------------------------+----------+--------+");
    }

    private void fila(Producto p) {
        System.out.printf("| %-4d | %-24s | %-8.2f | %-6d |%n",
                p.getId(), p.getNombre(), p.getPrecio(), p.getStock());
    }

    private void pie() {
        System.out.println("+------+--------------------------+----------+--------+");
    }
}
