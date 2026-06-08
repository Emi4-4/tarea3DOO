// package org.example;
// /**
//  * Clase dedicada a realizar pruebas unitarias sobre el comportamiento del sistema.
//  * Su objetivo es verificar que tanto los casos de éxito como los casos de error
//  * (excepciones) se comporten según lo esperado.
//  *
//  * @author Lenin(Chamo0312)
//  * @version 1.0
//  */
// public class MainPruebas {
//     /**
//      * Ejecuta una serie de pruebas automáticas para validar la lógica del expendedor.
//      * Evalúa escenarios de stock agotado, productos inexistentes, pago insuficiente
//      * y monedas nulas.
//      */
//     public static void main(String[] args){
//         Expendedor expendedor = new Expendedor(1); //Una unidad por producto para pruebas
//
//         //Compra valida
//         try {
//             Comprador c = new Comprador(new Moneda1000(), 5, expendedor);
//             System.out.println("Prueba compra: " + c.queCompraste());
//             System.out.println("Prueba vuelto: " + c.cuantoVuelto());
//         } catch (Exception e){
//             System.out.println("Error" + e.getMessage());
//         }
//
//         //No hay stock
//         try {
//             Comprador c = new Comprador(new Moneda1000(), 5, expendedor);
//         } catch (Exception e){
//             System.out.println("Excepcion cuando no queda stock: " + e.getMessage());
//         }
//
//         //Producto seleccionado no existe
//         try {
//             Comprador c = new Comprador(new Moneda1000(), 24, expendedor);
//         } catch (Exception e){
//             System.out.println("Excepcion cuando el producto ingresado no existe: " + e.getMessage());
//         }
//
//         //Dinero insuficiente para la compra
//         try {
//             Comprador c = new Comprador(new Moneda100(), 2, expendedor);
//         } catch (Exception e) {
//             System.out.println("Excepcion cuando la cantidad ingresada es insuficiente: " + e.getMessage());
//         }
//
//         //Cantidad ingresada invalida
//         try {
//             Comprador c = new Comprador(null, 3, expendedor);
//         } catch (Exception e) {
//             System.out.println("Excepcion cuando se ingresa una moneda invalida: " + e.getMessage());
//         }
//     }
// }