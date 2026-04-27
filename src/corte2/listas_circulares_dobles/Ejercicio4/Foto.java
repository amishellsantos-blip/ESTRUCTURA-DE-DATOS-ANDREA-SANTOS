package corte2.listas_circulares_dobles.Ejercicio4;

public class Foto {
    String titulo;
    String fecha;
    boolean esFavorita;
    Foto siguiente;
    Foto anterior;

    public Foto(String titulo, String fecha) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.esFavorita = false;
        this.siguiente = null;
        this.anterior = null;
    }
}
