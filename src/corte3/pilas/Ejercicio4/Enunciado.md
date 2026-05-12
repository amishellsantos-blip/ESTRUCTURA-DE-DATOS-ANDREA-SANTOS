# Farmacia Automatizada (Dispensador Tubo LIFO)

## Descripción del Problema

En una farmacia de alta tecnología, los medicamentos de alta rotación se almacenan en tubos dispensadores verticales. El personal introduce las cajas por la parte superior y las retira de la misma forma, cumpliendo el principio LIFO (el último lote en llegar es el primero en ser despachado).

## Requisitos

### La Clase Medicamento (Nodo)
Debe contener los siguientes atributos:
- `nombre` (String)
- `lote` (String)
- `diasParaVencer` (int)
- `siguiente` (Referencia al mismo tipo de nodo)

### La Clase TuboDispensador (Pila)
Debe gestionar una pila de medicamentos utilizando punteros (referencias) y garantizando que solo se interactúe con los elementos desde el tope.

### El Problema
Por norma de seguridad, no se puede despachar un medicamento si le quedan menos de 10 días para vencer.

### El Reto
Implementa un método `validarDespacho()` que revise el medicamento en el **tope**. Si está a punto de vencer (menos de 10 días), debe ser retirado automáticamente descartándolo (con un `pop()`) y el sistema debe revisar el siguiente. El proceso se repite hasta que el tope sea un medicamento seguro (10 o más días para vencer) o la pila quede vacía. Finalmente, si hay un medicamento seguro, se despacha.

## Salida Esperada
El programa debe tener un menú interactivo que permita:
1. Ver estado del tubo dispensador.
2. Ingresar un nuevo medicamento (Push).
3. Solicitar despacho seguro (Validar y Pop seguro).
4. Salir.

## Tips para el Desarrollo:
1. **Estado de la Pila:** Verifica constantemente con `estaVacia()` para evitar errores si el tubo se vacía descartando medicamentos vencidos.
2. **Uso de Peek:** Usa `peek()` para revisar los días para vencer del tope sin sacarlo de inmediato. Si es inseguro, usas `pop()` para descartarlo.
3. **Bucle de Validación:** Un bucle `while (!estaVacia() && peek().diasParaVencer < 10)` es ideal para limpiar el tope de elementos defectuosos antes de realizar el despacho final.

## Clases a Implementar
1. **Medicamento.java** - Nodo
2. **TuboDispensador.java** - Pila (Stack)
3. **App.java** - Aplicación para correr el menú
