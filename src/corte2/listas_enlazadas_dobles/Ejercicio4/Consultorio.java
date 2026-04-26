package corte2.listas_enlazadas_dobles.Ejercicio4;

public class Consultorio {
    Paciente cabeza;
    Paciente cola;

    public Consultorio() {
        this.cabeza = null;
        this.cola = null;
    }

    public void agregarPaciente(String nombre, int edad, int urgencia) {
        Paciente nuevo = new Paciente(nombre, edad, urgencia);

        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
        } 
        // Prioridad de Emergencia (Nivel 5)
        else if (urgencia == 5) {
            nuevo.siguiente = cabeza.siguiente;
            nuevo.anterior = cabeza;
            
            if (cabeza.siguiente != null) {
                cabeza.siguiente.anterior = nuevo;
            } else {
                cola = nuevo; // Si solo había uno, el nuevo nivel 5 es la nueva cola
            }
            cabeza.siguiente = nuevo;
            System.out.println("¡¡EMERGENCIA!! Paciente " + nombre + " posicionado prioritariamente.");
        } 
        // Ingreso Normal (Al final)
        else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
        }
    }

    public void buscarMayorEdadDesdeAtras() {
        if (cola == null) {
            System.out.println("¡¡No hay pacientes en la fila.!!");
            return;
        }

        System.out.println("\n>>> BUSCANDO PACIENTE MAYOR DESDE EL FINAL (COLA) <<<");
        Paciente mayor = cola;
        Paciente actual = cola.anterior;

        while (actual != null) {
            if (actual.edad > mayor.edad) {
                mayor = actual;
            }
            actual = actual.anterior;
        }

        System.out.println("=".repeat(50));
        System.out.println("PACIENTE DE MAYOR EDAD ENCONTRADO");
        System.out.println("=".repeat(50));
        System.out.println("Nombre: " + mayor.nombre);
        System.out.println("Edad: " + mayor.edad + " años");
        System.out.println("Nivel Urgencia: " + mayor.nivelUrgencia);
        System.out.println("=".repeat(50));
    }

    public void mostrarTurnos() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("FILA DE TURNOS - CONSULTORIO MÉDICO");
        System.out.println("=".repeat(60));
        System.out.printf("%-20s | %-10s | %-15s%n", "Nombre", "Edad", "Urgencia");
        System.out.println("-".repeat(60));

        Paciente temp = cabeza;
        if (temp == null) {
            System.out.println("No hay pacientes esperando.");
        } else {
            while (temp != null) {
                String prioridad = (temp.nivelUrgencia == 5) ? " [EMERGENCIA]" : "";
                System.out.printf("%-20s | %-10d | %-15d%s%n", 
                    temp.nombre, temp.edad, temp.nivelUrgencia, prioridad);
                temp = temp.siguiente;
            }
        }
        System.out.println("=".repeat(60) + "\n");
    }
}
