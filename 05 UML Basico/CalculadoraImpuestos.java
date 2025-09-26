package U5;

class Contribuyente {
    private String nombre, cuil;

    public Contribuyente(String nombre, String cuil) {
        this.nombre = nombre;
        this.cuil = cuil;
    }

    @Override
    public String toString() {
        return "Contribuyente: " + nombre + " | CUIL: " + cuil;
    }
}

class Impuesto {
    private double monto;
    private Contribuyente contribuyente; // asociación unidireccional

    public Impuesto(double monto, Contribuyente contribuyente) {
        this.monto = monto;
        this.contribuyente = contribuyente;
    }

    public double getMonto() { return monto; }
    public Contribuyente getContribuyente() { return contribuyente; }

    @Override
    public String toString() {
        return "Impuesto: $" + String.format("%.2f", monto) + " | " + contribuyente;
    }
}

public class CalculadoraImpuestos {
    // Dependencia de uso: la calculadora usa Impuesto
    public double calcular(Impuesto i) {
        // Ejemplo simple: recargo del 5%
        double total = i.getMonto() * 1.05;
        System.out.println("Total a pagar: $" + String.format("%.2f", total));
        return total;
    }

    // Prueba rápida
    public static void main(String[] args) {
        Contribuyente ctb = new Contribuyente("Fabrizio", "20-40123456-3");
        Impuesto imp = new Impuesto(15000.00, ctb);
        CalculadoraImpuestos calc = new CalculadoraImpuestos();
        System.out.println(imp);
        calc.calcular(imp);
    }
}