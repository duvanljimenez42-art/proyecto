package dao;

import java.util.List;

public interface CRUD {
    Object insertar (Object obj);
    boolean actualizar (Object obj);
    boolean eliminar (Object obj);
    List<Object> listarTodo();
    Object listarUno (Object obj);
}
