package corte3.arboles.Ejercicio3;

public class Empleado {
    long cedula;
    String nombreCompleto;
    String cargo;
    double salario;
    Empleado izq;
    Empleado der;

    public Empleado(long cedula, String nombreCompleto, String cargo, double salario) {
        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
        this.cargo = cargo;
        this.salario = salario;
        this.izq = null;
        this.der = null;
    }

    @Override
    public String toString() {
        return "[" + cedula + " | " + nombreCompleto + " | " + cargo + " | $" + salario + "]";
    }
}
