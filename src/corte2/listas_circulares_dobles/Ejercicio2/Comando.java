package corte2.listas_circulares_dobles.Ejercicio2;

public class Comando {
    String texto;
    boolean exitoso;
    String directorio;
    Comando siguiente;
    Comando anterior;

    public Comando(String texto, boolean exitoso, String directorio) {
        this.texto = texto;
        this.exitoso = exitoso;
        this.directorio = directorio;
        this.siguiente = null;
        this.anterior = null;
    }
}
