
package modelo;


public class Productos {
    private int id_codigo;
    private String nombre;
    private String descripcion;
    private int stock_actual;
    private int stock_minimo;
    private float precio_compra;
    private float precio_venta;
    private float porcentaje_iva;
    private String fecha_ultima_actualizacion;
    private int proveedores_id;
    private int categoria_id;

    public Productos(int id_codigo, String nombre, String descripcion, int stock_actual, int stock_minimo, float precio_compra, float precio_venta, float porcentaje_iva, String fecha_ultima_actualizacion, int proveedores_id, int categoria_id) {
        this.id_codigo = id_codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.stock_actual = stock_actual;
        this.stock_minimo = stock_minimo;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
        this.porcentaje_iva = porcentaje_iva;
        this.fecha_ultima_actualizacion = fecha_ultima_actualizacion;
        this.proveedores_id = proveedores_id;
        this.categoria_id = categoria_id;
    }
    

    public Productos() {
    }

    public int getId_codigo() {
        return id_codigo;
    }

    public void setId_codigo(int id_codigo) {
        this.id_codigo = id_codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock_actual() {
        return stock_actual;
    }

    public void setStock_actual(int stock_actual) {
        this.stock_actual = stock_actual;
    }

    public int getStock_minimo() {
        return stock_minimo;
    }

    public void setStock_minimo(int stock_minimo) {
        this.stock_minimo = stock_minimo;
    }

    public float getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(float precio_compra) {
        this.precio_compra = precio_compra;
    }

    public float getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(float precio_venta) {
        this.precio_venta = precio_venta;
    }

    public float getPorcentaje_iva() {
        return porcentaje_iva;
    }

    public void setPorcentaje_iva(float porcentaje_iva) {
        this.porcentaje_iva = porcentaje_iva;
    }

    public String getFecha_ultima_actualizacion() {
        return fecha_ultima_actualizacion;
    }

    public void setFecha_ultima_actualizacion(String fecha_ultima_actualizacion) {
        this.fecha_ultima_actualizacion = fecha_ultima_actualizacion;
    }

    public int getProveedores_id() {
        return proveedores_id;
    }

    public void setProveedores_id(int proveedores_id) {
        this.proveedores_id = proveedores_id;
    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categorias_id) {
        this.categoria_id = categorias_id;
    }

    @Override
    public String toString() {
        return "Productos{" + "id_codigo=" + id_codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", stock_actual=" + stock_actual + ", stock_minimo=" + stock_minimo + ", precio_compra=" + precio_compra + ", precio_venta=" + precio_venta + ", porcentaje_iva=" + porcentaje_iva + ", fecha_ultima_actualizacion=" + fecha_ultima_actualizacion + ", proveedores_id=" + proveedores_id + ", categoria_id=" + categoria_id + '}';
    }

    
    
    
}
