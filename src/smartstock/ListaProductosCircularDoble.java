package smartstock;

/**
 *
 * @author josep
 */
public class ListaProductosCircularDoble {

    private NodoDoble ultimo;

    private boolean estaVacia() {
        return ultimo == null;
    }

    public void insertarNodo(Producto producto) {
        if (producto == null) {
            System.out.println("No se puede agregar un producto nulo");
            return;
        }

        NodoDoble nuevo = new NodoDoble(producto);

        if (estaVacia()) {
            ultimo = nuevo;

            nuevo.setSiguiente(nuevo);
            nuevo.setAnterior(nuevo);
        } else {
            NodoDoble primero = ultimo.getSiguiente();

            nuevo.setSiguiente(primero);
            nuevo.setAnterior(ultimo);

            primero.setAnterior(nuevo);

            ultimo.setSiguiente(nuevo);
            ultimo = nuevo;
        }

        System.out.println("Producto agregado correctamente");
    }

    public void recorrerAdelante() {
        if (estaVacia()) {
            System.out.println("La lista esta vacia");
            return;
        }

        System.out.println("+------+--------------------------+----------+--------+");
        System.out.println("| ID   | NOMBRE                   | PRECIO   | STOCK  |");
        System.out.println("+------+--------------------------+----------+--------+");

        NodoDoble actual
                = ultimo.getSiguiente();

        do {

            System.out.printf(
                    "| %-4d | %-24s | %-8.2f | %-6d |%n",
                    actual.getDato().getId(),
                    actual.getDato().getNombre(),
                    actual.getDato().getPrecio(),
                    actual.getDato().getStock());

            actual = actual.getSiguiente();

        } while (actual != ultimo.getSiguiente());

        System.out.println("+------+--------------------------+----------+--------+");

    }

    public void recorrerAtras() {

        if (estaVacia()) {
            System.out.println("La lista circular doble está vacía.");

            return;
        }

        System.out.println("+------+--------------------------+----------+--------+");
        System.out.println("| ID   | NOMBRE                   | PRECIO   | STOCK  |");
        System.out.println("+------+--------------------------+----------+--------+");

        NodoDoble actual = ultimo;

        do {

            System.out.printf(
                    "| %-4d | %-24s | %-8.2f | %-6d |%n",
                    actual.getDato().getId(),
                    actual.getDato().getNombre(),
                    actual.getDato().getPrecio(),
                    actual.getDato().getStock());

            actual = actual.getAnterior();

        } while (actual != ultimo);

    }
    
    public void ordenarLista(){
        if (estaVacia()){
            System.out.println("La lista circular esta vacia");
            return;
        }
        
        if(ultimo.getSiguiente() == ultimo){
            System.out.println("Solo existe un producto");
            return;
        }
        
        boolean intercambio;
        
        do{
            intercambio = false;
            
            NodoDoble actual = ultimo.getSiguiente();
            
            do{
                NodoDoble siguiente = actual.getSiguiente();
                
                if(actual.getDato().getNombre().compareToIgnoreCase(siguiente.getDato().getNombre()) > 0){
                    Producto temporal = actual.getDato();
                    actual.setDato(siguiente.getDato());
                    siguiente.setDato(temporal);
                    intercambio = true;
                }
                actual = actual.getSiguiente();
                
            }while(actual.getSiguiente() != ultimo.getSiguiente());
        }while(intercambio);
        System.out.println("La lista a sido ordenada");
    }

}
