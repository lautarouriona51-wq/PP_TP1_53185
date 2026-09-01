package ejercicio4;

import ejercicio3.*;



public class App4 {
    public static void main(String[] args) {
        // a. 3 estudiantes
        Estudiante estudiante1 = new Estudiante("2001", "Sofia Ramirez");
        Estudiante estudiante2 = new Estudiante("2002", "Diego Torres");
        Estudiante estudiante3 = new Estudiante("2003", "Valentina Ruiz");

        // b. 1 evento
        EventoUniversitario evento1 = new EventoUniversitario("EV-100", "Semana de la Ingenieria", 10000, false);

        // c. 1 sala
        Sala sala1 = new Sala(1, "Aula Magna");
        evento1.asignarSala(sala1);

        // d. 2 actividades: una Charla y un Taller
        evento1.crearActividad(1, "Charla de Ciberseguridad", 40, "Charla", "Lic. Pablo Nunez");
        evento1.crearActividad(2, "Taller de Python", 25, "Taller", true);

        Actividad charla1 = evento1.getActividades().get(0);
        Actividad taller1 = evento1.getActividades().get(1);

        // e. 2 estudiantes inscriptos en la Charla
        Inscripcion inscripcion1 = charla1.inscribir(estudiante1);
        Inscripcion inscripcion2 = charla1.inscribir(estudiante2);

        // f. 2 estudiantes inscriptos en el Taller
        Inscripcion inscripcion3 = taller1.inscribir(estudiante2);
        Inscripcion inscripcion4 = taller1.inscribir(estudiante3);

        evento1.mostrarDatos();
        System.out.println("\nTotal de eventos creados: " + EventoUniversitario.getCantidadEventos());
    }
}
