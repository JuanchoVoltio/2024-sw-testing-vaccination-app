package edu.softwaretesting2.dummymavenapp.vaccination_app.service;

import edu.softwaretesting2.dummymavenapp.vaccination_app.model.Paciente;
import org.junit.jupiter.api.*;


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

@Test
    public void testAgregarPaciente() {
        Paciente paciente = new Paciente("Juan Perez", LocalDate.of(1950, 1, 1));
        Paciente.agregarPaciente(paciente);
        
        assertEquals(1, Paciente.listarPacientes().size());
        assertEquals("Juan Perez", Paciente.listarPacientes().get(0).getNombre());
    }

    @Test
    public void testObtenerPaciente() {
        Paciente paciente = new Paciente("Maria Gomez", LocalDate.of(1980, 5, 20));
        Paciente.agregarPaciente(paciente);

        Paciente encontrado = Paciente.obtenerPaciente("Maria Gomez");
        assertNotNull(encontrado);
        assertEquals("Maria Gomez", encontrado.getNombre());
    }

@Test
    public void testActualizarPaciente() {
        Paciente paciente = new Paciente("Carlos Lopez", LocalDate.of(1990, 3, 15));
        Paciente.agregarPaciente(paciente);

        LocalDate nuevaFechaNacimiento = LocalDate.of(1955, 3, 15);
        Paciente.actualizarPaciente("Carlos Lopez", nuevaFechaNacimiento);

        Paciente actualizado = Paciente.obtenerPaciente("Carlos Lopez");
        assertNotNull(actualizado);
        assertTrue(actualizado.esPrioritario(), "Debería ser prioritario después de la actualización de edad");
    }

    @Test
    public void testEliminarPaciente() {
        Paciente paciente = new Paciente("Luis Morales", LocalDate.of(1975, 7, 10));
        Paciente.agregarPaciente(paciente);

        Paciente.eliminarPaciente("Luis Morales");
        assertNull(Paciente.obtenerPaciente("Luis Morales"));
        assertEquals(0, Paciente.listarPacientes().size());
    }
}
