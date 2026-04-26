package corte2.listas_enlazadas_dobles.Ejercicio5;

public class Cancion {
    String titulo;
    String artista;
    int duracionSegundos;
    Cancion siguiente;
    Cancion anterior;

    public Cancion(String titulo, String artista, int duracion) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracionSegundos = duracion;
        this.siguiente = null;
        this.anterior = null;
    }
}
