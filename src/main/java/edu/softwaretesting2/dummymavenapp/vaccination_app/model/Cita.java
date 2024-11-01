package edu.softwaretesting2.dummymavenapp.vaccination_app.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cita {
private Paciente paciente;
    private LocalDate fechaProgramada;
    private LocalDate fechaRealizada;

    public Cita(Paciente paciente, LocalDate fechaProgramada) {
        this.paciente = paciente;
        this.fechaProgramada = fechaProgramada;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public LocalDate getFechaProgramada() {
        return fechaProgramada;
    }

    public LocalDate getFechaRealizada() {
        return fechaRealizada;
    }

    public void registrarVacunacion(LocalDate fechaRealizada) {
        this.fechaRealizada = fechaRealizada;
    }

    public static void agendarCita(Cita cita) {
        citas.add(cita);
    }

    public static Cita obtenerCita(Paciente paciente) {
        return citas.stream()
                    .filter(c -> c.getPaciente().equals(paciente))
                    .findFirst()
                    .orElse(null);
    }

    public static void cancelarCita(Paciente paciente) {
        citas.removeIf(c -> c.getPaciente().equals(paciente));
    }

    public static void reasignarCita(Paciente paciente, LocalDate nuevaFecha) {
        Cita cita = obtenerCita(paciente);
        if (cita != null) {
            cita.fechaProgramada = nuevaFecha;
        }
    }

    public static List<Cita> listarCitas() {
        return new ArrayList<>(citas);
    }

}
