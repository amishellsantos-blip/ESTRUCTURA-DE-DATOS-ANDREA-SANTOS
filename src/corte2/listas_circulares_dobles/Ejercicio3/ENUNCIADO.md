# Editor de Capas (Diseño Gráfico)

## Descripción del Problema

Los editores gráficos (como Photoshop o GIMP) organizan el diseño en capas apiladas. El usuario puede navegar de forma circular entre ellas, ocultarlas o eliminarlas. Se utiliza una lista circular doble para permitir un movimiento fluido hacia arriba y hacia abajo en la pila de capas.

## Requisitos

### La Clase Capa (Nodo Doble Circular)
Debe contener los siguientes atributos:
- `nombre` (String)
- `visible` (boolean)
- `tipo` (String — "fondo", "objeto", "texto")
- `siguiente` y `anterior` (Referencias al mismo tipo de nodo)

### La Clase EditorCapas (Lista Circular Doble)
Debe gestionar el panel con los siguientes métodos:
- `agregarCapa()` - Agrega una capa al final de la pila.
- `subirCapa()` - Mueve el foco (`capaActiva`) a la capa superior.
- `bajarCapa()` - Mueve el foco a la capa inferior.
- `toggleVisibilidad()` - Cambia el estado de visibilidad de la capa activa.
- `eliminarActiva()` - Elimina la capa seleccionada.

### El Problema
La estructura es circular: después de la capa más alta vuelve a la más baja. El editor debe ser capaz de eliminar la capa sobre la que se está trabajando (`capaActiva`) sin perder la referencia a las demás, pasando el foco automáticamente a la siguiente capa disponible.

### El Reto
Implementar la eliminación en **O(1)** y el manejo de punteros auxiliares. Según las instrucciones, si se elimina el nodo activo, se debe mover el puntero `capaActiva` **antes** de desconectar el nodo para no perder la navegación.

## Tips para el Desarrollo Aplicados:
1. **Eliminar en O(1):** Conexión directa usando `anterior` y `siguiente`.
2. **Invariantes Circulares:** Asegurar que los extremos siempre estén conectados en ambos sentidos.
3. **Gestión de Foco:** Movimiento preventivo del puntero `capaActiva` antes de la eliminación del nodo actual.

## Salida Esperada
El programa debe permitir:
1. Crear una pila de capas con diferentes tipos y nombres.
2. Alternar la visibilidad y ver el impacto en el panel.
3. Navegar en ambos sentidos y eliminar capas verificando la reconexión.

## Clases a Implementar
1. **Capa.java** - Nodo doble
2. **EditorCapas.java** - Lista circular doble
3. **App.java** - Clase principal con menú interactivo
