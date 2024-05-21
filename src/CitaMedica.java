class CitaMedica {
    //Atributos
    private Doctor nombreDoctor;
    private Paciente nombrePaciente;
    private String fechaHora;
    private String estadoCita;
    private String motivoCita;
    private final int ContadorCitas = 0;

    //Constructor
    public CitaMedica(Doctor nombreDoctor, Paciente nombrePaciente, String fechaHora) {
        this.nombreDoctor = nombreDoctor;
        this.nombrePaciente = nombrePaciente;
        this.fechaHora = fechaHora;
        this.estadoCita = "Programada";
        this.motivoCita = "Consulta General";

    }
    //Metodos
    public void asignarCita(Doctor doctor, Paciente paciente, String fechaHora) {
        this.nombreDoctor = doctor;
        this.nombrePaciente = paciente;
        this.fechaHora = fechaHora;
        this.estadoCita = "Programada";
        this.motivoCita = "Consulta General";

    }

    @Override
    public String toString() {
        return "CitaMedica{" +
                "doctor=" + nombreDoctor.getNombre() +
                ", paciente=" + nombrePaciente.getNombre() +
                ", fechaHora='" + fechaHora + '\'' +
                '}';
    }

    public Persona getNombrePaciente() {
        return nombrePaciente;

    }
}