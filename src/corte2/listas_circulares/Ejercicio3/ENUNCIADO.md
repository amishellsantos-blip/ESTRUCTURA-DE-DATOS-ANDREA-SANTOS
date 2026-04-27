# Planificador de CPU (Algoritmo Round Robin)

## Descripción del Problema

Los sistemas operativos modernos gestionan múltiples procesos simultáneamente utilizando el algoritmo **Round Robin**. Este sistema reparte el tiempo del procesador de forma equitativa a través de una lista circular, otorgando a cada proceso un pequeño intervalo de tiempo llamado **quantum**.

## Requisitos

### La Clase Proceso (Nodo Simple)
Debe contener los siguientes atributos:
- `nombre` (String)
- `pid` (int)
- `tiempoRestante` (int)
- `prioridad` (int - del 1 al 3)
- `siguiente` (Referencia al mismo tipo de nodo)

### La Clase Planificador (Lista Circular)
Debe gestionar una lista circular de procesos con los siguientes métodos:
- `agregarProceso()` - Agrega un proceso a la cola de ejecución.
- `ejecutar(int quantum)` - Simula el ciclo de procesamiento. En cada paso, se descuenta el quantum del tiempo restante del proceso actual.
- `mostrarCola()` - Imprime los procesos que aún están en espera de CPU.

### El Problema
El procesador recorre la lista circular en bucle. Si un proceso recibe su turno pero no termina en ese quantum, vuelve al final de la cola (en una lista circular, simplemente se pasa al siguiente nodo). Si el proceso termina (`tiempoRestante <= 0`), debe ser eliminado de la lista.

### El Reto
Implementar la simulación completa donde el ciclo solo termina cuando la lista circular queda vacía. Además, el sistema debe registrar y mostrar el **orden exacto en que terminaron** los procesos.

## Salida Esperada
El programa debe permitir:
1. Cargar procesos con su tiempo de ráfaga (burst time).
2. Definir un quantum de tiempo para la simulación.
3. Observar turno a turno qué proceso está en ejecución y cuánto tiempo le resta.
4. Ver el reporte final con el orden de finalización de todos los procesos.

## Tips para el Desarrollo:
1.  **Vaciado de Lista:** El bucle de ejecución debe continuar hasta que la lista esté vacía (`cabeza == null`).
2.  **Eliminación Dinámica:** Al terminar un proceso, usa el nodo `anterior` para reconectar el círculo.
3.  **Actualizar Cola:** Si eliminas el nodo que era la `cola`, actualiza el puntero al nodo anterior.

## Clases a Implementar
1. **Proceso.java** - Nodo simple
2. **Planificador.java** - Lista circular simple
3. **App.java** - Clase principal con menú interactivo
