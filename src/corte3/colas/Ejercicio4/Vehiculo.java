package corte3.colas.Ejercicio4;

public class Vehiculo {
    String placa;
    String tipoVehiculo;
    double tarifa;
    boolean esExento;
    Vehiculo siguiente;

    public Vehiculo(String placa, String tipoVehiculo, double tarifa, boolean esExento) {
        this.placa = placa;
        this.tipoVehiculo = tipoVehiculo;
        this.tarifa = tarifa;
        this.esExento = esExento;
        this.siguiente = null;
    }

    @Override
    public String toString() {
        String exentoStr = esExento ? "(EXENTO)" : "($" + tarifa + ")";
        return "[Placa: " + placa + " | " + tipoVehiculo + " | " + exentoStr + "]";
    }
}
