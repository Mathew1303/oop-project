import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreadorDeAsignaturas {
    private Scanner scanner;
    private List<Asignatura> asignaturas;

    public CreadorDeAsignaturas(List<Asignatura> asignaturas) {
        scanner = new Scanner(System.in);
        this.asignaturas = asignaturas;
    }

    public Asignatura crearAsignatura() {
        int tipo = solicitarNumeroValido("Seleccione el tipo de asignatura:\n1. Práctica\n2. Teórica", 1, 2);
        System.out.println("Ingrese el nombre de la asignatura:");
        String nombre = scanner.nextLine().trim();
        int creditos = solicitarNumeroValido("Ingrese el número de créditos:", 1, 10);
        System.out.println("Ingrese el departamento:");
        String nombreDepartamento = scanner.nextLine().trim();
        Departamento departamento = new Departamento(nombreDepartamento);
        Semestre semestreEnum = solicitarSemestre();

        Asignatura nuevaAsignatura = (tipo == 1) ? crearAsignaturaPractica(nombre, creditos, departamento, semestreEnum)
                : crearAsignaturaTeorica(nombre, creditos, departamento, semestreEnum);

        if (!asignaturaYaExiste(nombre, departamento)) {
            asignaturas.add(nuevaAsignatura);
            System.out.println("Agregando nueva asignatura a la lista.");
        } else {
            System.out.println("Asignatura ya existe. No se agregó a la lista.");
        }

        return nuevaAsignatura;
    }

    private boolean asignaturaYaExiste(String nombre, Departamento departamento) {
        for (Asignatura asignatura : asignaturas) {
            if (asignatura.getNombre_asign().equalsIgnoreCase(nombre) && asignatura.getDepartamento().equals(departamento)) {
                return true;
            }
        }
        return false;
    }

    private Semestre solicitarSemestre() {
        return solicitarNumeroValido("Seleccione el semestre:\n1. Primer Semestre\n2. Segundo Semestre", 1, 2) == 1 ? Semestre.PRIMER_SEMESTRE : Semestre.SEGUNDO_SEMESTRE;
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

    private Asignatura_Practica crearAsignaturaPractica(String nombre, int creditos, Departamento departamento, Semestre semestre) {
        System.out.println("Ingrese el material de apoyo:");
        String materialApoyo = scanner.nextLine().trim();
        System.out.println("Ingrese el sistema operativo utilizado:");
        String os = scanner.nextLine().trim();
        return new Asignatura_Practica(nombre, creditos, departamento, semestre, materialApoyo, os);
    }

    private Asignatura_Teorica crearAsignaturaTeorica(String nombre, int creditos, Departamento departamento, Semestre semestre) {
        System.out.println("Ingrese el sitio web de la asignatura:");
        String sitioWeb = scanner.nextLine().trim();
        return new Asignatura_Teorica(nombre, creditos, departamento, semestre, sitioWeb);
    }

    public void mostrarAsignaturas() {
        System.out.println("Todas las asignaturas creadas hasta ahora:");
        for (Asignatura asignatura : asignaturas) {
            System.out.println(asignatura);
        }
    }
}
