# Impresora Compartida (Red de Oficina)

## Descripción del Problema

En una oficina de arquitectura, varias computadoras comparten una única impresora de gran formato. Cada vez que alguien envía un documento, este se agrega al final de la cola de impresión. La impresora procesa los trabajos en el orden exacto en que fueron recibidos.

## Requisitos

### La Clase Documento (Nodo)
Debe contener los siguientes atributos:
- `nombreArchivo` (String)
- `usuario` (String)
- `numeroPaginas` (int)
- `esColor` (boolean)
- `siguiente` (Referencia al mismo tipo de nodo)

### La Clase ColaImpresion (Cola)
Debe gestionar una cola de impresión mediante punteros (referencias), asegurando que la inserción ocurra por la **entrada** y la extracción por la **salida**.

### El Problema
Antes de imprimir, el jefe de oficina quiere saber cuántas páginas en total tiene la cola de impresión pendiente.

### El Reto
Implementa un método `calcularPaginasTotales()` que recorra la cola y retorne la suma de `numeroPaginas` de todos los documentos en espera, sin alterar la cola.

## Salida Esperada
El programa debe permitir:
1. Ver documentos en la cola de impresión.
2. Enviar nuevo documento a imprimir (Enqueue).
3. Imprimir el siguiente documento (Dequeue).
4. Calcular total de páginas pendientes.
5. Salir.

## Tips para el Desarrollo:
1. **Dos punteros:** Recuerda que una cola mantiene siempre dos referencias: `entrada` (para agregar) y `salida` (para retirar). Perder alguna de estas referencias destruye la estructura.
2. **Recorrido sin destruir:** Para consultar la cola sin vaciarla, usa una **referencia auxiliar** que empiece en `salida` y avance nodo a nodo hasta llegar a `null`. Nunca muevas los punteros reales `entrada` o `salida` durante un recorrido.
3. **Cola vacía:** Siempre verifica `isEmpty()` antes de hacer `dequeue()` o `peek()` para evitar un `NullPointerException`.

## Clases a Implementar
1. **Documento.java** - Nodo de la Cola.
2. **ColaImpresion.java** - Estructura de la Cola (FIFO).
3. **App.java** - Clase principal con menú interactivo.
