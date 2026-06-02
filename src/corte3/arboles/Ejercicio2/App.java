package corte3.arboles.Ejercicio2;

import java.util.Scanner;

/*
Datos de prueba sugeridos para ingresar manualmente:
- ISBN: 9781234567890 | Titulo: Estructuras de Datos  | Autor: Joyanes | Año: 2010
- ISBN: 9789876543210 | Titulo: Algoritmos Avanzados  | Autor: Cormen  | Año: 2009
- ISBN: 9785555555555 | Titulo: Clean Code            | Autor: Martin  | Año: 2008
- ISBN: 9781111111111 | Titulo: Design Patterns       | Autor: Gamma   | Año: 1994
*/
public class App {
    public static void main(String[] args) {
        ArbolCatalogo catalogo = new ArbolCatalogo();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- CATÁLOGO DIGITAL (BIBLIOTECA) ---");
            System.out.println("1. Ver el catálogo completo (InOrden)");
            System.out.println("2. Registrar nuevo libro");
            System.out.println("3. Verificar si un ISBN existe");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.println("\nInventario de libros ordenado por ISBN:");
                    catalogo.imprimirCatalogo();
                    break;
                case 2:
                    System.out.print("ISBN (número largo sin guiones): "); 
                    long isbn = scanner.nextLong();
                    scanner.nextLine();
                    
                    System.out.print("Título del Libro: "); 
                    String titulo = scanner.nextLine();
                    
                    System.out.print("Autor: "); 
                    String autor = scanner.nextLine();
                    
                    System.out.print("Año de Publicación: "); 
                    int anio = scanner.nextInt();
                    scanner.nextLine();
                    
                    // Verificación antes de insertar
                    if (catalogo.existeISBN(isbn)) {
                        System.out.println("Error: El libro con ISBN " + isbn + " ya existe en el catálogo.");
                    } else {
                        catalogo.insertar(isbn, titulo, autor, anio);
                        System.out.println("Libro registrado exitosamente en el árbol BST.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el ISBN a consultar: ");
                    long isbnConsulta = scanner.nextLong();
                    scanner.nextLine();
                    
                    if (catalogo.existeISBN(isbnConsulta)) {
                        System.out.println("Resultado: El ISBN " + isbnConsulta + " SÍ está registrado en el sistema.");
                    } else {
                        System.out.println("Resultado: El ISBN " + isbnConsulta + " NO ha sido encontrado.");
                    }
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
