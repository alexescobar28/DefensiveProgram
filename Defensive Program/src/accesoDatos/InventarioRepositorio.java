package accesoDatos;

import java.util.ArrayList;
import java.util.List;

public class InventarioRepositorio {
    private final List<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public List<Producto> obtenerTodos() {
        return productos;
    }

    public Producto buscarPorNombre(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }
}
