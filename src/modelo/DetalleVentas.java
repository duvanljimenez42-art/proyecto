
package modelo;


public class DetalleVentas {
    private int id;
    private float cantidad;
    private float precio_unitario;
    private float porcentaje_iva;
    private float subtotal_item;
    private int ventasFactura_id;
    private int productos_id_codigo;
    
    public DetalleVentas() {
    }

    public DetalleVentas(int id, float cantidad, float precio_unitario, float porcentaje_iva, float subtotal_item, int ventasFactura_id, int productos_id_codigo) {
        this.id = id;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
        this.porcentaje_iva = porcentaje_iva;
        this.subtotal_item = subtotal_item;
        this.ventasFactura_id = ventasFactura_id;
        this.productos_id_codigo = productos_id_codigo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(float precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public float getPorcentaje_iva() {
        return porcentaje_iva;
    }

    public void setPorcentaje_iva(float porcentaje_iva) {
        this.porcentaje_iva = porcentaje_iva;
    }

    public float getSubtotal_item() {
        return subtotal_item;
    }

    public void setSubtotal_item(float subtotal_item) {
        this.subtotal_item = subtotal_item;
    }

    public int getVentasFactura_id() {
        return ventasFactura_id;
    }

    public void setVentasFactura_id(int ventasFactura_id) {
        this.ventasFactura_id = ventasFactura_id;
    }

    public int getProductos_id_codigo() {
        return productos_id_codigo;
    }

    public void setProductos_id_codigo(int productos_id_codigo) {
        this.productos_id_codigo = productos_id_codigo;
    }

    @Override
    public String toString() {
        return "DetalleVentas{" + "id=" + id + ", cantidad=" + cantidad + ", precio_unitario=" + precio_unitario + ", porcentaje_iva=" + porcentaje_iva + ", subtotal_item=" + subtotal_item + ", ventasFactura_id=" + ventasFactura_id + ", productos_id_codigo=" + productos_id_codigo + '}';
    }
    
    
}
