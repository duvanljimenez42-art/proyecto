
package modelo;


public class RelaTotalVentasRegistradas {
    private String numero_factura;
    private String cliente;
    private String vendedor;
    private String fecha_hora;
    private String total;

    public RelaTotalVentasRegistradas() {
    }

    public RelaTotalVentasRegistradas(String numero_factura, String cliente, String vendedor, String fecha_hora, String total) {
        this.numero_factura = numero_factura;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.fecha_hora = fecha_hora;
        this.total = total;
    }

    public String getNumero_factura() {
        return numero_factura;
    }

    public void setNumero_factura(String numero_factura) {
        this.numero_factura = numero_factura;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(String fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "relaTotalVentasRegistradas{" + "numero_factura=" + numero_factura + ", cliente=" + cliente + ", vendedor=" + vendedor + ", fecha_hora=" + fecha_hora + ", total=" + total + '}';
    }
}
