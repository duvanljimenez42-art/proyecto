
package modelo;


public class VentasFactura {
    private int id;
    private String numero_factura;
    private String fecha_hora;
    private String metodo_pago;
    private float costo_servicio_adicional;
    private float subtotal;
    private float iva_total;
    private float total;
    private int empleados_id;
    private int clientes_id;

    public VentasFactura(int id, String numero_factura, String fecha_hora, String metodo_pago, float costo_servicio_adicional, float subtotal, float iva_total, float total, int empleados_id, int clientes_id) {
        this.id = id;
        this.numero_factura = numero_factura;
        this.fecha_hora = fecha_hora;
        this.metodo_pago = metodo_pago;
        this.costo_servicio_adicional = costo_servicio_adicional;
        this.subtotal = subtotal;
        this.iva_total = iva_total;
        this.total = total;
        this.empleados_id = empleados_id;
        this.clientes_id = clientes_id;
    }

    

    public VentasFactura() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero_factura() {
        return numero_factura;
    }

    public void setNumero_factura(String numero_factura) {
        this.numero_factura = numero_factura;
    } 

    public String getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(String fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public float getCosto_servicio_adicional() {
        return costo_servicio_adicional;
    }

    public void setCosto_servicio_adicional(float costo_servicio_adicional) {
        this.costo_servicio_adicional = costo_servicio_adicional;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getIva_total() {
        return iva_total;
    }

    public void setIva_total(float iva_total) {
        this.iva_total = iva_total;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getEmpleados_id() {
        return empleados_id;
    }

    public void setEmpleados_id(int empleados_id) {
        this.empleados_id = empleados_id;
    }

    public int getClientes_id() {
        return clientes_id;
    }

    public void setClientes_id(int clientes_id) {
        this.clientes_id = clientes_id;
    }

    @Override
    public String toString() {
        return "VentasFactura{" + "id=" + id + ", numero_factura=" + numero_factura + ", fecha_hora=" + fecha_hora + ", metodo_pago=" + metodo_pago + ", costo_servicio_adicional=" + costo_servicio_adicional + ", subtotal=" + subtotal + ", iva_total=" + iva_total + ", total=" + total + ", empleados_id=" + empleados_id + ", clientes_id=" + clientes_id + '}';
    }
    
}
