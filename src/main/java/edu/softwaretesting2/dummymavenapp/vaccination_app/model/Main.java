package edu.softwaretesting2.dummymavenapp.vaccination_app.model;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Basededatos baseDeDatos = new Basededatos();

        // Crear y agregar pacientes con los nuevos atributos
        baseDeDatos.agregarPaciente(new Paciente("Juan Pérez", LocalDate.of(1993, 5, 20), true, "30"));
        baseDeDatos.agregarPaciente(new Paciente("María Gómez", LocalDate.of(1998, 11, 15), false, "25"));

        // Mostrar todos los pacientes
        System.out.println("Pacientes en la base de datos:");
        baseDeDatos.mostrarPacientes();

        // Buscar un paciente
        Paciente pacienteBuscado = baseDeDatos.buscarPacientePorNombre("Juan Pérez");
        System.out.println("\nPaciente encontrado: " + pacienteBuscado);

        // Eliminar un paciente
        boolean eliminado = baseDeDatos.eliminarPaciente("María Gómez");
        System.out.println("Paciente María Gómez eliminado: " + eliminado);

        // Mostrar todos los pacientes después de la eliminación
        System.out.println("\nPacientes en la base de datos después de la eliminación:");
        baseDeDatos.mostrarPacientes();
    }
}


