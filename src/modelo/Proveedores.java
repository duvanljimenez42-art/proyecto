package modelo;


public class Proveedores {
    private int id;
    private String documentoNit;
    private String razon_social;
    private String direccion;
    private String telefono;
    private String email;
    private String especialidad;
    private String terminos_pago;

    public Proveedores(int id, String documentoNit, String razon_social, String direccion, String telefono, String email, String especialidad, String terminosPago) {
        this.id = id;
        this.documentoNit = documentoNit;
        this.razon_social = razon_social;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.especialidad = especialidad;
        this.terminos_pago = terminosPago;
    }

    public Proveedores() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDocumentoNit(String documentoNit) {
        this.documentoNit = documentoNit;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setTerminos_pago(String terminos_pago) {
        this.terminos_pago = terminos_pago;
    }

    public int getId() {
        return id;
    }

    public String getDocumentoNit() {
        return documentoNit;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getTerminos_pago() {
        return terminos_pago;
    }

    @Override
    public String toString() {
        return "Proveedores{" + "id=" + id + ", documentoNit=" + documentoNit + ", razon_social=" + razon_social + ", direccion=" + direccion + ", telefono=" + telefono + ", email=" + email + ", especialidad=" + especialidad + ", terminos_pago=" + terminos_pago + '}';
    }

    
}
