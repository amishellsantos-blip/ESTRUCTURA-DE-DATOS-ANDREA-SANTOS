# Historial de Comandos de Terminal

## Descripción del Problema

Los terminales de comandos (como Bash o CMD) guardan un historial de las instrucciones ejecutadas. Este sistema utiliza una lista circular doble para permitir al usuario navegar de forma infinita entre comandos antiguos y recientes, además de permitir la eliminación selectiva de entradas.

## Requisitos

### La Clase Comando (Nodo Doble Circular)
Debe contener los siguientes atributos:
- `texto` (String)
- `exitoso` (boolean)
- `directorio` (String)
- `siguiente` y `anterior` (Referencias al mismo tipo de nodo)

### La Clase HistorialTerminal (Lista Circular Doble)
Debe gestionar el historial con los siguientes métodos:
- `agregarComando()` - Agrega una entrada al final del historial.
- `arriba()` - Mueve un puntero `cursor` al comando anterior.
- `abajo()` - Mueve el puntero `cursor` al siguiente comando.
- `eliminarActual()` - Elimina el comando apuntado por el cursor.

### El Problema
El historial es circular: después del comando más antiguo vuelve al más reciente y viceversa. Al eliminar un comando, el sistema no debe romperse; el cursor debe pasar automáticamente al siguiente comando disponible.

### El Reto
Implementar la eliminación en **O(1)**. A diferencia de las listas simples, aquí no se requiere recorrer la lista para encontrar el nodo previo, ya que el nodo tiene una referencia directa a su antecesor.

## Tips para el Desarrollo Aplicados:
1. **Eliminar en O(1):** Se desconecta el nodo usando sus propios punteros `anterior` y `siguiente`.
2. **Actualización de Cabeza/Cola:** Se verifica si el nodo eliminado era un extremo para mantener la integridad de la estructura.
3. **Puntero Auxiliar:** El `cursor` se mueve a la siguiente posición **antes** de destruir el nodo actual para evitar errores de referencia.

## Salida Esperada
El programa debe permitir:
1. Simular la escritura de múltiples comandos.
2. Navegar por el historial viendo el "comando actual".
3. Eliminar comandos y verificar que la circularidad se mantiene.

## Clases a Implementar
1. **Comando.java** - Nodo doble
2. **HistorialTerminal.java** - Lista circular doble
3. **App.java** - Clase principal con menú interactivo
