package edu.utn.tp8.pagos;

public class PayPal implements Pago {
    private final String usuario;

    public PayPal(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean procesarPago(double monto) {
        System.out.println("Procesando pago con PayPal @" + usuario + " por $" +
                String.format("%.2f", monto) + "...");
        // Simulación OK
        return true;
    }
}
