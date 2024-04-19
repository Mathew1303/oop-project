import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreadorDeAulas {
    private Scanner scanner;
    private List<Aula> aulas;

    public CreadorDeAulas(List<Aula> aulas) {
        scanner = new Scanner(System.in);
        this.aulas = aulas;
    }

    public Aula crearAula() {
        System.out.println("Ingrese el nombre del aula:");
        String nombre = scanner.nextLine().trim();
        int numero_aula = solicitarNumeroValido("Ingrese el número de aula (solo números):", 1, 999);
        int capacidad = solicitarNumeroValido("Ingrese la capacidad del aula (solo números):", 1, 100);
        System.out.println("Ingrese la ubicación del aula:");
        String ubicacion = scanner.nextLine().trim();

        int tipo = solicitarNumeroValido("Seleccione el tipo de aula:\n1. Práctica\n2. Teórica", 1, 2);
        Aula nuevaAula = null;
        if (tipo == 1) {
            nuevaAula = crearAulaPractica(nombre, numero_aula, capacidad, ubicacion);
        } else if (tipo == 2) {
            nuevaAula = crearAulaTeorica(nombre, numero_aula, capacidad, ubicacion);
        }
        aulas.add(nuevaAula);
        return nuevaAula;
    }

    private Aula_Practica crearAulaPractica(String nombre, int numero_aula, int capacidad, String ubicacion) {
        int cantidad_equipo = solicitarNumeroValido("Ingrese la cantidad de equipo en el aula (solo números):", 1, 50);
        System.out.println("Ingrese el tipo de equipo:");
        String tipo_equipo = scanner.nextLine().trim();
        return new Aula_Practica(nombre, numero_aula, capacidad, ubicacion, cantidad_equipo, tipo_equipo);
    }

    private Aula_Teorica crearAulaTeorica(String nombre, int numero_aula, int capacidad, String ubicacion) {
        boolean aire_condicionado = solicitarBooleano("¿El aula tiene aire acondicionado? (si/no)");
        boolean multimedia = solicitarBooleano("¿El aula tiene multimedia? (si/no)");
        return new Aula_Teorica(nombre, numero_aula, capacidad, ubicacion, aire_condicionado, multimedia);
    }

    private int solicitarNumeroValido(String mensaje, int min, int max) {
        int numero;
        while (true) {
            System.out.println(mensaje);
            try {
                numero = Integer.parseInt(scanner.nextLine().trim());
                if (numero >= min && numero <= max) {
                    break;
                } else {
                    System.out.println("Por favor, ingrese un número dentro del rango válido (" + min + " a " + max + ").");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese solo números.");
            }
        }
        return numero;
    }

    private boolean solicitarBooleano(String pregunta) {
        String respuesta;
        while (true) {
            System.out.println(pregunta);
            respuesta = scanner.nextLine().trim().toLowerCase();
            if (respuesta.equals("si") || respuesta.equals("no")) {
                break;
            } else {
                System.out.println("Por favor, responda 'si' o 'no'.");
            }
        }
        return respuesta.equals("si");
    }

    public void mostrarAulasTeoricas() {
        System.out.println("Mostrando todas las aulas teóricas:");
        for (Aula aula : aulas) {
            if (aula instanceof Aula_Teorica) {
                System.out.println(aula.getNombre());  // Asumiendo que Aula tiene un método toString adecuado
            }
        }
    }

    public void mostrarAulasPracticas() {
        System.out.println("Mostrando todas las aulas prácticas:");
        for (Aula aula : aulas) {
            if (aula instanceof Aula_Practica) {
                System.out.println(aula.getNombre());  // Asumiendo que Aula tiene un método toString adecuado
            }
        }
    }
}
