public class Asignatura_Practica extends Asignatura {
    private String materialApoyo;
    private String os;

    public Asignatura_Practica(String nombre_asig, int creditos, Departamento departamento, Semestre semestre, String materialApoyo, String os) {
        super(nombre_asig, creditos, departamento, semestre);
        this.materialApoyo = materialApoyo;
        this.os = os;
    }

    // Métodos getters o adicionales pueden ir aquí

    public String getMaterialApoyo() {
        return materialApoyo;
    }

    public String getOs() {
        return os;
    }
}