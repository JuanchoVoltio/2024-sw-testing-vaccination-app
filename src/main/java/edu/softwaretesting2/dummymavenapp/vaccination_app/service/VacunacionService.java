package edu.softwaretesting2.dummymavenapp.vaccination_app.service;

import edu.softwaretesting2.dummymavenapp.vaccination_app.model.Paciente;

import java.time.LocalDate;
import java.time.Period;



public class VacunacionService {
    public boolean validarLaEdadDelPaciente(Paciente p) {
        LocalDate fechaLímite = LocalDate.now().minusYears(60);
        boolean Prioritario = p.getFechaDeNacimiento().isBefore(fechaLímite);

        p.setPrioritario(Prioritario);

        return Prioritario;
    }
}