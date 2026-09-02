package ejercicio3;

public class App {
    public static void main(String[] args) {
        // a. Registrar estudiantes
        Estudiante e1 = new Estudiante("1001", "Ana Perez");
        Estudiante e2 = new Estudiante("1002", "Luis Gomez");
        Estudiante e3 = new Estudiante("1003", "Marta Diaz");

        // b. Construir evento
        EventoUniversitario evento1 = new EventoUniversitario("EV-001", "Jornada de Java", 15000, false);

        // c. Asignar sala
        Sala sala1 = new Sala(1, "Auditorio Principal");
        evento1.asignarSala(sala1);

        // d. Crear actividades del tipo Charla y Taller
        evento1.crearActividad(1, "Charla de Testing", 30, "Charla", "Ing. Juan Lopez");
        evento1.crearActividad(2, "Taller de Java", 20, "Taller", true);

        // e. Inscribir estudiantes en cada actividad
        evento1.getActividades().get(0).inscribir(e1);
        evento1.getActividades().get(0).inscribir(e2);
        evento1.getActividades().get(1).inscribir(e2);
        evento1.getActividades().get(1).inscribir(e3);

        // f. Resumen de datos y recorrido polimorfico de actividades
        System.out.println("=== Evento 1 ===");
        evento1.mostrarDatos();

        // g. Total de eventos
        System.out.println("\nTotal de eventos creados: " + EventoUniversitario.getCantidadEventos());
    }
}
