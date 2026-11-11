package smartstock;


public class InventarioLineal {

    private Producto[] productos = new Producto[350]; //Arreglo de productos, y se pueden almacenar hasta 350 pociciones.

    private int cantidadProductos = 0; //Son la cantidad de productos en el inventario, este inicia en 0.

    public void agregarProducto(Producto producto){//Con este agregamos los productos.
        if (cantidadProductos < productos.length){
            productos[cantidadProductos] = producto;
            cantidadProductos++;

        }else{
            System.out.println("El inventario esta lleno, no se puede agregar mas productos.");
        }

    }

   public void mostrarProductos() {

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


}



