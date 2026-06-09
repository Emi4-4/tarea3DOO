package interfaz;

import javax.swing.*;
import java.awt.*;
import org.example.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class PanelComprador extends JPanel {
    private PanelExpendedor panelExpendedor;
    private Expendedor expendedor;
    private Moneda monedaSeleccionada;

    // variables para definir el estado actual
    private int productoSeleccionado;
    private String mensaje;
    private String ultimoProducto;
    private int monedero;
    private int ultimoVuelto;

    //zonas de monedas, el espacio donde se recoge el producto y el vuelto etc
    private Rectangle zonaMoneda100, zonaMoneda500, zonaMoneda1000, zonaMoneda1500;
    private ArrayList<Rectangle> zonasProductos;
    private Rectangle zonaComprar;
    private Rectangle zonaRecogerProducto;
    private Rectangle zonaRecogerVuelto;



    public PanelComprador(int DineroInicial) {
        super();
        this.monedero = DineroInicial; // Saldo inicial
        this.mensaje = "Seleccione moneda y producto";
        this.ultimoProducto = "";
        this.ultimoVuelto = 0;
        this.monedaSeleccionada = null;
        this.productoSeleccionado = -1;
        this.setBackground(new Color(220, 220, 220));
        this.setPreferredSize(new Dimension(400, 600));

        zonasProductos = new ArrayList<>();
        zonasProductos.add(new Rectangle(30, 120, 80, 40)); // Coca
        zonasProductos.add(new Rectangle(130, 120, 80, 40)); // Sprite
        zonasProductos.add(new Rectangle(230, 120, 80, 40)); // Fanta
        zonasProductos.add(new Rectangle(330, 120, 80, 40)); // Snickers
        zonasProductos.add(new Rectangle(30, 180, 80, 40)); // Super8
        zonasProductos.add(new Rectangle(130, 180, 80, 40)); // Bonobon

        zonaMoneda100 = new Rectangle(30, 50, 80, 40);
        zonaMoneda500 = new Rectangle(130, 50, 80, 40);
        zonaMoneda1000 = new Rectangle(230, 50, 80, 40);
        zonaMoneda1500 = new Rectangle(330, 50, 80, 40);

        zonaComprar = new Rectangle(30, 250, 150, 50);
        zonaRecogerProducto = new Rectangle(200, 250, 150, 50);
        zonaRecogerVuelto = new Rectangle(30, 320, 320, 50);

        //
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clickMouse(e.getX(), e.getY());
            }
        });

    }

    public void clickMouse(int x, int y) {
        if (zonaMoneda100.contains(x, y)) {
            if (monedero >= 100){
                monedaSeleccionada = new Moneda100();
            } else {
                mensaje = "Saldo insuficiente";
            }
        } else if (zonaMoneda500.contains(x, y)) {
            if (monedero >= 500){
                monedaSeleccionada = new Moneda500();
            } else {
                mensaje = "Saldo insuficiente";
            }
        } else if (zonaMoneda1000.contains(x, y)) {
            if (monedero >= 1000){
                monedaSeleccionada = new Moneda1000();
            } else {
                mensaje = "Saldo insuficiente";
            }
        } else if (zonaMoneda1500.contains(x, y)) {
            if (monedero >= 1500){
                monedaSeleccionada = new Moneda1500();
            } else {
                mensaje = "Saldo insuficiente";
            }
        }
        // Seleccionar producto
        else {
            for(int i = 0; i < zonasProductos.size(); i++){
                if (zonasProductos.get(i).contains(x, y)) {
                    productoSeleccionado = i + 1;
                    String[] nombres = {"Coca", "Sprite", "Fanta", "Snickers", "Super8", "Bonobon"};// 1=Coca, 2=Sprite, 3=Fanta, 4=Snickers, 5=Super8, 6=Bonobon
                    int[] precios = {1000, 900, 1100, 1400, 800, 600};
                    mensaje = nombres[i] + " seleccionado ($" + precios[i] + ")";
                    break;
                }
            }
        }
        // la compra
        if (zonaComprar.contains(x, y)) {
            if (monedaSeleccionada == null) {
                mensaje = "Primero seleccione una moneda";
            } else if (productoSeleccionado == -1) {
                mensaje = "Primero seleccione un producto";
            } else {
                try {
                    expendedor.comprarProducto(monedaSeleccionada, productoSeleccionado);
                    // Si llegamos aquí, la compra fue exitosa (el producto está en depósito especial)
                    mensaje = "Compra exitosa! Recoga su producto y vuelto";
                    monedero = monedero - monedaSeleccionada.getValor();
                    monedaSeleccionada = null;
                    productoSeleccionado = -1;
                    panelExpendedor.revalidate();
                    panelExpendedor.repaint();
                } catch (PagoIncorrectoException | PagoInsuficienteException | NoHayProductoException ex) {
                    mensaje = "Error: " + ex.getMessage();
                    monedaSeleccionada = null;
                    // Devolver moneda en caso de error
                    Moneda devuelta = expendedor.getVuelto();
                    if (devuelta != null) {
                        mensaje += " | Se devolvió $" + devuelta.getValor();
                    }
                }
            }
        }
        // recoger el producto
        if (zonaRecogerProducto.contains(x, y)) {
            Producto p = expendedor.getProducto();
            if (p != null) {
                ultimoProducto = p.consumir();
                mensaje = "Producto recogido: " + ultimoProducto;
            } else {
                mensaje = "No hay producto en el depósito";
            }
        }

        //recoger vuelto
        if (zonaRecogerVuelto.contains(x, y)) {
            int vueltoTotal = 0;
            Moneda v;
            while ((v = expendedor.getVuelto()) != null) {
                vueltoTotal += v.getValor();
            }
            if (vueltoTotal > 0) {
                monedero += vueltoTotal;
                ultimoVuelto = vueltoTotal;
                mensaje = "Vuelto recogido: $" + vueltoTotal;
            } else {
                mensaje = "No hay vuelto";
            }
        }

        repaint();
    }
    public void setExpendedor(PanelExpendedor panelExpendedor){
        this.panelExpendedor = panelExpendedor;
        this.expendedor = panelExpendedor.getExpendedor();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        Font font = new Font("Arial", Font.BOLD, 14);
        g.setFont(font);


        g.setColor(Color.BLACK);
        g.drawString("Monedero: $" + monedero, 30, 30);

        dibujarZona(g, zonaMoneda100, "$100", new Color(220, 220, 220));
        dibujarZona(g, zonaMoneda500, "$500", new Color(255, 182, 193));
        dibujarZona(g, zonaMoneda1000, "$1000", new Color(144, 238, 144));
        dibujarZona(g, zonaMoneda1500, "$1500", new Color(173, 216, 230));

        g.drawString("PRODUCTOS", 30, 115);
        String[] nombresProductos = {"Coca", "Sprite", "Fanta", "Snickers", "Super8", "Bonobon"};
        Color[] coloresProductos = {
                new Color(255, 99, 71),
                new Color(152, 251, 152),
                new Color(255, 165, 0),
                new Color(210, 105, 30),
                new Color(255, 215, 0),
                new Color(255, 192, 203)
        };

        for (int i = 0; i < zonasProductos.size(); i++) {
            dibujarZona(g, zonasProductos.get(i), nombresProductos[i], coloresProductos[i]);
        }

        dibujarZona(g, zonaComprar, "COMPRAR", new Color(50, 205, 50));
        dibujarZona(g, zonaRecogerProducto, "Sacar Producto", new Color(100, 149, 237));
        dibujarZona(g, zonaRecogerVuelto, "Recoger Vuelto", new Color(255, 228, 181));

        g.setColor(Color.BLUE);
        g.drawString("Mensaje: " + mensaje, 30, 410);

        g.setColor(Color.DARK_GRAY);

        String txtMoneda = (monedaSeleccionada != null) ? "$" + monedaSeleccionada.getValor() : "Ninguna";
        g.drawString("Moneda en mano: " + txtMoneda, 30, 440);

        String txtProd = (productoSeleccionado != -1) ? nombresProductos[productoSeleccionado - 1] : "Ninguno";
        g.drawString("Producto a pedir: " + txtProd, 30, 470);

        g.drawString("Último producto retirado: " + (ultimoProducto.isEmpty() ? "Ninguno" : ultimoProducto), 30, 500);
    }

    private void dibujarZona(Graphics g, Rectangle rect, String texto, Color color) {
        g.setColor(color);
        g.fillRect(rect.x, rect.y, rect.width, rect.height);
        g.setColor(Color.BLACK);
        g.drawRect(rect.x, rect.y, rect.width, rect.height);
        FontMetrics fm = g.getFontMetrics();
        int anchoTexto = fm.stringWidth(texto);
        int altoTexto = fm.getHeight();
        g.drawString(texto, rect.x + (rect.width - anchoTexto) / 2, rect.y + (rect.height + altoTexto) / 2 - 2);
    }
}
