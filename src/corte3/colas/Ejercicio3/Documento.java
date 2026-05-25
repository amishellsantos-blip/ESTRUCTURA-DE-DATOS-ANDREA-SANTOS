package corte3.colas.Ejercicio3;

public class Documento {
    String nombreArchivo;
    String usuario;
    int numeroPaginas;
    boolean esColor;
    Documento siguiente;

    public Documento(String nombreArchivo, String usuario, int numeroPaginas, boolean esColor) {
        this.nombreArchivo = nombreArchivo;
        this.usuario = usuario;
        this.numeroPaginas = numeroPaginas;
        this.esColor = esColor;
        this.siguiente = null;
    }

    @Override
    public String toString() {
        String tipoColor = esColor ? "Color" : "Blanco/Negro";
        return "[" + nombreArchivo + " | User: " + usuario + " | " + numeroPaginas + " págs | " + tipoColor + "]";
    }
}
