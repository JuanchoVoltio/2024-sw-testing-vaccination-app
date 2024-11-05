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
    // Método para mostrar todos los pacientes (solo imprime)


    // Método para obtener todos los pacientes (devuelve la lista)
    public List<Paciente> obtenerPacientes() {
        return pacientes; // Devuelve la lista de pacientes
    }

    // Método para buscar un paciente por nombre
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

// Método para mostrar todos los pacientes (ajustado para retornar la lista)
public List<Paciente> mostrarPacientes() {
    return pacientes; // Retorna la lista de pacientes
}

}