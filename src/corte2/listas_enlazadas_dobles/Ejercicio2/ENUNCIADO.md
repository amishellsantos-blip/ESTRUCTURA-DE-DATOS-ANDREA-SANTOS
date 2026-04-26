# Carrusel de Imágenes (Galería Interactiva)

## Descripción del Problema

Simula el comportamiento de una galería de fotos en una aplicación móvil utilizando una lista doblemente enlazada. Esto permite al usuario deslizar hacia adelante y hacia atrás entre sus imágenes de forma fluida.

## Requisitos

### La Clase Fotografia (Nodo Doble)
Debe contener los siguientes atributos:
- `nombreArchivo` (String)
- `tamanoMB` (double)
- `resolucion` (String)
- `siguiente` y `anterior` (Referencias al mismo tipo de nodo)

### La Clase Galeria (Lista Doblemente Enlazada)
Debe gestionar una lista doble de fotos con los siguientes métodos:
- `agregarFoto()` - Agrega una fotografía al final de la galería.
- `avanzar()` - Muestra la siguiente foto en la lista.
- `retroceder()` - Regresa a la foto anterior.
- `reproducirGaleria()` - Realiza un recorrido automático de ida (inicio a fin) y vuelta (fin a inicio).

### El Problema
El usuario puede avanzar a la "Siguiente Foto" o retroceder a la "Foto Anterior". El sistema debe ser lineal, es decir, si se llega al final no se puede avanzar más, y lo mismo ocurre al llegar al principio.

### El Reto
Implementar el método `reproducirGaleria()` que demuestre la capacidad de la lista doble para ser recorrida en ambos sentidos sin perder el puntero de los nodos.

## Salida Esperada
El programa debe permitir:
1. Cargar múltiples fotos con sus metadatos (nombre, peso, resolución).
2. Navegar entre fotos viendo los detalles de la foto actual.
3. Ejecutar una "reproducción" que liste todas las fotos en ambos sentidos.

## Clases a Implementar
1. **Fotografia.java** - Nodo doble
2. **Galeria.java** - Lista doblemente enlazada
3. **App.java** - Clase principal con menú interactivo
