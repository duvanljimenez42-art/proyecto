
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

public class AdminDetalleOrdenesCompraDB extends Conexion implements CRUD{
    
    @Override
    public Object insertar(Object obj) {
        Connection conex = abrirConexion();
        DetalleOrdenesCompra objDetalleOrdenesCompra = (DetalleOrdenesCompra) obj;
        try {
            String sql = "INSERT INTO DetalleOrdenesCompra(id,numero_orden,fecha_estimada_entrega,estado,total,proveedores_id,empleados_id) VALUES(?,?,?,?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, objDetalleOrdenesCompra.getId());
            preparedStatement.setInt(2, objDetalleOrdenesCompra.getCantidad());
            preparedStatement.setFloat(3, objDetalleOrdenesCompra.getPrecio_compra());
            preparedStatement.setInt(4, objDetalleOrdenesCompra.getOrdenesCompra_id());
            preparedStatement.setInt(5, objDetalleOrdenesCompra.getProductos_id_codigo());
            preparedStatement.execute();
            
            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                objDetalleOrdenesCompra.setId(rs.getInt(1));
            }
            preparedStatement.close();
            //JOptionPane.showMessageDialog(null, "La inserción de la persona fue exitosa.");
            System.out.println("La inserción de la persona fue exitosa.");
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Error al insertar la persona: "+e.getMessage());
            System.out.println("Error al insertar la persona: "+e.getMessage());
        }
        cerrarConexion();
        return objDetalleOrdenesCompra;
    }

    @Override
    public boolean actualizar(Object obj) {
        DetalleOrdenesCompra objDetalleOrdenesCompra = (DetalleOrdenesCompra) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
                String sql = "UPDATE DetalleOrdenesCompra SET id=?,cantidad=?,=?,precio_compra=?,ordenesCompra_id=?,productos_id_codigo=? WHERE id=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objDetalleOrdenesCompra.getId());
            preparedStatement.setInt(2, objDetalleOrdenesCompra.getCantidad());
            preparedStatement.setFloat(3, objDetalleOrdenesCompra.getPrecio_compra());
            preparedStatement.setInt(4, objDetalleOrdenesCompra.getOrdenesCompra_id());
            preparedStatement.setInt(5, objDetalleOrdenesCompra.getProductos_id_codigo());
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
        DetalleOrdenesCompra objDetalleOrdenesCompra = (DetalleOrdenesCompra) obj;
         boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "DELETE FROM DetalleOrdenesCompra WHERE id=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objDetalleOrdenesCompra.getId());
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
        DetalleOrdenesCompra objDetalleOrdenesCompra;
        try {
            String sql = "SELECT * FROM DetalleOrdenesCompra ORDER BY documento_Nit ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objDetalleOrdenesCompra = new DetalleOrdenesCompra();
                objDetalleOrdenesCompra.setId(resultSet.getInt("id"));
                objDetalleOrdenesCompra.setCantidad(resultSet.getInt("cantidad"));
                objDetalleOrdenesCompra.setPrecio_compra(resultSet.getFloat("precio_compra"));
                objDetalleOrdenesCompra.setOrdenesCompra_id(resultSet.getInt("ordenesCompra_id"));
                objDetalleOrdenesCompra.setProductos_id_codigo(resultSet.getInt("productos_id_codigo"));
                rowsQuery.add(objDetalleOrdenesCompra);
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
        DetalleOrdenesCompra objDetalleOrdenesCompra = (DetalleOrdenesCompra) obj;
        try {
            String sql = "SELECT * FROM DetalleOrdenesCompra WHERE id = ?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objDetalleOrdenesCompra.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objDetalleOrdenesCompra = new DetalleOrdenesCompra();
                objDetalleOrdenesCompra.setId(resultSet.getInt("id"));
                objDetalleOrdenesCompra.setCantidad(resultSet.getInt("cantidad"));
                objDetalleOrdenesCompra.setPrecio_compra(resultSet.getFloat("precio_compra"));
                objDetalleOrdenesCompra.setOrdenesCompra_id(resultSet.getInt("ordenesCompra_id"));
                objDetalleOrdenesCompra.setProductos_id_codigo(resultSet.getInt("productos_id_codigo"));
            }

            preparedStatement.close();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Error en la adquisición de datos: "+ex.getMessage());
            System.out.println("Error en la adquisición de datos: "+ex.getMessage());
        }

        cerrarConexion();
        return objDetalleOrdenesCompra;
    }
}
