package universidad;

import java.util.ArrayList;
import java.util.List;

public class Universidad {
    private String nombre;
    private final List<Profesor> profesores = new ArrayList<>();
    private final List<Curso> cursos = new ArrayList<>();

    public Universidad(String nombre) { this.nombre = nombre; }

    public void agregarProfesor(Profesor p) { profesores.add(p); }
    public void agregarCurso(Curso c) { cursos.add(c); }

    public Profesor buscarProfesorPorId(String id) {
        for (Profesor p : profesores) if (p.getId().equalsIgnoreCase(id)) return p;
        return null;
    }

    public Curso buscarCursoPorCodigo(String codigo) {
        for (Curso c : cursos) if (c.getCodigo().equalsIgnoreCase(codigo)) return c;
        return null;
    }

    public void asignarProfesorACurso(String codigoCurso, String idProfesor) {
        Curso c = buscarCursoPorCodigo(codigoCurso);
        Profesor p = buscarProfesorPorId(idProfesor);
        if (c != null) c.setProfesor(p);
    }

    public void listarProfesores() {
        if (profesores.isEmpty()) System.out.println("No hay profesores.");
        for (Profesor p : profesores) p.mostrarInfo();
    }

    public void listarCursos() {
        if (cursos.isEmpty()) System.out.println("No hay cursos.");
        for (Curso c : cursos) c.mostrarInfo();
    }

    public boolean eliminarCurso(String codigo) {
        Curso c = buscarCursoPorCodigo(codigo);
        if (c != null) {
            c.setProfesor(null);
            return cursos.remove(c);
        }
        return false;
    }

    public boolean eliminarProfesor(String id) {
        Profesor p = buscarProfesorPorId(id);
        if (p != null) {
            new ArrayList<>(p.getCursos()).forEach(cur -> cur.setProfesor(null));
            return profesores.remove(p);
        }
        return false;
    }

    public void reporteCantidadCursosPorProfesor() {
        System.out.println("== Reporte: cantidad de cursos por profesor ==");
        for (Profesor p : profesores) {
            System.out.println(p.getNombre() + ": " + p.getCursos().size());
        }
    }
}
