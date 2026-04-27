# Carrusel de Anuncios (Pantalla Digital)

## Descripción del Problema

Una tienda tiene una pantalla publicitaria que muestra anuncios en rotación continua. Cuando termina el último anuncio, la pantalla vuelve automáticamente al primero, creando un ciclo infinito de publicidad.

## Requisitos

### La Clase Anuncio (Nodo Simple)
Debe contener los siguientes atributos:
- `titulo` (String)
- `duracionSegundos` (int)
- `vecesRepetido` (int)
- `categoria` (String - ej: "Oferta", "Marca", "Evento")
- `siguiente` (Referencia al mismo tipo de nodo)

### La Clase Pantalla (Lista Circular)
Debe gestionar una lista circular de anuncios con los siguientes métodos:
- `agregarAnuncio()` - Agrega un anuncio a la cola de rotación.
- `reproducir(int ciclos)` - Simula el paso de los anuncios por la pantalla durante un número determinado de vueltas completas.
- `mostrarAnuncios()` - Imprime la lista de anuncios y sus estadísticas de repetición.

### El Problema
La pantalla necesita saber cuánto tiempo total lleva encendida (suma de duraciones de cada vez que un anuncio apareció) y cuál ha sido el contenido más exitoso (el que más veces se ha repetido).

### El Reto
Implementar el método `reproducir(int ciclos)` que recorra el círculo incrementando el contador de repeticiones en cada paso y acumulando el tiempo total. Al final, debe ser capaz de identificar al anuncio con el mayor número de visualizaciones.

## Salida Esperada
El programa debe permitir:
1. Configurar una lista de anuncios con diferentes tiempos y categorías.
2. Simular la ejecución de la pantalla por múltiples ciclos.
3. Mostrar el **tiempo total acumulado** y el **anuncio líder** en repeticiones.

## Tips para el Desarrollo:
1.  **Condición de parada:** Usa `do { ... } while (actual != cabeza)` para recorrer el ciclo completo.
2.  **Estadísticas:** Acumula el tiempo sumando la duración de cada nodo en el recorrido.
3.  **Referencia a la cola:** Asegúrate de que `cola.siguiente` siempre apunte a `cabeza`.

## Clases a Implementar
1. **Anuncio.java** - Nodo simple
2. **Pantalla.java** - Lista circular simple
3. **App.java** - Clase principal con menú interactivo
