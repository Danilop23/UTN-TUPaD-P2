package edu.utn.tp8;

import edu.utn.tp8.estados.PedidoEstado;
import edu.utn.tp8.pagos.Pago;
import edu.utn.tp8.pagos.PagoConDescuento;
import edu.utn.tp8.pagos.PayPal;
import edu.utn.tp8.pagos.TarjetaCredito;

public class Main {
    public static void main(String[] args) {
        // Cliente que recibirá notificaciones
        Cliente cliente = new Cliente("Sol", "sol@ejemplo.com");

        // Pedido que implementa Pagable y notifica cambios de estado
        Pedido pedido = new Pedido(cliente);
        pedido.agregarProducto(new Producto("Grifería Bari", 129999));
        pedido.agregarProducto(new Producto("Inodoro Ferrum Varese", 219999));
        System.out.println("Total pedido: $" + String.format("%.2f", pedido.calcularTotal()));

        // Cambios de estado -> deben notificar al cliente
        pedido.cambiarEstado(PedidoEstado.PROCESANDO);

        // Pago con descuento (Tarjeta)
        PagoConDescuento tarjeta = new TarjetaCredito("**** **** **** 1234", 10);
        double totalConDesc = tarjeta.aplicarDescuento(pedido.calcularTotal());
        if (tarjeta.procesarPago(totalConDesc)) {
            pedido.cambiarEstado(PedidoEstado.PAGADO);
        }

        // Alternativa: pago sin descuento (PayPal)
        Pago paypal = new PayPal("sol.paypal");
        // paypal.procesarPago(pedido.calcularTotal());

        // Continuar flujo
        pedido.cambiarEstado(PedidoEstado.ENVIADO);
        pedido.cambiarEstado(PedidoEstado.ENTREGADO);

        System.out.println("Fin: " + pedido);
    }
}
