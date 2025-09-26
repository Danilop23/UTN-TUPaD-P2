package U5;

class Autor {
    private String nombre, nacionalidad;

    public Autor(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String toString() {
        return "Autor: " + nombre + " (" + nacionalidad + ")";
    }
}

class Editorial {
    private String nombre, direccion;

    public Editorial(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Editorial: " + nombre + " | " + direccion;
    }
}

public class Libro {
    private String titulo, isbn;
    private Autor autor;          // asociación
    private Editorial editorial;  // agregación

    public Libro(String titulo, String isbn, Autor autor, Editorial editorial) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.editorial = editorial;
    }

    @Override
    public String toString() {
        return "Libro: " + titulo + " | ISBN: " + isbn + " | " + autor + " | " + editorial;
    }

    // Método de prueba
    public static void main(String[] args) {
        Autor a = new Autor("Gabriel García Márquez", "Colombiano");
        Editorial e = new Editorial("Sudamericana", "Buenos Aires");
        Libro l = new Libro("Cien años de soledad", "978-84-376-0494-7", a, e);

        System.out.println(l);
    }
}