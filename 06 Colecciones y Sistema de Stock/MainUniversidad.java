package universidad;

public class MainUniversidad {
    public static void main(String[] args) {
        Universidad u = new Universidad("UTN - Programación II");

        Profesor pr1 = new Profesor("PR01", "Ana Torres", "Bases de Datos");
        Profesor pr2 = new Profesor("PR02", "Luis Gómez", "POO");
        Profesor pr3 = new Profesor("PR03", "Carla Díaz", "Redes");

        Curso c1 = new Curso("CUR01", "Programación II");
        Curso c2 = new Curso("CUR02", "Estructuras de Datos");
        Curso c3 = new Curso("CUR03", "Base de Datos I");
        Curso c4 = new Curso("CUR04", "Redes I");
        Curso c5 = new Curso("CUR05", "Sistemas Operativos");

        u.agregarProfesor(pr1); u.agregarProfesor(pr2); u.agregarProfesor(pr3);
        u.agregarCurso(c1); u.agregarCurso(c2); u.agregarCurso(c3); u.agregarCurso(c4); u.agregarCurso(c5);

        u.asignarProfesorACurso("CUR01", "PR02");
        u.asignarProfesorACurso("CUR02", "PR02");
        u.asignarProfesorACurso("CUR03", "PR01");
        u.asignarProfesorACurso("CUR04", "PR03");

        System.out.println("== Cursos con su profesor ==");
        u.listarCursos();
        System.out.println("\n== Profesores con cantidad de cursos ==");
        u.listarProfesores();
        System.out.println("\n== Cursos de Luis Gómez ==");
        pr2.listarCursos();

        System.out.println("\n== Cambiar profesor de CUR02 a PR01 ==");
        u.asignarProfesorACurso("CUR02", "PR01");
        u.listarCursos();
        System.out.println("\n== Cursos de Ana Torres ==");
        pr1.listarCursos();
        System.out.println("\n== Cursos de Luis Gómez ==");
        pr2.listarCursos();

        System.out.println("\n== Eliminar CUR03 ==");
        u.eliminarCurso("CUR03");
        u.listarCursos();
        System.out.println("\n== Cursos de Ana Torres ==");
        pr1.listarCursos();

        System.out.println("\n== Eliminar profesor PR02 ==");
        u.eliminarProfesor("PR02");
        u.listarCursos();

        System.out.println();
        u.reporteCantidadCursosPorProfesor();
    }
}
