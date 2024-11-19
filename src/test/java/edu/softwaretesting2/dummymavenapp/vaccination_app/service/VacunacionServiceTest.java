package edu.softwaretesting2.dummymavenapp.vaccination_app.service;

import edu.softwaretesting2.dummymavenapp.vaccination_app.model.Paciente;
import org.junit.jupiter.api.*;


import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


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
    public void testAgregarPacienteValido() {
        Paciente paciente = new Paciente("Juan Perez", LocalDate.of(1960, 5, 10));
        Paciente.agregarPaciente(paciente);

        assertEquals(1, Paciente.listarPacientes().size());
        assertEquals("Juan Perez", Paciente.listarPacientes().get(0).getNombre());
    }
    
    @Test
    public void testAgregarPacienteNombreVacio() {
        Paciente paciente = new Paciente("", LocalDate.of(1980, 3, 15));
        Paciente.agregarPaciente(paciente);

        assertEquals(1, Paciente.listarPacientes().size());
        assertEquals("", Paciente.listarPacientes().get(0).getNombre());
    }
    
    @Test
    public void testAgregarPacienteFechaNacimientoFutura() {
        Paciente paciente = new Paciente("Pedro Gómez", LocalDate.now().plusDays(1));
        Paciente.agregarPaciente(paciente);

        assertEquals(1, Paciente.listarPacientes().size());
        assertEquals("Pedro Gómez", Paciente.listarPacientes().get(0).getNombre());
    }
    
    @Test
    public void testAgregarPacienteDuplicado() {
        Paciente paciente = new Paciente("Maria Gomez", LocalDate.of(1980, 3, 15));
        Paciente.agregarPaciente(paciente);
        Paciente.agregarPaciente(paciente);

        assertEquals(1, Paciente.listarPacientes().size(), "No se deben permitir duplicados");
    }
    
    @Test
    public void testObtenerPacienteExistente() {
        Paciente paciente = new Paciente("Carlos Lopez", LocalDate.of(1990, 6, 20));
        Paciente.agregarPaciente(paciente);

        Paciente encontrado = Paciente.obtenerPaciente("Carlos Lopez");
        assertNotNull(encontrado);
        assertEquals("Carlos Lopez", encontrado.getNombre());
    }
    
    @Test
    public void testObtenerPacienteInexistente() {
        Paciente encontrado = Paciente.obtenerPaciente("Nombre Inexistente");
        assertNull(encontrado, "No se debe encontrar un paciente que no existe");
    }
    
    @Test
    public void testObtenerPacienteConMayusculas() {
        Paciente paciente = new Paciente("Luis Martínez", LocalDate.of(1990, 6, 20));
        Paciente.agregarPaciente(paciente);

        Paciente encontrado = Paciente.obtenerPaciente("LUIS MARTÍNEZ");
        assertNull(encontrado, "El método es sensible a mayúsculas/minúsculas");
    }
    
    @Test
    public void testObtenerPacienteListaVacia() {
        Paciente encontrado = Paciente.obtenerPaciente("Cualquier Nombre");
        assertNull(encontrado, "No se debe encontrar ningún paciente si la lista está vacía");
    }
    
    @Test
    public void testActualizarPacientePrioridad() {
        Paciente paciente = new Paciente("Luis Morales", LocalDate.of(1980, 2, 1));
        Paciente.agregarPaciente(paciente);

        Paciente.actualizarPaciente("Luis Morales", LocalDate.of(1950, 1, 1));

        Paciente actualizado = Paciente.obtenerPaciente("Luis Morales");
        assertNotNull(actualizado);
        assertTrue(actualizado.esPrioritario(), "El paciente debería ser prioritario después de la actualización");
    }
    
    
    @Test
    public void testActualizarPacienteNoPrioridad() {
        Paciente paciente = new Paciente("Ana Gómez", LocalDate.of(1940, 1, 1));
        Paciente.agregarPaciente(paciente);

        Paciente.actualizarPaciente("Ana Gómez", LocalDate.of(1990, 1, 1));

        Paciente actualizado = Paciente.obtenerPaciente("Ana Gómez");
        assertNotNull(actualizado);
        assertFalse(actualizado.esPrioritario(), "El paciente no debería ser prioritario después de la actualización");
    }
    
    @Test
    public void testActualizarPacienteInexistente() {
        Paciente.actualizarPaciente("Nombre Inexistente", LocalDate.of(1950, 1, 1));
        assertEquals(0, Paciente.listarPacientes().size(), "No debe haber cambios si el paciente no existe");
    }
    
    @Test
    public void testActualizarPacienteFechaInvalida() {
        Paciente paciente = new Paciente("Mario Ruiz", LocalDate.of(1980, 5, 10));
        Paciente.agregarPaciente(paciente);

        Paciente.actualizarPaciente("Mario Ruiz", LocalDate.now().plusDays(1));

        Paciente actualizado = Paciente.obtenerPaciente("Mario Ruiz");
        assertEquals(LocalDate.now().plusDays(1), actualizado.getFechaDeNacimiento());
    }
    
    @Test
    public void testEliminarPacienteExistente() {
        Paciente paciente = new Paciente("Ana Lopez", LocalDate.of(1975, 10, 5));
        Paciente.agregarPaciente(paciente);

        Paciente.eliminarPaciente("Ana Lopez");

        assertNull(Paciente.obtenerPaciente("Ana Lopez"));
        assertEquals(0, Paciente.listarPacientes().size());
    }

    @Test
    public void testEliminarPacienteInexistente() {
        Paciente paciente = new Paciente("Jose Garcia", LocalDate.of(1995, 8, 20));
        Paciente.agregarPaciente(paciente);

        Paciente.eliminarPaciente("Nombre Inexistente");

        assertEquals(1, Paciente.listarPacientes().size(), "No debe eliminarse un paciente inexistente");
    }
    
    @Test
    public void testEliminarPacienteListaVacia() {
        Paciente.eliminarPaciente("Cualquier Nombre");
        assertEquals(0, Paciente.listarPacientes().size(), "No debe ocurrir ningún cambio si la lista está vacía");
    }
    
    @Test
    public void testListarPacientesConElementos() {
        Paciente.agregarPaciente(new Paciente("Juan", LocalDate.of(1990, 1, 1)));
        Paciente.agregarPaciente(new Paciente("Maria", LocalDate.of(1985, 6, 10)));

        List<Paciente> pacientes = Paciente.listarPacientes();
        assertEquals(2, pacientes.size());
    }
    
    @Test
    public void testListarPacientesVacia() {
        List<Paciente> pacientes = Paciente.listarPacientes();
        assertEquals(0, pacientes.size(), "La lista debería estar vacía");
    }
    
    @Test
    public void testListarPacientesDespuesDeEliminar() {
        Paciente.agregarPaciente(new Paciente("Juan", LocalDate.of(1990, 1, 1)));
        Paciente.eliminarPaciente("Juan");

        List<Paciente> pacientes = Paciente.listarPacientes();
        assertEquals(0, pacientes.size(), "La lista debería estar vacía después de eliminar todos los pacientes");
    }
    
    
}
