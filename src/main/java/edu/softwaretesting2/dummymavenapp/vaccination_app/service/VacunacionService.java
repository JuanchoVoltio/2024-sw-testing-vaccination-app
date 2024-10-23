package edu.softwaretesting2.dummymavenapp.vaccination_app.service;

import edu.softwaretesting2.dummymavenapp.vaccination_app.model.Paciente;

import java.time.LocalDate;
import java.time.Period;

public class VacunacionService {
    public boolean validarLaEdadDelPaciente(Paciente paciente) {
        LocalDate fechaNacimiento = paciente.getFechaDeNacimiento();
        LocalDate fechaActual = LocalDate.now();
        int edad = Period.between(fechaNacimiento, fechaActual).getYears();
        
        return edad > 60;
}
}