# Control de Inventario (Almacén de Repuestos)

## Descripción del Problema

Un taller mecánico almacena los repuestos de su inventario en un BST organizado por código de referencia (un número entero único). Cuando un repuesto se agota, su nodo queda como **hoja** (no tiene hijos) porque no ha sido reemplazado por variantes. El administrador quiere saber cuántos repuestos son "únicos" (sin variantes relacionadas) y cuál es el recorrido completo del inventario en **PreOrden** para realizar una copia de seguridad del árbol.

## Requisitos

### La Clase Repuesto (Nodo)
Debe contener los siguientes atributos:
- `codigoRef` (int, clave del BST)
- `descripcion` (String)
- `marca` (String)
- `stock` (int)
- `izq` y `der` (Referencias a los subárboles)

### La Clase ArbolAlmacen (Estructura)
Debe gestionar un Árbol Binario de Búsqueda mediante la raíz, asegurando que los códigos menores vayan a la izquierda y los mayores a la derecha.

### El Problema
El administrador necesita dos reportes: el primero lista todos los repuestos en **PreOrden** (para poder reconstruir el árbol en otro sistema con el mismo orden de inserción), y el segundo informa cuántos repuestos son hojas del árbol (sin variantes relacionadas).

### El Reto
Implementa `backupPreOrden()` que imprima todos los repuestos en recorrido **PreOrden** con el formato `[codigoRef] descripcion - marca (stock uds)`. Implementa también `reporteRepuestosUnicos()` que use `contarHojas()` e imprima un mensaje indicando cuántos repuestos no tienen variantes relacionadas en el catálogo.

## Salida Esperada
El programa debe permitir:
1. Ver todos los repuestos en orden normal (InOrden).
2. Insertar un nuevo repuesto en el inventario.
3. Generar Backup (PreOrden).
4. Reportar Repuestos Únicos (Contar Hojas).
5. Salir.

## Tips para el Desarrollo:
1. **PreOrden para Backup:** El recorrido PreOrden (Raíz, Izquierda, Derecha) es el único que, al reinsertar los nodos en un árbol nuevo en ese mismo orden, genera exactamente la misma estructura que el árbol original.
2. **Nodos Hoja:** Recuerda que un nodo hoja es aquel cuyos punteros `izq` y `der` son ambos `null`.

## Clases a Implementar
1. **Repuesto.java** - Nodo del Árbol BST.
2. **ArbolAlmacen.java** - Estructura del Árbol Binario de Búsqueda.
3. **App.java** - Clase principal con menú interactivo.
