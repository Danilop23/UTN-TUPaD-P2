package U5;

class Usuario {
    private String nombre, email;

    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario: " + nombre + " | " + email;
    }
}

class FirmaDigital {
    private String codigoHash, fecha;
    private Usuario usuario; // agregación: la firma “conoce” al usuario

    public FirmaDigital(String codigoHash, String fecha, Usuario usuario) {
        this.codigoHash = codigoHash;
        this.fecha = fecha;
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "FirmaDigital: " + codigoHash + " | Fecha: " + fecha + " | " + usuario;
    }
}

public class Documento {
    private String titulo, contenido;
    private final FirmaDigital firma; // composición: el documento posee su firma

    public Documento(String titulo, String contenido, FirmaDigital firma) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.firma = firma;
    }

    @Override
    public String toString() {
        return "Documento: " + titulo + " | " + firma;
    }

    // Prueba rápida
    public static void main(String[] args) {
        Usuario u = new Usuario("Sol", "sol@ejemplo.com");
        FirmaDigital f = new FirmaDigital("ABCD1234HASH", "2025-09-26", u);
        Documento d = new Documento("Contrato de Servicios", "Contenido...", f);

        System.out.println(d);
    }
}