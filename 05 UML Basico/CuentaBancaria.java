package U5;

class ClaveSeguridad {
    private String codigo;
    private String ultimaModificacion;

    public ClaveSeguridad(String codigo, String ultimaModificacion) {
        this.codigo = codigo;
        this.ultimaModificacion = ultimaModificacion;
    }

    @Override
    public String toString() {
        return "ClaveSeguridad: " + codigo + " | Últ. modif.: " + ultimaModificacion;
    }
}

class Titular {
    private String nombre, dni;
    private CuentaBancaria cuenta; // vínculo bidireccional

    public Titular(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    /* paquete */ void setCuenta(CuentaBancaria c) { // lo usa CuentaBancaria
        this.cuenta = c;
    }

    @Override
    public String toString() {
        return "Titular: " + nombre + " | DNI: " + dni;
    }
}

public class CuentaBancaria {
    private String cbu;
    private double saldo;
    private final ClaveSeguridad clave; // composición
    private Titular titular;            // asociación bidireccional

    public CuentaBancaria(String cbu, double saldo, ClaveSeguridad clave) {
        this.cbu = cbu;
        this.saldo = saldo;
        this.clave = clave;
    }

    public void asignarTitular(Titular t) {
        this.titular = t;
        t.setCuenta(this);
    }

    public void depositar(double monto) {
        if (monto > 0) saldo += monto;
    }

    public boolean extraer(double monto) {
        if (monto > 0 && monto <= saldo) { saldo -= monto; return true; }
        return false;
    }

    @Override
    public String toString() {
        return "Cuenta CBU: " + cbu + " | Saldo: $" + String.format("%.2f", saldo) + " | " + clave;
    }

    // Prueba rápida
    public static void main(String[] args) {
        ClaveSeguridad cs = new ClaveSeguridad("A1B2-C3D4", "2025-09-26");
        CuentaBancaria cb = new CuentaBancaria("2850590940090418135201", 100000.00, cs);
        Titular t = new Titular("Sol", "12345678");

        cb.asignarTitular(t);
        cb.depositar(5000);
        cb.extraer(12000);

        System.out.println(cb);
        System.out.println(t);
    }
}