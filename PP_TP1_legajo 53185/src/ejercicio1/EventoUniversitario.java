package ejercicio1;

/**
 * Ejercicio 1: modela un evento universitario de forma aislada,
 * sin relaciones con Sala ni Actividad (eso se incorpora en el Ejercicio 2).
 */
public class EventoUniversitario {

    private final String id;
    private String titulo;
    private double costoBase;
    private boolean gratuito;
    private static int cantidadEventos = 0;

    public EventoUniversitario(String id, String titulo, double costoBase, boolean gratuito) {
        this.id = id;
        this.titulo = titulo;
        this.costoBase = costoBase;
        this.gratuito = gratuito;
        cantidadEventos++;
    }

    // Constructor de copia
    public EventoUniversitario(EventoUniversitario otro) {
        this.id = otro.id;
        this.titulo = otro.titulo;
        this.costoBase = otro.costoBase;
        this.gratuito = otro.gratuito;
        cantidadEventos++;
    }

    public double calcularCostoEstimado() {
        return gratuito ? 0 : costoBase;
    }

    public void mostrarDatos() {
        System.out.println("Id: " + id);
        System.out.println("Titulo: " + titulo);
        System.out.println("Costo base: $" + costoBase);
        System.out.println("Gratuito: " + (gratuito ? "Si" : "No"));
        System.out.println("Costo estimado: $" + calcularCostoEstimado());
    }

    public static int getCantidadEventos() {
        return cantidadEventos;
    }

    public String getId() { return id; }
    public String getTitulo() { return titulo; }
    public double getCostoBase() { return costoBase; }
    public boolean isGratuito() { return gratuito; }

    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setCostoBase(double costoBase) { this.costoBase = costoBase; }
    public void setGratuito(boolean gratuito) { this.gratuito = gratuito; }
}
