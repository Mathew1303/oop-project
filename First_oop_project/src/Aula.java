public class Aula {
    private String nombre;
    private int numero_aula;
    private int capacidad;
    private String ubicacion;

    public Aula(String nombre, int numero_aula, int capacidad, String ubicacion) {
        this.nombre = nombre;
        this.numero_aula = numero_aula;
        this.capacidad = capacidad;
        this.ubicacion = ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumero_aula() {
        return numero_aula;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public String getUbicacion() {
        return ubicacion;
    }
}
