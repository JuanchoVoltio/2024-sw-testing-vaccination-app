package edu.softwaretesting2.dummymavenapp.vaccination_app.service;

import java.time.LocalDate;

import edu.softwaretesting2.dummymavenapp.vaccination_app.model.Paciente;

public class VacunacionService {

    /**
     * Valida si el paciente tiene más de 60 años y lo marca como prioritario en caso afirmativo.
     * 
     * @param p El paciente cuya edad se desea validar.
     * @return true si el paciente es mayor de 60 años y, por lo tanto, prioritario; false en caso contrario.
     */
    public boolean validarLaEdadDelPaciente(Paciente p) {
        // Calculamos la fecha límite para pacientes prioritarios (hace 60 años desde hoy)
        LocalDate fechaLimite = LocalDate.now().minusYears(60);

        // Si la fecha de nacimiento del paciente es antes de la fecha límite, es prioritario
        boolean esPrioritario = p.getFechaDeNacimiento().isBefore(fechaLimite);

        // Actualizamos el estado del paciente
        p.setPrioritario(esPrioritario);

        // Retornamos si el paciente es prioritario o no
        return esPrioritario;
    }
}
