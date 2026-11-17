package smartstock;

/**
 * Representa a un cliente en la fila de atención de caja.
 */
public class Cliente {

    private int turno;
    private String nombre;

    public Cliente(int turno, String nombre) {
        this.turno = turno;
        this.nombre = nombre;
    }

    public int getTurno() {
        return turno;
    }

    public String getNombre() {
        return nombre;
    }

    public void mostrarInformacion() {
        System.out.println("Turno #" + turno + " - Cliente: " + nombre);
    }
}
