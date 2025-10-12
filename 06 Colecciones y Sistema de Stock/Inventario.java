package stock;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Inventario {
    private final ArrayList<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    public void listarProductos() {
        if (productos.isEmpty()) {
            System.out.println("Inventario vacío.");
        } else {
            productos.forEach(Producto::mostrarInfo);
        }
    }

    public Producto buscarProductoPorId(String id) {
        for (Producto p : productos) {
            if (p.getId().equalsIgnoreCase(id)) return p;
        }
        return null;
    }

    public boolean eliminarProducto(String id) {
        return productos.removeIf(p -> p.getId().equalsIgnoreCase(id));
    }

    public boolean actualizarStock(String id, int nuevaCantidad) {
        Producto p = buscarProductoPorId(id);
        if (p != null) {
            p.setCantidad(nuevaCantidad);
            return true;
        }
        return false;
    }

    public List<Producto> filtrarPorCategoria(CategoriaProducto categoria) {
        return productos.stream()
                .filter(p -> p.getCategoria() == categoria)
                .collect(Collectors.toList());
    }

    public int obtenerTotalStock() {
        int total = 0;
        for (Producto p : productos) total += p.getCantidad();
        return total;
    }

    public Producto obtenerProductoConMayorStock() {
        Optional<Producto> max = productos.stream()
                .max(Comparator.comparingInt(Producto::getCantidad));
        return max.orElse(null);
    }

    public List<Producto> filtrarProductosPorPrecio(double min, double max) {
        return productos.stream()
                .filter(p -> p.getPrecio() >= min && p.getPrecio() <= max)
                .collect(Collectors.toList());
    }

    public void mostrarCategoriasDisponibles() {
        for (CategoriaProducto c : CategoriaProducto.values()) {
            System.out.println(c.name() + " - " + c.getDescripcion());
        }
    }
}
