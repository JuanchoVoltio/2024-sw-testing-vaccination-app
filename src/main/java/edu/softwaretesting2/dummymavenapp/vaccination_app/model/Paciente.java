package edu.softwaretesting2.dummymavenapp.vaccination_app.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Paciente {

    private String nombre;
    private LocalDate fechaDeNacimiento;
    private boolean prioritario;

     private static List<Paciente> pacientes = new ArrayList<>();

    public Paciente(String nombre, LocalDate fechaDeNacimiento) {
        this.setNombre(nombre);
        this.setFechaDeNacimiento(fechaDeNacimiento);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public boolean esPrioritario() {
        return prioritario;
    }

    public void setPrioritario(boolean priotario) {
        this.prioritario = priotario;
    }

    public static void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public static Paciente obtenerPaciente(String nombre) {
        return pacientes.stream()
                        .filter(p -> p.getNombre().equals(nombre))
                        .findFirst()
                        .orElse(null);
    }

    public static void actualizarPaciente(String nombre, LocalDate nuevaFechaNacimiento) {
        Paciente paciente = obtenerPaciente(nombre);
        if (paciente != null) {
            paciente.fechaDeNacimiento = nuevaFechaNacimiento;
            paciente.prioritario = paciente.calcularPrioridad();
        }
    }

    public static void eliminarPaciente(String nombre) {
        pacientes.removeIf(p -> p.getNombre().equals(nombre));
    }

    public static List<Paciente> listarPacientes() {
        return new ArrayList<>(pacientes);
    }

    

}
