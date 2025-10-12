package universidad;

public class Curso {
    private String codigo;
    private String nombre;
    private Profesor profesor;

    public Curso(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public Profesor getProfesor() { return profesor; }

    public void setProfesor(Profesor p) {
        if (this.profesor == p) return;

        if (this.profesor != null) {
            Profesor anterior = this.profesor;
            this.profesor = null;
            anterior.getCursos().remove(this);
        }

        this.profesor = p;
        if (p != null && !p.getCursos().contains(this)) {
            p.getCursos().add(this);
        }
    }

    public void mostrarInfo() {
        String prof = (profesor == null) ? "SIN ASIGNAR" : profesor.getNombre();
        System.out.printf("Curso{codigo='%s', nombre='%s', profesor='%s'}%n", codigo, nombre, prof);
    }
}
