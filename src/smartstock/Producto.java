package smartstock;

public class Producto {
    //Declaracion de las variables de la clase producto 
    // y las caracteristicas de cada producto.
    private int id, stock;
    private String nombre;
    private double precio;

    //Constructor de la clase producto
    public Producto(int id, String nombre, double precio, int stock){
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }
    //Mostrando las caracteristicas de cada producto
    public void mostrarInformación(){
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: " + precio);
        System.out.println("Stock:  " + stock);
    }
    
    
}
