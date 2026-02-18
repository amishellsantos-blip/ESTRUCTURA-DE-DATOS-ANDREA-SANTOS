package Tema1_Variables_y_tipos_de_datos;
/*
 * Ejercicio 3 — Sensor de temperatura
 * Tema: Variables y tipos de datos
 * Descripción: Determinar si un sensor entra en estado de alarma
 * cuando la temperatura supera los 80°C.
 */

public class Ejercicio3 {
    public static void main(String[] args) {

        double temperatura = 85.5;
        String nombreSensor = "Sensor Industrial A1";
        int numeroLectura = 12;
        boolean enAlarma = temperatura > 80;

        System.out.println("=== Sensor de Temperatura ===");
        System.out.println("Nombre del Sensor: " + nombreSensor);
        System.out.println("Número de Lectura: " + numeroLectura);
        System.out.println("Temperatura actual: " + temperatura + "°C");
        System.out.println("¿En alarma?: " + (enAlarma ? "Sí" : "No"));
    }
    
}
