# Peaje Inteligente (Control de Tráfico)

## Descripción del Problema

En una autopista de peaje, los vehículos ingresan a un carril y avanzan en fila hasta la cabina de cobro. El sistema registra automáticamente cada vehículo al entrar al carril. El cajero cobra en el orden estricto de llegada.

## Requisitos

### La Clase Vehiculo (Nodo)
Debe contener los siguientes atributos:
- `placa` (String)
- `tipoVehiculo` (String)
- `tarifa` (double)
- `esExento` (boolean)
- `siguiente` (Referencia al mismo tipo de nodo)

### La Clase ColaPeaje (Cola)
Debe gestionar una cola de vehículos mediante punteros (referencias), asegurando que la inserción ocurra por la **entrada** y la extracción por la **salida**.

### El Problema
Al cerrar el turno, el sistema debe calcular el total recaudado, ignorando los vehículos exentos de pago.

### El Reto
Implementa un método `cerrarTurno()` que extraiga (`dequeue`) todos los vehículos de la cola, acumule la tarifa solo de los que tengan `esExento = false` e imprima el total recaudado al finalizar.

## Salida Esperada
El programa debe permitir:
1. Ver fila de vehículos en el peaje.
2. Registrar nuevo vehículo (Enqueue).
3. Cobrar a siguiente vehículo (Dequeue).
4. Cerrar turno (Extraer todos, acumular tarifas no exentas e imprimir total).
5. Salir.

## Tips para el Desarrollo:
1. **Dos punteros:** Recuerda que una cola mantiene siempre dos referencias: `entrada` (para agregar) y `salida` (para retirar). Perder alguna de estas referencias destruye la estructura.
2. **Cola vacía:** Siempre verifica `isEmpty()` antes de hacer `dequeue()` o `peek()` para evitar un `NullPointerException`.
3. **Destruir la cola:** El reto de este ejercicio implica vaciar la cola mientras se procesan las tarifas.

## Clases a Implementar
1. **Vehiculo.java** - Nodo de la Cola.
2. **ColaPeaje.java** - Estructura de la Cola (FIFO).
3. **App.java** - Clase principal con menú interactivo.
