package edu.utn.tp8.pagos;

public class TarjetaCredito implements PagoConDescuento {
    private final String nroEnmascarado;
    private final double descuentoPorcentaje; // ej. 10 => 10%

    public TarjetaCredito(String nroEnmascarado, double descuentoPorcentaje) {
        this.nroEnmascarado = nroEnmascarado;
        this.descuentoPorcentaje = Math.max(0, descuentoPorcentaje);
    }

    @Override
    public double aplicarDescuento(double monto) {
        double desc = monto * (descuentoPorcentaje / 100.0);
        return Math.max(0, monto - desc);
    }

    @Override
    public boolean procesarPago(double monto) {
        System.out.println("Procesando pago con Tarjeta (" + nroEnmascarado + ") por $" +
                String.format("%.2f", monto) + "...");
        // Simulación OK
        return true;
    }
}
