package smartstock;

public class Nodo {
    //Atributos del nodo
     Producto dato;//Dato del nodo
     Nodo siguiente;//Siguiente nodo

    
    public Nodo(Producto dato) {//Constructor del nodo
        this.dato = dato;
        this.siguiente = null;
    }

   
}
