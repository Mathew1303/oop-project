import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {
    private Scanner scanner;
    private CreadorDeAsignaturas creadorDeAsignaturas;
    private CreadorDeAulas creadorDeAulas;
    private CreadorDeProfesores creadorDeProfesores;
    private List<Asignatura> asignaturasDisponibles;
    private List<Aula> aulasDisponibles;

    public MenuPrincipal() {

        scanner = new Scanner(System.in);
        asignaturasDisponibles = new ArrayList<>();
        aulasDisponibles = new ArrayList<>();
        creadorDeAsignaturas = new CreadorDeAsignaturas(asignaturasDisponibles); // Asegúrate de que el constructor acepte este parámetro
        creadorDeAulas = new CreadorDeAulas(aulasDisponibles); // Asegúrate de que el constructor acepte este parámetro
        creadorDeProfesores = new CreadorDeProfesores(asignaturasDisponibles);
    }

    public void mostrarMenu() {
        int opcion = 0;
        do {
            System.out.println("\nMenú Principal");
            System.out.println("1. Crear Asignaturas");
            System.out.println("2. Crear Aulas");
            System.out.println("3. Crear Profesores");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    Asignatura nuevaAsignatura = creadorDeAsignaturas.crearAsignatura();
                    asignaturasDisponibles.add(nuevaAsignatura);
                    break;
                case 2:
                    Aula nuevaAula = creadorDeAulas.crearAula();
                    aulasDisponibles.add(nuevaAula);
                    break;
                case 3:
                    if (asignaturasDisponibles.isEmpty()) {
                        System.out.println("No hay asignaturas disponibles. Cree primero algunas asignaturas.");
                    } else {
                        Profesor nuevoProfesor = creadorDeProfesores.crearProfesor();
                    }
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor intente de nuevo.");
                    break;
            }
        } while (opcion != 4);
    }
}