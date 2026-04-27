package corte2.listas_circulares_dobles.Ejercicio3;

public class Capa {
    String nombre;
    boolean visible;
    String tipo;
    Capa siguiente;
    Capa anterior;

    public Capa(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.visible = true; // Por defecto visible
        this.siguiente = null;
        this.anterior = null;
    }
}
