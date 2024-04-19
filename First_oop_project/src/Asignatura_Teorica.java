public class Asignatura_Teorica extends Asignatura {
    private String sitioWeb;

    public Asignatura_Teorica(String nombre_asig, int creditos, Departamento departamento, Semestre semestre, String sitioWeb) {
        super(nombre_asig, creditos, departamento, semestre);
        this.sitioWeb = sitioWeb;
    }

    // Métodos getters o adicionales pueden ir aquí

    public String getSitioWeb() {
        return sitioWeb;
    }
}