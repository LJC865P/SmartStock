package smartstock;

public class NodoDoble {
    //Atributos del nodo
     private Producto dato;
     private NodoDoble anterior;
     private NodoDoble siguiente;

    // Constructor del nodo
    public NodoDoble(Producto dato) {
        this.dato = dato;
        this.anterior = null;
        this.siguiente = null;
    }

    public Producto getDato(){
        return dato;
    }


    public void setDato(Producto dato){
        this.dato = dato;
    }

    public NodoDoble getSiguiente(){
        return siguiente;
    }

    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDoble getAnterior(){
        return anterior;
    }

    public void setAnterior(NodoDoble anterior){
        this.anterior = anterior;
    }


    
}
