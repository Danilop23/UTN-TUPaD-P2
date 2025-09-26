package U5;

class Proyecto {
    private String nombre;
    private int duracionMin; // duración total en minutos

    public Proyecto(String nombre, int duracionMin) {
        this.nombre = nombre;
        this.duracionMin = duracionMin;
    }

    public String getNombre() { return nombre; }
    public int getDuracionMin() { return duracionMin; }

    @Override
    public String toString() {
        return "Proyecto: " + nombre + " (" + duracionMin + " min)";
    }
}

class Render {
    private String formato;   // p.ej.: MP4, MOV, MKV
    private Proyecto proyecto; // asociación unidireccional: Render -> Proyecto

    public Render(String formato, Proyecto proyecto) {
        this.formato = formato;
        this.proyecto = proyecto;
    }

    @Override
    public String toString() {
        return "Render: " + formato + " | " + proyecto;
    }
}

public class EditorVideo {
    // Dependencia de creación: EditorVideo crea un Render
    public Render exportar(String formato, Proyecto proyecto) {
        Render r = new Render(formato, proyecto);
        System.out.println("Exportando " + proyecto.getNombre() + " en formato " + formato);
        return r;
    }

    // Prueba rápida
    public static void main(String[] args) {
        Proyecto p = new Proyecto("Spot Semana Construcción", 2);
        EditorVideo editor = new EditorVideo();
        Render r = editor.exportar("MP4", p);
        System.out.println(r);
    }
}