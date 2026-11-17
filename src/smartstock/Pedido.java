package smartstock;

/**
 * Representa un pedido de reposición de inventario con nivel de prioridad.
 * Menor número de prioridad significa mayor urgencia (1 = Urgente, 2 = Media, 3 = Normal).
 */
public class Pedido {

    private int idProducto;
    private String nombreProducto;
    private int cantidadSolicitada;
    private int prioridad; // 1 = Alta (urgente), 2 = Media, 3 = Baja

    public Pedido(int idProducto, String nombreProducto, int cantidadSolicitada, int prioridad) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.cantidadSolicitada = cantidadSolicitada;
        this.prioridad = prioridad;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public int getCantidadSolicitada() {
        return cantidadSolicitada;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public String getDescripcionPrioridad() {
        switch (prioridad) {
            case 1:
                return "ALTA (Urgente)";
            case 2:
                return "MEDIA (Stock bajo)";
            case 3:
                return "BAJA (Rutinaria)";
            default:
                return "Prioridad " + prioridad;
        }
    }

    public void mostrarInformacion() {
        System.out.println("Pedido [Prod: " + nombreProducto
                + " (ID: " + idProducto + ")"
                + ", Cantidad: " + cantidadSolicitada
                + ", Prioridad: " + getDescripcionPrioridad() + "]");
    }
}
