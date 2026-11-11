package smartstock;

public class Producto {
   
    //En esta clase definimos los atributos de un producto.

    private int id; //El identificador unico.
    private String nombre; //Nombre del producto.
    private  double precio;//El valor del producto.
    private int stock;//Cantidad disponible del producto.

    //Los constructores de esta clase, los cuales permiten crear objetos de tipo producto.
    public Producto(String nombre, double precio, int stock) {


    if(nombre == null || nombre.trim().isEmpty()){//Validacion de los casos limites para el nombre.
        throw new IllegalArgumentException(
                "El nombre es obligatorio");
    }

    if(precio <= 0){//Validacion de los casos limites para el precio.
        throw new IllegalArgumentException(
                "El precio debe ser mayor que cero");
    }

    if(stock < 0){//Validacion de los casos limites para el stock.
        throw new IllegalArgumentException(
                "El stock no puede ser negativo");
    }

        
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
    public int getId() {//Lo que hace es retornar el valor del id del producto.
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
        if (id > 0) {
            this.id = id;
        } else {
            System.out.println("El ID debe ser un número positivo.");
        }
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        } else {
            System.out.println("El nombre no puede estar vacío.");
        }
        
    }

    public void setPrecio(double precio) {
        if (precio > 0){
            this.precio = precio;
        }else{
            System.out.println("El precio debe ser un número positivo.");
        }
    }

    public void setStock(int stock) {
        if (stock >= 0){
            this.stock = stock;

        } else{
            System.out.println("El stock no puede ser negativo.");
        }
    }

}