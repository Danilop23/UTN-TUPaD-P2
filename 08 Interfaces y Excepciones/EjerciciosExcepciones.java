package edu.utn.tp8.excepciones;

import java.io.*;
import java.util.Scanner;

public class EjerciciosExcepciones {

    public static void main(String[] args) {
        System.out.println("== Ejercicios de Excepciones ==");

        divisionSegura(10, 2);
        divisionSegura(5, 0); // dispara ArithmeticException controlada

        parseEntero("123");
        parseEntero("12x");   // dispara NumberFormatException controlada

        leerArchivo("src/edu/utn/tp8/io/DemoTryWithResources.txt");
        leerArchivo("no_existe.txt"); // FileNotFoundException controlada

        try {
            validarEdad(25);
            validarEdad(-5);  // dispara EdadInvalidaException
        } catch (EdadInvalidaException e) {
            System.out.println("Edad inválida capturada: " + e.getMessage());
        }

        demoTryWithResources("src/edu/utn/tp8/io/DemoTryWithResources.txt");
    }

    // 1) División segura
    static void divisionSegura(int a, int b) {
        try {
            int r = a / b;
            System.out.println("División " + a + "/" + b + " = " + r);
        } catch (ArithmeticException e) {
            System.out.println("Error: división por cero no permitida.");
        }
    }

    // 2) Conversión de cadena a número
    static void parseEntero(String texto) {
        try {
            int n = Integer.parseInt(texto);
            System.out.println("Entero válido: " + n);
        } catch (NumberFormatException e) {
            System.out.println("Error: '" + texto + "' no es un entero válido.");
        }
    }

    // 3) Lectura de archivo con manejo de FileNotFoundException
    static void leerArchivo(String ruta) {
        try {
            File file = new File(ruta);
            Scanner sc = new Scanner(file);
            System.out.println("Contenido de " + ruta + ":");
            while (sc.hasNextLine()) System.out.println(sc.nextLine());
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + ruta);
        }
    }

    // 4) Excepción personalizada
    static void validarEdad(int edad) throws EdadInvalidaException {
        if (edad < 0 || edad > 120) {
            throw new EdadInvalidaException("La edad " + edad + " no es válida (0–120).");
        }
        System.out.println("Edad válida: " + edad);
    }

    // 5) try-with-resources + manejo de IOException
    static void demoTryWithResources(String ruta) {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            System.out.println("Leyendo con try-with-resources:");
            String line;
            while ((line = br.readLine()) != null) System.out.println(line);
        } catch (IOException e) {
            System.out.println("Error de IO al leer: " + e.getMessage());
        }
    }
}
