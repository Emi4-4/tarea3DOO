// package org.example;
// import java.util.Scanner;
// /**
//  * Clase que proporciona una interfaz interactiva para el sistema.
//  * Permite a los usuarios seleccionar monedas y productos de forma dinámica
//  * mientras el programa está en ejecución.
//  *
//  * @author Lenin(Chamo0312)
//  * @version 1.0
//  */
// public class MainInteractivo {
//     /**
//      * Punto de entrada interactivo del programa.
//      * Gestiona un bucle principal donde se solicitan entradas al usuario,
//      * se instancia la compra y se capturan las excepciones posibles.
//      */
//     public static void main(String[] args){
//         Scanner leer = new Scanner(System.in);
//         Expendedor expendedor = new Expendedor(3);
//         int opciones = 3;
//         while (opciones != 2) {
//             System.out.println("Maquina expendedora");
//             System.out.println("1. Comprar");
//             System.out.println("2. Salir");
//             System.out.print("Seleccione opcion: ");
//
//             opciones = leer.nextInt();
//             if (opciones == 1){
//                 try {
//                     System.out.print("Ingrese moneda (100, 500, 1000, 1500): ");
//                     int dinero = leer.nextInt();
//                     Moneda moneda = null;
//                     switch (dinero){
//                         case 100:
//                             moneda = new Moneda100();
//                             break;
//                         case 500:
//                             moneda = new Moneda500();
//                             break;
//                         case 1000:
//                             moneda = new Moneda1000();
//                             break;
//                         case 1500:
//                             moneda = new Moneda1500();
//                             break;
//                         default:
//                             System.out.println("Moneda Invalida");
//                             continue;
//                     }
//                     System.out.println("Productos disponibles:");
//                     System.out.println("Bebidas:");
//                     System.out.println("1. CocaCola (1000)");
//                     System.out.println("2. Sprite (900)");
//                     System.out.println("3. Fanta (1100)");
//                     System.out.println("Dulces:");
//                     System.out.println("4. Snickers (1400)");
//                     System.out.println("5. Super8 (800)");
//                     System.out.println("6. BonoBon (600)");
//
//                     int producto = leer.nextInt();
//                     Comprador usuario = new Comprador(moneda, producto, expendedor);
//                     System.out.println("Compraste: " + usuario.queCompraste());
//                     System.out.println("Tu vuelto: " + usuario.cuantoVuelto());
//                 }
//                 catch (PagoIncorrectoException e) { //Imprime el mensaje de error correspondiente y devuelve la moneda insertada
//                     System.out.println(e.getMessage());
//                     int vuelto = 0;
//                     Moneda v = expendedor.getVuelto();
//                     while (v!=null){
//                         vuelto = v.getValor();
//                         v = expendedor.getVuelto();
//                     }
//                     System.out.println("Se devuelve " + vuelto);
//                 }
//                 catch (PagoInsuficienteException e) {
//                     System.out.println(e.getMessage());
//                     int vuelto = 0;
//                     Moneda v = expendedor.getVuelto();
//                     while (v!=null){
//                         vuelto = v.getValor();
//                         v = expendedor.getVuelto();
//                     }
//                     System.out.println("Se devuelve " + vuelto);
//                 }
//                 catch (NoHayProductoException e) {
//                     System.out.println(e.getMessage());
//                     int vuelto = 0;
//                     Moneda v = expendedor.getVuelto();
//                     while (v!=null){
//                         vuelto = v.getValor();
//                         v = expendedor.getVuelto();
//                     }
//                     System.out.println("Se devuelve " + vuelto);}
//             } else if (opciones==2) {
//                 System.out.println("Gracias por su compra, saliendo.");} else {
//                 System.out.println("Opcion invalida");}
//         }
//         leer.close();
//     }
// }