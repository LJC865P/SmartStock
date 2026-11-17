package smartstock;

/**
 * PilaMovimientos — Estructura LIFO (Last In, First Out).
 *
 * Registra los movimientos recientes del inventario (entradas, salidas, ventas)
 * y permite consultar o deshacer la última acción realizada.
 */
public class PilaMovimientos {

    private static final int CAPACIDAD_MAXIMA = 100;
    private Movimiento[] pila;
    private int tope;

    public PilaMovimientos() {
        this.pila = new Movimiento[CAPACIDAD_MAXIMA];
        this.tope = -1; // Inicia vacía
    }

    public boolean estaVacia() {
        return tope == -1;
    }

    public boolean estaLlena() {
        return tope == CAPACIDAD_MAXIMA - 1;
    }

    /**
     * Agrega un movimiento en la cima de la pila (Push).
     */
    public void apilarMovimiento(Movimiento movimiento) {
        if (movimiento == null) {
            System.out.println("Error: No se puede apilar un movimiento nulo.");
            return;
        }

        if (estaLlena()) {
            System.out.println("Error: La pila de movimientos está llena.");
            return;
        }

        tope++;
        pila[tope] = movimiento;
        System.out.println("Movimiento apilado con éxito: " + movimiento.getTipo()
                + " (Producto ID: " + movimiento.getIdProducto() + ", Cantidad: " + movimiento.getCantidad() + ")");
    }

    /**
     * Sobrecarga para apilar pasando directamente los datos del movimiento.
     */
    public void apilarMovimiento(int idProducto, String tipo, int cantidad) {
        apilarMovimiento(new Movimiento(idProducto, tipo, cantidad));
    }

    /**
     * Retira y devuelve el último movimiento registrado (Pop).
     * Ideal para deshacer la última operación.
     */
    public Movimiento desapilarMovimiento() {
        if (estaVacia()) {
            System.out.println("La pila está vacía, no hay movimientos para desapilar.");
            return null;
        }

        Movimiento desapilado = pila[tope];
        pila[tope] = null; // Liberamos la referencia
        tope--;
        System.out.println("Movimiento desapilado: " + desapilado.getTipo()
                + " (Producto ID: " + desapilado.getIdProducto() + ", Cantidad: " + desapilado.getCantidad() + ")");
        return desapilado;
    }

    /**
     * Consulta el movimiento más reciente sin retirarlo (Peek).
     */
    public Movimiento consultarUltimoMovimiento() {
        if (estaVacia()) {
            System.out.println("La pila está vacía.");
            return null;
        }
        return pila[tope];
    }

    /**
     * Muestra todo el historial de movimientos de la pila desde el tope hasta la base.
     */
    public void mostrarPila() {
        if (estaVacia()) {
            System.out.println("Pila de movimientos vacía.");
            return;
        }

        System.out.println("\n===== HISTORIAL DE MOVIMIENTOS (Pila LIFO) =====");
        for (int i = tope; i >= 0; i--) {
            String indicador = (i == tope) ? " [TOPE] -> " : "           -> ";
            System.out.println(indicador + (i + 1) + ". " + pila[i].getTipo()
                    + " | ID Prod: " + pila[i].getIdProducto()
                    + " | Cantidad: " + pila[i].getCantidad());
        }
        System.out.println("================================================");
    }

    public int getTope() {
        return tope;
    }
}
