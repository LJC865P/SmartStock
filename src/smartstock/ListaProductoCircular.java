package smartstock;

public class ListaProductoCircular {

    // el atributo principal de esta calse
    private Nodo ultimo;

    // Para revisar que el metodo no este vacio
    private boolean estaVacia() {
        return ultimo == null;
    }

    // Para determinar si la lista esta vacia se apunta asi misma.
    public void insertarNodo(Producto producto) {
        if (producto == null) {
            System.out.println("No se puede iinsertar un producto nulo");
            return;
        }

        Nodo nuevo = new Nodo(producto);

        if (estaVacia()) {
            ultimo = nuevo;
            ultimo.setSiguiente(nuevo);
        } else {
            nuevo.setSiguiente(ultimo.getSiguiente()); // La cabeza de la lista
            ultimo.setSiguiente(nuevo);
            ultimo = nuevo;

        }
        System.out.println("Producto agregado correctamente");
    }

    public void recorrerCircular(){

        if (estaVacia()){
            System.out.println("La lista circular esta vacia");
            return;
        }

        System.out.println(
                "+------+--------------------------+----------+--------+");
        System.out.println(
                "| ID   | NOMBRE                   | PRECIO   | STOCK  |");
        System.out.println(
                "+------+--------------------------+----------+--------+");

        Nodo actual = ultimo.getSiguiente();

        do {

            Producto p = actual.getDato();

            System.out.printf(
                    "| %-4d | %-24s | %-8.2f | %-6d |%n",
                    p.getId(),
                    p.getNombre(),
                    p.getPrecio(),
                    p.getStock());

            actual = actual.getSiguiente();

        } while (actual != ultimo.getSiguiente());

        System.out.println(
                "+------+--------------------------+----------+--------+");
    
    }

    public void ordenarPorLista(){
        if (estaVacia()){
            System.out.println("La lista circular esta vacia.");
            return;
        }

        if (ultimo.getSiguiente() == ultimo) {
            System.out.println("Solo existe un producto");
            return;
        }

        boolean intercambio;

        do{
            intercambio = false; 
            Nodo actual = ultimo.getSiguiente();

            do{

                Nodo siguiente = actual.getSiguiente();


                if (actual.getDato().getNombre().compareToIgnoreCase(siguiente.getDato().getNombre()) > 0) {

                Producto temp = actual.getDato();

                actual.setDato(siguiente.getDato());
                
                siguiente.setDato(temp);

                intercambio = true;
                 }

                 actual = actual.getSiguiente();
            }while (actual.getSiguiente() != ultimo.getSiguiente());

        }while (intercambio); 
            System.out.println("Lista ordenada correctamente");
    }
}
