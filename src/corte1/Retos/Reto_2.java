package Retos;
import java.util.Scanner;
/*
 * Reto 2 — Transacciones bancarias y verificación de cuentas VIP
 * Tema: Arreglos, búsqueda lineal y búsqueda binaria
 * Descripción: Registrar los números de cuenta y los montos de las últimas
 * 5 transacciones de un cajero automático. Utilizar una búsqueda lineal
 * para encontrar las transacciones cuyo monto supere los $5000. Para cada
 * una de estas transacciones, verificar mediante búsqueda binaria si el
 * número de cuenta pertenece a una lista de cuentas VIP previamente
 * ordenada. Si la cuenta no es VIP, mostrar un mensaje de alerta de fraude.
 */
public class Reto_2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] CuentasVIP = {123456, 234567, 345678, 456789, 567890}; 

        for (int i = 0; i < 5; i++) {

            System.out.println("\nTransacción " + (i + 1) + ":");

            System.out.print("Ingrese el número de cuenta: ");
            int numeroCuenta = scanner.nextInt();

            System.out.print("Ingrese el monto de la transacción: ");
            double monto = scanner.nextDouble();

            if (monto > 5000) {

                boolean esVIP = false;
                int inicio = 0;
                int fin = CuentasVIP.length - 1;

                while (inicio <= fin) {

                    int medio = inicio + (fin - inicio) / 2;
                    if (CuentasVIP[medio] == numeroCuenta) {
                        esVIP = true;
                        break;
                    } else if (CuentasVIP[medio] < numeroCuenta) {
                        inicio = medio + 1;
                    } else {
                        fin = medio - 1;
                    }
                }

                if (!esVIP) {
                    System.out.println("¡Alerta de fraude! La cuenta " + numeroCuenta + " no es VIP.");
                } else {
                    System.out.println("La cuenta " + numeroCuenta + " es VIP. Transacción permitida.");
                }
            }
        }
        scanner.close();
    }
    
}
