# Urgencias Hospitalarias (Triaje)

## Descripción del Problema

En la sala de urgencias de un hospital, los pacientes que llegan son registrados y colocados en una fila de atención. Dado el volumen de pacientes, el médico de guardia atiende en estricto orden de llegada. Al momento de llamar a un paciente, el sistema debe mostrar su información completa.

## Requisitos

### La Clase Paciente (Nodo)
Debe contener los siguientes atributos:
- `cedula` (String)
- `nombreCompleto` (String)
- `edad` (int)
- `sintomaPrincipal` (String)
- `siguiente` (Referencia al mismo tipo de nodo)

### La Clase ColaPacientes (Cola)
Debe gestionar una cola de pacientes mediante punteros (referencias), asegurando que la inserción ocurra por la **entrada** y la extracción por la **salida**.

### El Problema
Al finalizar el turno, el hospital necesita un reporte del total de pacientes atendidos y la lista completa en orden de atención.

### El Reto
Implementa un método `atenderTodos()` que extraiga (`dequeue`) a cada paciente uno a uno, imprima su información al momento de ser atendido e imprima al final el total de pacientes procesados.

## Salida Esperada
El programa debe permitir:
1. Ver fila de espera.
2. Registrar nuevo paciente (Enqueue).
3. Atender (retirar) al siguiente paciente (Dequeue).
4. Finalizar turno (Atender a todos los restantes e imprimir reporte).
5. Salir.

## Tips para el Desarrollo:
1. **Dos punteros:** Recuerda que una cola mantiene siempre dos referencias: `entrada` (para agregar) y `salida` (para retirar). Perder alguna de estas referencias destruye la estructura.
2. **Cola vacía:** Siempre verifica `isEmpty()` antes de hacer `dequeue()` o `peek()` para evitar un `NullPointerException`.
3. **Destruir la cola:** El reto de este ejercicio implica vaciar la cola mientras se va atendiendo a cada nodo.

## Clases a Implementar
1. **Paciente.java** - Nodo de la Cola.
2. **ColaPacientes.java** - Estructura de la Cola (FIFO).
3. **App.java** - Clase principal con menú interactivo.
