
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


public class AdminVentasFacturaDB extends Conexion implements CRUD{
    
    @Override
    public Object insertar(Object obj) {
        Connection conex = abrirConexion();
        VentasFactura objVentasFactura = (VentasFactura) obj;
        try {
            String sql = "INSERT INTO VentasFactura(id,numero_factura,fecha_hora,metodo_pago,costo_servicio_adicional,subtotal,iva_total,total,empledos_id,clientes_id) VALUES(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, objVentasFactura.getId());
            preparedStatement.setString(2, objVentasFactura.getNumero_factura());
            preparedStatement.setString(3, objVentasFactura.getFecha_hora());
            preparedStatement.setString(4, objVentasFactura.getMetodo_pago());
            preparedStatement.setFloat(5, objVentasFactura.getCosto_servicio_adicional());
            preparedStatement.setFloat(6, objVentasFactura.getSubtotal()); 
            preparedStatement.setFloat(7, objVentasFactura.getIva_total());
            preparedStatement.setFloat(8, objVentasFactura.getTotal());
            preparedStatement.setInt(9, objVentasFactura.getEmpleados_id());
            preparedStatement.setInt(10, objVentasFactura.getClientes_id());
            preparedStatement.execute();
            
            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                objVentasFactura.setId(rs.getInt(1));
            }
            preparedStatement.close();
            //JOptionPane.showMessageDialog(null, "La inserción de la persona fue exitosa.");
            System.out.println("La inserción de la persona fue exitosa.");
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Error al insertar la persona: "+e.getMessage());
            System.out.println("Error al insertar la persona: "+e.getMessage());
        }
        cerrarConexion();
        return objVentasFactura;
    }

    @Override
    public boolean actualizar(Object obj) {
        VentasFactura objVentasFactura = (VentasFactura) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
                String sql = "UPDATE VentasFactura SET id=?,numero_factura=?,fecha_hora=?,metodo_pago=?,costo_servicio_adicional=?,subtotal=?,iva_total=?,total=?,empleados_id=?,clientes_id=? WHERE id=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objVentasFactura.getId());
            preparedStatement.setString(2, objVentasFactura.getNumero_factura());
            preparedStatement.setString(3, objVentasFactura.getFecha_hora());
            preparedStatement.setString(4, objVentasFactura.getMetodo_pago());
            preparedStatement.setFloat(5, objVentasFactura.getCosto_servicio_adicional());
            preparedStatement.setFloat(6, objVentasFactura.getSubtotal()); 
            preparedStatement.setFloat(7, objVentasFactura.getIva_total());
            preparedStatement.setFloat(8, objVentasFactura.getTotal());
            preparedStatement.setInt(9, objVentasFactura.getEmpleados_id());
            preparedStatement.setInt(10, objVentasFactura.getClientes_id());
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
        VentasFactura objVentasFactura = (VentasFactura) obj;
         boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "DELETE FROM VentasFactura WHERE id=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objVentasFactura.getId());
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
        VentasFactura objVentasFactura;
        try {
            String sql = "SELECT * FROM VentasFactura ORDER BY numero_factura ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objVentasFactura = new VentasFactura();
                objVentasFactura.setId(resultSet.getInt("id"));
                objVentasFactura.setNumero_factura(resultSet.getString("numero_factura"));
                objVentasFactura.setFecha_hora(resultSet.getString("fecha_hora"));
                objVentasFactura.setMetodo_pago(resultSet.getString("metodo_pago"));
                objVentasFactura.setCosto_servicio_adicional(resultSet.getFloat("costo_servicio_adicional"));
                objVentasFactura.setSubtotal(resultSet.getFloat("subtotal"));
                objVentasFactura.setIva_total(resultSet.getFloat("iva_total"));
                objVentasFactura.setTotal(resultSet.getFloat("total"));
                objVentasFactura.setEmpleados_id(resultSet.getInt("empleados_id"));
                objVentasFactura.setClientes_id(resultSet.getInt("id proveedor"));
                rowsQuery.add(objVentasFactura);
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
        VentasFactura objVentasFactura = (VentasFactura) obj;
        try {
            String sql = "SELECT * FROM VentasFactura WHERE id = ?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objVentasFactura.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objVentasFactura.setId(resultSet.getInt("id"));
                objVentasFactura.setNumero_factura(resultSet.getString("numero_factura"));
                objVentasFactura.setFecha_hora(resultSet.getString("fecha_hora"));
                objVentasFactura.setMetodo_pago(resultSet.getString("metodo_pago"));
                objVentasFactura.setCosto_servicio_adicional(resultSet.getFloat("costo_servicio_adicional"));
                objVentasFactura.setSubtotal(resultSet.getFloat("subtotal"));
                objVentasFactura.setIva_total(resultSet.getFloat("iva_total"));
                objVentasFactura.setTotal(resultSet.getFloat("total"));
                objVentasFactura.setEmpleados_id(resultSet.getInt("empleados_id"));
                objVentasFactura.setClientes_id(resultSet.getInt("id proveedor"));
            }

            preparedStatement.close();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Error en la adquisición de datos: "+ex.getMessage());
            System.out.println("Error en la adquisición de datos: "+ex.getMessage());
        }

        cerrarConexion();
        return objVentasFactura;
    }
    
}
