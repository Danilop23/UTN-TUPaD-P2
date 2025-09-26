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

class CodigoQR {
    private String valor;
    private Usuario usuario; // asociación unidireccional: QR -> Usuario

    public CodigoQR(String valor, Usuario usuario) {
        this.valor = valor;
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "CodigoQR: [" + valor + "] | " + usuario;
    }
}

public class GeneradorQR {
    // Dependencia de creación: GeneradorQR crea un CodigoQR
    public CodigoQR generar(String valor, Usuario usuario) {
        CodigoQR qr = new CodigoQR(valor, usuario);
        System.out.println("QR generado para " + usuario + " con valor: " + valor);
        return qr;
    }

    // Prueba rápida
    public static void main(String[] args) {
        Usuario u = new Usuario("Sol", "sol@ejemplo.com");
        GeneradorQR gen = new GeneradorQR();
        CodigoQR qr = gen.generar("U5-AC13-XYZ-001", u);
        System.out.println(qr);
    }
}