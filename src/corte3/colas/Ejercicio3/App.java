package corte3.colas.Ejercicio3;

import java.util.Scanner;

/*
Datos de prueba sugeridos para ingresar manualmente:
- Archivo: PlanosCasa.dwg     | Usuario: Arquitecto1 | Páginas: 5   | Color: true
- Archivo: ReporteGastos.pdf  | Usuario: Contador    | Páginas: 12  | Color: false
- Archivo: Maqueta3D.png      | Usuario: Diseniador  | Páginas: 1   | Color: true
*/
public class App {
    public static void main(String[] args) {
        ColaImpresion impresora = new ColaImpresion();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\n--- IMPRESORA COMPARTIDA (RED DE OFICINA) ---");
            System.out.println("1. Ver documentos en la cola de impresión");
            System.out.println("2. Enviar nuevo documento a imprimir (Enqueue)");
            System.out.println("3. Imprimir el siguiente documento (Dequeue)");
            System.out.println("4. Calcular total de páginas pendientes");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.println("\nEstado actual de la cola de impresión:");
                    impresora.imprimir();
                    break;
                case 2:
                    System.out.print("Nombre del Archivo: "); String archivo = scanner.nextLine();
                    System.out.print("Usuario: "); String usuario = scanner.nextLine();
                    System.out.print("Número de páginas: "); int paginas = scanner.nextInt();
                    System.out.print("¿Es a color? (true/false): "); boolean color = scanner.nextBoolean();
                    scanner.nextLine();
                    impresora.enqueue(new Documento(archivo, usuario, paginas, color));
                    System.out.println("Documento enviado a la cola de impresión.");
                    break;
                case 3:
                    Documento impreso = impresora.dequeue();
                    if (impreso != null) {
                        System.out.println("Imprimiendo documento: " + impreso);
                    } else {
                        System.out.println("No hay documentos en espera para imprimir.");
                    }
                    break;
                case 4:
                    int total = impresora.calcularPaginasTotales();
                    System.out.println("Total de páginas pendientes en la cola de impresión: " + total + " páginas.");
                    break;
                case 5:
                    System.out.println("Apagando sistema de impresión...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}
