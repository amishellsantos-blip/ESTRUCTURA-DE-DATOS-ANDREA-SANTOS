package corte2.listas_enlazadas_dobles.Ejercicio1;

public class Cambio {
    String texto;
    String tipoOperacion;
    Cambio siguiente;
    Cambio anterior;

    public Cambio(String texto, String tipoOperacion) {
        this.texto = texto;
        this.tipoOperacion = tipoOperacion;
        this.siguiente = null;
        this.anterior = null;
    }
}
