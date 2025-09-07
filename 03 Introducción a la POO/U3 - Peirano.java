package tp.Peirano;

public class Main {

    // ---------- Clase Estudiante ----------
    static class Estudiante {
        private String nombre;
        private String apellido;
        private String curso;
        private double calificacion;

        public Estudiante(String nombre, String apellido, String curso, double calificacion) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.curso = curso;
            this.calificacion = calificacion;
        }

        public void mostrarInfo() {
            System.out.println(nombre + " " + apellido + " - Curso: " + curso + " - Calificación: " + calificacion);
        }

        public void subirCalificacion(double puntos) {
            calificacion += puntos;
        }

        public void bajarCalificacion(double puntos) {
            calificacion -= puntos;
        }
    }

    // ---------- Clase Mascota ----------
    static class Mascota {
        private String nombre;
        private String especie;
        private int edad;

        public Mascota(String nombre, String especie, int edad) {
            this.nombre = nombre;
            this.especie = especie;
            this.edad = edad;
        }

        public void mostrarInfo() {
            System.out.println(nombre + " (" + especie + ") - Edad: " + edad);
        }

        public void cumplirAnios() {
            edad++;
        }
    }

    // ---------- Clase Libro (con encapsulamiento) ----------
    static class Libro {
        private String titulo;
        private String autor;
        private int anioPublicacion;

        public Libro(String titulo, String autor, int anioPublicacion) {
            this.titulo = titulo;
            this.autor = autor;
            setAnioPublicacion(anioPublicacion);
        }

        public String getTitulo() { return titulo; }
        public String getAutor() { return autor; }
        public int getAnioPublicacion() { return anioPublicacion; }

        public void setAnioPublicacion(int anio) {
            if (anio > 0 && anio <= 2025) {
                this.anioPublicacion = anio;
            } else {
                System.out.println("Año inválido.");
            }
        }
    }

    // ---------- Clase Gallina ----------
    static class Gallina {
        private int idGallina;
        private int edad;
        private int huevosPuestos;

        public Gallina(int idGallina, int edad) {
            this.idGallina = idGallina;
            this.edad = edad;
            this.huevosPuestos = 0;
        }

        public void ponerHuevo() {
            huevosPuestos++;
        }

        public void envejecer() {
            edad++;
        }

        public void mostrarEstado() {
            System.out.println("Gallina " + idGallina + " - Edad: " + edad + " - Huevos puestos: " + huevosPuestos);
        }
    }

    // ---------- Clase NaveEspacial ----------
    static class NaveEspacial {
        private String nombre;
        private int combustible;

        public NaveEspacial(String nombre, int combustible) {
            this.nombre = nombre;
            this.combustible = combustible;
        }

        public void despegar() {
            if (combustible >= 10) {
                combustible -= 10;
                System.out.println(nombre + " ha despegado.");
            } else {
                System.out.println("No hay suficiente combustible para despegar.");
            }
        }

        public void avanzar(int distancia) {
            int consumo = distancia * 2; // 2 unidades por km
            if (combustible >= consumo) {
                combustible -= consumo;
                System.out.println(nombre + " avanzó " + distancia + " km.");
            } else {
                System.out.println("Combustible insuficiente para avanzar.");
            }
        }

        public void recargarCombustible(int cantidad) {
            if (combustible + cantidad <= 100) {
                combustible += cantidad;
            } else {
                combustible = 100;
                System.out.println("Depósito lleno. No se puede superar el límite.");
            }
        }

        public void mostrarEstado() {
            System.out.println("Nave: " + nombre + " - Combustible: " + combustible);
        }
    }

    // ---------- Main para probar todo ----------
    public static void main(String[] args) {
        // Estudiante
        System.out.println("=== ESTUDIANTE ===");
        Estudiante e1 = new Estudiante("Juan", "Pérez", "Programación II", 7.5);
        e1.mostrarInfo();
        e1.subirCalificacion(1.0);
        e1.bajarCalificacion(0.5);
        e1.mostrarInfo();

        // Mascota
        System.out.println("\n=== MASCOTA ===");
        Mascota m1 = new Mascota("Firulais", "Perro", 3);
        m1.mostrarInfo();
        m1.cumplirAnios();
        m1.mostrarInfo();

        // Libro
        System.out.println("\n=== LIBRO ===");
        Libro l1 = new Libro("Java Básico", "Autor X", 2020);
        l1.setAnioPublicacion(2030); // inválido
        l1.setAnioPublicacion(2022);
        System.out.println(l1.getTitulo() + " - " + l1.getAutor() + " - " + l1.getAnioPublicacion());

        // Gallinas
        System.out.println("\n=== GALLINAS ===");
        Gallina g1 = new Gallina(1, 2);
        Gallina g2 = new Gallina(2, 1);
        g1.envejecer();
        g1.ponerHuevo();
        g1.mostrarEstado();
        g2.ponerHuevo();
        g2.mostrarEstado();

        // Nave Espacial
        System.out.println("\n=== NAVE ESPACIAL ===");
        NaveEspacial n1 = new NaveEspacial("Apollo", 50);
        n1.despegar();
        n1.avanzar(30); // tal vez no alcance
        n1.recargarCombustible(60);
        n1.avanzar(20);
        n1.mostrarEstado();
    }
}