public class MainVehiculos {
    public static void main(String[] args) {
        Auto a = new Auto("Toyota", "Corolla", 4);
        System.out.println(a.mostrarInfo());

        Vehiculo v = a;
        System.out.println(v.mostrarInfo());

        if (v instanceof Auto) {
            Auto a2 = (Auto) v;
            System.out.println("Puertas (downcasting): " + a2.getCantidadPuertas());
        }
    }
}