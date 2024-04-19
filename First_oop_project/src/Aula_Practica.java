public class Aula_Practica extends Aula{
    private int cantidad_equipo;
    private String tipo_equipo;

    public Aula_Practica(String nombre, int numero_aula, int capacidad, String ubicacion, int cantidad_equipo, String tipo_equipo) {
        super(nombre, numero_aula, capacidad, ubicacion);
        this.cantidad_equipo = cantidad_equipo;
        this.tipo_equipo = tipo_equipo;
    }
}
