public class EmpleadoPlanta extends Empleado {
    private double salarioBase;
    private int aniosAntiguedad;

    public EmpleadoPlanta(String nombre, double salarioBase, int aniosAntiguedad) {
        super(nombre);
        this.salarioBase = salarioBase;
        this.aniosAntiguedad = aniosAntiguedad;
    }

    @Override
    public double calcularSueldo() {
        return salarioBase * (1 + 0.03 * aniosAntiguedad);
    }
}