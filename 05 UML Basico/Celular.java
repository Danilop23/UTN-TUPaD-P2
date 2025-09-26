package U5;

class Bateria {
    private String modelo;
    private int capacidad; // mAh

    public Bateria(String modelo, int capacidad) {
        this.modelo = modelo;
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Batería: " + modelo + " - " + capacidad + "mAh";
    }
}

class Usuario {
    private String nombre, dni;
    private Celular celular; // vínculo bidireccional

    public Usuario(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    /* paquete */ void setCelular(Celular c) { // solo lo usa Celular
        this.celular = c;
    }

    @Override
    public String toString() {
        return "Usuario: " + nombre + " | DNI: " + dni;
    }
}

public class Celular {
    private String imei, marca, modelo;
    private Bateria bateria;    // agregación (se “inyecta”; no la crea el celular)
    private Usuario usuario;    // asociación bidireccional

    public Celular(String imei, String marca, String modelo, Bateria bateria) {
        this.imei = imei;
        this.marca = marca;
        this.modelo = modelo;
        this.bateria = bateria;
    }

    public void asignarUsuario(Usuario u) {
        this.usuario = u;
        u.setCelular(this); // completa el lado del usuario
    }

    @Override
    public String toString() {
        return "Celular: " + marca + " " + modelo + " | IMEI: " + imei + " | " + bateria;
    }

    // Prueba rápida
    public static void main(String[] args) {
        Bateria bat = new Bateria("BL-45", 5000);
        Celular cel = new Celular("359123456789012", "Moto", "G54", bat);
        Usuario usr = new Usuario("Fabrizio", "40123456");

        cel.asignarUsuario(usr);

        System.out.println(cel);
        System.out.println(usr);
    }
}