
package modelo;


public class Clientes {
    private int id;
    private String documento_nit;
    private String nombres_apellidos;
    private String direccion;
    private String telefono;
    private String email;
    private String nombre_comercial;
    private String contacto_autorizado;
    private int tipoCliente_id;

    public Clientes(int id, String documento_nit, String nombres_apellidos, String direccion, String telefono, String email, String nombre_comercial, String contacto_autorizado, int tipoCliente_id) {
        this.id = id;
        this.documento_nit = documento_nit;
        this.nombres_apellidos = nombres_apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.nombre_comercial = nombre_comercial;
        this.contacto_autorizado = contacto_autorizado;
        this.tipoCliente_id = tipoCliente_id;
    }

    

    public Clientes() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocumento_nit() {
        return documento_nit;
    }

    public void setDocumento_nit(String documento_nit) {
        this.documento_nit = documento_nit;
    }

    public String getNombres_apellidos() {
        return nombres_apellidos;
    }

    public void setNombres_apellidos(String nombres_apellidos) {
        this.nombres_apellidos = nombres_apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre_comercial() {
        return nombre_comercial;
    }

    public void setNombre_comercial(String nombre_comercial) {
        this.nombre_comercial = nombre_comercial;
    }

    public String getContacto_autorizado() {
        return contacto_autorizado;
    }

    public void setContacto_autorizado(String contacto_autorizado) {
        this.contacto_autorizado = contacto_autorizado;
    }

    public int getTipoCliente_id() {
        return tipoCliente_id;
    }

    public void setTipoCliente_id(int tipoCliente_id) {
        this.tipoCliente_id = tipoCliente_id;
    }

    

    @Override
    public String toString() {
        return "Clientes{" + "id=" + id + ", documento_nit=" + documento_nit + ", nombres_apellidos=" + nombres_apellidos + ", direccion=" + direccion + ", telefono=" + telefono + ", email=" + email + ", nombre_comercial=" + nombre_comercial + ", contacto_autorizado=" + contacto_autorizado + ", tipoCliente_id=" + tipoCliente_id + '}';
    }
    
    
}
