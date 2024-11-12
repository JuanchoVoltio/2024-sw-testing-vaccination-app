package edu.softwaretesting2.dummymavenapp.vaccination_app.database;

import edu.softwaretesting2.dummymavenapp.vaccination_app.model.Paciente;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DatabaseTest {


    Database database;
    @BeforeAll
    void init() {
       database = new Database();
    }

    @BeforeEach
    void setUp() {
    }

    @Test
    public void pruebaCrearPaciente() {
        //GIVEN
        Paciente paciente = new Paciente(100, "Falcao Garcia", LocalDate.of(1963, 12, 24));

        //WHEN
        boolean respuesta = database.agregarPaciente(paciente);
        //THEN
        Assertions.assertTrue(respuesta);
    }

    @Test
    public void pruebaBuscarPacientesPorNombre() {
        //GIVEN
        String nombrePaciente = "J";

        //WHEN
        List<Paciente> resultList = database.buscarPacientesPorNombre(nombrePaciente);
        //THEN
        Assertions.assertFalse(resultList.isEmpty());
    }

    @Test
    public void pruebaBuscarPacientesPorId() {
        //GIVEN
        int idPaciente = 5;
        //WHEN
        Paciente result = database.buscarPacientePorId(idPaciente);
        //THEN
        Assertions.assertNotNull(result);
    }

    @Test
    public void pruebaBuscarPacientesPorPrioridad() {
        //GIVEN
        boolean prioridad = false;

        //WHEN
        List<Paciente> resultList = database.buscarPacientePorPrioridad(prioridad);
        //THEN
        Assertions.assertFalse(resultList.isEmpty());
    }

    @Test
    public void pruebaEditarPaciente() {
        //GIVEN
        Paciente paciente =  new Paciente(3, "Fabian Guayacan",LocalDate.of(1963, 12, 24));

        //WHEN
        boolean result = database.editarPaciente(paciente.getId(), paciente);
        //THEN
        Assertions.assertTrue(result);
    }

    @Test
    public void pruebaEliminarPaciente() {
        //GIVEN
        int id = 9;

        //WHEN
        boolean result = database.eliminarPaciente(id);
        //THEN
        Assertions.assertTrue(result);
    }
}