package U5;

class Artista {
    private String nombre, genero;

    public Artista(String nombre, String genero) {
        this.nombre = nombre;
        this.genero = genero;
    }

    public String getNombre() { return nombre; }

    @Override
    public String toString() {
        return "Artista: " + nombre + " (" + genero + ")";
    }
}

class Cancion {
    private String titulo;
    private Artista artista; // asociación unidireccional: Cancion -> Artista

    public Cancion(String titulo, Artista artista) {
        this.titulo = titulo;
        this.artista = artista;
    }

    public String getTitulo() { return titulo; }
    public Artista getArtista() { return artista; }

    @Override
    public String toString() {
        return "Canción: " + titulo + " | " + artista;
    }
}

public class Reproductor {
    // Dependencia de uso: Reproductor usa Cancion
    public void reproducir(Cancion c) {
        System.out.println("Reproduciendo: " + c.getTitulo() + " - " + c.getArtista().getNombre());
    }

    // Prueba rápida
    public static void main(String[] args) {
        Artista a = new Artista("Charly García", "Rock");
        Cancion c = new Cancion("Demoliendo hoteles", a);
        Reproductor r = new Reproductor();
        r.reproducir(c);
    }
}