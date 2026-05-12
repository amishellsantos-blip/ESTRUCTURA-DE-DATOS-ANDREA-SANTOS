package corte2.Parcial2.Ejercicio1;

public class Vagon {
    int id;
    String contenido;
    double pesoToneladas;
    Vagon siguiente;

    public Vagon(int id, String contenido, double pesoToneladas) {
        this.id = id;
        this.contenido = contenido;
        this.pesoToneladas = pesoToneladas;
        this.siguiente = null;
    }

}
