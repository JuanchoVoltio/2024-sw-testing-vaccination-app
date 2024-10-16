package edu.softwaretesting2.dummymavenapp.vaccination_app.model;

import java.time.LocalDate;

public class Paciente {

    private String nombre;
    private LocalDate fechaDeNacimiento;
    private boolean prioritario;

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
}
