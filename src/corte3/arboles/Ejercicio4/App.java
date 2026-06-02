package corte3.arboles.Ejercicio4;

import java.util.Scanner;

/*
Datos de prueba sugeridos para ingresar manualmente:
- ELO: 1500 | Usuario: chess_master   | País: Colombia | Partidas: 120
- ELO: 2100 | Usuario: rey_blanco     | País: España   | Partidas: 350
- ELO: 1850 | Usuario: peon_aislado   | País: México   | Partidas: 80
- ELO: 2400 | Usuario: gran_maestro23 | País: Argentina| Partidas: 900
*/
public class App {
    public static void main(String[] args) {
        ArbolRanking ranking = new ArbolRanking();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- TORNEO DE AJEDREZ (RANKING ELO) ---");
            System.out.println("1. Ver ranking global (Ordenado de menor a mayor)");
            System.out.println("2. Registrar nuevo jugador");
            System.out.println("3. Listar jugadores clasificados (Filtrar por rango de ELO)");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.println("\nClasificación Global:");
                    ranking.imprimirRanking();
                    break;
                case 2:
                    System.out.print("Puntaje ELO (Ej. 1800): "); 
                    int elo = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.print("Nombre de Usuario: "); 
                    String usuario = scanner.nextLine();
                    
                    System.out.print("País: "); 
                    String pais = scanner.nextLine();
                    
                    System.out.print("Partidas Jugadas: "); 
                    int partidas = scanner.nextInt();
                    scanner.nextLine();
                    
                    ranking.insertar(elo, usuario, pais, partidas);
                    System.out.println("Jugador registrado exitosamente en el árbol BST.");
                    break;
                case 3:
                    System.out.print("Ingrese el ELO mínimo (Ej. 1800): ");
                    int eloMin = scanner.nextInt();
                    System.out.print("Ingrese el ELO máximo (Ej. 2200): ");
                    int eloMax = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.println("\nJugadores clasificados en el rango [" + eloMin + " - " + eloMax + "]:");
                    ranking.listarEnRango(eloMin, eloMax);
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}
