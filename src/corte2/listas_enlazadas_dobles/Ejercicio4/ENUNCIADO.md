# Turnos de Consultorio Médico (Prioridad de Emergencia)

## Descripción del Problema

Gestiona una fila de pacientes en un consultorio médico utilizando una lista doblemente enlazada. El sistema permite manejar casos normales y prioridades de emergencia, además de facilitar búsquedas rápidas desde ambos extremos de la lista.

## Requisitos

### La Clase Paciente (Nodo Doble)
Debe contener los siguientes atributos:
- `nombre` (String)
- `edad` (int)
- `nivelUrgencia` (int del 1 al 5)
- `siguiente` y `anterior` (Referencias al mismo tipo de nodo)

### La Clase Consultorio (Lista Doblemente Enlazada)
Debe gestionar una lista doble de pacientes con los siguientes métodos:
- `agregarPaciente()` - Los pacientes se agregan al final normalmente. Pero si el `nivelUrgencia == 5`, el paciente debe ser insertado justo después de la Cabeza (el primer paciente de la fila).
- `buscarMayorEdadDesdeAtras()` - Recorre la lista desde la **Cola** hacia la **Cabeza** para encontrar y mostrar los datos del paciente más anciano.
- `mostrarTurnos()` - Imprime la lista completa de pacientes en espera.

### El Problema
En un consultorio real, las emergencias rompen el orden de llegada. La lista doble permite reinsertar elementos cerca del inicio y realizar recorridos desde atrás (hacia el pasado) de manera eficiente.

### El Reto
Implementar un método que demuestre el uso del puntero `anterior` recorriendo la lista desde el final hacia el principio para encontrar un valor máximo (edad).

## Salida Esperada
El programa debe permitir:
1. Registrar pacientes con sus datos básicos y nivel de prioridad.
2. Observar cómo los pacientes de prioridad 5 "saltan" posiciones en la fila.
3. Encontrar al paciente de mayor edad iniciando la búsqueda desde el final de la fila.

## Clases a Implementar
1. **Paciente.java** - Nodo doble
2. **Consultorio.java** - Lista doblemente enlazada
3. **App.java** - Clase principal con menú interactivo
