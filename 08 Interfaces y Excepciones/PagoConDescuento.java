package edu.utn.tp8.pagos;

public interface PagoConDescuento extends Pago {
    /**
     * Devuelve el monto final luego de aplicar el descuento.
     */
    double aplicarDescuento(double monto);
}
