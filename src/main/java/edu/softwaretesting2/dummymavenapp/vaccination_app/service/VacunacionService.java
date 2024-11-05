package edu.softwaretesting2.dummymavenapp.vaccination_app.service;

import edu.softwaretesting2.dummymavenapp.vaccination_app.model.Paciente;

import java.time.LocalDate;

public class VacunacionService {
    public boolean validarLaEdadDelPaciente(Paciente p) {
        //definir como prioritaria si su fecha de nacimiento es antes de hace 60 años 
        boolean esEprioritario = p.getFechaDeNacimiento().isBefore(fechaLimite);
        p.setPrioritario(esPrioritario); //si aun necesitamos establecer el estado en el objeto paciente
        
        return esPrioritario;
        
    }
}
