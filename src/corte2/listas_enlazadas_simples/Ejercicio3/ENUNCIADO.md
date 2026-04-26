# Torre de Control (Aterrizajes de Emergencia)

## Descripción del Problema

Simula la cola de aviones esperando para aterrizar en un aeropuerto congestionado. El sistema debe gestionar las prioridades basadas en el combustible restante de los vuelos.

## Requisitos

### La Clase Vuelo (Nodo)
Debe contener los siguientes atributos:
- `numeroVuelo` (String)
- `aerolinea` (String)
- `combustibleRestante` (int)
- `pasajeros` (int)

### La Clase TorreControl (Lista Enlazada)
Debe gestionar una lista enlazada de vuelos con los siguientes métodos:
- `insertarVuelo()` - Agrega un vuelo a la cola (al final por defecto, o al inicio si tiene poco combustible)
- `reportarEmergencia(String numeroVuelo)` - Busca un vuelo y lo mueve inmediatamente al inicio de la lista
- `mostrarCola()` - Imprime la lista de espera en formato de tabla

### El Problema
Normalmente los vuelos se forman al final de la cola. Sin embargo, si un vuelo reporta menos de 10 unidades de combustible, debe ser movido inmediatamente al inicio de la lista (Cabeza) para darle prioridad de aterrizaje.

### El Reto
Implementar el método `reportarEmergencia(String numeroVuelo)` que busque un vuelo específico en cualquier posición de la cola y lo mueva al principio (Cabeza), permitiendo gestionar situaciones críticas de último minuto.

## Salida Esperada
El programa debe permitir:
1. Ingresar vuelos con validación de datos.
2. Mostrar la cola de aterrizaje organizada por prioridad.
3. Reportar emergencias y ver cómo cambia el orden de la cola en tiempo real.

## Clases a Implementar
1. **Vuelo.java** - Clase que representa un vuelo (Nodo)
2. **TorreControl.java** - Clase que gestiona la lista enlazada (Lista)
3. **App.java** - Clase principal para la interacción con el usuario
