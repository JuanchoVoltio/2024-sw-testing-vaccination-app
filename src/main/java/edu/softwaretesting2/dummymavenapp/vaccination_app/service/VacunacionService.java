package edu.softwaretesting2.dummymavenapp.vaccination_app.service;

import edu.softwaretesting2.dummymavenapp.vaccination_app.model.Paciente;

import java.time.LocalDate;
import java.time.Period;

<<<<<<< HEAD

public class VacunacionService {
    public boolean validarLaEdadDelPaciente(Paciente p) {
        LocalDate fechaLímite = LocalDate.now().minusYears(60);
        boolean Prioritario = p.getFechaDeNacimiento().isBefore(fechaLímite);

        p.setPrioritario(Prioritario);

        return Prioritario;
    }
=======
public class VacunacionService {
    public boolean validarLaEdadDelPaciente(Paciente paciente) {
        LocalDate fechaNacimiento = paciente.getFechaDeNacimiento();
        LocalDate fechaActual = LocalDate.now();
        int edad = Period.between(fechaNacimiento, fechaActual).getYears();
        
        return edad > 60;
>>>>>>> ee4abaefc5aae930cfceb18a681b73adc748e901
}
}