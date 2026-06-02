# Torneo de Ajedrez (Sistema de Rankings ELO)

## Descripción del Problema

Una plataforma de ajedrez en línea gestiona el ranking ELO de sus jugadores en un BST. A medida que los jugadores completan partidas, su ELO se actualiza y se reinsertan en el árbol. El director del torneo necesita obtener la lista de jugadores que clasifican a la siguiente ronda, es decir, todos aquellos cuyo ELO se encuentre dentro de un rango específico.

## Requisitos

### La Clase Jugador (Nodo)
Debe contener los siguientes atributos:
- `elo` (int, clave del BST)
- `nombreUsuario` (String)
- `pais` (String)
- `partidasJugadas` (int)
- `izq` y `der` (Referencias a los subárboles)

### La Clase ArbolRanking (Estructura)
Debe gestionar un Árbol Binario de Búsqueda mediante la raíz, asegurando que los jugadores con menor ELO vayan a la izquierda y aquellos con mayor ELO a la derecha.

### El Problema
Para la ronda de clasificación, el director fija un rango mínimo y máximo de ELO (por ejemplo, entre 1800 y 2200). Todos los jugadores en ese rango deben ser listados de menor a mayor ELO para armar los emparejamientos.

### El Reto
Implementa el método `listarEnRango(int eloMin, int eloMax)` que recorra el árbol e imprima los datos de todos los jugadores cuyo `elo` esté dentro del rango `[eloMin, eloMax]` en orden ascendente. Usa la propiedad del BST para podar: si el nodo actual es menor que `eloMin`, solo explora el subárbol derecho; si es mayor que `eloMax`, solo explora el izquierdo.

## Salida Esperada
El programa debe permitir:
1. Ver todos los jugadores ordenados por ELO (InOrden).
2. Insertar un nuevo jugador al ranking.
3. Listar jugadores en un rango de ELO específico.
4. Salir.

## Tips para el Desarrollo:
1. **Poda inteligente:** En lugar de recorrer TODO el árbol y luego preguntar si el nodo está en el rango (lo cual sería ineficiente), usa las reglas del BST. Si el ELO actual es `1500` y el rango mínimo es `1800`, sabes que NINGÚN nodo a la izquierda servirá. Así ahorras tiempo de procesamiento.
2. **InOrden condicionado:** Para que la lista salga ordenada, el método debe seguir la misma lógica de `InOrden` (`izquierda` -> `imprimir` -> `derecha`), pero condicionando las llamadas recursivas según los límites del rango.

## Clases a Implementar
1. **Jugador.java** - Nodo del Árbol BST.
2. **ArbolRanking.java** - Estructura del Árbol Binario de Búsqueda.
3. **App.java** - Clase principal con menú interactivo.
