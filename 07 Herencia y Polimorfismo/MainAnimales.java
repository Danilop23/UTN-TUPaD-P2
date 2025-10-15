public class MainAnimales {
    public static void main(String[] args) {
        Animal[] animales = new Animal[] { new Perro(), new Gato(), new Vaca() };

        for (Animal a : animales) {
            System.out.println(a.describirAnimal() + " y hago: " + a.hacerSonido());
        }
    }
}