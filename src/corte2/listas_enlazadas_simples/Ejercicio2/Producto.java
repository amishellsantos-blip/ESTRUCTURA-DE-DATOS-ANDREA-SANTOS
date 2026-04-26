package corte2.listas_enlazadas_simples.Ejercicio2;

public class Producto {
    String nombre;
    int cantidad;
    int diasParaVencer;
    Producto siguiente;

    public Producto(String nombre, int cantidad, int diasParaVencer) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.diasParaVencer = diasParaVencer;
        this.siguiente = null;
    }
}
