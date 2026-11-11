package smartstock;

public class Producto {
   
    //En esta clase definimos los atributos de un producto.

    private int id; //El identificador unico.
    private String nombre; //Nombre del producto.
    private  double precio;//El valor del producto.
    private int stock;//Cantidad disponible del producto.

    //Los constructores de esta clase, los cuales permiten crear objetos de tipo producto.
    public Producto(int id, String nombre, double precio, int stock) {
        this.id = id;//
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    //Metodo para mostrar la información del producto individual, eliminar al final.
    public void mostrarInformacion(){
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: " + precio);
        System.out.println("Stock: " + stock);
    }
    //Getters para obtener los valores de los atributos del producto.
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    //Setters para modificar los valores de los atributos del producto.
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}