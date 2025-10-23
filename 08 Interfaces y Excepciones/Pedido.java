package edu.utn.tp8;

import edu.utn.tp8.contratos.Pagable;
import edu.utn.tp8.contratos.Notificable;
import edu.utn.tp8.estados.PedidoEstado;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pedido implements Pagable {
    private final List<Producto> productos = new ArrayList<>();
    private PedidoEstado estado = PedidoEstado.NUEVO;
    private final Notificable suscriptor;

    public Pedido(Notificable suscriptor) {
        this.suscriptor = suscriptor;
    }

    public void agregarProducto(Producto p) {
        productos.add(p);
        notificar("Se agregó: " + p);
    }

    public List<Producto> getProductos() {
        return Collections.unmodifiableList(productos);
    }

    public PedidoEstado getEstado() { return estado; }

    public void cambiarEstado(PedidoEstado nuevo) {
        this.estado = nuevo;
        notificar("El pedido cambió a estado: " + nuevo);
    }

    private void notificar(String msg) {
        if (suscriptor != null) suscriptor.notificar(msg);
    }

    @Override
    public double calcularTotal() {
        return productos.stream().mapToDouble(Producto::calcularTotal).sum();
    }

    @Override
    public String toString() {
        return "Pedido{estado=" + estado + ", total=$" + String.format("%.2f", calcularTotal()) + "}";
    }
}
