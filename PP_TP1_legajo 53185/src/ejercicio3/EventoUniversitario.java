package ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class EventoUniversitario {

    private final String id;
    private String titulo;
    private double costoBase;
    private boolean gratuito;
    private static int cantidadEventos = 0;

    private Sala sala;
    private List<Actividad> actividades = new ArrayList<>();

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

    // Si el evento es gratuito el costo sigue siendo cero.
    // En otro caso: (costoBase + costo de cada actividad) * 1.21 (21% de impuestos)
    public double calcularCostoEstimado() {
        if (gratuito) return 0;
        double costoActividades = 0;
        for (Actividad a : actividades) {
            costoActividades += a.calcularCostoMateriales();
        }
        return (costoBase + costoActividades) * 1.21;
    }

    public void asignarSala(Sala sala) {
        this.sala = sala;
    }

    /**
     * Crea una actividad concreta (Charla o Taller) segun el tipo indicado.
     * - tipo = "Charla": detalle debe ser un String con el nombre del disertante.
     * - tipo = "Taller": detalle debe ser un Boolean que indica si requiere notebook.
     */
    public void crearActividad(int id, String titulo, int cupo, String tipo, Object detalle) {
        Actividad actividad;
        switch (tipo) {
            case "Charla":
                actividad = new Charla(id, titulo, cupo, (String) detalle);
                break;
            case "Taller":
                actividad = new Taller(id, titulo, cupo, (Boolean) detalle);
                break;
            default:
                throw new IllegalArgumentException("Tipo de actividad no soportado: " + tipo);
        }
        actividades.add(actividad);
    }

    public void mostrarDatos() {
        System.out.println("Id: " + id);
        System.out.println("Titulo: " + titulo);
        System.out.println("Gratuito: " + (gratuito ? "Si" : "No"));
        System.out.println("Costo estimado: $" + calcularCostoEstimado());
        System.out.println("Sala: " + (sala != null ? sala.getNombre() : "sin asignar"));
        System.out.println("Actividades (" + actividades.size() + "):");
        for (Actividad a : actividades) {
            a.mostrarIdentificacion(); // polimorfico: usa getTipo() de cada subclase
            a.mostrarInscripciones();
        }
    }

    public static int getCantidadEventos() { return cantidadEventos; }
    public List<Actividad> getActividades() { return actividades; }
}
