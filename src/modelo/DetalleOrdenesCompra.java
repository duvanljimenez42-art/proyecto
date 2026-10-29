
package modelo;


public class DetalleOrdenesCompra {
    private int id;
    private int cantidad;
    private float precio_compra;
    private int ordenesCompra_id;
    private int productos_id_codigo;

    public DetalleOrdenesCompra() {
    }

    public DetalleOrdenesCompra(int id, int cantidad, float precio_compra, int ordenesCompra_id, int productos_id_codigo) {
        this.id = id;
        this.cantidad = cantidad;
        this.precio_compra = precio_compra;
        this.ordenesCompra_id = ordenesCompra_id;
        this.productos_id_codigo = productos_id_codigo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(float precio_compra) {
        this.precio_compra = precio_compra;
    }

    public int getOrdenesCompra_id() {
        return ordenesCompra_id;
    }

    public void setOrdenesCompra_id(int ordenesCompra_id) {
        this.ordenesCompra_id = ordenesCompra_id;
    }

    public int getProductos_id_codigo() {
        return productos_id_codigo;
    }

    public void setProductos_id_codigo(int productos_id_codigo) {
        this.productos_id_codigo = productos_id_codigo;
    }

    @Override
    public String toString() {
        return "DetalleOrdenesCompra{" + "id=" + id + ", cantidad=" + cantidad + ", precio_compra=" + precio_compra + ", ordenesCompra_id=" + ordenesCompra_id + ", productos_id_codigo=" + productos_id_codigo + '}';
    }
    
    
}
