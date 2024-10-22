package edu.softwaretesting2.dummymavenapp.vaccination_app.model;

import java.time.LocalDate;

public class Paciente {

    private String nombre;
    private LocalDate fechaDeNacimiento;
    private boolean prioritario;

    // Constructor para inicializar el nombre y la fecha de nacimiento
    public Paciente(String nombre, LocalDate fechaDeNacimiento) {
        this.setNombre(nombre);
        this.setFechaDeNacimiento(fechaDeNacimiento);
    }

    // Getter para el nombre
    public String getNombre() {
        return nombre;
    }

    // Setter para el nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter para la fecha de nacimiento
    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    // Setter para la fecha de nacimiento
    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    // Getter para saber si es prioritario
    public boolean isPrioritario() {
        return prioritario;
    }

    // Setter para establecer si es prioritario
    public void setPrioritario(boolean prioritario) {
        this.prioritario = prioritario;
    }
}
