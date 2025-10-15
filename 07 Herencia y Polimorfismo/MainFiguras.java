public class MainFiguras {
    public static void main(String[] args) {
        Figura[] figuras = new Figura[] {
            new Circulo(3.0),
            new Rectangulo(4.0, 5.0),
            new Circulo(1.5)
        };

        for (Figura f : figuras) {
            System.out.println(f.getNombre() + " -> Área: " + f.calcularArea());
        }
    }
}