package edu.softwaretesting2.dummymavenapp.vaccination_app.service;

import edu.softwaretesting2.dummymavenapp.vaccination_app.model.Paciente;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class VacunacionServiceTest {

    Paciente persona1;
    Paciente personaPrioritaria;
    boolean respuesta;
    VacunacionService servicio;

    @BeforeAll
    void init() {
        persona1 = new Paciente("NN", LocalDate.of(1986, 12, 24));
        personaPrioritaria = new Paciente("Bla", LocalDate.of(1963, 12, 24));
        servicio = new VacunacionService();
    }

    @BeforeEach
    void setUp() {
       
    }

    @Test
    public void deberíaAsignarMaximo40PersonasParaUnDía() {
        // GIVEN
        List<Paciente> pacientes = generarPacientes(50); // Generamos 50 pacientes

        // WHEN
        List<Paciente> pacientesAsignados = servicio.asignarCitasDiarias(pacientes);

        // THEN
        Assertions.assertEquals(40, pacientesAsignados.size(), "Debe asignar máximo 40 personas por día");
    }

    @Test
    public void deberíaDefinirComoPriotitariaAUnaPersonaDeMasDe60Años() {
        // GIVEN
        LocalDate fechaActual = LocalDate.now();

        // WHEN
        boolean respuesta = servicio.validarLaEdadDelPaciente(personaPrioritaria);

        // THEN
        Assertions.assertTrue(respuesta, "Una persona mayor de 60 años debe ser prioritaria");
    }

    // Método para generar una lista de pacientes
    private List<Paciente> generarPacientes(int cantidad) {
        List<Paciente> pacientes = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            pacientes.add(new Paciente("Paciente" + i, LocalDate.of(1990, 1, 1).plusDays(i)));
        }
        return pacientes;
    }
}
