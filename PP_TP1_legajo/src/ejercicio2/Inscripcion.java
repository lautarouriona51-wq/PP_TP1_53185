package ejercicio2;

import java.time.LocalDate;

public class Inscripcion {
    private LocalDate fecha;
    private String estado;
    private Actividad actividad;
    private Estudiante estudiante;

    public Inscripcion(Actividad actividad, Estudiante estudiante) {
        this.actividad = actividad;
        this.estudiante = estudiante;
        this.fecha = LocalDate.now();
        this.estado = "Confirmada";
    }

    public LocalDate getFecha() { return fecha; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public Actividad getActividad() { return actividad; }
    public Estudiante getEstudiante() { return estudiante; }
}
