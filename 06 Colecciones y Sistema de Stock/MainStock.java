package stock;

import java.util.List;

public class MainStock {
    public static void main(String[] args) {
        Inventario inv = new Inventario();

        inv.agregarProducto(new Producto("P001", "Arroz 1kg", 1200, 35, CategoriaProducto.ALIMENTOS));
        inv.agregarProducto(new Producto("P002", "Smartphone", 250000, 7, CategoriaProducto.ELECTRONICA));
        inv.agregarProducto(new Producto("P003", "Remera básica", 8500, 50, CategoriaProducto.ROPA));
        inv.agregarProducto(new Producto("P004", "Tostadora", 38000, 12, CategoriaProducto.HOGAR));
        inv.agregarProducto(new Producto("P005", "Leche 1L", 900, 60, CategoriaProducto.ALIMENTOS));

        System.out.println("== Listado de productos ==");
        inv.listarProductos();

        System.out.println("\n== Buscar producto P003 ==");
        Producto buscado = inv.buscarProductoPorId("P003");
        if (buscado != null) buscado.mostrarInfo();

        System.out.println("\n== Filtrar por categoría ALIMENTOS ==");
        List<Producto> alimentos = inv.filtrarPorCategoria(CategoriaProducto.ALIMENTOS);
        alimentos.forEach(Producto::mostrarInfo);

        System.out.println("\n== Eliminar P002 y listar restantes ==");
        inv.eliminarProducto("P002");
        inv.listarProductos();

        System.out.println("\n== Actualizar stock de P004 a 20 ==");
        inv.actualizarStock("P004", 20);
        inv.buscarProductoPorId("P004").mostrarInfo();

        System.out.println("\n== Total de unidades en stock ==");
        System.out.println(inv.obtenerTotalStock());

        System.out.println("\n== Producto con mayor stock ==");
        Producto mayor = inv.obtenerProductoConMayorStock();
        if (mayor != null) mayor.mostrarInfo();

        System.out.println("\n== Productos entre $1000 y $3000 ==");
        inv.filtrarProductosPorPrecio(1000, 3000).forEach(Producto::mostrarInfo);

        System.out.println("\n== Categorías disponibles ==");
        inv.mostrarCategoriasDisponibles();
    }
}
