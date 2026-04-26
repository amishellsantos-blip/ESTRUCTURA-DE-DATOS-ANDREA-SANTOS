# Inventario de Alimentos (Control de Caducidad)

## Descripción del Problema

Un supermercado necesita gestionar su estante de lácteos. Los productos que vencen más pronto deben colocarse al principio para ser vendidos primero.

## Requisitos

### La Clase Producto (Nodo)
Debe contener los siguientes atributos:
- `nombre` (String)
- `cantidad` (int)
- `diasParaVencer` (int)

### La Clase Inventario (Lista Enlazada)
Debe gestionar una lista enlazada de productos con los siguientes métodos:
- `insertarProducto()` - Inserta un producto respetando la prioridad de caducidad
  - Si vence en **menos de 3 días**: insertar al **inicio** (prioridad de venta)
  - Si vence en **3 días o más**: insertar al **final**
- `mostrarProductosProximos()` - Muestra solo los productos que tienen menos de 5 días para vencer
- `mostrarTodosProductos()` - Muestra todos los productos en una tabla formateada

### El Problema
Si llega un producto que vence en menos de 3 días, debe insertarse al **inicio** de la lista (prioridad de venta). Si vence en más tiempo, se pone al final. Los datos pueden ser ingresados por el usuario interactivamente.

### El Reto
Implementa un método que imprima solo los productos que tienen menos de 5 días para vencer, mostrando los resultados en una tabla formateada con todos los datos del inventario.

## Salida Esperada
El programa debe mostrar:
1. Una tabla con todos los productos (nombre, cantidad, días para vencer)
2. Una tabla separada con los productos que vencen en menos de 5 días
3. La información organizada y formateada profesionalmente

## Clases a Implementar
1. **Producto.java** - Clase que representa un producto del inventario
2. **Inventario.java** - Clase que gestiona la lista enlazada de productos
3. **App.java** - Clase principal con el método main() para la interfaz de usuario
