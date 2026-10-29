
package modelo;

import dao.CRUD;
import dao.Conexion;
import java.util.List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class AdminProductosDB extends Conexion implements CRUD{
    
    @Override
    public Object insertar(Object obj) {
        Connection conex = abrirConexion();
        Productos objProductos = (Productos) obj;
        try {
            String sql = "INSERT INTO Productos(id_codigo,nombre,descripcion,categoria,actual,stock_actual,stock_minimo,precio_compra,precio_venta,porcentaje_iva,id_proveedor) VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, objProductos.getId_codigo());
            preparedStatement.setString(2, objProductos.getNombre());
            preparedStatement.setString(3, objProductos.getDescripcion());
            preparedStatement.setInt(4, objProductos.getStock_actual());
            preparedStatement.setInt(5, objProductos.getStock_minimo()); 
            preparedStatement.setFloat(6, objProductos.getPrecio_compra());
            preparedStatement.setFloat(7, objProductos.getPrecio_venta());
            preparedStatement.setFloat(8, objProductos.getPorcentaje_iva());
            preparedStatement.setString(9, objProductos.getFecha_ultima_actualizacion());
            preparedStatement.setInt(10, objProductos.getProveedores_id());
            preparedStatement.setInt(11, objProductos.getCategoria_id());
            preparedStatement.execute();
            
            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                objProductos.setId_codigo(rs.getInt(1));
            }
            preparedStatement.close();
            //JOptionPane.showMessageDialog(null, "La inserción de la persona fue exitosa.");
            System.out.println("La inserción de la persona fue exitosa.");
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Error al insertar la persona: "+e.getMessage());
            System.out.println("Error al insertar la persona: "+e.getMessage());
        }
        cerrarConexion();
        return objProductos;
    }

    @Override
    public boolean actualizar(Object obj) {
        Productos objProductos = (Productos) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
                String sql = "UPDATE Productos SET id_codigo=?,nombre=?,descripcion=?,Stock_actual=?,Stock_minimo=?,Precio_compra=?,precio_venta=?,porcentaje_iva=?,Fecha_ultima_actualizacion=?,Fecha_ultima_actualizacion=?,Proveedores_id=?,Categoria_id=? WHERE id=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objProductos.getId_codigo());
            preparedStatement.setString(2, objProductos.getNombre());
            preparedStatement.setString(3, objProductos.getDescripcion());
            preparedStatement.setInt(4, objProductos.getStock_actual());
            preparedStatement.setInt(5, objProductos.getStock_minimo()); 
            preparedStatement.setFloat(6, objProductos.getPrecio_compra());
            preparedStatement.setFloat(7, objProductos.getPrecio_venta());
            preparedStatement.setFloat(8, objProductos.getPorcentaje_iva());
            preparedStatement.setString(9, objProductos.getFecha_ultima_actualizacion());
            preparedStatement.setInt(10, objProductos.getProveedores_id());
            preparedStatement.setInt(11, objProductos.getCategoria_id());
            int totalFilasafectadas = preparedStatement.executeUpdate();
            if(totalFilasafectadas>0){
                flag = true;
            }
            preparedStatement.close();
            
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Error en la actualización del cliente: "+e.getMessage());
            System.out.println("Error en la actualización del cliente: "+e.getMessage());
        }
        cerrarConexion();
        return flag;    
    }

    @Override
    public boolean eliminar(Object obj) {
        Productos objProductos = (Productos) obj;
         boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "DELETE FROM Productos WHERE id=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objProductos.getId_codigo());
            int totalFilasafectadas = preparedStatement.executeUpdate();
            if(totalFilasafectadas>0){
                flag = true;
            }
            preparedStatement.close();
            
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Error al eliminar el cliente: "+e.getMessage());
            System.out.println("Error al eliminar el cliente: "+e.getMessage());
        }
        cerrarConexion();
        return flag;
    }

    @Override
    public List<Object> listarTodo() {
        List<Object> rowsQuery = new ArrayList<Object>();
        Connection conex = abrirConexion();
        Productos objProductos;
        try {
            String sql = "SELECT * FROM Productos ORDER BY documento_Nit ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objProductos = new Productos();
                objProductos.setId_codigo(resultSet.getInt("id codigo"));
                objProductos.setNombre(resultSet.getString("nombre"));
                objProductos.setDescripcion(resultSet.getString("descripcion"));
                objProductos.setStock_actual(resultSet.getInt("Stock actual"));
                objProductos.setStock_minimo(resultSet.getInt("Stock minimo"));
                objProductos.setPrecio_compra(resultSet.getFloat("precio compra"));
                objProductos.setPrecio_venta(resultSet.getFloat("precio venta"));
                objProductos.setPorcentaje_iva(resultSet.getFloat("porcentaje iva"));
                objProductos.setFecha_ultima_actualizacion(resultSet.getString("fecha de ultima actualizacion"));
                objProductos.setProveedores_id(resultSet.getInt("proveedores_id"));
                objProductos.setCategoria_id(resultSet.getInt("categoria_id"));
                rowsQuery.add(objProductos);
            }
            preparedStatement.close();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            System.out.println("Error en la adquisición de datos");
        }
        cerrarConexion();
        return rowsQuery;
    }

    @Override
    public Object listarUno(Object obj) {
        Connection conex = abrirConexion();
        Productos objProductos = (Productos) obj;
        try {
            String sql = "SELECT * FROM Productos WHERE id = ?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objProductos.getId_codigo());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objProductos.setId_codigo(resultSet.getInt("id codigo"));
                objProductos.setNombre(resultSet.getString("nombre"));
                objProductos.setDescripcion(resultSet.getString("descripcion"));
                objProductos.setStock_actual(resultSet.getInt("Stock actual"));
                objProductos.setStock_minimo(resultSet.getInt("Stock minimo"));
                objProductos.setPrecio_compra(resultSet.getFloat("precio compra"));
                objProductos.setPrecio_venta(resultSet.getFloat("precio venta"));
                objProductos.setPorcentaje_iva(resultSet.getFloat("porcentaje iva"));
                objProductos.setFecha_ultima_actualizacion(resultSet.getString("fecha de ultima actualizacion"));
                objProductos.setProveedores_id(resultSet.getInt("proveedores_id"));
                objProductos.setCategoria_id(resultSet.getInt("categoria_id"));
            }

            preparedStatement.close();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Error en la adquisición de datos: "+ex.getMessage());
            System.out.println("Error en la adquisición de datos: "+ex.getMessage());
        }

        cerrarConexion();
        return objProductos;
    }
}
