package U5;

class Foto {
    private String imagen, formato;

    public Foto(String imagen, String formato) {
        this.imagen = imagen;
        this.formato = formato;
    }

    @Override
    public String toString() {
        return "Foto: " + imagen + " (" + formato + ")";
    }
}

class Titular {
    private String nombre, dni;
    private Pasaporte pasaporte; // relación bidireccional

    public Titular(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public void setPasaporte(Pasaporte p) {
        this.pasaporte = p;
    }

    @Override
    public String toString() {
        return "Titular: " + nombre + " | DNI: " + dni;
    }
}

public class Pasaporte {
    private String numero, fechaEmision;
    private final Foto foto;   // composición
    private Titular titular;   // asociación

    public Pasaporte(String numero, String fechaEmision, Foto foto) {
        this.numero = numero;
        this.fechaEmision = fechaEmision;
        this.foto = foto;
    }

    public void asignarTitular(Titular t) {
        this.titular = t;
        t.setPasaporte(this);
    }

    @Override
    public String toString() {
        return "Pasaporte Nº: " + numero +
               " | Emisión: " + fechaEmision +
               " | " + foto;
    }

    // Método main de prueba
    public static void main(String[] args) {
        Foto f = new Foto("img.jpg", "JPG");
        Pasaporte p = new Pasaporte("A123", "2025-01-01", f);
        Titular t = new Titular("Sol", "12345678");

        p.asignarTitular(t);

        System.out.println(p);
        System.out.println(t);
    }
}
