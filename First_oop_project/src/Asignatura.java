public abstract class Asignatura {
    private String nombre_asig;
    private int creditos;
    private Departamento departamento;
    private Semestre semestre;

    public Asignatura(String nombre_asig, int creditos, Departamento departamento, Semestre semestre) {
        this.nombre_asig = nombre_asig;
        this.creditos = creditos;
        this.departamento = departamento;
        this.semestre = semestre;
    }

    public int cantidadHoras() {
        int horas = 3; // Asumimos 3 horas por crédito como estándar
        return horas * creditos;
    }

    public String getNombre_asign() {
        return this.nombre_asig;
    }

    public int getCreditos() {
        return creditos;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public Semestre getSemestre() {
        return semestre;
    }
}