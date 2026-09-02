package ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Actividad {
    private int id;
    private String titulo;
    private int cupoMaximo;
    public static final int CUPO_MINIMO = 5;

    private List<Inscripcion> inscripciones = new ArrayList<>();

    public Actividad(int id, String titulo, int cupoMaximo) {
        this.id = id;
        this.titulo = titulo;
        this.cupoMaximo = Math.max(cupoMaximo, CUPO_MINIMO);
    }

    public Inscripcion inscribir(Estudiante estudiante) {
        if (inscripciones.size() >= cupoMaximo) {
            System.out.println("No hay cupo disponible en la actividad " + titulo);
            return null;
        }
        Inscripcion inscripcion = new Inscripcion(this, estudiante);
        inscripciones.add(inscripcion);
        return inscripcion;
    }

    public void mostrarInscripciones() {
        System.out.println("Inscripciones de la actividad '" + titulo + "':");
        if (inscripciones.isEmpty()) {
            System.out.println("  (sin inscripciones)");
        }
        for (Inscripcion i : inscripciones) {
            System.out.println("  - " + i.getEstudiante() + " | Fecha: " + i.getFecha() + " | Estado: " + i.getEstado());
        }
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public int getCupoMaximo() { return cupoMaximo; }
    public List<Inscripcion> getInscripciones() { return inscripciones; }
}
