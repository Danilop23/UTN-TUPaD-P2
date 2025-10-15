public class Animal {
    public String hacerSonido() {
        return "Sonido genérico";
    }

    public String describirAnimal() {
        return "Soy un " + this.getClass().getSimpleName();
    }
}