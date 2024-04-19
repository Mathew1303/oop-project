import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Profesor extends Persona {
    private Departamento departamento;
    private LinkedList<Asignatura> asignaturas;
    private Map<String, List<BloqueHorario>> horarioProf;

    public Profesor(String nombre, int cedula, Departamento departamento) {
        super(nombre, cedula);
        this.departamento = departamento;
        this.asignaturas = new LinkedList<>();
        this.horarioProf = new HashMap<>();
    }

    public void agregarAsignatura(Asignatura asignatura) {
        asignaturas.add(asignatura);
    }

    public void agregarBloqueHorario(String dia, BloqueHorario bloque) {
        horarioProf.computeIfAbsent(dia, k -> new LinkedList<>()).add(bloque);
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public Map<String, List<BloqueHorario>> getHorarioProf() {
        return horarioProf;
    }

    @Override
    public String toString() {
        return "nombre:" + getNombre() +"\n"+ "Cedula:" + getCedula() +"\n"+
                "Departamento:" + getDepartamento() +"\n"+ "Horarios:" + horarioProf+"\n";
    }
}
