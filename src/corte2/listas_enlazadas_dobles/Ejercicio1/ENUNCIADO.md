# Sistema de Control de Versiones (Undo/Redo)

## Descripción del Problema

Diseña un editor de texto muy simple que guarde el historial de cambios utilizando una lista doblemente enlazada. Esto permite al usuario moverse libremente entre los estados anteriores y futuros de su documento.

## Requisitos

### La Clase Cambio (Nodo Doble)
Debe contener los siguientes atributos:
- `texto` (String)
- `tipoOperacion` (String - ej: "Escribir", "Borrar")
- `siguiente` y `anterior` (Referencias al mismo tipo de nodo)

### La Clase Historial (Lista Doblemente Enlazada)
Debe gestionar una lista doble de cambios con los siguientes métodos:
- `agregarCambio()` - Agrega un cambio al final del historial.
- `deshacer()` - Retrocede el puntero al cambio anterior.
- `rehacer()` - Avanza el puntero al siguiente cambio disponible.
- `mostrarHistorial()` - Imprime todo el historial marcando cuál es el estado actual.

### El Problema
Cada vez que el usuario realiza una acción, esta se guarda al final. Si el usuario decide deshacer una acción, el sistema debe ser capaz de regresar al estado anterior sin perder la posibilidad de volver al estado futuro (rehacer).

### El Reto
Implementar los métodos `deshacer()` y `rehacer()` que muevan un puntero `actual` a través de la lista doble, asegurándose de manejar los límites (inicio y fin de la lista).

## Salida Esperada
El programa debe permitir:
1. Registrar cambios con su texto y tipo.
2. Navegar hacia atrás (Undo) y hacia adelante (Redo) en el tiempo.
3. Visualizar el historial completo con una marca en el punto actual del historial.

## Clases a Implementar
1. **Cambio.java** - Nodo doble
2. **Historial.java** - Lista doblemente enlazada
3. **App.java** - Clase principal con menú interactivo
