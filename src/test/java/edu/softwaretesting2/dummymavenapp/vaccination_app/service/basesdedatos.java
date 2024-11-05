package edu.softwaretesting2.dummymavenapp.vaccination_app.service;

import edu.softwaretesting2.dummymavenapp.vaccination_app.model.Basededatos;
import edu.softwaretesting2.dummymavenapp.vaccination_app.model.Paciente;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class basesdedatos{
    private Basededatos baseDeDatos;

    @Before
    public void setUp() {
        baseDeDatos = new BaseDeDatosPacientes();
    }

    @Test
    public void testAgregarPaciente() {
        Paciente paciente = new Paciente("Juan Pérez", 30, "Masculino", "123456789", "Calle Falsa 123");
        baseDeDatos.agregarPaciente(paciente);
        assertEquals(1, baseDeDatos.mostrarPacientes().size()); // Ajuste necesario para obtener el tamaño de la lista
    }

    @Test
    public void testBuscarPacientePorNombre() {
        Paciente paciente = new Paciente("María Gómez", 25, "Femenino", "987654321", "Calle Verdadera 456");
        baseDeDatos.agregarPaciente(paciente);
        assertNotNull(baseDeDatos.buscarPacientePorNombre("María Gómez"));
        assertNull(baseDeDatos.buscarPacientePorNombre("No Existente"));
    }

    @Test
    public void testEliminarPaciente() {
        Paciente paciente = new Paciente("Juan Pérez", 30, "Masculino", "123456789", "Calle Falsa 123");
        baseDeDatos.agregarPaciente(paciente);
        assertTrue(baseDeDatos.eliminarPaciente("Juan Pérez"));
        assertFalse(baseDeDatos.eliminarPaciente("No Existente"));
    }
}