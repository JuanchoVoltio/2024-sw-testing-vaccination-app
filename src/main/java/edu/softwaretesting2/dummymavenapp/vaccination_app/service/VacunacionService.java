package edu.softwaretesting2.dummymavenapp.vaccination_app.service;

import edu.softwaretesting2.dummymavenapp.vaccination_app.model.Paciente;

import java.time.LocalDate;
import java.time.Period;

public class VacunacionService {
    public void validarLaEdadDelPaciente(Paciente p) {
        LocalDate fechaActual = LocalDate.now();
        // Calcular la edad restando el año actual con el año de nacimiento
        int edad = Period.between(p.getFechaNacimiento(), fechaActual).getYears();
        // Considerar prioritaria a las personas mayores de 60
        return edad > 60;
    }
}
