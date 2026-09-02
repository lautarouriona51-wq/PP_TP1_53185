package ejercicio2;

public class App {
    public static void main(String[] args) {
        // a. Lista de estudiantes
        Estudiante e1 = new Estudiante("1001", "Ana Perez");
        Estudiante e2 = new Estudiante("1002", "Luis Gomez");
        Estudiante e3 = new Estudiante("1003", "Marta Diaz");

        // b. Eventos
        EventoUniversitario evento1 = new EventoUniversitario("EV-001", "Jornada de Java", 15000, false);
        EventoUniversitario evento2 = new EventoUniversitario("EV-002", "Semana de la Programacion", 0, true);

        // c. Asignar sala a cada evento
        Sala salaA = new Sala(1, "Auditorio Principal");
        Sala salaB = new Sala(2, "Laboratorio 3");
        evento1.asignarSala(salaA);
        evento2.asignarSala(salaB);

        // d. Actividades propias de cada evento
        evento1.crearActividad(1, "Taller de Java", 20);
        evento1.crearActividad(2, "Charla de Testing", 30);
        evento2.crearActividad(3, "Hackathon", 15);

        // e. Inscribir estudiantes en cada actividad
        evento1.getActividades().get(0).inscribir(e1);
        evento1.getActividades().get(0).inscribir(e2);
        evento1.getActividades().get(1).inscribir(e2);
        evento2.getActividades().get(0).inscribir(e1);
        evento2.getActividades().get(0).inscribir(e3);

        // f. Resumen de datos por evento
        System.out.println("=== Evento 1 ===");
        evento1.mostrarDatos();
        System.out.println("\n=== Evento 2 ===");
        evento2.mostrarDatos();

        // g. Total de eventos
        System.out.println("\nTotal de eventos creados: " + EventoUniversitario.getCantidadEventos());
    }
}
