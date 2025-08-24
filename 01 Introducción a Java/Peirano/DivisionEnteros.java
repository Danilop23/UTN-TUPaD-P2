package tp.peirano;

import java.util.Scanner;

public class DivisionEnteros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el primer número entero: ");
        int num1 = scanner.nextInt();

        System.out.print("Ingrese el segundo número entero: ");
        int num2 = scanner.nextInt();

        if (num2 != 0) {
            int division = num1 / num2; // división entera
            System.out.println("Resultado de la división (int): " + division);
        } else {
            System.out.println("No se puede dividir por cero.");
        }

        scanner.close();
    }
}