package ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class EventoUniversitario {

    private final String id;
    private String titulo;
    private double costoBase;
    private boolean gratuito;
    private static int cantidadEventos = 0;

    private Sala sala;                           // agregacion: la sala existe independientemente del evento
    private List<Actividad> actividades = new ArrayList<>(); // composicion: las actividades son parte del evento

    public EventoUniversitario(String id, String titulo, double costoBase, boolean gratuito) {
        this.id = id;
        this.titulo = titulo;
        this.costoBase = costoBase;
        this.gratuito = gratuito;
        cantidadEventos++;
    }

    public EventoUniversitario(EventoUniversitario otro) {
        this.id = otro.id;
        this.titulo = otro.titulo;
        this.costoBase = otro.costoBase;
        this.gratuito = otro.gratuito;
        this.sala = otro.sala;
        this.actividades = new ArrayList<>(otro.actividades);
        cantidadEventos++;
    }

    public double calcularCostoEstimado() {
        return gratuito ? 0 : costoBase;
    }

    public void asignarSala(Sala sala) {
        this.sala = sala;
    }

    public void crearActividad(int id, String titulo, int cupo) {
        actividades.add(new Actividad(id, titulo, cupo));
    }

    public void mostrarDatos() {
        System.out.println("Id: " + id);
        System.out.println("Titulo: " + titulo);
        System.out.println("Costo base: $" + costoBase);
        System.out.println("Gratuito: " + (gratuito ? "Si" : "No"));
        System.out.println("Costo estimado: $" + calcularCostoEstimado());
        System.out.println("Sala: " + (sala != null ? sala.getNombre() : "sin asignar"));
        System.out.println("Actividades (" + actividades.size() + "):");
        for (Actividad a : actividades) {
            System.out.println("  - " + a.getTitulo() + " (cupo: " + a.getCupoMaximo() + ")");
            a.mostrarInscripciones();
        }
    }

    public static int getCantidadEventos() { return cantidadEventos; }
    public List<Actividad> getActividades() { return actividades; }
}
