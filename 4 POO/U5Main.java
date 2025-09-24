package tp.Peirano;

public class U5Main {
    public static void main(String[] args) {
        // Instancias usando ambos constructores
        Empleado e1 = new Empleado(100, "Ana López", "Analista", 800000);
        Empleado e2 = new Empleado("Juan Pérez", "Desarrollador");
        Empleado e3 = new Empleado("Sofía Díaz", "Soporte");

        // Seteo inicial de salarios cuando usé el constructor reducido
        e2.setSalario(650000);
        e3.setSalario(500000);

        // Aplicar métodos sobrecargados
        e1.actualizarSalario(12.5);  // porcentaje
        e2.actualizarSalario(50000); // monto fijo
        e3.actualizarSalario(5.0);   // porcentaje

        // Imprimir información
        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);

        System.out.println("Total empleados: " + Empleado.mostrarTotalEmpleados());
    }
}

// ↓↓↓ MISMA HOJA: Empleado SIN 'public'
class Empleado {

    // Atributos (encapsulados)
    private int id;
    private String nombre;
    private String puesto;
    private double salario;

    // Atributos/Métodos estáticos
    private static int totalEmpleados = 0;   // contador global
    private static int nextId = 1;           // para ID automático en constructor reducido
    private static final double SALARIO_POR_DEFECTO = 0.0;

    // Constructor completo
    public Empleado(int id, String nombre, String puesto, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
        totalEmpleados++;
    }

    // Constructor reducido
    public Empleado(String nombre, String puesto) {
        this.id = nextId++;
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = SALARIO_POR_DEFECTO;
        totalEmpleados++;
    }

    // Sobrecargas de actualizarSalario
    public void actualizarSalario(double porcentaje) {
        this.salario += this.salario * (porcentaje / 100.0);
    }
    public void actualizarSalario(int montoFijo) {
        this.salario += montoFijo;
    }

    @Override
    public String toString() {
        return "Empleado { " +
               "id=" + id +
               ", nombre='" + nombre + '\'' +
               ", puesto='" + puesto + '\'' +
               ", salario=" + String.format("%.2f", salario) +
               " }";
    }

    public static int mostrarTotalEmpleados() {
        return totalEmpleados;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getPuesto() { return puesto; }
    public void setPuesto(String puesto) { this.puesto = puesto; }

    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }
}