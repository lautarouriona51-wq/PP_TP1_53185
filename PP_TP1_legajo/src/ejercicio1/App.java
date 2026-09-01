package ejercicio1;

public class App {
    public static void main(String[] args) {
        EventoUniversitario evento1 = new EventoUniversitario("EV-001", "Jornada de Java", 15000, false);
        EventoUniversitario evento2 = new EventoUniversitario("EV-002", "Charla de Bienvenida", 0, true);

        // Copias usando el constructor de copia
        EventoUniversitario copia1 = new EventoUniversitario(evento1);
        EventoUniversitario copia2 = new EventoUniversitario(evento2);

        System.out.println("=== Evento 1 ===");
        evento1.mostrarDatos();
        System.out.println("\n=== Copia de Evento 1 ===");
        copia1.mostrarDatos();

        System.out.println("\n=== Evento 2 ===");
        evento2.mostrarDatos();
        System.out.println("\n=== Copia de Evento 2 ===");
        copia2.mostrarDatos();

        System.out.println("\nTotal de eventos creados: " + EventoUniversitario.getCantidadEventos());
    }
}
