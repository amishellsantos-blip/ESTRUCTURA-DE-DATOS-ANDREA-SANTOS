# Catálogo Digital (Biblioteca Universitaria)

## Descripción del Problema

La biblioteca de la universidad organiza su colección de libros en un BST usando el ISBN como clave única. Cada vez que ingresa un libro nuevo, se inserta automáticamente en el árbol. El sistema debe poder confirmar si un ISBN ya existe antes de registrar un nuevo ejemplar y listar toda la colección ordenada por ISBN.

## Requisitos

### La Clase Libro (Nodo)
Debe contener los siguientes atributos:
- `isbn` (long, clave del BST)
- `titulo` (String)
- `autor` (String)
- `anioPublicacion` (int)
- `izq` y `der` (Referencias a los subárboles)

### La Clase ArbolCatalogo (Estructura)
Debe gestionar un Árbol Binario de Búsqueda mediante la raíz, asegurando que los libros con menor ISBN vayan a la izquierda y aquellos con mayor ISBN a la derecha.

### El Problema
Al final del semestre, el bibliotecario necesita imprimir el inventario completo ordenado de menor a mayor por ISBN para enviarlo a la sede central. También debe verificar si un ISBN específico ya existe en el catálogo antes de registrar una donación.

### El Reto
Implementa el método `imprimirCatalogo()` usando el recorrido **InOrden** para listar todos los libros en orden ascendente de ISBN (imprime `isbn - titulo - autor`). Además, implementa `existeISBN(long isbn)` que retorne `true` si el libro ya está registrado y `false` en caso contrario.

## Salida Esperada
El programa debe permitir:
1. Ver el catálogo completo de libros ordenado por ISBN (InOrden).
2. Insertar un nuevo libro en el árbol.
3. Verificar si un ISBN existe en el sistema.
4. Salir.

## Tips para el Desarrollo:
1. **Recursión con caso base:** Todos los métodos del BST dependen de manejar correctamente el caso `nodo == null`. Sin ese control, obtendrás un `NullPointerException`.
2. **Búsqueda Eficiente:** El método `existeISBN` debe aprovechar las reglas del BST. Si el ISBN que buscas es menor, vete a la izquierda; si es mayor, a la derecha. Así evitas buscar en todo el árbol y reduces la búsqueda de O(n) a O(log n).

## Clases a Implementar
1. **Libro.java** - Nodo del Árbol BST.
2. **ArbolCatalogo.java** - Estructura del Árbol Binario de Búsqueda.
3. **App.java** - Clase principal con menú interactivo.
