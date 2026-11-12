package smartstock;


public class InventarioLineal {

    
    private Producto[] productos = new Producto[350]; //Arreglo de productos, y se pueden almacenar hasta 350 pociciones.

    
    private int cantidadProductos = 0; //Son la cantidad de productos en el inventario, este inicia en 0.
    private int siguienteId = 1;
    
    private boolean estaVacio(){ //Para verificar si el inventario esta vacio.
        return cantidadProductos == 0;
    }

    private boolean estaLleno(){//Para verificar si el inventario esta lleno.
        return cantidadProductos == productos.length;
    }

    public void agregarProducto(Producto producto){//Con este agregamos los productos.

        producto.setId(siguienteId);//Asignamos el id al producto y luego incrementamos el siguienteId 
        siguienteId++;    // para el próximo producto.
        

        //Validacion de los casos limintes 
        if(producto == null){
            System.out.println("Error, no se puede agregar un producto nulo");
            return ;
        }
         if (estaLleno()){
            System.out.println("El inventario esta lleno, no se pueden agregar mas productos.");
            return;
        }
        
        if (cantidadProductos < productos.length){
            productos[cantidadProductos] = producto;
            cantidadProductos++;
            
        }else{
            System.out.println("El inventario esta lleno, no se puede agregar mas productos.");
        } 
        
        
    }
    //Para mostrar los productos, 
    // y con formato tipo hoja de exel para identificar mejor. :v
   public void mostrarProductos() {
    if (estaVacio()){
            System.out.println("El inventario esta vacio, no hay productos");
            return;
        }

    System.out.println("+------+--------------------------+----------+--------+");
    System.out.println("| ID   | NOMBRE                   | PRECIO   | STOCK  |");
    System.out.println("+------+--------------------------+----------+--------+");

    for (int i = 0; i < cantidadProductos; i++) {

        System.out.printf("| %-4d | %-24s | %-8.2f | %-6d |%n",
                productos[i].getId(),
                productos[i].getNombre(),
                productos[i].getPrecio(),
                productos[i].getStock());
        }

    System.out.println("+------+--------------------------+----------+--------+");
    }

    public void MostrarCantidadProductos(){//Metodo para mostrar la cantidad de productos en el inventario.
        System.out.println("Cantidad de productos en el invetario: " + cantidadProductos);

    }

    public int cantidadProductos() { //Metodo para obtener la cantidad de productos en el inventario.
        return cantidadProductos;
    }




}



