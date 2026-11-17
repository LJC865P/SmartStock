package smartstock;

/**
 * ColaClientes — Estructura FIFO (First In, First Out).
 *
 * Administra los clientes en espera en la caja del supermercado.
 * El primer cliente que llega es el primero en ser atendido.
 */
public class ColaClientes {

    private static final int CAPACIDAD_MAXIMA = 50;
    private Cliente[] cola;
    private int frente;
    private int fin;
    private int cantidad;
    private int siguienteTurno;

    public ColaClientes() {
        this.cola = new Cliente[CAPACIDAD_MAXIMA];
        this.frente = 0;
        this.fin = -1;
        this.cantidad = 0;
        this.siguienteTurno = 1;
    }

    public boolean estaVacia() {
        return cantidad == 0;
    }

    public boolean estaLlena() {
        return cantidad == CAPACIDAD_MAXIMA;
    }

    /**
     * Agrega un nuevo cliente al final de la cola (Enqueue).
     */
    public void encolarCliente(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            System.out.println("Error: El nombre del cliente no puede estar vacío.");
            return;
        }

        if (estaLlena()) {
            System.out.println("Error: La cola de clientes está llena.");
            return;
        }

        Cliente nuevo = new Cliente(siguienteTurno++, nombre);
        fin = (fin + 1) % CAPACIDAD_MAXIMA;
        cola[fin] = nuevo;
        cantidad++;

        System.out.println("Cliente registrado: " + nuevo.getNombre()
                + " (Turno #" + nuevo.getTurno() + ")");
    }

    /**
     * Atiende y retira al primer cliente de la fila (Dequeue).
     */
    public Cliente desencolarCliente() {
        if (estaVacia()) {
            System.out.println("No hay clientes en la cola para atender.");
            return null;
        }

        Cliente atendido = cola[frente];
        cola[frente] = null;
        frente = (frente + 1) % CAPACIDAD_MAXIMA;
        cantidad--;

        System.out.println("Atendiendo a: " + atendido.getNombre()
                + " (Turno #" + atendido.getTurno() + ")");
        return atendido;
    }

    /**
     * Consulta quién es el siguiente cliente en la fila sin retirarlo.
     */
    public Cliente consultarPrimero() {
        if (estaVacia()) {
            System.out.println("No hay clientes en la fila.");
            return null;
        }
        return cola[frente];
    }

    /**
     * Muestra la lista de clientes esperando su turno.
     */
    public void mostrarCola() {
        if (estaVacia()) {
            System.out.println("La cola de clientes está vacía.");
            return;
        }

        System.out.println("\n===== FILA DE CLIENTES EN CAJA (Cola FIFO) =====");
        int indice = frente;
        for (int i = 0; i < cantidad; i++) {
            String indicador = (i == 0) ? " [SIGUIENTE] -> " : "              -> ";
            System.out.println(indicador + "Turno #" + cola[indice].getTurno()
                    + " : " + cola[indice].getNombre());
            indice = (indice + 1) % CAPACIDAD_MAXIMA;
        }
        System.out.println("Total en espera: " + cantidad);
        System.out.println("================================================");
    }

    public int getCantidad() {
        return cantidad;
    }
}
