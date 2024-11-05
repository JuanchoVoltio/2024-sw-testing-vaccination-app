package edu.softwaretesting2.dummymavenapp.vaccination_app.model;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class citar {
    private List<Cita> citas;

    public citar(){
        citas = new ArrayList<>(); 
    }

    public void agendarCitas(pacientec listaPacientes) {
        
        List<Paciente> pacientesOrdenados = new ArrayList<>(listaPacientes.listarPacientes());
        pacientesOrdenados.sort(Comparator.comparing(Paciente::esPrioritario).reversed());

        LocalDate fechaActual = LocalDate.now();
        int pacientesDiarios = 0;
        int maxPacientesPorDia = 40;

        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresar la sede para las citas: ");
        String sede = sc.nextLine(); 

        for (Paciente paciente : pacientesOrdenados) {
            if (pacientesDiarios >= maxPacientesPorDia) {
                fechaActual = fechaActual.plusDays(1);
                pacientesDiarios = 0;
            }

            String diaSemana;
        switch (fechaActual.getDayOfWeek()) {
            case MONDAY:    diaSemana = "Lunes"; break;
            case TUESDAY:   diaSemana = "Martes"; break;
            case WEDNESDAY: diaSemana = "Miércoles"; break;
            case THURSDAY:  diaSemana = "Jueves"; break;
            case FRIDAY:    diaSemana = "Viernes"; break;
            case SATURDAY:  diaSemana = "Sábado"; break;
            case SUNDAY:    diaSemana = "Domingo"; break;
            default:        diaSemana = "";
        }

            Cita nuevaCita = new Cita(paciente.getNombre(), fechaActual, diaSemana, sede);
            nuevaCita.setPrioritario(paciente.esPrioritario());
            citas.add(nuevaCita);
            pacientesDiarios++;
        }
        System.out.println("Citas de esta semana agendadas con éxito!");
        mostrarMenuCitar();
    }

    public void citasAgendadas() {
        if (citas.isEmpty()) {
            System.out.println("No hay citas agendadas de momento");
        } else {
            listarCitas();
        }
    }

    public Optional<Cita> buscarCita(String nombrePaciente) {
        return citas.stream()
            .filter(c -> c.getNombre().equalsIgnoreCase(nombrePaciente))
            .findFirst();
    }

    public boolean actualizarCita(String nombrePaciente, LocalDate nuevaFecha, String nuevaSede) {
        Optional<Cita> citaOpt = buscarCita(nombrePaciente);
        if (citaOpt.isPresent()) {
            Cita cita = citaOpt.get();
            cita.setFechaDeCita(nuevaFecha);
            cita.setSede(nuevaSede);
            System.out.println("Cita actualizada con éxito!");
            return true;
        } else {
            System.out.println("El paciente no tiene ninguna cita asignada");
            return false;
        }
    }

    public boolean eliminarCita(String nombrePaciente) {
        return citas.removeIf(c -> c.getNombre().equalsIgnoreCase(nombrePaciente)); 
    }

    public void listarCitas() {
        if (citas.isEmpty()) {
            System.out.println("No hay citas agendadas.");
        } else {
            for (Cita cita : citas) {
                System.out.println("Nombre: " + cita.getNombre() +
                        ", Fecha de Cita: " + cita.getFechaDeCita() +
                        ", Día de la Semana: " + cita.getDiaSemana() +
                        ", Sede: " + cita.getSede() +
                        ", Prioritario: " + (cita.esPrioritario() ? "Sí" : "No"));
            }
        }
    }

    public void descargarCitas(String nombreArchivo) {
        // Obtener la ruta del directorio actual
        String rutaArchivo = System.getProperty("user.dir") + "/" + nombreArchivo;
    
        try (FileWriter fileWriter = new FileWriter(rutaArchivo)) {
            fileWriter.append("Nombre, Fecha de Cita, Día de la Semana, Sede, Prioritario\n");
    
            for (Cita cita : citas) {
                fileWriter.append(cita.getNombre()).append(",");
                fileWriter.append(cita.getFechaDeCita().toString()).append(",");
                fileWriter.append(cita.getDiaSemana()).append(",");
                fileWriter.append(cita.getSede()).append(",");
                fileWriter.append(cita.esPrioritario() ? "Sí" : "No").append("\n");
            }
    
            System.out.println("Citas exportadas exitosamente en " + rutaArchivo);
        } catch (IOException e) {
            System.out.println("Error al exportar las citas: " + e.getMessage());
        }
    }

    public void mostrarMenuCitar() {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- Menú de Citas ---");
            System.out.println("1. Listar citas agendadas");
            System.out.println("2. Buscar cita por nombre");
            System.out.println("3. Actualizar cita");
            System.out.println("4. Eliminar cita");
            System.out.println("5. Exportar citas a Excel");
            System.out.println("6. Salir al menú principal");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    listarCitas();
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del paciente: ");
                    String nombrePaciente = sc.nextLine();
                    buscarCita(nombrePaciente).ifPresentOrElse(
                        cita -> System.out.println("Cita encontrada: " + cita),
                        () -> System.out.println("Cita no encontrada.")
                    );
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del paciente: ");
                    String nombreParaActualizar = sc.nextLine();
                    System.out.print("Ingrese la nueva fecha (YYYY-MM-DD): ");
                    LocalDate nuevaFecha = LocalDate.parse(sc.nextLine());
                    System.out.print("Ingrese la nueva sede: ");
                    String nuevaSede = sc.nextLine();
                    actualizarCita(nombreParaActualizar, nuevaFecha, nuevaSede);
                    break;
                case 4:
                    System.out.print("Ingrese el nombre del paciente para eliminar la cita: ");
                    String nombreParaEliminar = sc.nextLine();
                    if (eliminarCita(nombreParaEliminar)) {
                        System.out.println("Cita eliminada con éxito.");
                    } else {
                        System.out.println("No se encontró la cita para el paciente.");
                    }
                    break;
                case 5:
                    descargarCitas("citas.xlsx");
                    break;
                case 6:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
        sc.close();
    }
}
