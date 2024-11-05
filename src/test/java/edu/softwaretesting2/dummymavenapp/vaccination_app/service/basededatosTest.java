

package edu.softwaretesting2.dummymavenapp.vaccination_app.service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import edu.softwaretesting2.dummymavenapp.vaccination_app.model.Paciente;
import edu.softwaretesting2.dummymavenapp.vaccination_app.model.Basededatos;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BasededatosTest {
    private Basededatos baseDeDatos; // Nombre corregido a Basededatos

    @BeforeEach
    void setUp() {
        baseDeDatos = new Basededatos(); // Inicializa la base de datos
    }

    @Test
    public void testAgregarPaciente() {
        Paciente paciente = new Paciente("Juan Pérez", LocalDate.of(1993, 5, 15), false, 30);
        baseDeDatos.agregarPaciente(paciente);
        assertEquals(1, baseDeDatos.mostrarPacientes().size(), "Debería haber un paciente en la base de datos.");
    }

    @Test
    public void testBuscarPacientePorNombre() {
        Paciente paciente = new Paciente("María Gómez", LocalDate.of(1998, 4, 10), true, 25);
        baseDeDatos.agregarPaciente(paciente);
        assertNotNull(baseDeDatos.buscarPacientePorNombre("María Gómez"), "El paciente debería existir.");
        assertNull(baseDeDatos.buscarPacientePorNombre("No Existente"), "El paciente no debería existir.");
    }

    @Test
    public void testEliminarPaciente() {
        Paciente paciente = new Paciente("Juan Pérez", LocalDate.of(1990, 2, 20), false, 33);
        baseDeDatos.agregarPaciente(paciente);
        assertTrue(baseDeDatos.eliminarPaciente("Juan Pérez"), "Debería eliminar al paciente.");
        assertFalse(baseDeDatos.eliminarPaciente("No Existente"), "No debería eliminar un paciente que no existe.");
    }
}
