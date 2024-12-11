package logicaNegocio;

import accesoDatos.InventarioRepositorio;
import accesoDatos.Producto;

public class InventarioServicio {
    private final InventarioRepositorio repositorio;

    public InventarioServicio(InventarioRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void agregarProducto(String nombre, double precio, int cantidad) {
        // Programación Defensiva
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a cero.");
        }
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa.");
        }

        // Diseño por Contrato - Precondición
        assert repositorio.buscarPorNombre(nombre) == null : "El producto ya existe.";

        // Agregar el producto
        repositorio.agregarProducto(new Producto(nombre, precio, cantidad));

        // Diseño por Contrato - Postcondición
        assert repositorio.buscarPorNombre(nombre) != null : "El producto no fue agregado correctamente.";
    }

    public void listarProductos() {
        var productos = repositorio.obtenerTodos();
        if (productos.isEmpty()) {
            System.out.println("El inventario está vacío.");
        } else {
            for (Producto producto : productos) {
                System.out.println(producto);
            }
        }
    }

    public void buscarProducto(String nombre) {
        // Validación Defensiva
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }

        var producto = repositorio.buscarPorNombre(nombre);
        if (producto == null) {
            System.out.println("Producto no encontrado.");
        } else {
            System.out.println(producto);
        }
    }
}
