# Gestión de Mesas en Restaurante (Lista de Espera Circular)

## Descripción del Problema

Un restaurante popular gestiona su lista de espera utilizando una estructura circular. Este sistema permite una rotación justa y el manejo especial de clientes recurrentes o VIP que requieren múltiples atenciones o rondas de servicio.

## Requisitos

### La Clase Grupo (Nodo Simple)
Debe contener los siguientes atributos:
- `nombreReserva` (String)
- `numeroPersonas` (int)
- `esVip` (boolean)
- `minutosEsperando` (int)
- `siguiente` (Referencia al mismo tipo de nodo)

### La Clase Restaurante (Lista Circular)
Debe gestionar la espera con los siguientes métodos:
- `agregarGrupo()` - Agrega un grupo al final de la lista circular.
- `atenderSiguiente()` - Procesa el grupo que está en la cabeza de la lista.
- `mostrarLista()` - Imprime los grupos que aún esperan mesa o atención.

### El Problema
Los grupos normales son atendidos y salen definitivamente de la lista. Sin embargo, los grupos **VIP** tienen un beneficio: al ser atendidos, no salen del sistema, sino que son reinsertados automáticamente al final de la lista circular para una posible segunda ronda o pedido especial.

### El Reto
Implementar el método `atenderSiguiente()` que diferencie el flujo entre clientes normales y VIP. Se debe simular el comportamiento dinámico del restaurante donde la lista cambia constantemente después de cada turno.

## Salida Esperada
El programa debe permitir:
1. Registrar grupos especificando si son VIP o no.
2. Atender a los grupos uno por uno.
3. Observar cómo los VIP vuelven al final mientras que los normales desaparecen.
4. Ejecutar una simulación rápida de 6 atenciones para verificar la rotación circular.

## Tips para el Desarrollo:
1.  **Rotación VIP:** Para mover un VIP al final en O(1), simplemente haz `cola = cabeza` y `cabeza = cabeza.siguiente`.
2.  **Mantenimiento del Ciclo:** Siempre asegura que `cola.siguiente == cabeza` después de cada atención.
3.  **Caso Base:** Si solo queda un grupo, asegúrate de que al atenderlo la lista pase a ser `null`.

## Clases a Implementar
1. **Grupo.java** - Nodo simple
2. **Restaurante.java** - Lista circular simple
3. **App.java** - Clase principal con menú interactivo
