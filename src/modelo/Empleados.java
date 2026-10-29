package modelo;


public class Empleados {
    private int id;
    private String documento_identidad;
    private String nombres_apellidos;
    private String email;
    private String telefono;
    private String clave;
    private int roles_id;

    public Empleados(int id, String documento_identidad, String nombre_apellidos, String email, String telefono, String clave, int roles_id) {
        this.id = id;
        this.documento_identidad = documento_identidad;
        this.nombres_apellidos = nombres_apellidos;
        this.email = email;
        this.telefono = telefono;
        this.clave = clave;
        this.roles_id = roles_id;
    }

    public Empleados() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDocumento_identidad(String documento_identidad) {
        this.documento_identidad = documento_identidad;
    }

    public void setNombres_apellidos(String nombres_apellidos) {
        this.nombres_apellidos = nombres_apellidos;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setRoles_id(int roles_id) {
        this.roles_id = roles_id;
    }

    public int getId() {
        return id;
    }

    public String getDocumento_identidad() {
        return documento_identidad;
    }

    public String getNombres_apellidos() {
        return nombres_apellidos;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getClave() {
        return clave;
    }

    public int getRoles_id() {
        return roles_id;
    }

    @Override
    public String toString() {
        return "Empleados{" + "id=" + id + ", documento_identidad=" + documento_identidad + ", nombres_apellidos=" + nombres_apellidos + ", email=" + email + ", telefono=" + telefono + ", clave=" + clave + ", roles_id=" + roles_id + '}';
    }    
    
}
