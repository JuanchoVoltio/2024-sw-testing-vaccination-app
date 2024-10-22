package edu.softwaretesting2.dummymavenapp.vaccination_app.service;

import java.time.LocalDate;
import java.time.Period;

import edu.softwaretesting2.dummymavenapp.vaccination_app.model.Paciente;

public class VaccinationService {

    /**
     * Este método valida si el paciente tiene más de 60 años, lo cual lo consideraría como prioritaria para la vacunación.
     *
     * @param paciente El paciente cuya edad se desea validar.
     * @return true si la edad del paciente es mayor de 60 años, false en caso contrario.
     */
    public boolean validarLaEdadDelPaciente(Paciente paciente) {
        // Obtenemos la fecha actual
        LocalDate fechaActual = LocalDate.now();
        
        // Calculamos el periodo entre la fecha de nacimiento del paciente y la fecha actual
        Period period = Period.between(paciente.getFechaDeNacimiento(), fechaActual);
        
        // Obtenemos la edad del paciente en años
        int edad = period.getYears();
        
        // Retornamos true si la edad es mayor de 60
        return edad > 60;
    }

    @Override
    public String toString() {
        return "VacunacionService []";
    }
}
