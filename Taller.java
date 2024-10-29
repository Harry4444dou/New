import java.util.ArrayList;
import java.util.Scanner;

public class Taller {
    private ArrayList<Integer> elementos;

    public Taller() {
        this.elementos = new ArrayList<>();
    }

    public void apilar(int valor) {
        elementos.add(valor);
        System.out.println("Elemento " + valor + " apilado.");
    }

    public int desapilar() {
        if (!estaVacia()) {
            int valorDesapilado = elementos.remove(elementos.size() - 1);
            return valorDesapilado;
        } else {
            System.out.println("La pila está vacía. No se puede desapilar.");
            return -1;
        }
    }

    public int obtenerTope() {
        if (!estaVacia()) {
            return elementos.get(elementos.size() - 1);
        } else {
            System.out.println("La pila está vacía. No hay elemento en el tope.");
            return -1;
        }
    }

    public void mostrarElementos() {
        if (!estaVacia()) {
            System.out.print("Elementos de la pila: ");
            for (int elemento : elementos) {
                System.out.print(elemento + " ");
            }
            System.out.println();
        } else {
            System.out.println("La pila está vacía.");
        }
    }

    public boolean estaVacia() {
        return elementos.isEmpty();
    }

    public int obtenerTamaño() {
        return elementos.size();
    }

    public void vaciar() {
        elementos.clear();
        System.out.println("La pila ha sido vaciada.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Taller pila = new Taller ();
        int opcion;

        do {
            System.out.println("\n--- Menú de la Pila ---");
            System.out.println("1. Apilar");
            System.out.println("2. Desapilar");
            System.out.println("3. Obtener el tope");
            System.out.println("4. Mostrar elementos");
            System.out.println("5. Verificar si está vacía");
            System.out.println("6. Obtener tamaño");
            System.out.println("7. Vaciar pila");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese un valor a apilar: ");
                    int valor = scanner.nextInt();
                    pila.apilar(valor);
                    break;
                case 2:
                    int valorDesapilado = pila.desapilar();
                    if (valorDesapilado != -1) {
                        System.out.println("Elemento desapilado: " + valorDesapilado);
                    }
                    break;
                case 3:
                    int tope = pila.obtenerTope();
                    if (tope != -1) {
                        System.out.println("Elemento en el tope: " + tope);
                    }
                    break;
                case 4:
                    pila.mostrarElementos();
                    break;
                case 5:
                    System.out.println(pila.estaVacia() ? "La pila está vacía." : "La pila no está vacía.");
                    break;
                case 6:
                    System.out.println("Tamaño actual de la pila: " + pila.obtenerTamaño());
                    break;
                case 7:
                    pila.vaciar();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
