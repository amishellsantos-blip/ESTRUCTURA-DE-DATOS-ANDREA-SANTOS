# Navegación de Pestañas de Navegador

## Descripción del Problema

Simula el comportamiento de un navegador web donde puedes moverte entre pestañas abiertas. Utiliza una lista doblemente enlazada para permitir una navegación eficiente y la reconexión de pestañas cuando una de ellas se cierra.

## Requisitos

### La Clase Pestana (Nodo Doble)
Debe contener los siguientes atributos:
- `tituloPagina` (String)
- `url` (String)
- `horaApertura` (String)
- `siguiente` y `anterior` (Referencias al mismo tipo de nodo)

### La Clase Navegador (Lista Doblemente Enlazada)
Debe gestionar una lista doble de pestañas con los siguientes métodos:
- `abrirPestana()` - Agrega una pestaña al final de la lista.
- `cerrarPestanaActual(String url)` - Busca una pestaña por su URL, la elimina y reconecta los nodos adyacentes.
- `mostrarPestanas()` - Imprime todas las pestañas abiertas en formato de tabla.

### El Problema
Las pestañas se abren una tras otra. Si el usuario decide cerrar una pestaña específica, el sistema debe ser capaz de "coser" la lista nuevamente, uniendo la pestaña anterior con la siguiente para no perder la estructura.

### El Reto
Implementar el método `cerrarPestanaActual(String url)` manejando cuidadosamente todos los casos posibles:
1. Eliminar la única pestaña existente.
2. Eliminar la primera pestaña (Cabeza).
3. Eliminar la última pestaña (Cola).
4. Eliminar una pestaña intermedia.

## Salida Esperada
El programa debe permitir:
1. Abrir múltiples pestañas con sus metadatos (Título, URL, Hora).
2. Cerrar pestañas específicas y verificar que la navegación sigue funcionando.
3. Mostrar la lista actualizada de pestañas abiertas.

## Clases a Implementar
1. **Pestana.java** - Nodo doble
2. **Navegador.java** - Lista doblemente enlazada
3. **App.java** - Clase principal con menú interactivo
