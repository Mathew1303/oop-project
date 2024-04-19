public class Persona {
    private String nombre;
    private int cedula;

    public java.lang.String getNombre() {
        return this.nombre;
    }

    public int getCedula() {
        return this.cedula;
    }

    public Persona(String nombre, int cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }
}
