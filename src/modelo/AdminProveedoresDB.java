package modelo;

import dao.CRUD;
import dao.Conexion;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class AdminProveedoresDB extends Conexion implements CRUD{

    @Override
    public Object insertar(Object obj) {
        Connection conex = abrirConexion();
        Proveedores objProveedores = (Proveedores) obj;
        try {
            String sql = "INSERT INTO Proveedores(id,documentoNit,razon_social,direccion,telefono,email,especialidad,terminos_pago) VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, objProveedores.getId());
            preparedStatement.setString(2, objProveedores.getDocumentoNit());
            preparedStatement.setString(3, objProveedores.getRazon_social());
            preparedStatement.setString(4, objProveedores.getDireccion());
            preparedStatement.setString(5, objProveedores.getTelefono());
            preparedStatement.setString(6, objProveedores.getEmail()); 
            preparedStatement.setString(7, objProveedores.getEspecialidad());
            preparedStatement.setString(8, objProveedores.getTerminos_pago());
            preparedStatement.execute();
            
            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                objProveedores.setId(rs.getInt(1));
            }
            preparedStatement.close();
            //JOptionPane.showMessageDialog(null, "La inserción de la persona fue exitosa.");
            System.out.println("La inserción de la persona fue exitosa.");
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Error al insertar la persona: "+e.getMessage());
            System.out.println("Error al insertar la persona: "+e.getMessage());
        }
        cerrarConexion();
        return objProveedores;

    }

    @Override
    public boolean actualizar(Object obj) {
        Proveedores objProveedores = (Proveedores) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
                String sql = "UPDATE Proveedores SET id=?,documentoNit=?,razon_social=?,direccion=?,telefono=?,email=?,especialidad=?, terminos_pago=? WHERE id=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objProveedores.getId());
            preparedStatement.setString(2, objProveedores.getDocumentoNit());
            preparedStatement.setString(3, objProveedores.getRazon_social());
            preparedStatement.setString(4, objProveedores.getDireccion());
            preparedStatement.setString(5, objProveedores.getTelefono());
            preparedStatement.setString(6, objProveedores.getEmail());
            preparedStatement.setString(7, objProveedores.getEspecialidad());
            preparedStatement.setString(8, objProveedores.getTerminos_pago());
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
        Proveedores objProveedores = (Proveedores) obj;
         boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "DELETE FROM Empleados WHERE id=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objProveedores.getId());
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
        Proveedores objProveedores;
        try {
            String sql = "SELECT * FROM Proveedores ORDER BY documentoNit ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objProveedores = new Proveedores();
                objProveedores.setId(resultSet.getInt("id"));
                objProveedores.setDocumentoNit(resultSet.getString("documentoNit"));
                objProveedores.setRazon_social(resultSet.getString("razon_social"));
                objProveedores.setDireccion(resultSet.getString("direccion"));
                objProveedores.setTelefono(resultSet.getString("telefono"));
                objProveedores.setEmail(resultSet.getString("email"));
                objProveedores.setEspecialidad(resultSet.getString("especialidad"));
                objProveedores.setTerminos_pago(resultSet.getString("terminos_pago"));
                rowsQuery.add(objProveedores);
            }
            preparedStatement.close();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            System.out.println("Error en la adquisición de datos: "+ex.getMessage());
        }
        cerrarConexion();
        return rowsQuery;

    }

    @Override
    public Object listarUno(Object obj) {
        Connection conex = abrirConexion();
        Proveedores objProveedores = (Proveedores) obj;
        try {
            String sql = "SELECT * FROM Proveedores WHERE id = ?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objProveedores.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objProveedores.setId(resultSet.getInt("id"));
                objProveedores.setDocumentoNit(resultSet.getString("documentoNit"));
                objProveedores.setRazon_social(resultSet.getString("razon social"));
                objProveedores.setDireccion(resultSet.getString("direccion"));
                objProveedores.setTelefono(resultSet.getString("telefono"));
                objProveedores.setEmail(resultSet.getString("email"));
                objProveedores.setEspecialidad(resultSet.getString("especialidad"));
                objProveedores.setTerminos_pago(resultSet.getString("terminos de pago"));
            }

            preparedStatement.close();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Error en la adquisición de datos: "+ex.getMessage());
            System.out.println("Error en la adquisición de datos: "+ex.getMessage());
        }

        cerrarConexion();
        return objProveedores;
    }
    
    
}
