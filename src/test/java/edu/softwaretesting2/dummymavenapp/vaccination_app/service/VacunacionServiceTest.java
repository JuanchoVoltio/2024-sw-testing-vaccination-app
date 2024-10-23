package edu.softwaretesting2.dummymavenapp.vaccination_app.service;

import edu.softwaretesting2.dummymavenapp.vaccination_app.model.Paciente;
import org.junit.jupiter.api.*;

import javax.lang.model.util.AbstractAnnotationValueVisitor6;
import java.time.LocalDate;
import java.time.Period;

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
        public boolean validarLaEdadDelPaciente(Paciente paciente) {
        LocalDate fechaNacimiento = paciente.getFechaDeNacimiento();
        LocalDate fechaActual = LocalDate.now();
        int edad = Period.between(fechaNacimiento, fechaActual).getYears();
        return edad > 60;
    }
}
