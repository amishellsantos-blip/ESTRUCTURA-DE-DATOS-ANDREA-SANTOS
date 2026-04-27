# Torneo de Fútbol (Fixture Round Robin)

## Descripción del Problema

En un torneo de fútbol por el sistema de todos contra todos, se utiliza una lista circular para gestionar la rotación de los equipos y generar el fixture (calendario de partidos). Este sistema asegura que todos se enfrenten entre sí de manera justa.

## Requisitos

### La Clase Equipo (Nodo Simple)
Debe contener los siguientes atributos:
- `nombre` (String)
- `ciudad` (String)
- `puntos` (int)
- `golesFavor` (int)
- `siguiente` (Referencia al mismo tipo de nodo)

### La Clase Torneo (Lista Circular)
Debe gestionar la competencia con los siguientes métodos:
- `agregarEquipo()` - Agrega un equipo a la lista circular de participantes.
- `generarFixture()` - Genera todos los partidos del torneo siguiendo la rotación Round Robin.
- `mostrarTablaPosiciones()` - Imprime los resultados finales ordenados por puntos y goles.

### El Problema
Para generar las jornadas, se fija un equipo (la cabeza) y el resto de los equipos en el círculo rotan una posición en cada jornada. Los enfrentamientos se dan entre los equipos que quedan en posiciones opuestas dentro de la estructura circular.

### El Reto
Implementar el método `generarFixture()` que maneje la lógica de rotación completa para un número par de equipos (ej: 6 equipos). Además, se debe implementar un algoritmo de ordenamiento que tome los nodos de la lista circular y los presente como una tabla de posiciones tradicional.

## Salida Esperada
El programa debe permitir:
1. Registrar un conjunto de equipos (mínimo 2 y número par).
2. Generar automáticamente todas las jornadas de partidos con resultados aleatorios.
3. Mostrar la tabla de posiciones final organizada de mayor a menor puntaje.

## Tips para el Desarrollo:
1.  **Rotación de Equipos:** La lista circular es ideal para rotar equipos. Mantén un puntero fijo y mueve los demás una posición por jornada.
2.  **Recorrido de Tabla:** Usa `do { ... } while (actual != cabeza)` para copiar los datos a un visor (como un array) antes de ordenar la tabla final.
3.  **Invariante:** Al rotar, nunca rompas la conexión `cola.siguiente == cabeza`.

## Clases a Implementar
1. **Equipo.java** - Nodo simple
2. **Torneo.java** - Lista circular simple
3. **App.java** - Clase principal con menú interactivo
