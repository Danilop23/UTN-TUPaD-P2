package tp.peirano;

import java.util.Scanner;

public class DivisionDouble {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el primer número (double): ");
        double num1 = scanner.nextDouble();

        System.out.print("Ingrese el segundo número (double): ");
        double num2 = scanner.nextDouble();

        if (num2 != 0) {
            double division = num1 / num2; // división con decimales
            System.out.println("Resultado de la división (double): " + division);
        } else {
            System.out.println("No se puede dividir por cero.");
        }

        scanner.close();
    }
}