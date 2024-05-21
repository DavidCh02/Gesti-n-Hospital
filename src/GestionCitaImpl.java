class GestionCitaImpl implements GestionCita {
    @Override
    public void programarCita(CitaMedica cita) {
        System.out.println("Cita programada: " + cita);
    }


    @Override
    public void cancelarCita(CitaMedica cita) {
        System.out.println("Cita cancelada: " + cita);
    }

    @Override
    public void realizarCita(CitaMedica cita) {
        System.out.println("Cita realizada: " + cita);
    }

}