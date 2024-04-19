import java.util.LinkedList;

public class Coordinador extends Persona{
    private Departamento departamento;
    //private LinkedList<Profesor> lista_profesores;

    public Coordinador(String nombre, int cedula, Departamento departamento) {
        super(nombre, cedula);
        this.departamento = departamento;
    }
}
