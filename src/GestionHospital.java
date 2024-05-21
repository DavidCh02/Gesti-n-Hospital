import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionHospital {

    private static final List<Doctor> doctores = new ArrayList<>();
    private static final List<Paciente> pacientes = new ArrayList<>();
    private static final List<CitaMedica> citas = new ArrayList<>();
    private static final GestionCita gestionCita = new GestionCitaImpl();

    public static void main(String[] args) {
        // Inicializar algunos datos
        inicializarDatos();

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    programarCita(scanner);
                    break;
                case 2:
                    cancelarCita(scanner);
                    break;
                case 3:
                    realizarCita(scanner);
                    break;
                case 4:
                    listarCitas();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intenta de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }

    private static void inicializarDatos() {
        // Crear algunos doctores y pacientes de ejemplo
        doctores.add(new Doctor("Dr. Juan", "D001", Especialidad.CARDIOLOGIA));
        doctores.add(new Doctor("Dra. Maria", "D002", Especialidad.PEDIATRIA));

        pacientes.add(new Paciente("Maria Perez", "P001"));
        pacientes.add(new Paciente("Juan Lopez", "P002"));
    }

    private static void mostrarMenu() {
        System.out.println("\nSistema de Gestión del Hospital");
        System.out.println("1. Programar Cita");
        System.out.println("2. Cancelar Cita");
        System.out.println("3. Realizar Cita");
        System.out.println("4. Listar Citas");
        System.out.println("5. Salir");
        System.out.print("Selecciona una opción: ");
    }

    private static void programarCita(Scanner scanner) {
        System.out.println("\nProgramar Cita");
        System.out.print("Ingrese ID del Doctor: ");
        String idDoctor = scanner.nextLine();
        System.out.print("Ingrese ID del Paciente: ");
        String idPaciente = scanner.nextLine();
        System.out.print("Ingrese Fecha y Hora (YYYY-MM-DD HH:MM): ");
        String fechaHora = scanner.nextLine();

        Doctor doctor = buscarDoctorPorId(idDoctor);
        Paciente paciente = buscarPacientePorId(idPaciente);

        if (doctor != null && paciente != null) {
            CitaMedica cita = new CitaMedica(doctor, paciente, fechaHora);
            citas.add(cita);
            gestionCita.programarCita(cita);
        } else {
            System.out.println("Doctor o Paciente no encontrado.");
        }
    }

    private static void cancelarCita(Scanner scanner) {
        System.out.println("\nCancelar Cita");
        System.out.print("Ingrese ID del Paciente: ");
        String idPaciente = scanner.nextLine();
        CitaMedica cita = buscarCitaPorPaciente(idPaciente);
        if (cita != null) {
            gestionCita.cancelarCita(cita);
            citas.remove(cita);
        } else {
            System.out.println("Cita no encontrada.");
        }
    }

    private static void realizarCita(Scanner scanner) {
        System.out.println("\nRealizar Cita");
        System.out.print("Ingrese ID del Paciente: ");
        String idPaciente = scanner.nextLine();
        CitaMedica cita = buscarCitaPorPaciente(idPaciente);
        if (cita != null) {
            gestionCita.realizarCita(cita);
            citas.remove(cita);
        } else {
            System.out.println("Cita no encontrada.");
        }
    }

    private static void listarCitas() {
        System.out.println("\nListado de Citas");
        for (CitaMedica cita : citas) {
            System.out.println(cita);
        }
    }

    private static Doctor buscarDoctorPorId(String id) {
        for (Doctor doctor : doctores) {
            if (doctor.getIdentificacion().equals(id)) {
                return doctor;
            }
        }
        return null;
    }

    private static Paciente buscarPacientePorId(String id) {
        for (Paciente paciente : pacientes) {
            if (paciente.getIdentificacion().equals(id)) {
                return paciente;
            }
        }
        return null;
    }

    private static CitaMedica buscarCitaPorPaciente(String idPaciente) {
        for (CitaMedica cita : citas) {
            if (cita.getNombrePaciente().getIdentificacion().equals(idPaciente)) {
                return cita;
            }
        }
        return null;
    }
}
