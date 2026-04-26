# El Tren de Carga (Logística Ferroviaria)

## Descripción del Problema

Diseña un sistema para gestionar los vagones de un tren de carga internacional.

## Requisitos

### La Clase Vagon (Nodo)
Debe contener los siguientes atributos:
- `contenido` (String)
- `pesoToneladas` (double)
- `origen` (String)
- `destino` (String)

### La Clase Tren (Lista Enlazada)
Debe gestionar una lista enlazada de vagones con los siguientes métodos:
- `engancharVagon()` - Agrega un vagón al final del tren
- `calcularPesoTotal()` - Calcula el peso total de toda la carga

### El Problema
El tren sale de una estación y se le van enganchando vagones al final. Los datos pueden ser ingresados por el usuario interactivamente.

### El Reto
Implementa un método que recorra el tren y calcule el **peso total** de toda la carga transportada, mostrando los resultados en una tabla formateada con todos los datos del tren.

## Salida Esperada
El programa debe mostrar una tabla con:
- Contenido de cada vagón
- Peso en toneladas
- Puerto de origen
- Destino
- **Peso total del tren** al final

## Clases a Implementar
1. **Vagon.java** - Clase que representa un vagón del tren
2. **Tren.java** - Clase que gestiona la lista enlazada de vagones
3. **App.java** - Clase principal con el método main() para la interfaz de usuario
