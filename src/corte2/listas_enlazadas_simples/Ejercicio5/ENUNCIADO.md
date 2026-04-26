# Spotify Lite (Lista de Reproducción)

## Descripción del Problema

Crea un reproductor de música simplificado que gestione una lista de canciones. El sistema permite al usuario decidir si quiere que una canción se reproduzca justo después de la actual o si prefiere mandarla al final de la cola.

## Requisitos

### La Clase Cancion (Nodo)
Debe contener los siguientes atributos:
- `titulo` (String)
- `artista` (String)
- `duracionSegundos` (int)
- `genero` (String)

### La Clase Reproductor (Lista Enlazada)
Debe gestionar una lista enlazada de canciones con los siguientes métodos:
- `agregarSiguiente()` - Inserta una canción después de la primera posición (reproducir a continuación)
- `agregarAlFinal()` - Agrega una canción al final de la cola de reproducción
- `mostrarLista()` - Imprime la lista completa, incluyendo la suma total del tiempo de reproducción

### El Problema
El usuario necesita flexibilidad al armar su lista. A veces quiere escuchar algo "ahora mismo" (segunda posición) y otras veces solo quiere ir armando una cola larga (final de la lista).

### El Reto
Implementar un método que recorra todas las canciones, sume su duración en segundos y transforme ese resultado a un formato legible de minutos y segundos (`MM:SS`).

## Salida Esperada
El programa debe permitir:
1. Agregar canciones en diferentes posiciones de la lista.
2. Mostrar una tabla formateada con los detalles de cada pista.
3. Mostrar el **tiempo total de duración** de la lista completa en formato de tiempo real.

## Clases a Implementar
1. **Cancion.java** - Clase que representa una canción (Nodo)
2. **Reproductor.java** - Clase que gestiona la lista enlazada (Lista)
3. **App.java** - Clase principal con menú interactivo
