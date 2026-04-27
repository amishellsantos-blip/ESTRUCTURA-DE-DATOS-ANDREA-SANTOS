package corte2.listas_circulares.Ejercicio4;

public class Grupo {
    String nombreReserva;
    int numeroPersonas;
    boolean esVip;
    int minutosEsperando;
    Grupo siguiente;

    public Grupo(String nombreReserva, int numeroPersonas, boolean esVip, int minutosEsperando) {
        this.nombreReserva = nombreReserva;
        this.numeroPersonas = numeroPersonas;
        this.esVip = esVip;
        this.minutosEsperando = minutosEsperando;
        this.siguiente = null;
    }
}
