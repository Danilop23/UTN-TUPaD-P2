import java.util.ArrayList;
import java.util.List;

public class MainEmpleados {
    public static void main(String[] args) {
        List<Empleado> empleados = new ArrayList<>();
        empleados.add(new EmpleadoPlanta("Ana", 500000, 5));
        empleados.add(new EmpleadoTemporal("Luis", 160, 2500, 20000));
        empleados.add(new EmpleadoPlanta("Sofía", 600000, 2));

        for (Empleado e : empleados) {
            double sueldo = e.calcularSueldo();
            String tipo = (e instanceof EmpleadoPlanta) ? "Planta" :
                          (e instanceof EmpleadoTemporal) ? "Temporal" : "Otro";
            System.out.printf("%s (%s) -> Sueldo: %.2f%n", e.getNombre(), tipo, sueldo);
        }
    }
}