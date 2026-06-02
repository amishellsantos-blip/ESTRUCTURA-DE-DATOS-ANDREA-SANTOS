# Estación Meteorológica (Registro de Temperaturas)

## Descripción del Problema

Una red de sensores ambientales distribuidos en la cordillera registra la temperatura máxima diaria de cada estación. Los datos se almacenan en un BST usando la temperatura como clave de ordenamiento, lo que permite consultarlos en orden cronológico de menor a mayor y detectar anomalías rápidamente.

## Requisitos

### La Clase Registro (Nodo)
Debe contener los siguientes atributos:
- `temperatura` (double, clave del BST)
- `fecha` (String)
- `estacion` (String)
- `humedad` (double)
- `izq` y `der` (Referencias a los subárboles)

### La Clase ArbolRegistros (Estructura)
Debe gestionar un Árbol Binario de Búsqueda mediante la raíz, asegurando que los valores menores vayan a la izquierda y los mayores a la derecha.

### El Problema
El climatólogo necesita identificar cuántos registros del árbol superan un umbral crítico de temperatura (por ejemplo, más de 35 °C) para emitir alertas de calor extremo.

### El Reto
Implementa el método `contarSobre(double umbral)` que recorra el árbol y retorne la cantidad de nodos cuya `temperatura` sea **estrictamente mayor** que el umbral recibido, sin modificar la estructura. Aprovecha la propiedad del BST para evitar recorrer subárboles innecesarios: si el nodo actual es ≤ umbral, los menores también lo serán.

## Salida Esperada
El programa debe permitir:
1. Ver todos los registros ordenados por temperatura (InOrden).
2. Insertar un nuevo registro meteorológico en el BST.
3. Contar registros que superen un umbral de temperatura.
4. Salir.

## Tips para el Desarrollo:
1. **Recursión con caso base:** Todos los métodos del BST dependen de manejar correctamente el caso `nodo == null`. Sin ese control, obtendrás un `NullPointerException` al llegar a las hojas.
2. **Poda del árbol:** Para métodos como `contarSobre(umbral)`, aprovecha la propiedad de orden del BST para no recorrer subárboles que nunca contendrán la respuesta. Esto mejora el rendimiento.
3. **InOrden = ordenado:** Recuerda que el recorrido **InOrden** en un BST siempre produce los nodos en orden ascendente según la clave. Úsalo siempre que necesites listar datos ordenados.

## Clases a Implementar
1. **Registro.java** - Nodo del Árbol BST.
2. **ArbolRegistros.java** - Estructura del Árbol Binario de Búsqueda.
3. **App.java** - Clase principal con menú interactivo.
