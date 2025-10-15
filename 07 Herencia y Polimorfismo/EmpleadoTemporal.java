public class EmpleadoTemporal extends Empleado {
    private int horasTrabajadas;
    private double valorHora;
    private double bono;

    public EmpleadoTemporal(String nombre, int horasTrabajadas, double valorHora, double bono) {
        super(nombre);
        this.horasTrabajadas = horasTrabajadas;
        this.valorHora = valorHora;
        this.bono = bono;
    }

    @Override
    public double calcularSueldo() {
        return horasTrabajadas * valorHora + bono;
    }
}