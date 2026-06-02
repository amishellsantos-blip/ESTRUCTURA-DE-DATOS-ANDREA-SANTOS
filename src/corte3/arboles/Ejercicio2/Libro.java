package corte3.arboles.Ejercicio2;

public class Libro {
    long isbn;
    String titulo;
    String autor;
    int anioPublicacion;
    Libro izq;
    Libro der;

    public Libro(long isbn, String titulo, String autor, int anioPublicacion) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.izq = null;
        this.der = null;
    }

    @Override
    public String toString() {
        return "[" + isbn + " | " + titulo + " | " + autor + " | " + anioPublicacion + "]";
    }
}
