public class BloqueHorario {
    private int horaInicio;
    private int horaFin;  // Horas expresadas como enteros (e.g., 7 para las 7 AM, 13 para la 1 PM)

    public BloqueHorario(int horaInicio, int horaFin) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    @Override
    public String toString() {
        return "de " + horaInicio + ":00 a " + horaFin + ":00";
    }
}
