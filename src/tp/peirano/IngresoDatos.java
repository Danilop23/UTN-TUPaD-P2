package tp.peirano;

import java.util.Scanner;

public class IngresoDatos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar nombre
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();

        // Solicitar edad
        System.out.print("Ingrese su edad: ");
        int edad = scanner.nextInt();

        // Mostrar en pantalla
        System.out.println("\n--- Datos ingresados ---");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad + " años");

        scanner.close(); // buena práctica: cerrar el Scanner
    }
}