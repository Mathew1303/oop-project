import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class CreadorDeProfesores {
    private Scanner scanner;
    private List<Profesor> profesores;
    private List<Asignatura> asignaturasDisponibles; // Debes llenar esta lista con asignaturas existentes

    public CreadorDeProfesores(List<Asignatura> asignaturasDisponibles) {
        this.scanner = new Scanner(System.in);
        this.profesores = new ArrayList<>();
        this.asignaturasDisponibles = asignaturasDisponibles;
    }

    public Profesor crearProfesor() {
        System.out.println("Ingrese el nombre del profesor:");
        String nombre = scanner.nextLine().trim();
        int cedula = solicitarNumeroValido("Ingrese la cédula del profesor (solo números):");
        System.out.println("Seleccione el departamento del profesor:");
        String nombreDepartamento = scanner.nextLine().trim();
        Departamento departamento = new Departamento(nombreDepartamento);
        Profesor profesor = new Profesor(nombre, cedula, departamento);
        agregarAsignaturas(profesor);
        return profesor;
    }

    private void agregarAsignaturas(Profesor profesor) {
        int cantidad = solicitarNumeroValido("¿Cuántas asignaturas imparte el profesor?");
        for (int i = 0; i < cantidad; i++) {
            System.out.println("Listado de asignaturas disponibles:");
            for (int j = 0; j < asignaturasDisponibles.size(); j++) {
                System.out.println((j + 1) + ". " + asignaturasDisponibles.get(j).getNombre_asign());
            }
            int indiceAsignatura = solicitarNumeroValido("Seleccione una asignatura (por número):") - 1;
            if (indiceAsignatura >= 0 && indiceAsignatura < asignaturasDisponibles.size()) {
                profesor.agregarAsignatura(asignaturasDisponibles.get(indiceAsignatura));
            } else {
                System.out.println("Número de asignatura no válido, intente de nuevo.");
                i--; // Decrementa i para repetir la selección de asignatura.
            }
        }
    }

    private int solicitarNumeroValido(String mensaje) {
        while (true) {
            System.out.println(mensaje);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, introduzca solo números.");
            }
        }
    }

    private void agregarHorarios(Profesor profesor) {
        Set<String> diasValidos = new HashSet<>();
        diasValidos.add("lunes");
        diasValidos.add("martes");
        diasValidos.add("miércoles");
        diasValidos.add("jueves");
        diasValidos.add("viernes");

        System.out.println("Ingrese los días con bloques horarios (Ej. Lunes, Martes):");
        while (true) {
            System.out.println("Día (deje en blanco y pulse enter para finalizar):");
            String dia = scanner.nextLine().trim().toLowerCase(); // Asegúrate de normalizar a minúsculas
            if (dia.isEmpty()) break; // Si el usuario no ingresa nada, termina el ciclo

            if (!diasValidos.contains(dia)) {
                System.out.println("Por favor, ingrese un día válido (Lunes, Martes, Miércoles, Jueves, Viernes).");
                continue; // Continúa el ciclo si el día no es válido, pidiendo otra entrada
            }

            System.out.println("Hora de inicio (formato 24h, ej. 7 para las 7 AM):");
            int horaInicio = Integer.parseInt(scanner.nextLine());
            System.out.println("Hora de fin (formato 24h, ej. 12 para las 12 PM):");
            int horaFin = Integer.parseInt(scanner.nextLine());

            BloqueHorario bloque = new BloqueHorario(horaInicio, horaFin);
            profesor.agregarBloqueHorario(dia, bloque);
        }
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    // Método para mostrar todos los profesores y su información básica
    public void mostrarProfesores() {
        for (Profesor profesor : profesores) {
            System.out.println(profesor);
        }
    }
}
