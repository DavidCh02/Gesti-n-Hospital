class Paciente extends Persona {
    private ExpedienteMedico expedienteMedico;
    private String identificacionPaciente;


    public Paciente(String nombre, String identificacion) {
        super(nombre, identificacion);
        this.expedienteMedico = new ExpedienteMedico();
    }

    public ExpedienteMedico getExpedienteMedico() {
        return expedienteMedico;
    }

}