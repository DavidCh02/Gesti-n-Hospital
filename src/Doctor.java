class Doctor extends Persona {
    private Especialidad especialidad;
    private String identificacionDoctor;


    public Doctor(String nombre, String identificacion, Especialidad especialidad) {
        super(nombre, identificacion);
        this.especialidad = especialidad;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }
}
