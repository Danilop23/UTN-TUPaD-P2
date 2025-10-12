package universidad;

import java.util.ArrayList;
import java.util.List;

public class Profesor {
    private String id;
    private String nombre;
    private String especialidad;
    private final List<Curso> cursos = new ArrayList<>();

    public Profesor(String id, String nombre, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public List<Curso> getCursos() { return cursos; }

    public void agregarCurso(Curso c) {
        if (!cursos.contains(c)) {
            cursos.add(c);
            if (c.getProfesor() != this) {
                c.setProfesor(this);
            }
        }
    }

    public void eliminarCurso(Curso c) {
        if (cursos.remove(c)) {
            if (c.getProfesor() == this) {
                c.setProfesor(null);
            }
        }
    }

    public void listarCursos() {
        if (cursos.isEmpty()) {
            System.out.println(nombre + " no dicta cursos.");
        } else {
            cursos.forEach(cur -> System.out.println(cur.getCodigo() + " - " + cur.getNombre()));
        }
    }

    public void mostrarInfo() {
        System.out.printf("Profesor{id='%s', nombre='%s', especialidad='%s', cursos=%d}%n",
                id, nombre, especialidad, cursos.size());
    }

    @Override
    public String toString() {
        return nombre + " (" + especialidad + ")";
    }
}
