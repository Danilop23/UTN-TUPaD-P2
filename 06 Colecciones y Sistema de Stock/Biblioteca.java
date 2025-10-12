package biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Biblioteca {
    private String nombre;
    private final List<Libro> libros = new ArrayList<>();

    public Biblioteca(String nombre) {
        this.nombre = nombre;
    }

    public void agregarLibro(String isbn, String titulo, int anioPublicacion, Autor autor) {
        libros.add(new Libro(isbn, titulo, anioPublicacion, autor));
    }

    public void listarLibros() {
        if (libros.isEmpty()) System.out.println("No hay libros.");
        else libros.forEach(Libro::mostrarInfo);
    }

    public Libro buscarLibroPorIsbn(String isbn) {
        for (Libro l : libros) if (l.getIsbn().equalsIgnoreCase(isbn)) return l;
        return null;
    }

    public boolean eliminarLibro(String isbn) {
        return libros.removeIf(l -> l.getIsbn().equalsIgnoreCase(isbn));
    }

    public int obtenerCantidadLibros() {
        return libros.size();
    }

    public List<Libro> filtrarLibrosPorAnio(int anio) {
        return libros.stream().filter(l -> l.getAnioPublicacion() == anio).collect(Collectors.toList());
    }

    public void mostrarAutoresDisponibles() {
        libros.stream()
                .map(Libro::getAutor)
                .distinct()
                .forEach(Autor::mostrarInfo);
    }
}
