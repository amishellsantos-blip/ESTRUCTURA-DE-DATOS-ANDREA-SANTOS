package corte3.arboles.Ejercicio5;

public class Repuesto {
    int codigoRef;
    String descripcion;
    String marca;
    int stock;
    Repuesto izq;
    Repuesto der;

    public Repuesto(int codigoRef, String descripcion, String marca, int stock) {
        this.codigoRef = codigoRef;
        this.descripcion = descripcion;
        this.marca = marca;
        this.stock = stock;
        this.izq = null;
        this.der = null;
    }

    @Override
    public String toString() {
        return "[" + codigoRef + "] " + descripcion + " - " + marca + " (" + stock + " uds)";
    }
}
