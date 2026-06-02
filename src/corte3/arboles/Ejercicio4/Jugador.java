package corte3.arboles.Ejercicio4;

public class Jugador {
    int elo;
    String nombreUsuario;
    String pais;
    int partidasJugadas;
    Jugador izq;
    Jugador der;

    public Jugador(int elo, String nombreUsuario, String pais, int partidasJugadas) {
        this.elo = elo;
        this.nombreUsuario = nombreUsuario;
        this.pais = pais;
        this.partidasJugadas = partidasJugadas;
        this.izq = null;
        this.der = null;
    }

    @Override
    public String toString() {
        return "[ELO: " + elo + " | " + nombreUsuario + " | " + pais + " | Partidas: " + partidasJugadas + "]";
    }
}
