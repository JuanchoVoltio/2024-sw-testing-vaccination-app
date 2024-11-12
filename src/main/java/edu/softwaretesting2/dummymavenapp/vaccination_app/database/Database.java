package edu.softwaretesting2.dummymavenapp.vaccination_app.database;

import edu.softwaretesting2.dummymavenapp.vaccination_app.model.Cita;
import edu.softwaretesting2.dummymavenapp.vaccination_app.model.Paciente;

import java.time.LocalDate;
import java.util.*;

public class Database {

    private List<Paciente> pacientes = new ArrayList<>();

    public Database() {
        this.pacientes = new ArrayList<>(Arrays.asList(
                new Paciente(1,"Lionel Messi", LocalDate.of(1960, 12, 24)),
                new Paciente(2,"Walter White", LocalDate.of(2000, 1, 10)),
                new Paciente(3,"Cristiano Ronaldo", LocalDate.of(1999, 10, 5)),
                new Paciente(4,"Edwin Luqque", LocalDate.of(1954, 8, 5)),
                new Paciente(5,"John Muñoz", LocalDate.of(1956, 9, 27)),
                new Paciente(6,"Fabian Guayacan", LocalDate.of(1980, 10, 31)),
                new Paciente(7,"Juliana Rodriguez", LocalDate.of(2001, 7, 12)),
                new Paciente(8,"Valeria Dominguez", LocalDate.of(1998, 12, 8)),
                new Paciente(9,"Mariana Pajon", LocalDate.of(1949, 12, 24))
        ));
    }

    //Create

    /**
     * Metodo para crear paciente
     * @param nuevoPaciente nuevo paciente para insertar a la lista
     * @return boolean si retorna true se guardo, si retorna en false hubo un error o no se pudo guardar
     */
    public boolean agregarPaciente(Paciente nuevoPaciente){
        if (nuevoPaciente != null && buscarPacientePorId(nuevoPaciente.getId()) == null) {
          pacientes.add(nuevoPaciente);
          System.out.println("Se ha registrado correctamente el siguiente usuario: "+nuevoPaciente);
          return true;
        } else {
            System.out.println("No se pudo registrar el usuario");
            return false;
        }
    }

    /**
     * Metodo para buscar los pacientes por nombre
     * @param nombre Recibe un String con el nombre para poder filtrar
     * @return Retorna una lista con el resultado obtenido si retorna vacio significa que no encontro nada con el
     * parametro dado
     */
    //Read
    public List<Paciente> buscarPacientesPorNombre(String nombre) {
        List<Paciente> listaBusqueda = new ArrayList<Paciente>();
        if (nombre != null && !nombre.isEmpty()) {
            pacientes.forEach(paciente -> {
                if (paciente.getNombre().contains(nombre)) {
                    listaBusqueda.add(paciente);
                }
            });
            System.out.println("listaBusqueda = " + listaBusqueda);
            return listaBusqueda;
        } else {
            System.out.println("Por favor llenar el campo nombre!!!");
            return List.of();
        }
    }

    //Read
    public Paciente buscarPacientePorId(int id) {
        for (Paciente paciente: pacientes) {
            if (paciente.getId() == id) {
                System.out.println("Se encontro el siguiente paciente: "+paciente);
                return paciente;
            }
        }
        System.out.println("No se encontro a ningun paciente");
        return null;
    }

    //Read
    public List<Paciente> buscarPacientePorPrioridad(boolean esPrioritario) {
        List<Paciente> listaBusqueda = new ArrayList<Paciente>();
            pacientes.forEach(paciente -> {
                if (paciente.esPrioritario() == esPrioritario) {
                    listaBusqueda.add(paciente);
                }
            });
        System.out.println("Se encontro los siguientes pacientes prioritarios = " + listaBusqueda);
        return listaBusqueda;
    }

    //Edit
    public boolean editarPaciente(int id, Paciente pacienteEditado) {
        for (Paciente paciente: pacientes) {
            if (paciente.getId() == id) {
                paciente = pacienteEditado;
                pacientes.get(id-1).setNombre(paciente.getNombre());
                pacientes.get(id-1).setFechaDeNacimiento(paciente.getFechaDeNacimiento());
                pacientes.get(id-1).setPrioritario(paciente.esPrioritario());
                System.out.println("paciente  actualizado = " + paciente);
                System.out.println("pacientes actualizado = " + pacientes);
                return true;
            }
        }
        return false;
    }

    //REMOVE
    public  boolean eliminarPaciente(int id){
        for (Paciente paciente: pacientes) {
            if (paciente.getId() == id) {
                pacientes.remove(paciente);
                System.out.println("paciente eliminado= " + paciente);
                System.out.println("pacientes = " + pacientes);
                return true;
            }
        }
        System.out.println("pacientes = " + pacientes);
        return false;
    }

}
