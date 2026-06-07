package org.example;
/**
 * Enumeración que define el catálogo de productos disponibles en el expendedor.
 * Cada elemento asocia un nombre de producto con su código identificador y su precio.
 *
 * @author Valentina (arenisca)
 * @author Emiliano (Emi4-4)
 * @version 1.0
 */
public enum SelectorProductos {
    /** Bebida CocaCola - Código 1, Precio $1000 */
    COCACOLA(1,1000),
    /** Bebida Sprite - Código 2, Precio $900 */
    SPRITE(2,900),
    /** Bebida Fanta - Código 3, Precio $1100 */
    FANTA(3,1100),
    /** Dulce Snickers - Código 4, Precio $1400 */
    SNICKERS(4,1400),
    /** Dulce Super8 - Código 5, Precio $800 */
    SUPER8(5,800),
    /** Dulce BonoBon - Código 6, Precio $600 */
    BONOBON(6,600);
    /** Precio del producto */
    private final int precio;
    /**numero que identifica al producto*/
    private final int numero;
    /**
     * Constructor del enum para asignar valores a cada producto.
     *
     * @param numero numero del producto
     * @param precio Valor del producto
     */
    SelectorProductos(int numero,int precio){
        this.precio = precio;
        this.numero  = numero;
    }
    /**
     * Busca y retorna el producto que corresponde al numero dado.
     *
     * @param posicion El número ingresado por el usuario.
     * @return El producto correspondiente, o null si el código no existe.
     */
    public static SelectorProductos cualPosicion(int posicion){
        for (SelectorProductos producto : SelectorProductos.values()){
            if (producto.getTipoProducto() == posicion){
                return producto;
            }
        }
        return null;
    }
    /**
     * Obtiene el precio asociado al producto.
     *
     * @return Valor del producto.
     */
    public int getPrecio(){
        return precio;
    }
    /**
     * Obtiene el numero asociado al producto.
     *
     * @return numero del prudcot.
     */
    public int getTipoProducto() {
        return numero;
    }
}