package smartstock;

/**
 * ColaPrioridadPedidos — Cola de Prioridad para pedidos de reposición.
 *
 * Los pedidos se atienden según su nivel de urgencia, no por orden de llegada:
 * Prioridad 1 = ALTA (Urgente, stock en cero)
 * Prioridad 2 = MEDIA (Alerta de stock bajo)
 * Prioridad 3 = BAJA (Reposición habitual)
 *
 * Mantiene los elementos ordenados para que el más urgente esté siempre al frente.
 */
public class ColaPrioridadPedidos {

    private static final int CAPACIDAD_MAXIMA = 50;
    private Pedido[] pedidos;
    private int tamanio;

    public ColaPrioridadPedidos() {
        this.pedidos = new Pedido[CAPACIDAD_MAXIMA];
        this.tamanio = 0;
    }

    public boolean estaVacia() {
        return tamanio == 0;
    }

    public boolean estaLlena() {
        return tamanio == CAPACIDAD_MAXIMA;
    }

    /**
     * Inserta un nuevo pedido en la posición que le corresponde según su prioridad.
     * Los pedidos con prioridad menor (1 antes que 2) van al inicio.
     */
    public void insertarPedido(Pedido nuevoPedido) {
        if (nuevoPedido == null) {
            System.out.println("Error: No se puede insertar un pedido nulo.");
            return;
        }

        if (estaLlena()) {
            System.out.println("Error: La cola de pedidos de reposición está llena.");
            return;
        }

        // Encontrar la posición donde debe insertarse según la prioridad (inserción ordenada)
        int i = tamanio - 1;
        while (i >= 0 && pedidos[i].getPrioridad() > nuevoPedido.getPrioridad()) {
            pedidos[i + 1] = pedidos[i]; // Desplazamos hacia la derecha
            i--;
        }

        pedidos[i + 1] = nuevoPedido;
        tamanio++;

        System.out.println("Pedido registrado con éxito: " + nuevoPedido.getNombreProducto()
                + " | Cantidad: " + nuevoPedido.getCantidadSolicitada()
                + " | Prioridad: " + nuevoPedido.getDescripcionPrioridad());
    }

    /**
     * Sobrecarga para registrar pasando directamente los datos del pedido.
     */
    public void insertarPedido(int idProducto, String nombreProducto, int cantidad, int prioridad) {
        insertarPedido(new Pedido(idProducto, nombreProducto, cantidad, prioridad));
    }

    /**
     * Procesa y atiende el pedido con mayor prioridad (el primero de la cola).
     */
    public Pedido atenderPedido() {
        if (estaVacia()) {
            System.out.println("No hay pedidos pendientes por atender.");
            return null;
        }

        Pedido atendido = pedidos[0];

        // Desplazamos todos los elementos restantes a la izquierda
        for (int i = 0; i < tamanio - 1; i++) {
            pedidos[i] = pedidos[i + 1];
        }
        pedidos[tamanio - 1] = null;
        tamanio--;

        System.out.println("Atendiendo pedido: " + atendido.getNombreProducto()
                + " (Cantidad: " + atendido.getCantidadSolicitada()
                + ", Prioridad: " + atendido.getDescripcionPrioridad() + ")");
        return atendido;
    }

    /**
     * Consulta cuál es el siguiente pedido más urgente sin retirarlo.
     */
    public Pedido consultarPrioridad() {
        if (estaVacia()) {
            System.out.println("No hay pedidos en la cola de prioridad.");
            return null;
        }
        return pedidos[0];
    }

    /**
     * Muestra todos los pedidos pendientes ordenados por prioridad.
     */
    public void mostrarPedidos() {
        if (estaVacia()) {
            System.out.println("No hay pedidos de reposición pendientes.");
            return;
        }

        System.out.println("\n===== PEDIDOS DE REPOSICIÓN (Cola de Prioridad) =====");
        System.out.println("+----+--------------------------+----------+-----------------------+");
        System.out.println("| ID | PRODUCTO                 | CANTIDAD | PRIORIDAD             |");
        System.out.println("+----+--------------------------+----------+-----------------------+");

        for (int i = 0; i < tamanio; i++) {
            System.out.printf("| %-2d | %-24s | %-8d | %-21s |%n",
                    pedidos[i].getIdProducto(),
                    pedidos[i].getNombreProducto(),
                    pedidos[i].getCantidadSolicitada(),
                    pedidos[i].getDescripcionPrioridad());
        }
        System.out.println("+----+--------------------------+----------+-----------------------+");
    }

    public int getTamanio() {
        return tamanio;
    }
}
