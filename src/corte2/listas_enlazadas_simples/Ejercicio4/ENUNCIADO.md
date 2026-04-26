# Monitoreo Industrial (Sensores en Tiempo Real)

## Descripción del Problema

Una planta química registra lecturas de sus tanques cada hora en una lista enlazada para auditoría. El sistema debe permitir al supervisor ver siempre la información más reciente de primero.

## Requisitos

### La Clase Lectura (Nodo)
Debe contener los siguientes atributos:
- `idSensor` (int)
- `temperatura` (double)
- `presion` (double)
- `hora` (String)

### La Clase Monitoreo (Lista Enlazada)
Debe gestionar una lista enlazada de lecturas con los siguientes métodos:
- `agregarLectura()` - Agrega una lectura al inicio de la lista (LIFO)
- `obtenerTemperaturaAlta()` - Busca y muestra los detalles de la lectura con la temperatura más alta
- `mostrarHistorial()` - Imprime todas las lecturas registradas en formato de tabla

### El Problema
Las lecturas se van agregando al inicio de la lista para que la más reciente sea siempre la primera que vea el supervisor al consultar el historial.

### El Reto
Implementar un método que recorra todo el historial de lecturas y determine cuál fue la temperatura máxima alcanzada, mostrando todos los datos asociados a ese sensor (ID, Presión, Hora).

## Salida Esperada
El programa debe permitir:
1. Ingresar múltiples lecturas con validación de datos numéricos.
2. Identificar instantáneamente el pico máximo de temperatura en el historial.
3. Mostrar el historial completo organizado desde lo más nuevo a lo más antiguo.

## Clases a Implementar
1. **Lectura.java** - Clase que representa una lectura (Nodo)
2. **Monitoreo.java** - Clase que gestiona la lista enlazada (Lista)
3. **App.java** - Clase principal con menú interactivo
