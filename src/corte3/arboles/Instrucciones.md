# Ejercicios de Aplicación — Árboles Binarios de Búsqueda (BST)

> **Instrucciones:** Resuelve los siguientes problemas del mundo real utilizando un **Árbol Binario de Búsqueda (BST)**. Para cada ejercicio, debes definir una clase **Nodo** con sus atributos específicos y una clase **ArbolBST** que gestione la estructura con los métodos de inserción, búsqueda y recorrido vistos en clase. Recuerda que la regla del BST siempre debe respetarse: los valores **menores van a la izquierda** y los **mayores van a la derecha**.

---

### 1. Estación Meteorológica (Registro de Temperaturas)

Una red de sensores ambientales distribuidos en la cordillera registra la temperatura máxima diaria de cada estación. Los datos se almacenan en un BST usando la temperatura como clave de ordenamiento, lo que permite consultarlos en orden cronológico de menor a mayor y detectar anomalías rápidamente.

- **La Clase Registro (Nodo):** Debe contener `temperatura` (double, clave del BST), `fecha` (String), `estacion` (String) y `humedad` (double).
- **El Problema:** El climatólogo necesita identificar cuántos registros del árbol superan un umbral crítico de temperatura (por ejemplo, más de 35 °C) para emitir alertas de calor extremo.
- **Reto:** Implementa el método `contarSobre(double umbral)` que recorra el árbol y retorne la cantidad de nodos cuya `temperatura` sea **estrictamente mayor** que el umbral recibido, sin modificar la estructura. Aprovecha la propiedad del BST para evitar recorrer subárboles innecesarios: si el nodo actual es ≤ umbral, los menores también lo serán.

---

### 2. Catálogo Digital (Biblioteca Universitaria)

La biblioteca de la universidad organiza su colección de libros en un BST usando el ISBN como clave única. Cada vez que ingresa un libro nuevo, se inserta automáticamente en el árbol. El sistema debe poder confirmar si un ISBN ya existe antes de registrar un nuevo ejemplar y listar toda la colección ordenada por ISBN.

- **La Clase Libro (Nodo):** Debe contener `isbn` (long, clave del BST), `titulo` (String), `autor` (String) y `anioPublicacion` (int).
- **El Problema:** Al final del semestre, el bibliotecario necesita imprimir el inventario completo ordenado de menor a mayor por ISBN para enviarlo a la sede central. También debe verificar si un ISBN específico ya existe en el catálogo antes de registrar una donación.
- **Reto:** Implementa el método `imprimirCatalogo()` usando el recorrido **InOrden** para listar todos los libros en orden ascendente de ISBN (imprime `isbn - titulo - autor`). Además, implementa `existeISBN(long isbn)` que retorne `true` si el libro ya está registrado y `false` en caso contrario.

---

### 3. Sistema de Nómina (Recursos Humanos)

Una empresa de logística administra a sus empleados en un BST organizado por número de cédula. El área de RRHH consulta frecuentemente el empleado con el **menor** y el **mayor** número de cédula para procesar los extremos de la nómina. También necesita conocer la **altura** del árbol para auditar si la estructura sigue siendo eficiente después de muchas incorporaciones.

- **La Clase Empleado (Nodo):** Debe contener `cedula` (long, clave del BST), `nombreCompleto` (String), `cargo` (String) y `salario` (double).
- **El Problema:** El sistema debe poder ubicar al empleado con la cédula más baja (el más antiguo en el registro) y al de cédula más alta (el más reciente), y también reportar la altura actual del árbol para verificar que las búsquedas siguen siendo eficientes.
- **Reto:** Implementa `buscarMinimo()` y `buscarMaximo()`, que recorran el BST siguiendo siempre el subárbol izquierdo o derecho respectivamente hasta llegar a una hoja e impriman los datos del empleado encontrado. Implementa también `reporteEficiencia()` que imprima la altura actual del árbol y el número total de hojas (`contarHojas()`).

---

### 4. Torneo de Ajedrez (Sistema de Rankings ELO)

Una plataforma de ajedrez en línea gestiona el ranking ELO de sus jugadores en un BST. A medida que los jugadores completan partidas, su ELO se actualiza y se reinsertan en el árbol. El director del torneo necesita obtener la lista de jugadores que clasifican a la siguiente ronda, es decir, todos aquellos cuyo ELO se encuentre dentro de un rango específico.

- **La Clase Jugador (Nodo):** Debe contener `elo` (int, clave del BST), `nombreUsuario` (String), `pais` (String) y `partidasJugadas` (int).
- **El Problema:** Para la ronda de clasificación, el director fija un rango mínimo y máximo de ELO (por ejemplo, entre 1800 y 2200). Todos los jugadores en ese rango deben ser listados de menor a mayor ELO para armar los emparejamientos.
- **Reto:** Implementa el método `listarEnRango(int eloMin, int eloMax)` que recorra el árbol e imprima los datos de todos los jugadores cuyo `elo` esté dentro del rango `[eloMin, eloMax]` en orden ascendente. Usa la propiedad del BST para podar: si el nodo actual es menor que `eloMin`, solo explora el subárbol derecho; si es mayor que `eloMax`, solo explora el izquierdo.

---

### 5. Control de Inventario (Almacén de Repuestos)

Un taller mecánico almacena los repuestos de su inventario en un BST organizado por código de referencia (un número entero único). Cuando un repuesto se agota, su nodo queda como **hoja** (no tiene hijos) porque no ha sido reemplazado por variantes. El administrador quiere saber cuántos repuestos son "únicos" (sin variantes relacionadas) y cuál es el recorrido completo del inventario en **PreOrden** para realizar una copia de seguridad del árbol.

- **La Clase Repuesto (Nodo):** Debe contener `codigoRef` (int, clave del BST), `descripcion` (String), `marca` (String) y `stock` (int).
- **El Problema:** El administrador necesita dos reportes: el primero lista todos los repuestos en **PreOrden** (para poder reconstruir el árbol en otro sistema con el mismo orden de inserción), y el segundo informa cuántos repuestos son hojas del árbol (sin variantes relacionadas).
- **Reto:** Implementa `backupPreOrden()` que imprima todos los repuestos en recorrido **PreOrden** con el formato `[codigoRef] descripcion - marca (stock uds)`. Implementa también `reporteRepuestosUnicos()` que use `contarHojas()` e imprima un mensaje indicando cuántos repuestos no tienen variantes relacionadas en el catálogo.

---

## Tips para el Desarrollo:

1. **Recursión con caso base:** Todos los métodos del BST dependen de manejar correctamente el caso `nodo == null`. Sin ese control, obtendrás un `NullPointerException` al llegar a las hojas.
2. **Poda del árbol:** Para métodos como `contarSobre(umbral)` o `listarEnRango(min, max)`, aprovecha la propiedad de orden del BST para no recorrer subárboles que nunca contendrán la respuesta. Esto mejora el rendimiento de O(n) a O(log n + k), donde k es el número de resultados.
3. **Mínimo y máximo sin comparar:** En un BST, el nodo mínimo siempre es el que está más a la **izquierda** y el máximo el más a la **derecha**. No necesitas comparar valores, solo seguir los punteros.
4. **InOrden = ordenado:** Recuerda que el recorrido **InOrden** en un BST siempre produce los nodos en orden ascendente según la clave. Úsalo siempre que necesites listar datos ordenados.
5. **Visualización sugerida:** Al imprimir el árbol, usa el siguiente formato de recorrido para que quede claro el orden:
   `InOrden → [2] → [4] → [6] → [8] → [10] → [12] → [14]`