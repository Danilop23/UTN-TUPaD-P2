package U5;

class Paciente {
    private String nombre, obraSocial;

    public Paciente(String nombre, String obraSocial) {
        this.nombre = nombre;
        this.obraSocial = obraSocial;
    }

    @Override
    public String toString() {
        return "Paciente: " + nombre + " | Obra social: " + obraSocial;
    }
}

class Profesional {
    private String nombre, especialidad;

    public Profesional(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Profesional: " + nombre + " | " + especialidad;
    }
}

public class CitaMedica {
    private String fecha, hora;
    private Paciente paciente;       // asociación unidireccional
    private Profesional profesional; // asociación unidireccional

    public CitaMedica(String fecha, String hora, Paciente paciente, Profesional profesional) {
        this.fecha = fecha;
        this.hora = hora;
        this.paciente = paciente;
        this.profesional = profesional;
    }

    @Override
    public String toString() {
        return "Cita: " + fecha + " " + hora + " | " + paciente + " | " + profesional;
    }

    // Prueba rápida
    public static void main(String[] args) {
        Paciente p = new Paciente("Fabrizio", "OSDE 310");
        Profesional pr = new Profesional("Dra. López", "Clínica Médica");
        CitaMedica c = new CitaMedica("2025-10-03", "09:30", p, pr);

        System.out.println(c);
    }
}