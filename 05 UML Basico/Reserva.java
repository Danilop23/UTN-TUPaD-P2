package U5;

class Cliente {
    private String nombre, telefono;

    public Cliente(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Cliente: " + nombre + " | Tel: " + telefono;
    }
}

class Mesa {
    private int numero, capacidad;

    public Mesa(int numero, int capacidad) {
        this.numero = numero;
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Mesa N°" + numero + " | Capacidad: " + capacidad;
    }
}

public class Reserva {
    private String fecha, hora;
    private Cliente cliente; // asociación (unidireccional desde Reserva)
    private Mesa mesa;       // agregación

    public Reserva(String fecha, String hora, Cliente cliente, Mesa mesa) {
        this.fecha = fecha;
        this.hora = hora;
        this.cliente = cliente;
        this.mesa = mesa;
    }

    @Override
    public String toString() {
        return "Reserva: " + fecha + " " + hora + " | " + cliente + " | " + mesa;
    }

    // Prueba rápida
    public static void main(String[] args) {
        Cliente c = new Cliente("Sol", "351-5551234");
        Mesa m = new Mesa(7, 4);
        Reserva r = new Reserva("2025-10-01", "21:00", c, m);

        System.out.println(r);
    }
}