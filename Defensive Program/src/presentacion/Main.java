package presentacion;

import accesoDatos.InventarioRepositorio;
import logicaNegocio.InventarioServicio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InventarioRepositorio repositorio = new InventarioRepositorio();
        InventarioServicio servicio = new InventarioServicio(repositorio);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nOpciones:");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Listar Productos");
            System.out.println("3. Buscar Producto");
            System.out.println("4. Salir");

            System.out.print("Selecciona una opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Nombre del producto: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Precio del producto: ");
                    double precio = scanner.nextDouble();

                    System.out.print("Cantidad: ");
                    int cantidad = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    try {
                        servicio.agregarProducto(nombre, precio, cantidad);
                        System.out.println("Producto agregado correctamente.");
                    } catch (Exception ex) {
                        System.out.println("Error: " + ex.getMessage());
                    }
                    break;

                case "2":
                    servicio.listarProductos();
                    break;

                case "3":
                    System.out.print("Nombre del producto a buscar: ");
                    String nombreBusqueda = scanner.nextLine();
                    servicio.buscarProducto(nombreBusqueda);
                    break;

                case "4":
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}
