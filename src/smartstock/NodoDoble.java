package smartstock;

public class NodoDoble {
    //Atributos del nodo
     Producto dato;
     NodoDoble anterior;
     NodoDoble siguiente;

    // Constructor del nodo
    public NodoDoble(Producto dato) {
        this.dato = dato;
        this.anterior = null;
        this.siguiente = null;
    }


    
}
