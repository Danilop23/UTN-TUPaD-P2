package U5;

class Motor {
    private String tipo;
    private String numeroSerie;

    public Motor(String tipo, String numeroSerie) {
        this.tipo = tipo;
        this.numeroSerie = numeroSerie;
    }

    @Override
    public String toString() {
        return "Motor: " + tipo + " | N° " + numeroSerie;
    }
}

class Conductor {
    private String nombre, licencia;
    private Vehiculo vehiculo; // vínculo bidireccional

    public Conductor(String nombre, String licencia) {
        this.nombre = nombre;
        this.licencia = licencia;
    }

    /* paquete */ void setVehiculo(Vehiculo v) { // lo usa Vehiculo
        this.vehiculo = v;
    }

    @Override
    public String toString() {
        return "Conductor: " + nombre + " | Licencia: " + licencia;
    }
}

public class Vehiculo {
    private String patente, modelo;
    private Motor motor;        // agregación (inyectado desde afuera)
    private Conductor conductor; // asociación bidireccional

    public Vehiculo(String patente, String modelo, Motor motor) {
        this.patente = patente;
        this.modelo = modelo;
        this.motor = motor;
    }

    public void asignarConductor(Conductor c) {
        this.conductor = c;
        c.setVehiculo(this);
    }

    @Override
    public String toString() {
        return "Vehículo: " + modelo + " | Patente: " + patente + " | " + motor;
    }

    // Prueba rápida
    public static void main(String[] args) {
        Motor m = new Motor("Nafta 1.6", "MS-001-ABC");
        Vehiculo v = new Vehiculo("AE123BC", "Fiat Cronos", m);
        Conductor c = new Conductor("Fabrizio", "B1");

        v.asignarConductor(c);

        System.out.println(v);
        System.out.println(c);
    }
}