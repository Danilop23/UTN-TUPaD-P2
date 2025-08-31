import java.util.Scanner;

public class TP2JAVAPEIRANO {

    private static final Scanner sc = new Scanner(System.in);
    // Ej. 11: variable "global" (constante) de descuento especial
    private static final double DESCUENTO_ESPECIAL = 0.10;

    public static void main(String[] args) {
        // Forzar UTF-8 en tiempo de ejecución
    System.setProperty("file.encoding", "UTF-8");
        while (true) {
            System.out.println("\n=== TP2: Programación Estructurada (Java) ===");
            System.out.println("1) Verificación de Año Bisiesto");
            System.out.println("2) Mayor de tres números");
            System.out.println("3) Clasificación de edad");
            System.out.println("4) Descuento según categoría (A/B/C)");
            System.out.println("5) Suma de números pares (while, termina con 0)");
            System.out.println("6) Contador Pos/Neg/Ceros (for, 10 valores)");
            System.out.println("7) Validación de nota 0-10 (do-while)");
            System.out.println("8) Precio final (impuesto y descuento)");
            System.out.println("9) Envío y total de compra (composición de funciones)");
            System.out.println("10) Actualización de stock");
            System.out.println("11) Descuento especial (variable global)");
            System.out.println("12) Arrays: modificar precio y mostrar (for-each)");
            System.out.println("13) Arrays + recursividad: imprimir antes y después");
            System.out.println("0) Salir");
            System.out.print("Elegí una opción: ");

            int op = leerEntero();
            switch (op) {
                case 1 -> ejercicio1();
                case 2 -> ejercicio2();
                case 3 -> ejercicio3();
                case 4 -> ejercicio4();
                case 5 -> ejercicio5();
                case 6 -> ejercicio6();
                case 7 -> ejercicio7();
                case 8 -> ejercicio8();
                case 9 -> ejercicio9();
                case 10 -> ejercicio10();
                case 11 -> ejercicio11();
                case 12 -> ejercicio12();
                case 13 -> ejercicio13();
                case 0 -> { System.out.println("¡Fin!"); return; }
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    // Utilidades de lectura -------
    private static int leerEntero() {
        while (true) {
            try {
                int v = Integer.parseInt(sc.nextLine().trim());
                return v;
            } catch (Exception e) {
                System.out.print("Número inválido. Reintentá: ");
            }
        }
    }
    private static double leerDouble() {
        while (true) {
            try {
                double v = Double.parseDouble(sc.nextLine().trim().replace(',', '.'));
                return v;
            } catch (Exception e) {
                System.out.print("Número inválido. Reintentá: ");
            }
        }
    }

    // 1) Bisiesto
    private static void ejercicio1() {
        System.out.print("Ingrese un año: ");
        int anio = leerEntero();
        boolean esBisiesto = (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0);
        System.out.println("El año " + anio + (esBisiesto ? " es bisiesto." : " no es bisiesto."));
    }

    // 2) Mayor de tres
    private static void ejercicio2() {
        System.out.print("Ingrese el primer número: "); int a = leerEntero();
        System.out.print("Ingrese el segundo número: "); int b = leerEntero();
        System.out.print("Ingrese el tercer número: "); int c = leerEntero();
        int mayor = Math.max(a, Math.max(b, c));
        System.out.println("El mayor es: " + mayor);
    }

    // 3) Clasificación de edad
    private static void ejercicio3() {
        System.out.print("Ingrese su edad: "); int edad = leerEntero();
        String etapa = (edad < 12) ? "Niño"
                : (edad <= 17) ? "Adolescente"
                : (edad <= 59) ? "Adulto"
                : "Adulto mayor";
        System.out.println("Eres un " + etapa + ".");
    }

    // 4) Descuento por categoría
    private static void ejercicio4() {
        System.out.print("Ingrese el precio del producto: ");
        double precio = leerDouble();
        System.out.print("Ingrese la categoría del producto (A, B o C): ");
        String cat = sc.nextLine().trim().toUpperCase();
        double descPct = switch (cat) {
            case "A" -> 10;
            case "B" -> 15;
            case "C" -> 20;
            default -> {
                System.out.println("Categoría inválida. Se asume 0%.");
                yield 0;
            }
        };
        double precioFinal = precio * (1 - descPct / 100.0);
        System.out.println("Descuento aplicado: " + (int)descPct + "%");
        System.out.println("Precio final: " + precioFinal);
    }

    // 5) Suma pares (while)
    private static void ejercicio5() {
        int suma = 0;
        while (true) {
            System.out.print("Ingrese un número (0 para terminar): ");
            int n = leerEntero();
            if (n == 0) break;
            if (n % 2 == 0) suma += n;
        }
        System.out.println("La suma de los números pares es: " + suma);
    }

    // 6) Contador Pos/Neg/Ceros (for, 10 nums)
    private static void ejercicio6() {
        int pos = 0, neg = 0, ceros = 0;
        for (int i = 1; i <= 10; i++) {
            System.out.print("Ingrese el número " + i + ": ");
            int n = leerEntero();
            if (n > 0) pos++;
            else if (n < 0) neg++;
            else ceros++;
        }
        System.out.println("Resultados:\nPositivos: " + pos + "\nNegativos: " + neg + "\nCeros: " + ceros);
    }

    // 7) Validación de nota (do-while)
    private static void ejercicio7() {
        int nota;
        do {
            System.out.print("Ingrese una nota (0-10): ");
            nota = leerEntero();
            if (nota < 0 || nota > 10) {
                System.out.println("Error: Nota inválida. Ingrese una nota entre 0 y 10.");
            }
        } while (nota < 0 || nota > 10);
        System.out.println("Nota guardada correctamente.");
    }

    // 8) Precio final con impuesto y descuento
    private static void ejercicio8() {
        System.out.print("Ingrese el precio base del producto: ");
        double precioBase = leerDouble();
        System.out.print("Ingrese el impuesto en porcentaje (Ejemplo: 10 para 10%): ");
        double impPct = leerDouble();
        System.out.print("Ingrese el descuento en porcentaje (Ejemplo: 5 para 5%): ");
        double descPct = leerDouble();

        double precioFinal = calcularPrecioFinal(precioBase, impPct, descPct);
        System.out.println("El precio final del producto es: " + precioFinal);
    }
    // Firma ampliada para incluir precio base (tal como exige el cálculo)
    private static double calcularPrecioFinal(double precioBase, double impuestoPct, double descuentoPct) {
        double impuesto = precioBase * (impuestoPct / 100.0);
        double descuento = precioBase * (descuentoPct / 100.0);
        return precioBase + impuesto - descuento;
    }

    // 9) Envío y total
    private static void ejercicio9() {
        System.out.print("Ingrese el precio del producto: "); double precio = leerDouble();
        System.out.print("Ingrese el peso del paquete en kg: "); double peso = leerDouble();
        System.out.print("Ingrese la zona de envío (Nacional/Internacional): ");
        String zona = sc.nextLine().trim();

        double costoEnvio = calcularCostoEnvio(peso, zona);
        double total = calcularTotalCompra(precio, costoEnvio);

        System.out.println("El costo de envío es: " + costoEnvio);
        System.out.println("El total a pagar es: " + total);
    }
    private static double calcularCostoEnvio(double peso, String zona) {
        boolean nacional = zona.equalsIgnoreCase("Nacional");
        boolean internacional = zona.equalsIgnoreCase("Internacional");
        double tarifa = nacional ? 5.0 : (internacional ? 10.0 : 0.0);
        if (tarifa == 0.0) {
            System.out.println("Zona inválida. Se asume costo 0.");
        }
        return peso * tarifa;
    }
    private static double calcularTotalCompra(double precioProducto, double costoEnvio) {
        return precioProducto + costoEnvio;
    }

    // 10) Actualización de stock
    private static void ejercicio10() {
        System.out.print("Ingrese el stock actual del producto: "); int stock = leerEntero();
        System.out.print("Ingrese la cantidad vendida: "); int vendida = leerEntero();
        System.out.print("Ingrese la cantidad recibida: "); int recibida = leerEntero();
        int nuevo = actualizarStock(stock, vendida, recibida);
        System.out.println("El nuevo stock del producto es: " + nuevo);
    }
    private static int actualizarStock(int stockActual, int cantidadVendida, int cantidadRecibida) {
        return stockActual - cantidadVendida + cantidadRecibida; // fórmula correcta
    }

    // 11) Descuento especial usando variable global
    private static void ejercicio11() {
        System.out.print("Ingrese el precio del producto: "); double precio = leerDouble();
        double descuentoAplicado = precio * DESCUENTO_ESPECIAL;
        double precioFinal = precio - descuentoAplicado;
        System.out.println("El descuento especial aplicado es: " + descuentoAplicado);
        System.out.println("El precio final con descuento es: " + precioFinal);
    }

    // 12) Arrays: modificar y mostrar
    private static void ejercicio12() {
        double[] precios = {199.99, 299.5, 149.75, 399.0, 89.99};

        System.out.println("Precios originales:");
        for (double p : precios) System.out.println("Precio: $" + p);

        // Modificar el precio de un producto específico (ej: índice 2 -> 129.99)
        precios[2] = 129.99;

        System.out.println("Precios modificados:");
        for (double p : precios) System.out.println("Precio: $" + p);
    }

    // 13) Arrays + recursividad
    private static void ejercicio13() {
        double[] precios = {199.99, 299.5, 149.75, 399.0, 89.99};

        System.out.println("Precios originales:");
        imprimirArrayRecursivo(precios, 0);

        // Modificar precio específico (índice 2)
        precios[2] = 129.99;

        System.out.println("Precios modificados:");
        imprimirArrayRecursivo(precios, 0);
    }
    private static void imprimirArrayRecursivo(double[] arr, int idx) {
        if (idx >= arr.length) return;
        System.out.println("Precio: $" + arr[idx]);
        imprimirArrayRecursivo(arr, idx + 1);
    }
}