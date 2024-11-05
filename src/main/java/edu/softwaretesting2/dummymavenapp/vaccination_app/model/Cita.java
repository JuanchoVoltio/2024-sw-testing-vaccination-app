package edu.softwaretesting2.dummymavenapp.vaccination_app.model;

import java.time.LocalDate;

public class Cita {
    private String  nombre;
    private LocalDate fechaDeCita;
    private String diaSemana;
    private String sede;
    private boolean prioritario;

    public Cita (String nombre, LocalDate fechaDeCita, String diaSemana, String Sede) {
        this.setNombre(nombre);
        this.setFechaDeCita(fechaDeCita);
        this.setDiaSemana(diaSemana);
        this.setSede(sede);
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public LocalDate getFechaDeCita(){
        return fechaDeCita;
    }

    public void setFechaDeCita(LocalDate fechaDeCita){
        this.fechaDeCita = fechaDeCita;
    }

    public String getDiaSemana(){
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana){
        this.diaSemana = diaSemana;
    }

    public String getSede(){
        return sede;
    }

    public void setSede(String sede){
        this.sede = sede;
    }

    public boolean esPrioritario() {
        return prioritario;
    }

    public void setPrioritario(boolean prioritario){
        this.prioritario = prioritario;
    }


}
