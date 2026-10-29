
package modelo;


public class OrdenesCompra {
    private int id;
    private String numero_orden;
    private String fecha_estimada_entrega;
    private String estado;
    private float total;
    private int proveedores_id;
    private int empleados_id;

    public OrdenesCompra() {
    }

    public OrdenesCompra(int id, String numero_orden, String fecha_estimada_entrega, String estado, float total, int proveedores_id, int empleados_id) {
        this.id = id;
        this.numero_orden = numero_orden;
        this.fecha_estimada_entrega = fecha_estimada_entrega;
        this.estado = estado;
        this.total = total;
        this.proveedores_id = proveedores_id;
        this.empleados_id = empleados_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero_orden() {
        return numero_orden;
    }

    public void setNumero_orden(String numero_orden) {
        this.numero_orden = numero_orden;
    }

    public String getFecha_estimada_entrega() {
        return fecha_estimada_entrega;
    }

    public void setFecha_estimada_entrega(String fecha_estimada_entrega) {
        this.fecha_estimada_entrega = fecha_estimada_entrega;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getProveedores_id() {
        return proveedores_id;
    }

    public void setProveedores_id(int proveedores_id) {
        this.proveedores_id = proveedores_id;
    }

    public int getEmpleados_id() {
        return empleados_id;
    }

    public void setEmpleados_id(int empleados_id) {
        this.empleados_id = empleados_id;
    }

    @Override
    public String toString() {
        return "OrdenesCompra{" + "id=" + id + ", numero_orden=" + numero_orden + ", fecha_estimada_entrega=" + fecha_estimada_entrega + ", estado=" + estado + ", total=" + total + ", proveedores_id=" + proveedores_id + ", empleados_id=" + empleados_id + '}';
    }
    
    
}
