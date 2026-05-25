package corte3.colas.Ejercicio1;

public class Llamada {
    String idLlamada;
    String nombreCliente;
    String motivoConsulta;
    int duracionEstimadaMinutos;
    Llamada siguiente;

    public Llamada(String idLlamada, String nombreCliente, String motivoConsulta, int duracionEstimadaMinutos) {
        this.idLlamada = idLlamada;
        this.nombreCliente = nombreCliente;
        this.motivoConsulta = motivoConsulta;
        this.duracionEstimadaMinutos = duracionEstimadaMinutos;
        this.siguiente = null;
    }

    @Override
    public String toString() {
        return "[" + idLlamada + " | " + nombreCliente + " | " + motivoConsulta + " | " + duracionEstimadaMinutos + " min]";
    }
}
