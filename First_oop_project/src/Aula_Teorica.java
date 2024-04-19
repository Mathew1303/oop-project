public class Aula_Teorica extends Aula{
    private boolean aire_condicionado;
    private boolean multimedia;

    public Aula_Teorica(String nombre, int numero_aula, int capacidad, String ubicacion, boolean aire_condicionado, boolean multimedia) {
        super(nombre, numero_aula, capacidad, ubicacion);
        this.aire_condicionado = aire_condicionado;
        this.multimedia = multimedia;
    }
}
