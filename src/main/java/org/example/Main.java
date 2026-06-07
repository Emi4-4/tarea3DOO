package org.example;

public class Main {
    public static void main(String[] args)
            throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        // Inicializamos con 5 unidades de cada cosa
        Expendedor expendedor = new Expendedor(5);

        // Caso: Comprar un Super8 (Número 5, Precio $800)
        System.out.println("--- PRUEBA 1: COMPRA EXITOSA ---");
        Moneda mil = new Moneda1000();
        // 5 es el super8 en el selector
        Producto p = expendedor.comprarProducto(mil, 5);

        if (p != null) {
            System.out.println("Obtenido: " + p.getClass().getSimpleName()); // Debería decir Super8

            // Verificar vuelto: 1000 - 800 = 200 (2 monedas de 100)
            int vueltoTotal = 0;
            Moneda v = expendedor.getVuelto();
            while (v != null) {
                vueltoTotal += v.getValor();
                v = expendedor.getVuelto();
            }
            System.out.println("Vuelto total: $" + vueltoTotal);
        }

        // Caso: Pago insuficiente
        System.out.println("\n--- PRUEBA 2: PAGO INSUFICIENTE ---");
        Moneda cien = new Moneda100();
        Producto p2 = expendedor.comprarProducto(cien, 1); // Intentar comprar Coca (1000) con 100

        if (p2 == null) {
            System.out.println("Correcto: No se entregó producto por falta de dinero.");
            System.out.println("Moneda devuelta: $" + expendedor.getVuelto().getValor());
        }
    }
}