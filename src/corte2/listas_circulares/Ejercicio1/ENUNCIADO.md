# Ruleta de Sorteos (Sistema de Rifa Digital)

## Descripción del Problema

Una empresa organiza una rifa y quiere un sistema que "gire" la rueda de participantes hasta detenerse en un ganador. Se utiliza una lista circular simple para representar la rueda, donde el último participante se conecta con el primero.

## Requisitos

### La Clase Participante (Nodo Simple)
Debe contener los siguientes atributos:
- `nombre` (String)
- `numeroBoleta` (int)
- `ciudad` (String)
- `siguiente` (Referencia al mismo tipo de nodo)

### La Clase Ruleta (Lista Circular)
Debe gestionar una lista circular de participantes con los siguientes métodos:
- `registrarParticipante()` - Agrega un participante a la rueda (orden de llegada).
- `realizarSorteo(int pasos)` - Avanza un número determinado de posiciones desde la cabeza. El participante en el que se detiene es el ganador.
- `mostrarParticipantes()` - Imprime la lista de todos los participantes que aún están en la rueda.

### El Problema
Los participantes forman un ciclo infinito. Para realizar el sorteo, el sistema avanza un número aleatorio de posiciones. El reto es eliminar correctamente al ganador de la lista circular para que no pueda volver a ganar en la misma rifa, reconectando los nodos para mantener el ciclo.

### El Reto
Implementar el método `realizarSorteo(int pasos)` que maneje la eliminación del nodo ganador en todos los casos: si es el único participante, si es la cabeza o si está en cualquier otra posición del círculo.

## Salida Esperada
El programa debe permitir:
1. Registrar múltiples participantes con sus datos de contacto.
2. Simular el giro de la rueda con un número aleatorio de pasos.
3. Mostrar al ganador y retirarlo de la lista automáticamente.
4. Mostrar quiénes quedan en la ruleta después de cada sorteo.

## Tips para el Desarrollo:

1.  **Condición de parada:** Nunca uses `while (actual != null)`. En una lista circular siempre terminarás en `do { ... } while (actual != cabeza)` o con un contador de nodos recorridos.
2.  **Eliminar mientras recorres:** Si necesitas eliminar nodos durante un recorrido, guarda siempre la referencia al nodo **anterior** para poder reconectar la lista sin romper el ciclo.
3.  **Lista de un solo nodo:** Cuando quede un único nodo, su `siguiente` debe apuntarse a sí mismo. Verifica este caso antes de eliminar para no dejar referencias colgantes.
4.  **Puntero a la cola:** Mantener `cola` actualizado te permite insertar al final en O(1). Si al eliminar o insertar olvidas actualizar `cola`, la invariante `cola.siguiente == cabeza` se romperá.

## Clases a Implementar
1. **Participante.java** - Nodo simple
2. **Ruleta.java** - Lista circular simple
3. **App.java** - Clase principal con menú interactivo
