package edu.softwaretesting2.dummymavenapp.vaccination_app.service;

import edu.softwaretesting2.dummymavenapp.vaccination_app.model.Paciente;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class VacunacionServiceTest {

    Paciente persona1;
    Paciente personaPrioritaria;

    @BeforeAll
    void init() {
        persona1 = new Paciente(10, "NN", LocalDate.of(1986, 12, 24));
        personaPrioritaria = new Paciente(11, "Bla", LocalDate.of(1963, 12, 24));
    }

    @BeforeEach
    void setUp() {
    }

    @Test
    public void deberíaAsignarMaximo40PersonasParaUnDía() {
        //GIVEN

        //WHEN

        //THEN

    }

    @Test
    public void deberíaDefinirComoPriotitariaAUnaPersonaDeMasDe60Años() {
        //GIVEN
        LocalDate fechaActual = LocalDate.now();
        VacunacionService servicio = new VacunacionService();

        //WHEN
        boolean respuesta = servicio.validarLaEdadDelPaciente(personaPrioritaria);

        //THEN
        Assertions.assertTrue(respuesta);
    }
}