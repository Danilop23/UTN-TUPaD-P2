package U5;

class Banco {
    private String nombre, cuit;

    public Banco(String nombre, String cuit) {
        this.nombre = nombre;
        this.cuit = cuit;
    }

    @Override
    public String toString() {
        return "Banco: " + nombre + " (CUIT " + cuit + ")";
    }
}

class Cliente {
    private String nombre, dni;
    private TarjetaDeCredito tarjeta;   // vínculo bidireccional

    public Cliente(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    /* paquete */ void setTarjeta(TarjetaDeCredito t) { // lo usa TarjetaDeCredito
        this.tarjeta = t;
    }

    @Override
    public String toString() {
        return "Cliente: " + nombre + " | DNI: " + dni;
    }
}

public class TarjetaDeCredito {
    private String numero, fechaVencimiento;
    private Banco banco;     // agregación
    private Cliente cliente; // asociación bidireccional

    public TarjetaDeCredito(String numero, String fechaVencimiento, Banco banco) {
        this.numero = numero;
        this.fechaVencimiento = fechaVencimiento;
        this.banco = banco;
    }

    public void asignarCliente(Cliente c) {
        this.cliente = c;
        c.setTarjeta(this);
    }

    @Override
    public String toString() {
        return "Tarjeta: " + numero + " | Vence: " + fechaVencimiento + " | " + banco;
    }

    // Prueba rápida
    public static void main(String[] args) {
        Banco b = new Banco("Banco Nación", "30-50000000-1");
        TarjetaDeCredito t = new TarjetaDeCredito("4509 1234 5678 9010", "12/28", b);
        Cliente c = new Cliente("Sol", "12345678");

        t.asignarCliente(c);

        System.out.println(t);
        System.out.println(c);
    }
}