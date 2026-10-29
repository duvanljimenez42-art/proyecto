
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


public class AdminOrdenesCompraDB extends Conexion implements CRUD{
    
    @Override
    public Object insertar(Object obj) {
        Connection conex = abrirConexion();
        OrdenesCompra objOrdenesCompra = (OrdenesCompra) obj;
        try {
            String sql = "INSERT INTO OrdenesCompra(id,numero_orden,fecha_estimada_entrega,estado,total,proveedores_id,empleados_id) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, objOrdenesCompra.getId());
            preparedStatement.setString(2, objOrdenesCompra.getNumero_orden());
            preparedStatement.setString(3, objOrdenesCompra.getFecha_estimada_entrega());
            preparedStatement.setString(4, objOrdenesCompra.getEstado());
            preparedStatement.setFloat(5, objOrdenesCompra.getTotal());
            preparedStatement.setInt(6, objOrdenesCompra.getProveedores_id()); 
            preparedStatement.setInt(7, objOrdenesCompra.getEmpleados_id());
            preparedStatement.execute();
            
            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                objOrdenesCompra.setId(rs.getInt(1));
            }
            preparedStatement.close();
            //JOptionPane.showMessageDialog(null, "La inserción de la persona fue exitosa.");
            System.out.println("La inserción de la persona fue exitosa.");
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Error al insertar la persona: "+e.getMessage());
            System.out.println("Error al insertar la persona: "+e.getMessage());
        }
        cerrarConexion();
        return objOrdenesCompra;
    }

    @Override
    public boolean actualizar(Object obj) {
        OrdenesCompra objOrdenesCompra = (OrdenesCompra) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
                String sql = "UPDATE OrdenesCompra SET id=?,numero_orden=?,=?,fecha_estimada_entrega=?,estado=?,total=?,proveedores_id=?,empleados_id=? WHERE id=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objOrdenesCompra.getId());
            preparedStatement.setString(2, objOrdenesCompra.getNumero_orden());
            preparedStatement.setString(3, objOrdenesCompra.getFecha_estimada_entrega());
            preparedStatement.setString(4, objOrdenesCompra.getEstado());
            preparedStatement.setFloat(5, objOrdenesCompra.getTotal());
            preparedStatement.setInt(6, objOrdenesCompra.getProveedores_id()); 
            preparedStatement.setInt(7, objOrdenesCompra.getEmpleados_id());
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
        OrdenesCompra objOrdenesCompra = (OrdenesCompra) obj;
         boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "DELETE FROM OrdenesCompra WHERE id=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objOrdenesCompra.getId());
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
        OrdenesCompra objOrdenesCompra;
        try {
            String sql = "SELECT * FROM OrdenesCompra ORDER BY documento_Nit ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objOrdenesCompra = new OrdenesCompra();
                objOrdenesCompra.setId(resultSet.getInt("id"));
                objOrdenesCompra.setNumero_orden(resultSet.getString("cantidad"));
                objOrdenesCompra.setFecha_estimada_entrega(resultSet.getString("precio_unitario"));
                objOrdenesCompra.setEstado(resultSet.getString("porcentaje_iva"));
                objOrdenesCompra.setTotal(resultSet.getFloat("subtotal_item"));
                objOrdenesCompra.setProveedores_id(resultSet.getInt("ventasFactura_id"));
                objOrdenesCompra.setEmpleados_id(resultSet.getInt("productos_id_codigo"));
                rowsQuery.add(objOrdenesCompra);
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
        OrdenesCompra objOrdenesCompra = (OrdenesCompra) obj;
        try {
            String sql = "SELECT * FROM DetalleVentas WHERE id = ?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objOrdenesCompra.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objOrdenesCompra.setId(resultSet.getInt("id"));
                objOrdenesCompra.setNumero_orden(resultSet.getString("cantidad"));
                objOrdenesCompra.setFecha_estimada_entrega(resultSet.getString("precio_unitario"));
                objOrdenesCompra.setEstado(resultSet.getString("porcentaje_iva"));
                objOrdenesCompra.setTotal(resultSet.getFloat("subtotal_item"));
                objOrdenesCompra.setProveedores_id(resultSet.getInt("ventasFactura_id"));
                objOrdenesCompra.setEmpleados_id(resultSet.getInt("productos_id_codigo"));
            }

            preparedStatement.close();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Error en la adquisición de datos: "+ex.getMessage());
            System.out.println("Error en la adquisición de datos: "+ex.getMessage());
        }

        cerrarConexion();
        return objOrdenesCompra;
    }
    
}
