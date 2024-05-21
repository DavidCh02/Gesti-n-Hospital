abstract class Persona {
    private String nombre;
    private String identificacion;
    private String ubicacion;

    public Persona(String nombre, String identificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.ubicacion = "Hospital";
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }
}
