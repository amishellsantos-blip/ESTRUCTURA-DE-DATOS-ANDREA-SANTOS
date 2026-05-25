# Fábrica de Pedidos (E-commerce)

## Descripción del Problema

Una tienda en línea recibe pedidos de manera continua. Cada pedido ingresa a una cola central de procesamiento. El sistema de bodega toma los pedidos en orden de llegada para preparar el envío. Si un pedido ya fue cancelado por el cliente, debe ser descartado automáticamente al momento de ser procesado.

## Requisitos

### La Clase Pedido (Nodo)
Debe contener los siguientes atributos:
- `numeroPedido` (String)
- `cliente` (String)
- `totalPagar` (double)
- `cancelado` (boolean)
- `siguiente` (Referencia al mismo tipo de nodo)

### La Clase ColaPedidos (Cola)
Debe gestionar una cola de pedidos mediante punteros (referencias), asegurando que la inserción ocurra por la **entrada** y la extracción por la **salida**.

### El Problema
La bodega necesita procesar solo los pedidos vigentes. Los cancelados deben ser eliminados sin ser despachados, pero registrados en un conteo.

### El Reto
Implementa un método `procesarPedidos()` que recorra y vacíe la cola. Para cada pedido: si `cancelado = true`, lo descarta e incrementa un contador de cancelados; si `cancelado = false`, lo "despacha" imprimiendo sus datos. Al finalizar, muestra el total despachado y el total cancelado.

## Salida Esperada
El programa debe permitir:
1. Ver pedidos en espera.
2. Ingresar nuevo pedido (Enqueue).
3. Extraer el siguiente pedido manualmente (Dequeue).
4. Procesar toda la bodega (Reto).
5. Salir.

## Tips para el Desarrollo:
1. **Dos punteros:** Recuerda que una cola mantiene siempre dos referencias: `entrada` (para agregar) y `salida` (para retirar). Perder alguna de estas referencias destruye la estructura.
2. **Cola vacía:** Siempre verifica `isEmpty()` antes de hacer `dequeue()` o `peek()` para evitar un `NullPointerException`.
3. **Destruir la cola:** El reto de este ejercicio implica vaciar la cola mientras se van clasificando los pedidos en despachados o cancelados.

## Clases a Implementar
1. **Pedido.java** - Nodo de la Cola.
2. **ColaPedidos.java** - Estructura de la Cola (FIFO).
3. **App.java** - Clase principal con menú interactivo.
