package smartstock;

public class InventarioLineal {

    private Producto[] productos = productos = new Producto[150]; //Lo que se hace aca es que el arreglo producotos se inicialice con un tamaño de 350, 
                                                                  // osea puede almacenar hasta 350 productos.
    private int cantidadProductos = 0; //Esta variable se utiliza para llevar un registro de la cantidad de productos que se han agregado al inventario.
    
    //Metodo para agregar un producto al inventario
    public void agregarProducto(Producto producto){
        if (cantidadProductos < productos.length){
            productos[cantidadProductos] = producto;
            cantidadProductos++;
    
        }else{
            System.out.println("El inventario esta lleno");
        }
    }
    
    public void mostrarProductos(){
        for (int i = 0; i < cantidadProductos; i++){
            productos[i].mostrarInformación();
        }
    }

   
}



