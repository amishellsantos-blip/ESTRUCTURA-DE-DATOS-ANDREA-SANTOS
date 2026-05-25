package corte3.colas.Ejercicio2;

public class Paciente {
    String cedula;
    String nombreCompleto;
    int edad;
    String sintomaPrincipal;
    Paciente siguiente;

    public Paciente(String cedula, String nombreCompleto, int edad, String sintomaPrincipal) {
        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.sintomaPrincipal = sintomaPrincipal;
        this.siguiente = null;
    }

    @Override
    public String toString() {
        return "[CC: " + cedula + " | " + nombreCompleto + " | Edad: " + edad + " | Síntoma: " + sintomaPrincipal + "]";
    }
}
