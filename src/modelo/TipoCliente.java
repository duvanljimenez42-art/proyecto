package modelo;


public class TipoCliente {
    private int id;
    private String nombre;

    public TipoCliente(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public TipoCliente() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "TipoCliente{" + "id=" + id + ", nombre=" + nombre + '}';
    }
    
    
}
