package org.example;
/**
 * Clase que representa una máquina expendedora de productos de tipo bebida y dulce.
 * Se encarga de gestionar el stock de productos, procesar pagos y calcular el vuelto.
 *
 * @author Valentina (arenisca)
 * @author Lenin(Chamo0312)
 * @version 2.0
 */
import java.awt.Color;
import java.awt.Graphics;

public class Expendedor {
    /**deposito de bebidas y dulces*/
    private Deposito<Producto> cocacola;
    private Deposito<Producto> sprite;
    private Deposito<Producto> fanta;
    private Deposito<Producto> super8;
    private Deposito<Producto> snickers;
    private Deposito<Producto> bonobon;
    /**deposito de monedas de vuelto*/
    private Deposito<Moneda> monedaVuelto;

    private Producto productoEnDepositoEspecial;
    private Deposito<Moneda> depositoMonedasGanadas;

    /**
     * Constructor que inicializa los depósitos y los llena con una cantidad inicial de productos.
     * Cada producto recibe un número de serie único basado en su tipo.
     *
     * @param numeroProductos Cantidad de unidades para cada tipo de producto.
     */
    public Expendedor(int numeroProductos) {
        //posiciones x e y genericas por el momento ,abiertas a modificacion
        cocacola = new Deposito<Producto>(60, 80);
        sprite = new Deposito<Producto>(120, 80);
        fanta = new Deposito<Producto>(180,  80);
        super8 = new Deposito<Producto>(60, 220);
        snickers = new Deposito<Producto>(120, 220);
        bonobon = new Deposito<Producto>(180, 220);

        monedaVuelto = new Deposito<Moneda>(250, 380);

        depositoMonedasGanadas = new Deposito<Moneda>(320, 380);
        productoEnDepositoEspecial = null;

        if (numeroProductos > 0) {
            for (int i = 0; i < numeroProductos; i = i + 1) {
                Bebida cocas = new CocaCola(100 + i);
                Bebida sprit = new Sprite(200 + i);
                Bebida fantas = new Fanta(300 + i);
                Dulce super8s = new Super8(400 + i);
                Dulce snicker = new Snickers(500 + i);
                Dulce bonbons = new BonoBon(600 + i);

                cocacola.addProducto(cocas);
                sprite.addProducto(sprit);
                fanta.addProducto(fantas);
                super8.addProducto(super8s);
                snickers.addProducto(snicker);
                bonobon.addProducto(bonbons);

            }
        }
    }
    /**
     * Extrae una moneda de vuelto del depósito de monedas.
     *
     * @return Una moneda de 100 del depósito de vuelto, o null si no hay más.
     */
    public Moneda getVuelto() {
        return monedaVuelto.getProducto();
    }

    public Producto getProducto() {
        Producto aux = this.productoEnDepositoEspecial;
        this.productoEnDepositoEspecial = null;
        return aux;
    }

    public void rellenarDepositosVacios() {
        if (cocacola.getArraySize() == 0) {
            cocacola.addProducto(new CocaCola(1000));
        }
        if (sprite.getArraySize() == 0) {
            sprite.addProducto(new Sprite(2000));
        }
        if (fanta.getArraySize() == 0) {
            fanta.addProducto(new Fanta(3000));
        }
        if (super8.getArraySize() == 0) {
            super8.addProducto(new Super8(4000));
        }
        if (snickers.getArraySize() == 0) {
            snickers.addProducto(new Snickers(5000));
        }
        if (bonobon.getArraySize() == 0) {
            bonobon.addProducto(new BonoBon(6000));
        }
    }

    private void generarVueltoDinamico(int vueltoTotal) {
        while (vueltoTotal >= 500) {
            monedaVuelto.addProducto(new Moneda500()); // Asume que tienes la clase Moneda500
            vueltoTotal -= 500;
        }

        while (vueltoTotal >= 100) {
            monedaVuelto.addProducto(new Moneda100());
            vueltoTotal -= 100;
        }
    }
    /**
     * Procesa la compra de un producto validando el pago y el stock disponible.
     * Si la compra es exitosa, calcula y deposita el vuelto en monedas de 100.
     * En caso de error, la moneda entregada se devuelve al depósito de vuelto.
     *
     * @param m La moneda entregada para realizar la compra.
     * @param cual El código identificador del producto que se quiere comprar.
     * @return El producto comprado si la transacción es exitosa.
     * @throws NoHayProductoException Si el código es inválido o no queda stock del producto.
     * @throws PagoInsuficienteException Si el valor de la moneda es menor al precio del producto.
     * @throws PagoIncorrectoException Si se intenta realizar una compra con una moneda nula.
     */

    public void comprarProducto(Moneda m, int cual)
            throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        Producto producto = null;
        if (m == null) {
            throw new PagoIncorrectoException("No se ingresó dinero");
        } else {
            SelectorProductos productos = SelectorProductos.cualPosicion(cual);
            if (productos == null) {
                monedaVuelto.addProducto(m);
                throw new NoHayProductoException("Producto inválido");
            } else {

                switch (productos) {
                    case COCACOLA:
                        if (m.getValor() < productos.getPrecio()) {
                            monedaVuelto.addProducto(m);
                            throw new PagoInsuficienteException("Pago insuficiente");
                        } else if (m.getValor() == productos.getPrecio()) {
                            producto = cocacola.getProducto();

                            if (producto == null) {
                                monedaVuelto.addProducto(m); // devuelve moneda
                                throw new NoHayProductoException("No queda CocaCola en stock");
                            }

                        } else {
                            producto = cocacola.getProducto();
                            if (producto == null) {
                                monedaVuelto.addProducto(m);
                                throw new NoHayProductoException("No queda CocaCola en stock");
                            } else {
                                int vuelto = m.getValor() - productos.getPrecio();
                                generarVueltoDinamico(vuelto);
                            }
                        }
                        break;

                    case SPRITE:
                        if (m.getValor() < productos.getPrecio()) {
                            monedaVuelto.addProducto(m);
                            throw new PagoInsuficienteException("Pago insuficiente");
                        } else if (m.getValor() == productos.getPrecio()) {
                            producto = sprite.getProducto();
                            if (producto == null) {
                                monedaVuelto.addProducto(m);
                                throw new NoHayProductoException("No queda Sprite en stock");
                                //
                            }
                        } else {
                            producto = sprite.getProducto();
                            if (producto == null) {
                                monedaVuelto.addProducto(m);
                                throw new NoHayProductoException("No queda Sprite en stock");
                            } else {
                                int vuelto = m.getValor() - productos.getPrecio();
                                generarVueltoDinamico(vuelto);
                            }
                        }
                        break;

                    case FANTA:
                        if (m.getValor() < productos.getPrecio()) {
                            monedaVuelto.addProducto(m);
                            throw new PagoInsuficienteException("Pago insuficiente");
                        } else if (m.getValor() == productos.getPrecio()) {
                            producto = fanta.getProducto();
                            if (producto == null) {
                                monedaVuelto.addProducto(m);
                                throw new NoHayProductoException("No queda Fanta en stock");
                                //
                            }
                        } else {
                            producto = fanta.getProducto();
                            if (producto == null) {
                                monedaVuelto.addProducto(m);
                                throw new NoHayProductoException("No queda Fanta en stock");
                            } else {
                                int vuelto = m.getValor() - productos.getPrecio();
                                generarVueltoDinamico(vuelto);
                            }
                        }
                        break;

                    case SUPER8:
                        if (m.getValor() < productos.getPrecio()) {
                            monedaVuelto.addProducto(m);
                            throw new PagoInsuficienteException("Pago insuficiente");
                        } else if (m.getValor() == productos.getPrecio()) {
                            producto = super8.getProducto();
                            if (producto == null) {
                                monedaVuelto.addProducto(m);
                                throw new NoHayProductoException("No quedan super8 en stock");
                                //
                            }
                        } else {
                            producto = super8.getProducto();
                            if (producto == null) {
                                monedaVuelto.addProducto(m);
                                throw new NoHayProductoException("No quedan super8 en stock");
                            } else {
                                int vuelto = m.getValor() - productos.getPrecio();
                                generarVueltoDinamico(vuelto);
                            }
                        }
                        break;
                    case SNICKERS:
                        if (m.getValor() < productos.getPrecio()) {
                            monedaVuelto.addProducto(m);
                            throw new PagoInsuficienteException("Pago insuficiente");
                        } else if (m.getValor() == productos.getPrecio()) {
                            producto = snickers.getProducto();
                            if (producto == null) {
                                monedaVuelto.addProducto(m);
                                throw new NoHayProductoException("No quedan snickers en stock");
                                //
                            }
                        } else {
                            producto = snickers.getProducto();
                            if (producto == null) {
                                monedaVuelto.addProducto(m);
                                throw new NoHayProductoException("No quedan snickers en stock");
                            } else {
                                int vuelto = m.getValor() - productos.getPrecio();
                                generarVueltoDinamico(vuelto);
                            }
                        }
                        break;
                    case BONOBON:
                        if (m.getValor() < productos.getPrecio()) {
                            monedaVuelto.addProducto(m);
                            throw new PagoInsuficienteException("Pago insuficiente");
                        } else if (m.getValor() == productos.getPrecio()) {
                            producto = bonobon.getProducto();
                            if (producto == null) {
                                monedaVuelto.addProducto(m);
                                throw new NoHayProductoException("No quedan BonoBon en stock");
                                //
                            }
                        } else {
                            producto = bonobon.getProducto();
                            if (producto == null) {
                                monedaVuelto.addProducto(m);
                                throw new NoHayProductoException("No quedan BonoBon en stock");
                            } else {
                                int vuelto = m.getValor() - productos.getPrecio();
                                generarVueltoDinamico(vuelto);
                            }
                        }
                        break;
                }
            }
        }
        if (producto != null) {
            this.depositoMonedasGanadas.addProducto(m);
        }

        this.productoEnDepositoEspecial = producto;
    }

    public void paintComponent(Graphics g) {

        g.setColor(Color.DARK_GRAY);
        g.fillRect(50, 50, 400, 500);
        g.setColor(Color.BLACK);
        g.drawRect(50, 50, 400, 500);

        cocacola.paintComponent(g);
        sprite.paintComponent(g);
        fanta.paintComponent(g);
        super8.paintComponent(g);
        snickers.paintComponent(g);
        bonobon.paintComponent(g);


        monedaVuelto.paintComponent(g);
        depositoMonedasGanadas.paintComponent(g);

        int especialX = 60;
        int especialY = 380;
        g.setColor(Color.BLACK);
        g.fillRect(especialX, especialY, 150, 60);

        if (productoEnDepositoEspecial != null) {
            productoEnDepositoEspecial.setXY(especialX + 50, especialY + 20);
            productoEnDepositoEspecial.paintComponent(g, 40, 20);
        }

    }
}