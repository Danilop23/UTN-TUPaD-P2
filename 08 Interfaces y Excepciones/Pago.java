package edu.utn.tp8.pagos;

public interface Pago {
    /**
     * Procesa un pago por el monto indicado y devuelve true si fue exitoso.
     */
    boolean procesarPago(double monto);
}
