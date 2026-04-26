package Tema3_Estructuras_lineales_y_no_lineales.Ejercicios;
/*
 * Ejercicio 12 — Historial de ventas
 * Tema: Estructuras lineales (Arreglos)
 * Descripción: Almacenar 7 ventas diarias en un arreglo de tipo double,
 * recorrerlo para calcular la venta más alta, la más baja y el total acumulado del día.
 */
public class Ejercicio12 {

    public static void main(String[] args) {
        
        double[] ventas = {150300.75, 200180.50, 320510.00, 80650.25, 400050.00, 250800.00, 100200.00};

        double ventaMasAlta = ventas[0];
        double ventaMasBaja = ventas[0];    
        double totalVentas = 0.0;

        for(int i = 0; i < ventas.length; i++){

            if(ventas[i] > ventaMasAlta){
                ventaMasAlta = ventas[i];
            }
            if(ventas[i] < ventaMasBaja){
                ventaMasBaja = ventas[i];
            }
            totalVentas += ventas[i];
        }

        System.out.println("Venta más alta del día: $" + ventaMasAlta);
        System.out.println("Venta más baja del día: $" + ventaMasBaja);
        System.out.println("Total acumulado del día: $" + totalVentas);
    }
    
}
