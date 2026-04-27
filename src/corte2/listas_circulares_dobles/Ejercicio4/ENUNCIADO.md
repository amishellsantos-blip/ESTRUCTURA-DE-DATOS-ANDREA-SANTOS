# Galería de Fotos (Álbum Digital)

## Descripción del Problema

Simula el comportamiento de una aplicación de galería de fotos en un dispositivo móvil. El usuario puede desplazarse entre sus imágenes de forma infinita en ambos sentidos, marcar sus favoritas y gestionar su biblioteca eliminando contenido no deseado.

## Requisitos

### La Clase Foto (Nodo Doble Circular)
Debe contener los siguientes atributos:
- `titulo` (String)
- `fecha` (String)
- `esFavorita` (boolean)
- `siguiente` y `anterior` (Referencias al mismo tipo de nodo)

### La Clase GaleriaFotos (Lista Circular Doble)
Debe gestionar el álbum con los siguientes métodos:
- `agregarFoto()` - Agrega una imagen al final de la galería.
- `siguiente()` - Muestra la siguiente foto en el ciclo.
- `anterior()` - Muestra la foto anterior en el ciclo.
- `toggleFavorita()` - Alterna el estado de favorita de la foto que se está viendo.
- `eliminarActual()` - Elimina la foto que está en pantalla.

### El Problema
La navegación es circular: al avanzar desde la última foto se vuelve a la primera y viceversa. Al eliminar una foto, la experiencia del usuario debe ser fluida, mostrando inmediatamente la siguiente foto disponible sin "agujeros" en la lista.

### El Reto
Implementar la eliminación en **O(1)** y el mantenimiento de la circularidad doble. Es fundamental mover el puntero `actual` a la siguiente foto **antes** de desconectar el nodo actual de la estructura para asegurar que el usuario nunca pierda su posición en la galería.

## Tips para el Desarrollo Aplicados:
1. **Eliminación sin Búsqueda:** Se desconecta el nodo usando sus referencias directas a `anterior` y `siguiente`.
2. **Invariantes del Álbum:** Se asegura que el ciclo se mantenga cerrado (`cola.siguiente == cabeza` y `cabeza.anterior == cola`).
3. **Control de Referencias:** Se limpia la memoria correctamente al eliminar la última foto disponible.

## Salida Esperada
El programa debe permitir:
1. Cargar una colección inicial de fotos.
2. Navegar en ambos sentidos viendo los metadatos de cada imagen.
3. Gestionar favoritos y depurar la galería eliminando fotos en tiempo real.

## Clases a Implementar
1. **Foto.java** - Nodo doble
2. **GaleriaFotos.java** - Lista circular doble
3. **App.java** - Clase principal con menú interactivo
