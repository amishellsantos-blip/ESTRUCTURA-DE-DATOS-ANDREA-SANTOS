# Ruta de Rescate (Espeleología Geológica)

## Descripción del Problema

Un equipo de rescatistas entra en una cueva inexplorada. Para no perderse, van dejando "Estaciones de Seguridad" representadas por una baliza que registra los datos del entorno a medida que avanzan.

## Requisitos

### La Clase Estacion (Nodo)
Debe contener los siguientes atributos:
- `nombrePunto` (String)
- `profundidad` (int)
- `nivelOxigeno` (double)
- `siguiente` (Referencia al mismo tipo de nodo)

### La Clase PilaEstaciones (Pila)
Debe gestionar una pila de estaciones utilizando punteros (referencias) y garantizando que solo se interactúe con los elementos desde el tope.

### El Problema
Para salir de la cueva, el equipo debe seguir las estaciones en el orden inverso al que fueron colocadas (de la más profunda a la entrada). Este comportamiento (el último punto visitado es el primer punto de retorno) es el de una Pila perfecta (LIFO).

### El Reto
Implementa el método `retrocederASuperficie()`. Este debe extraer (con `pop`) y mostrar el nombre de cada estación a medida que se desapila. **Importante:** Si en alguna estación el `nivelOxigeno` es inferior al 18%, el sistema debe imprimir una alerta de "Uso de Tanque de Emergencia Requerido" al pasar por ese punto.

## Salida Esperada
El programa debe tener un menú interactivo que permita:
1. Ver ruta actual (estaciones dejadas en el camino).
2. Avanzar y dejar una nueva estación (Push).
3. Retroceder a la superficie (Pop de toda la pila con alertas).
4. Salir.

## Tips para el Desarrollo:
1. **Recorrido Destructivo:** En este caso, el recorrido destruye la pila (desapila los nodos permanentemente) ya que los rescatistas están recogiendo las estaciones o pasando por ellas para nunca volver a ese nivel de profundidad. Usa un bucle `while (!estaVacia())` que haga un `pop()` en cada paso.
2. **Alertas en el Retorno:** Antes de imprimir el paso, verifica el atributo `nivelOxigeno` del nodo desapilado para saber si debes imprimir la alerta de emergencia.

## Clases a Implementar
1. **Estacion.java** - Nodo
2. **PilaEstaciones.java** - Pila (Stack)
3. **App.java** - Aplicación para correr el menú
