# Sistema de Nómina (Recursos Humanos)

## Descripción del Problema

Una empresa de logística administra a sus empleados en un BST organizado por número de cédula. El área de RRHH consulta frecuentemente el empleado con el **menor** y el **mayor** número de cédula para procesar los extremos de la nómina. También necesita conocer la **altura** del árbol para auditar si la estructura sigue siendo eficiente después de muchas incorporaciones.

## Requisitos

### La Clase Empleado (Nodo)
Debe contener los siguientes atributos:
- `cedula` (long, clave del BST)
- `nombreCompleto` (String)
- `cargo` (String)
- `salario` (double)
- `izq` y `der` (Referencias a los subárboles)

### La Clase ArbolNomina (Estructura)
Debe gestionar un Árbol Binario de Búsqueda mediante la raíz, asegurando que los empleados con cédula menor vayan a la izquierda y aquellos con cédula mayor a la derecha.

### El Problema
El sistema debe poder ubicar al empleado con la cédula más baja (el más antiguo en el registro) y al de cédula más alta (el más reciente), y también reportar la altura actual del árbol para verificar que las búsquedas siguen siendo eficientes.

### El Reto
Implementa `buscarMinimo()` y `buscarMaximo()`, que recorran el BST siguiendo siempre el subárbol izquierdo o derecho respectivamente hasta llegar a un nodo sin ese hijo e impriman los datos del empleado encontrado. Implementa también `reporteEficiencia()` que imprima la altura actual del árbol y el número total de hojas usando un método `contarHojas()`.

## Salida Esperada
El programa debe permitir:
1. Ver todos los empleados en orden ascendente (InOrden).
2. Insertar un nuevo empleado en la nómina.
3. Buscar el empleado con la cédula más baja (Mínimo).
4. Buscar el empleado con la cédula más alta (Máximo).
5. Generar reporte de eficiencia (Altura y cantidad de hojas).
6. Salir.

## Tips para el Desarrollo:
1. **Mínimo y máximo sin comparar:** En un BST, el nodo mínimo siempre es el que está más a la **izquierda** y el máximo el más a la **derecha**. No necesitas comparar valores, solo seguir los punteros hasta que `.izq` o `.der` sea `null`.
2. **Altura de un árbol:** La altura es 1 + el máximo entre la altura del subárbol izquierdo y la del subárbol derecho. Si un nodo es nulo, su altura es 0.
3. **Hojas:** Un nodo es hoja cuando `izq == null && der == null`.

## Clases a Implementar
1. **Empleado.java** - Nodo del Árbol BST.
2. **ArbolNomina.java** - Estructura del Árbol Binario de Búsqueda.
3. **App.java** - Clase principal con menú interactivo.
