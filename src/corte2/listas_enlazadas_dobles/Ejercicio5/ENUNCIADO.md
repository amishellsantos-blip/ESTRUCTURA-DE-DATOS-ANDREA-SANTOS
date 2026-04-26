# Reproductor de Música Premium

## Descripción del Problema

Mejora el sistema de gestión de música utilizando una lista doblemente enlazada. A diferencia de una lista simple, una lista doble permite que el reproductor se mueva hacia adelante y hacia atrás de manera eficiente, brindando una experiencia de usuario mucho más fluida (como en Spotify o Apple Music).

## Requisitos

### La Clase Cancion (Nodo Doble)
Debe contener los siguientes atributos:
- `titulo` (String)
- `artista` (String)
- `duracionSegundos` (int)
- `siguiente` y `anterior` (Referencias al mismo tipo de nodo)

### La Clase ReproductorPremium (Lista Doblemente Enlazada)
Debe gestionar una lista doble de canciones con los siguientes métodos:
- `agregarCancion()` - Agrega una canción al final de la lista.
- `saltarAdelante()` - Avanza el puntero a la siguiente canción.
- `saltarAtras()` - Retrocede el puntero a la canción anterior.
- `mostrarEstadoActual()` - Muestra los detalles de la canción que se está reproduciendo en ese momento.

### El Problema
En una lista simple, para ir a la "Canción Anterior" tendrías que recorrer toda la lista desde la cabeza hasta encontrar el nodo previo. La lista doble soluciona esto usando el puntero `anterior`, permitiendo saltos instantáneos en ambas direcciones.

### El Reto
Implementar el método `saltarAtras()` asegurándose de que, si el usuario intenta retroceder desde la primera canción de la lista, el sistema muestre un mensaje de error claro indicando que no hay pista anterior.

## Salida Esperada
El programa debe permitir:
1. Crear una lista de reproducción personalizada.
2. Navegar entre canciones (Siguiente/Anterior).
3. Ver el estado de reproducción actual y la lista completa con el indicador de posición.

## Clases a Implementar
1. **Cancion.java** - Nodo doble
2. **ReproductorPremium.java** - Lista doblemente enlazada
3. **App.java** - Clase principal con menú interactivo
