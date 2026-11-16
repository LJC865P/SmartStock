package smartstock;

public class Nodo {
    //Atributos del nodo
     private Producto dato;//Dato del nodo
     private Nodo siguiente;//Siguiente nodo

    
    public Nodo(Producto dato) {//Constructor del nodo
        this.dato = dato;
        this.siguiente = null;
    }

    public Producto getDato(){
        return dato;
    }


    public void setDato(Producto dato){
        this.dato = dato;
    }

    public Nodo getSiguiente(){
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }


   
}
