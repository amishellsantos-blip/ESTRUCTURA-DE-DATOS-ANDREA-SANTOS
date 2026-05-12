# Logística de Distribución (Callejón sin Salida)

## Descripción del Problema

Un centro de logística urbana tiene un muelle de carga ubicado al final de un callejón muy estrecho. Los camiones de reparto entran uno tras otro y quedan "atrapados" en el orden de llegada. El último camión en entrar debe ser obligatoriamente el primero en salir para permitir que los demás se retiren.

## Requisitos

### La Clase Camion (Nodo)
Debe contener los siguientes atributos:
- `placa` (String)
- `conductor` (String)
- `cargaToneladas` (double)
- `siguiente` (Referencia al mismo tipo de nodo)

### La Clase PilaCamiones (Pila)
Debe gestionar una pila de camiones utilizando punteros (referencias) y garantizando que solo se interactúe con los elementos desde el tope.

### El Problema
El supervisor necesita saber cuánta carga total hay en el callejón sin mover los camiones físicamente de forma permanente (es decir, preservando el orden y los datos de la estructura original tras realizar la consulta).

### El Reto
Implementa un método `calcularCargaTotal()` que calcule la suma total de `cargaToneladas` de todos los camiones estacionados. Debes desapilar los camiones para contarlos, pero al finalizar el método, la pila original debe quedar exactamente en el mismo estado (reconstruyéndola con una pila auxiliar).

## Salida Esperada
El programa debe tener un menú interactivo que permita:
1. Ver camiones en el callejón.
2. Ingresar un nuevo camión (Push).
3. Retirar el último camión ingresado (Pop).
4. Calcular carga total en el callejón.
5. Salir.

## Tips para el Desarrollo:
1. **Uso de Auxiliares:** Utiliza una `PilaCamiones` temporal dentro del método de conteo. Pasa los nodos del callejón principal a la pila temporal usando `pop()` y sumando la carga.
2. **Reconstrucción:** Una vez finalizado el conteo y la suma, vuelve a pasar todos los elementos de la pila temporal a la principal usando de nuevo `pop()` y `push()`, para que recuperen su orden original.
3. **Encapsulamiento:** Cumpliendo estas reglas, estarás operando 100% como una pila abstracta, respetando su principio de no ver elementos intermedios sin sacarlos por arriba.

## Clases a Implementar
1. **Camion.java** - Nodo
2. **PilaCamiones.java** - Pila (Stack)
3. **App.java** - Aplicación para correr el menú
