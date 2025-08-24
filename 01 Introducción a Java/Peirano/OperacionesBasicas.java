package tp.peirano;

import java.util.Scanner;

public class OperacionesBasicas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir números
        System.out.print("Ingrese el primer número entero: ");
        int num1 = scanner.nextInt();

        System.out.print("Ingrese el segundo número entero: ");
        int num2 = scanner.nextInt();

        // Operaciones
        int suma = num1 + num2;
        int resta = num1 - num2;
        int multiplicacion = num1 * num2;

        // División: controlamos que no sea división por cero
        double division = (num2 != 0) ? (double) num1 / num2 : Double.NaN;

        // Mostrar resultados
        System.out.println("\n--- Resultados ---");
        System.out.println("Suma: " + suma);
        System.out.println("Resta: " + resta);
        System.out.println("Multiplicación: " + multiplicacion);
        
        if (num2 != 0) {
            System.out.println("División: " + division);
        } else {
            System.out.println("División: no se puede dividir por cero");
        }

        scanner.close();
    }
}