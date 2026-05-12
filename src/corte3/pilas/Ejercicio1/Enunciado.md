# Puerto Marítimo (Gestión de Contenedores)

## Descripción del Problema

En un puerto de carga, los contenedores se apilan en columnas verticales dentro de los barcos o en el muelle. Debido al espacio restringido, solo se puede acceder al contenedor que está en la cima.

## Requisitos

### La Clase Contenedor (Nodo)
Debe contener los siguientes atributos:
- `idCodigo` (String)
- `empresa` (String)
- `peso` (double)
- `tipoCarga` (String)
- `siguiente` (Referencia al mismo tipo de nodo)

### La Clase PilaContenedores (Pila)
Debe gestionar una pila de contenedores mediante punteros, operando solo a través del **tope**.

### El Problema
El supervisor necesita un reporte rápido de cuánta carga hay de una empresa en particular sin retirar los contenedores.

### El Reto
Implementa un método `contarPorEmpresa(String nombreEmpresa)` que recorra la pila y devuelva la cantidad total de contenedores que pertenecen a esa empresa.

## Salida Esperada
El programa debe permitir:
1. Ver contenedores en el muelle (visualizando el tope).
2. Registrar nuevo contenedor (Push).
3. Retirar contenedor del tope (Pop).
4. Contar contenedores por empresa.
5. Salir.

## Tips para el Desarrollo:

1. **Uso de Auxiliares:** En Pilas, para buscar o recorrer sin perder los datos, es muy común usar una **segunda Pila temporal**. Sin embargo, dependiendo de tu implementación manual, también puedes recorrer los nodos.
2. **Encapsulamiento:** Recuerda que en una Pila **no existe el método get(index)**. Solo puedes ver lo que retorna `peek()` o lo que sale con `pop()`.
3. **Estado de la Pila:** Siempre verifica `isEmpty()` antes de realizar un `pop()` o `peek()` para evitar errores de ejecución (NullPointerException).
4. **Visualización Sugerida:** Al imprimir la pila, usa una flecha que indique claramente dónde está el tope:
   `TOPE -> [Caja A] -> [Caja B] -> [Caja C] -> BASE`

## Clases a Implementar
1. **Contenedor.java** - Nodo de la Pila.
2. **PilaContenedores.java** - Estructura de la Pila (LIFO).
3. **App.java** - Clase principal con menú interactivo.
