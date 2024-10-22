package edu.softwaretesting2.dummymavenapp.vaccination_app.service;

import edu.softwaretesting2.dummymavenapp.vaccination_app.model.Paciente;
import org.junit.jupiter.api.*;

import javax.lang.model.util.AbstractAnnotationValueVisitor6;
import java.time.LocalDate;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class VacunacionServiceTest {

    Paciente persona1;
    Paciente personaPrioritaria;

    @BeforeAll
    void init(){
        persona1 = new Paciente("NN", LocalDate.of(1986, 12, 24));
        personaPrioritaria = new Paciente("Bla", LocalDate.of(1963, 12, 24));
    }

    @BeforeEach
    void setUp() {
    }

    @Test
    public void deberíaAsignarMaximo40PersonasParaUnDía(){
        //GIVEN

        //WHEN

        //THEN

    }

    @Test
    public void deberíaDefinirComoPriotitariaAUnaPersonaDeMasDe60Años(){
        //GIVEN
        LocalDate fechaActual = LocalDate.now();
        VacunacionService servicio = new VacunacionService();

        //WHEN
        boolean respuesta = servicio.validarLaEdadDelPaciente(personaPrioritaria);

        //THEN
        Assertions.assertTrue(respuesta);
    }
}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class VacunacionServiceTest {

    @Test
    public void deberíaDefinirComoPrioritariaAUnaPersonaDeMasDe60Años() {
        // GIVEN
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaDeNacimiento = fechaActual.minusYears(65); // Persona de 65 años
        Persona personaPrioritaria = new Persona("Juan Perez", fechaDeNacimiento);
        VacunacionService servicio = new VacunacionService();

        // WHEN
        boolean esPrioritaria = servicio.validarLaEdadDelPaciente(personaPrioritaria);

        // THEN
        Assertions.assertTrue(esPrioritaria, "La persona debería ser prioritaria por tener más de 60 años");
    }
}
