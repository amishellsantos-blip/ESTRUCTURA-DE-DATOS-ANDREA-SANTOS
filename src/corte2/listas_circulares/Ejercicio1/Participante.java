package corte2.listas_circulares.Ejercicio1;

public class Participante {
    String nombre;
    int numeroBoleta;
    String ciudad;
    Participante siguiente;

    public Participante(String nombre, int numeroBoleta, String ciudad) {
        this.nombre = nombre;
        this.numeroBoleta = numeroBoleta;
        this.ciudad = ciudad;
        this.siguiente = null;
    }
}
