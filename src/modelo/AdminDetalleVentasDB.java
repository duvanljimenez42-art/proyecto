
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

public class AdminDetalleVentasDB extends Conexion implements CRUD{
    
    @Override
    public Object insertar(Object obj) {
        Connection conex = abrirConexion();
        DetalleVentas objDetalleVentas = (DetalleVentas) obj;
        try {
            String sql = "INSERT INTO DetalleVentas(id,cantidad,precio_unitario,porcentaje_iva,subtotal_item,ventasFactura_id,productos_id_codigo) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, objDetalleVentas.getId());
            preparedStatement.setFloat(2, objDetalleVentas.getCantidad());
            preparedStatement.setFloat(3, objDetalleVentas.getPrecio_unitario());
            preparedStatement.setFloat(4, objDetalleVentas.getPorcentaje_iva());
            preparedStatement.setFloat(5, objDetalleVentas.getSubtotal_item());
            preparedStatement.setInt(6, objDetalleVentas.getVentasFactura_id()); 
            preparedStatement.setInt(7, objDetalleVentas.getProductos_id_codigo());
            preparedStatement.execute();
            
            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                objDetalleVentas.setId(rs.getInt(1));
            }
            preparedStatement.close();
            //JOptionPane.showMessageDialog(null, "La inserción de la persona fue exitosa.");
            System.out.println("La inserción de la persona fue exitosa.");
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Error al insertar la persona: "+e.getMessage());
            System.out.println("Error al insertar la persona: "+e.getMessage());
        }
        cerrarConexion();
        return objDetalleVentas;
    }

    @Override
    public boolean actualizar(Object obj) {
        DetalleVentas objDetalleVentas = (DetalleVentas) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
                String sql = "UPDATE DetalleVentas SET id=?,cantidad=?,precio_unitario=?,porcentaje_iva=?,subtotal_item=?,ventasFactura_id=?,productos_id_codigo=? WHERE id=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objDetalleVentas.getId());
            preparedStatement.setFloat(2, objDetalleVentas.getCantidad());
            preparedStatement.setFloat(3, objDetalleVentas.getPrecio_unitario());
            preparedStatement.setFloat(4, objDetalleVentas.getPorcentaje_iva());
            preparedStatement.setFloat(5, objDetalleVentas.getSubtotal_item());
            preparedStatement.setInt(6, objDetalleVentas.getVentasFactura_id()); 
            preparedStatement.setInt(7, objDetalleVentas.getProductos_id_codigo());
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
        DetalleVentas objDetalleVentas = (DetalleVentas) obj;
         boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "DELETE FROM DetalleVentas WHERE id=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objDetalleVentas.getId());
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
        DetalleVentas objDetalleVentas;
        try {
            String sql = "SELECT * FROM DetalleVentas ORDER BY documento_Nit ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objDetalleVentas = new DetalleVentas();
                objDetalleVentas.setId(resultSet.getInt("id"));
                objDetalleVentas.setCantidad(resultSet.getFloat("cantidad"));
                objDetalleVentas.setPrecio_unitario(resultSet.getFloat("precio_unitario"));
                objDetalleVentas.setPorcentaje_iva(resultSet.getFloat("porcentaje_iva"));
                objDetalleVentas.setSubtotal_item(resultSet.getFloat("subtotal_item"));
                objDetalleVentas.setVentasFactura_id(resultSet.getInt("ventasFactura_id"));
                objDetalleVentas.setProductos_id_codigo(resultSet.getInt("productos_id_codigo"));
                rowsQuery.add(objDetalleVentas);
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
        DetalleVentas objDetalleVentas = (DetalleVentas) obj;
        try {
            String sql = "SELECT * FROM DetalleVentas WHERE id = ?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objDetalleVentas.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objDetalleVentas = new DetalleVentas();
                objDetalleVentas.setId(resultSet.getInt("id"));
                objDetalleVentas.setCantidad(resultSet.getFloat("cantidad"));
                objDetalleVentas.setPrecio_unitario(resultSet.getFloat("precio_unitario"));
                objDetalleVentas.setPorcentaje_iva(resultSet.getFloat("porcentaje_iva"));
                objDetalleVentas.setSubtotal_item(resultSet.getFloat("subtotal_item"));
                objDetalleVentas.setVentasFactura_id(resultSet.getInt("ventasFactura_id"));
                objDetalleVentas.setProductos_id_codigo(resultSet.getInt("productos_id_codigo"));
            }

            preparedStatement.close();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Error en la adquisición de datos: "+ex.getMessage());
            System.out.println("Error en la adquisición de datos: "+ex.getMessage());
        }

        cerrarConexion();
        return objDetalleVentas;
    }

}
