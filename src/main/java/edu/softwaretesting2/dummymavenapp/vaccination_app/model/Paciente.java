package edu.softwaretesting2.dummymavenapp.vaccination_app.model;

import java.time.LocalDate;

public class Paciente {

    private String nombre;
    private LocalDate fechaDeNacimiento;
    private boolean prioritario;
    private String edad;

    // Constructor para inicializar el nombre y la fecha de nacimiento
    public Paciente(String nombre, LocalDate fechaDeNacimiento , boolean prioritario,String edad) {
        this.setNombre(nombre);
        this.setFechaDeNacimiento(fechaDeNacimiento);
        this.prioritario = prioritario;
        this.edad = edad;
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

@Override
public String toString() {
    return "Paciente{" +
            "nombre='" + nombre + '\'' +
            ", edad=" + edad +
            ", fechaDeNacimiento='" + fechaDeNacimiento + '\'' +
            ", prioritario='" + prioritario + '\'' +
           
            '}';
}

}