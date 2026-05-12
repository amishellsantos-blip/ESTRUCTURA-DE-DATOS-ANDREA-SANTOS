# Control de Calidad (Línea de Ensamblaje)

## Descripción del Problema

Un brazo robótico en una fábrica de motores apila componentes siguiendo una secuencia precisa. Un sensor de visión artificial inspecciona cada pieza después de ser colocada. Si el sensor detecta una pieza defectuosa, la línea de producción debe detenerse inmediatamente para limpiar la falla, lo que implica descartar las piezas que ya se habían apilado sobre ella.

## Requisitos

### La Clase Pieza (Nodo)
Debe contener los siguientes atributos:
- `nombrePieza` (String)
- `numeroSerie` (String)
- `esDefectuosa` (boolean)
- `siguiente` (Referencia al mismo tipo de nodo)

### La Clase PilaPiezas (Pila)
Debe gestionar una pila de piezas utilizando punteros (referencias) y garantizando que solo se interactúe con los elementos desde el tope.

### El Problema
Si se detecta una pieza mala, el sistema tiene que deshacer el trabajo reciente. Esto requiere extraer las piezas que están encima de la defectuosa para despejar el problema de la línea de ensamblaje.

### El Reto
Crea un método `limpiarHastaDefecto()` que extraiga (`pop`) todas las piezas de la pila hasta encontrar la primera que tenga `esDefectuosa = true`. El método debe imprimir el nombre de todas las piezas "buenas" que tuvieron que ser retiradas y descartadas antes de llegar a la pieza fallida.

## Salida Esperada
El programa debe tener un menú interactivo que permita:
1. Ver piezas en la línea.
2. Agregar nueva pieza (Push).
3. Ejecutar protocolo 'Limpiar hasta defecto'.
4. Salir.

## Tips para el Desarrollo:
1. **Encapsulamiento:** En una Pila no hay acceso por índice, para encontrar la defectuosa debes realizar `pop()` repetidamente.
2. **Estado de la Pila:** Comprueba `estaVacia()` en cada iteración para evitar un `NullPointerException` si por error ejecutas la limpieza en una pila que no tiene piezas defectuosas.
3. **Bucle de Retiro:** Usa un ciclo `while` que evalúe si la pila no está vacía y ve desapilando nodos, comprobando la bandera `esDefectuosa`.

## Clases a Implementar
1. **Pieza.java** - Nodo
2. **PilaPiezas.java** - Pila (Stack)
3. **App.java** - Aplicación para correr el menú
