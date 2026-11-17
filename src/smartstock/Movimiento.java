package smartstock;

/**
 * Representa un movimiento registrado en el inventario.
 * Guarda la información necesaria para auditar o deshacer una operación.
 */
public class Movimiento {

    private int idProducto;
    private String tipo;     // "ENTRADA", "SALIDA", "VENTA"
    private int cantidad;

    public Movimiento(int idProducto, String tipo, int cantidad) {
        this.idProducto = idProducto;
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void mostrarMovimiento() {
        System.out.println("Movimiento [Producto ID: " + idProducto
                + ", Tipo: " + tipo
                + ", Cantidad: " + cantidad + "]");
    }
}
