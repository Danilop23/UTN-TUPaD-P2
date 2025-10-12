package biblioteca;

public class Autor {
    private String id;
    private String nombre;
    private String nacionalidad;

    public Autor(String id, String nombre, String nacionalidad) {
        this.id = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getNacionalidad() { return nacionalidad; }

    public void mostrarInfo() {
        System.out.printf("Autor{id='%s', nombre='%s', nacionalidad='%s'}%n", id, nombre, nacionalidad);
    }

    @Override
    public String toString() {
        return nombre + " (" + nacionalidad + ")";
    }
}
