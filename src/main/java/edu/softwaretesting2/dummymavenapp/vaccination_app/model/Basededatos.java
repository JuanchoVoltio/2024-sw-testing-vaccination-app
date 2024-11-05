package edu.softwaretesting2.dummymavenapp.vaccination_app.model;

import java.util.ArrayList;
import java.util.List;

public class Basededatos {
    private List<Paciente> pacientes;

    // Constructor
    public Basededatos() {
        this.pacientes = new ArrayList<>();
    }

    // Método para agregar un paciente
    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    // Método para mostrar todos los pacientes
    public void mostrarPacientes() {
        for (Paciente paciente : pacientes) {
            System.out.println(paciente);
        }
    }

    // Método para buscar un paciente por nombre
    /**
     * @param nombre
     * @return
     */
    public Paciente buscarPacientePorNombre(String nombre) {
        for (Paciente paciente : pacientes) {
            if (paciente.getNombre().equalsIgnoreCase(nombre)) {
                return paciente;
            }
        }
        return null; // No encontrado
    }

    // Método para eliminar un paciente por nombre
    public boolean eliminarPaciente(String nombre) {
        Paciente paciente = buscarPacientePorNombre(nombre);
        if (paciente != null) {
            pacientes.remove(paciente);
            return true; // Eliminado
        }
        return false; // No encontrado
    }
}
