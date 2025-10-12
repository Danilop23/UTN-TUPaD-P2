package biblioteca;

public class MainBiblioteca {
    public static void main(String[] args) {
        Biblioteca b = new Biblioteca("Biblioteca Central");

        Autor a1 = new Autor("A01", "Julio Cortázar", "Argentina");
        Autor a2 = new Autor("A02", "Isabel Allende", "Chile");
        Autor a3 = new Autor("A03", "Haruki Murakami", "Japón");

        b.agregarLibro("ISBN001", "Rayuela", 1963, a1);
        b.agregarLibro("ISBN002", "Bestiario", 1951, a1);
        b.agregarLibro("ISBN003", "La casa de los espíritus", 1982, a2);
        b.agregarLibro("ISBN004", "Tokio Blues", 1987, a3);
        b.agregarLibro("ISBN005", "Kafka en la orilla", 2002, a3);

        System.out.println("== Listado de libros ==");
        b.listarLibros();

        System.out.println("\n== Buscar ISBN003 ==");
        Libro buscado = b.buscarLibroPorIsbn("ISBN003");
        if (buscado != null) buscado.mostrarInfo();

        System.out.println("\n== Libros publicados en 1987 ==");
        b.filtrarLibrosPorAnio(1987).forEach(Libro::mostrarInfo);

        System.out.println("\n== Eliminar ISBN002 y listar restantes ==");
        b.eliminarLibro("ISBN002");
        b.listarLibros();

        System.out.println("\n== Cantidad total de libros ==");
        System.out.println(b.obtenerCantidadLibros());

        System.out.println("\n== Autores disponibles ==");
        b.mostrarAutoresDisponibles();
    }
}
