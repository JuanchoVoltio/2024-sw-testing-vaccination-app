package edu.softwaretesting2.dummymavenapp.vaccination_app.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import edu.softwaretesting2.dummymavenapp.vaccination_app.service.VacunacionService;

public class pacientec {
    private List<Paciente> pacientes;
    private VacunacionService vacunacionService;
    private citar Citar;

    public pacientec() {
        pacientes = new ArrayList<>();
        vacunacionService = new VacunacionService();
    }

    public void crearpacientes(String nombre, LocalDate fechaDeNacimiento) {
        Paciente nuevoPaciente = new Paciente(nombre, fechaDeNacimiento);
        pacientes.add(nuevoPaciente);

        System.out.println("\nPaciente agregado con éxito");
        System.out.println("El paciente agregado nuevo es: " + nombre);
    }

    public Optional<Paciente> BuscarPacientes(String nombre) {
        Optional<Paciente> pacienteOpt = pacientes.stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombre))
                .findFirst();

        if (pacienteOpt.isPresent()) {
            Paciente paciente = pacienteOpt.get();
            boolean esPrioritario = vacunacionService.validarLaEdadDelPaciente(paciente);
            System.out.println("Paciente encontrado: " + paciente.getNombre() + ", Fecha de Nacimiento: " +
                    paciente.getFechaDeNacimiento() + ", Prioritario: " + (esPrioritario ? "Sí" : "No"));
        } else {
            System.out.println("Paciente no encontrado.");
        }

        return pacienteOpt;
    }

    public boolean actualizarPaciente(String nombre, String nuevoNombre, LocalDate nuevaFechaDeNacimiento) {
        Optional<Paciente> pacienteOpt = BuscarPacientes(nombre);
        if (pacienteOpt.isPresent()) {
            Paciente paciente = pacienteOpt.get();
            paciente.setNombre(nuevoNombre);
            paciente.setFechaDeNacimiento(nuevaFechaDeNacimiento);
            System.out.println("Se actualizaron los datos del paciente: " + nuevoNombre);
            return true;
        }
        return false;
    }

    public boolean eliminarPaciente(String nombre) {
        System.out.println("El paciente se borró con éxito");
        return pacientes.removeIf(p -> p.getNombre().equalsIgnoreCase(nombre));
    }

    public List<Paciente> listarPacientes() {
        return new ArrayList<>(pacientes);
    }

    public void generarPacientesAutomáticamente(int cantidad) {
        for (int i = 1; i <= cantidad; i++) {
            String nombre = "Paciente" + i;
            LocalDate fechaDeNacimiento = LocalDate.of(
                    1950 + (int) (Math.random() * 50),
                    1 + (int) (Math.random() * 12),
                    1 + (int) (Math.random() * 28)
            );

            crearpacientes(nombre, fechaDeNacimiento);
        }

        System.out.println(cantidad + " pacientes generados automáticamente.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        pacientec pacientep = new pacientec();
        citar cita = new citar();
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- Menú de Pacientes ---");
            System.out.println("1. Crear nuevo paciente");
            System.out.println("2. Buscar paciente por nombre");
            System.out.println("3. Actualizar paciente");
            System.out.println("4. Eliminar paciente");
            System.out.println("5. Listar todos los pacientes");
            System.out.println("6. Generar pacientes automáticamente");
            System.out.println("7. Agendar citas");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del paciente: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el año de nacimiento (yyyy): ");
                    int anio = scanner.nextInt();
                    System.out.print("Ingrese el mes de nacimiento (mm): ");
                    int mes = scanner.nextInt();
                    System.out.print("Ingrese el día de nacimiento (dd): ");
                    int dia = scanner.nextInt();
                    pacientep.crearpacientes(nombre, LocalDate.of(anio, mes, dia));
                    break;

                case 2:
                    System.out.print("Ingrese el nombre del paciente a buscar: ");
                    nombre = scanner.nextLine();
                    pacientep.BuscarPacientes(nombre);
                    break;

                case 3:
                    System.out.print("Ingrese el nombre del paciente a actualizar: ");
                    nombre = scanner.nextLine();
                    System.out.print("Ingrese el nuevo nombre: ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.print("Ingrese el nuevo año de nacimiento (yyyy): ");
                    anio = scanner.nextInt();
                    System.out.print("Ingrese el nuevo mes de nacimiento (mm): ");
                    mes = scanner.nextInt();
                    System.out.print("Ingrese el nuevo día de nacimiento (dd): ");
                    dia = scanner.nextInt();
                    pacientep.actualizarPaciente(nombre, nuevoNombre, LocalDate.of(anio, mes, dia));
                    break;

                case 4:
                    System.out.print("Ingrese el nombre del paciente a eliminar: ");
                    nombre = scanner.nextLine();
                    pacientep.eliminarPaciente(nombre);
                    break;

                case 5:
                    List<Paciente> listaPacientes = pacientep.listarPacientes();
                    if (listaPacientes.isEmpty()) {
                        System.out.println("No hay pacientes registrados.");
                    } else {
                        System.out.println("Lista de pacientes:");
                        listaPacientes.forEach(p -> System.out.println("Nombre: " + p.getNombre() +
                                ", Fecha de Nacimiento: " + p.getFechaDeNacimiento()));
                    }
                    break;

                case 6:
                    System.out.print("Ingrese el número de pacientes a generar automáticamente: ");
                    int cantidad = scanner.nextInt();
                    pacientep.generarPacientesAutomáticamente(cantidad);
                    break;

                case 7:
                    cita.agendarCitas(pacientep);
                    break;
                case 8:
                    continuar = false;
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
        scanner.close();
    }
}

