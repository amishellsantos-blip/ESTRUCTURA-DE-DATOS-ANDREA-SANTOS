# Centro de Llamadas (Atención al Cliente)

## Descripción del Problema

Una empresa de telecomunicaciones recibe cientos de llamadas al día. Cuando todos los agentes están ocupados, las llamadas entrantes se ponen en espera formando una fila virtual. La primera llamada en esperar es la primera en ser atendida por el próximo agente disponible. Cada llamada se clasifica según su motivo: `"Facturación"`, `"Soporte Técnico"`, `"Cancelación"` o `"Información"`.

## Requisitos

### La Clase Llamada (Nodo)
Debe contener los siguientes atributos:
- `idLlamada` (String)
- `nombreCliente` (String)
- `motivoConsulta` (String)
- `duracionEstimadaMinutos` (int)
- `siguiente` (Referencia al mismo tipo de nodo)

### La Clase ColaLlamadas (Cola)
Debe gestionar una cola de llamadas mediante punteros (referencias), asegurando que la inserción ocurra por la **entrada** y la extracción por la **salida**.

### El Problema
El supervisor necesita saber cuántas llamadas en espera corresponden a un motivo específico, para decidir si activa agentes especializados.

### El Reto
Implementa un método `contarPorMotivo(String motivo)` que recorra la cola y devuelva la cantidad de llamadas cuyo `motivoConsulta` coincida con el parámetro recibido, sin modificar la cola.

## Salida Esperada
El programa debe permitir:
1. Ver estado de la cola (imprimir llamadas).
2. Registrar nueva llamada en espera (Enqueue).
3. Atender (retirar) la siguiente llamada (Dequeue).
4. Contar llamadas por motivo.
5. Salir.

## Tips para el Desarrollo:
1. **Dos punteros:** Recuerda que una cola mantiene siempre dos referencias: `entrada` (para agregar) y `salida` (para retirar). Perder alguna de estas referencias destruye la estructura.
2. **Recorrido sin destruir:** Para consultar la cola sin vaciarla, usa una **referencia auxiliar** que empiece en `salida` y avance nodo a nodo hasta llegar a `null`. Nunca muevas los punteros reales `entrada` o `salida` durante un recorrido.
3. **Cola vacía:** Siempre verifica `isEmpty()` antes de hacer `dequeue()` o `peek()` para evitar un `NullPointerException`.

## Clases a Implementar
1. **Llamada.java** - Nodo de la Cola.
2. **ColaLlamadas.java** - Estructura de la Cola (FIFO).
3. **App.java** - Clase principal con menú interactivo.
