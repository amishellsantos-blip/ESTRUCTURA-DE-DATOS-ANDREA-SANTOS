# Línea de Metro Circular

## Descripción del Problema

Una ciudad tiene una línea de metro que forma un anillo cerrado: después de la última estación el tren vuelve automáticamente a la primera. Se utiliza una lista circular doble para representar esta red, lo que permite a los pasajeros viajar en cualquier dirección (sentido horario o anti-horario).

## Requisitos

### La Clase Estacion (Nodo Doble Circular)
Debe contener los siguientes atributos:
- `nombre` (String)
- `zona` (int — del 1 al 3)
- `pasajerosDiarios` (int)
- `siguiente` y `anterior` (Referencias al mismo tipo de nodo)

### La Clase MetroCircular (Lista Circular Doble)
Debe gestionar la red con los siguientes campos explícitos:
- `cabeza` y `cola`.
- Invariante obligatoria: `cola.siguiente == cabeza` y `cabeza.anterior == cola`.

### El Problema
Dado el nombre de una estación de origen y una de destino, el sistema debe calcular la distancia (número de paradas) en ambos sentidos para recomendar la ruta más eficiente.

### El Reto
Implementar el método `rutaMasCorta(String origen, String destino)` que:
1. Recorra hacia adelante (`siguiente`) con un contador hasta encontrar el destino.
2. Recorra hacia atrás (`anterior`) con un contador hasta encontrar el destino.
3. Compare ambos resultados y anuncie la ruta ganadora.

## Tips para el Desarrollo Aplicados:
1. **Contar en ambas direcciones:** Se utiliza un bucle `do-while` para cada sentido, evitando vueltas infinitas y asegurando que se exploren ambos caminos.
2. **Navegación Doble:** Se aprovecha la naturaleza bidireccional de la lista circular doble para una búsqueda eficiente.

## Salida Esperada
El programa debe permitir:
1. Registrar al menos 6 estaciones para una simulación realista.
2. Ingresar cualquier par de estaciones y obtener el reporte de paradas.
3. Mostrar el mapa completo indicando el sentido de la red.

## Clases a Implementar
1. **Estacion.java** - Nodo doble
2. **MetroCircular.java** - Lista circular doble
3. **App.java** - Clase principal con menú interactivo
