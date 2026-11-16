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
            nuevo.setSiguiente(cabeza);
            cabeza.setAnterior(nuevo);
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
            nuevo.setAnterior(cola);
            cola.setSiguiente(nuevo);
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
            fila(actual.getDato());
            actual = actual.getSiguiente();
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
            fila(actual.getDato());
            actual = actual.getAnterior();
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
        while (actual != null && actual.getDato().getId() != id) {
            actual = actual.getSiguiente();
        }

        if (actual == null) {
            System.out.println("Producto no encontrado, no se elimino nada.");
            return false;
        }

        if (actual.getAnterior() != null) {
            actual.getAnterior().setSiguiente(actual.getSiguiente());
        } else {
            cabeza = actual.getSiguiente();
        }

        if (actual.getSiguiente() != null) {
            actual.getSiguiente().setAnterior(actual.getAnterior());
        } else {
            cola = actual.getAnterior();
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
