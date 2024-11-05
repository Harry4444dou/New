import java.util.*;

public class Cafeteria {
    
    // Cola de pedidos que simula la fila de atención
    private Queue<Pedido> colaPedidos;
    private Scanner scanner;
    
    public Cafeteria() {
        colaPedidos = new LinkedList<>();
        scanner = new Scanner(System.in);
    }

    // Método para registrar un nuevo pedido
    public void registrarPedido() {
        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = scanner.nextLine();

        Pedido nuevoPedido = new Pedido(nombreCliente);

        while (true) {
            System.out.print("Ingrese el nombre del producto (o 'fin' para terminar): ");
            String nombreProducto = scanner.nextLine();
            if (nombreProducto.equalsIgnoreCase("fin")) {
                break;
            }

            System.out.print("Ingrese la cantidad de " + nombreProducto + ": ");
            int cantidad = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            nuevoPedido.agregarProducto(nombreProducto, cantidad);
        }

        colaPedidos.offer(nuevoPedido);
        System.out.println("Pedido registrado con éxito.");
    }

    // Método para atender el próximo pedido (FIFO)
    public void atenderPedido() {
        if (colaPedidos.isEmpty()) {
            System.out.println("No hay pedidos pendientes.");
        } else {
            Pedido pedidoAtendido = colaPedidos.poll(); // Atendemos el primer pedido en la cola
            System.out.println("Atendiendo el pedido de " + pedidoAtendido.getNombreCliente());
            System.out.println(pedidoAtendido);
        }
    }

    // Método para ver el estado de los pedidos pendientes
    public void verificarEstadoPedidos() {
        if (colaPedidos.isEmpty()) {
            System.out.println("No hay pedidos pendientes.");
        } else {
            System.out.println("--- Pedidos pendientes ---");
            for (Pedido pedido : colaPedidos) {
                System.out.println(pedido);
            }
        }
    }

    // Menú de interacción con el usuario
    public void mostrarMenu() {
        System.out.println("\n--- Menú Cafetería ---");
        System.out.println("1. Registrar nuevo pedido");
        System.out.println("2. Atender próximo pedido");
        System.out.println("3. Verificar estado de pedidos pendientes");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static void main(String[] args) {
        Cafeteria cafeteria = new Cafeteria();
        
        // Bucle principal del programa para interactuar con el usuario
        while (true) {
            cafeteria.mostrarMenu();
            int opcion = cafeteria.scanner.nextInt();
            cafeteria.scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    cafeteria.registrarPedido();
                    break;
                case 2:
                    cafeteria.atenderPedido();
                    break;
                case 3:
                    cafeteria.verificarEstadoPedidos();
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, intente nuevamente.");
            }
        }
    }

    // Clase interna Pedido que maneja los productos
    static class Pedido {
        private String nombreCliente;
        private LinkedList<Producto> productos;

        public Pedido(String nombreCliente) {
            this.nombreCliente = nombreCliente;
            this.productos = new LinkedList<>();
        }

        // Agregar productos al pedido
        public void agregarProducto(String nombre, int cantidad) {
            productos.add(new Producto(nombre, cantidad));
        }

        public String getNombreCliente() {
            return nombreCliente;
        }

        @Override
        public String toString() {
            StringBuilder detalle = new StringBuilder("Pedido de " + nombreCliente + ":\n");
            for (Producto producto : productos) {
                detalle.append(" - ").append(producto).append("\n");
            }
            return detalle.toString();
        }
    }

    // Clase interna Producto que representa cada item del pedido
    static class Producto {
        private String nombre;
        private int cantidad;

        public Producto(String nombre, int cantidad) {
            this.nombre = nombre;
            this.cantidad = cantidad;
        }

        @Override
        public String toString() {
            return nombre + " x" + cantidad;
        }
    }
}
