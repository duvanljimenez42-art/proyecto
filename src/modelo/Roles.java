package modelo;


public class Roles {
    private int id;
    private String nombre;

    public Roles(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Roles() {
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
        return "Roles{" + "id=" + id + ", nombre=" + nombre + '}';
    }
    
    
}
