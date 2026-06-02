package corte3.arboles.Ejercicio1;

public class Registro {
    double temperatura;
    String fecha;
    String estacion;
    double humedad;
    Registro izq;
    Registro der;

    public Registro(double temperatura, String fecha, String estacion, double humedad) {
        this.temperatura = temperatura;
        this.fecha = fecha;
        this.estacion = estacion;
        this.humedad = humedad;
        this.izq = null;
        this.der = null;
    }

    @Override
    public String toString() {
        return "[" + temperatura + "°C | " + fecha + " | " + estacion + " | " + humedad + "%]";
    }
}
