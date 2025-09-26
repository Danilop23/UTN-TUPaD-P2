package U5;

class PlacaMadre {
    private String modelo, chipset;

    public PlacaMadre(String modelo, String chipset) {
        this.modelo = modelo;
        this.chipset = chipset;
    }

    @Override
    public String toString() {
        return "PlacaMadre: " + modelo + " | Chipset: " + chipset;
    }
}

class Propietario {
    private String nombre, dni;
    private Computadora computadora; // vínculo bidireccional

    public Propietario(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    /* paquete */ void setComputadora(Computadora c) { // lo usa Computadora
        this.computadora = c;
    }

    @Override
    public String toString() {
        return "Propietario: " + nombre + " | DNI: " + dni;
    }
}

public class Computadora {
    private String marca, numeroSerie;
    private final PlacaMadre placa;   // composición
    private Propietario propietario;  // asociación bidireccional

    public Computadora(String marca, String numeroSerie, PlacaMadre placa) {
        this.marca = marca;
        this.numeroSerie = numeroSerie;
        this.placa = placa;
    }

    public void asignarPropietario(Propietario p) {
        this.propietario = p;
        p.setComputadora(this);
    }

    @Override
    public String toString() {
        return "Computadora: " + marca + " | NS: " + numeroSerie + " | " + placa;
    }

    // Prueba rápida
    public static void main(String[] args) {
        PlacaMadre pm = new PlacaMadre("ASUS TUF B550M", "AMD B550");
        Computadora pc = new Computadora("Lenovo", "SN-00112233", pm);
        Propietario prop = new Propietario("Fabrizio", "40123456");

        pc.asignarPropietario(prop);

        System.out.println(pc);
        System.out.println(prop);
    }
}