package edu.softwaretesting2.dummymavenapp.vaccination_app.service;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import edu.softwaretesting2.dummymavenapp.vaccination_app.model.Paciente;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class VacunacionServiceTest {

    Paciente persona1;
    Paciente personaPrioritaria;

    @BeforeAll
    void init(){
        persona1 = new Paciente("NN", LocalDate.of(1986, 12, 24));
        personaPrioritaria = new Paciente("Bla", LocalDate.of(1963, 12, 24)); // Esta persona tiene más de 60 años
    }

    @Test
    public void deberíaDefinirComoPriotitariaAUnaPersonaDeMasDe60Años(){
        //GIVEN
        VacunacionService servicio = new VacunacionService();

        //WHEN
        boolean respuesta = servicio.validarLaEdadDelPaciente(personaPrioritaria);

        //THEN
        Assertions.assertTrue(respuesta, "La persona debería ser marcada como prioritaria (edad > 60)");
    }
}
