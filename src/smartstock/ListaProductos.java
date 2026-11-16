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
        nuevo.setSiguiente(cabeza);
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
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
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

        if (cabeza.getDato().getId() == id) {
            cabeza = cabeza.getSiguiente();
            tamano--;
            return true;
        }

        Nodo actual = cabeza;
        while (actual.getSiguiente() != null && actual.getSiguiente().getDato().getId() != id) {
            actual = actual.getSiguiente();
        }

        if (actual.getSiguiente() == null) {
            System.out.println("Producto no encontrado, no se elimino nada.");
            return false;
        }

        actual.setSiguiente(actual.getSiguiente().getSiguiente());
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
                    actual.getDato().getId(),
                    actual.getDato().getNombre(),
                    actual.getDato().getPrecio(),
                    actual.getDato().getStock());
            actual = actual.getSiguiente();
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
            if (actual.getDato().getId() == id) {
                return actual.getDato();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    public int getTamano() {
        return tamano;
    }
}
