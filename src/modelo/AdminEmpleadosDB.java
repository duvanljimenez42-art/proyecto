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


public class AdminEmpleadosDB extends Conexion implements CRUD{

    @Override
    public Object insertar(Object obj) {
        Connection conex = abrirConexion();
        Empleados objEmpleados = (Empleados) obj;
        try {
            String sql = "INSERT INTO Empleados(id,documento_identidad,nombres_apellidos,email,telefono,clave,roles_id) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, objEmpleados.getId());
            preparedStatement.setString(2, objEmpleados.getDocumento_identidad());
            preparedStatement.setString(3, objEmpleados.getNombres_apellidos());
            preparedStatement.setString(4, objEmpleados.getEmail());
            preparedStatement.setString(5, objEmpleados.getTelefono());
            preparedStatement.setString(6, objEmpleados.getClave());
            preparedStatement.setInt(7, objEmpleados.getRoles_id());
            preparedStatement.execute();
            
            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                objEmpleados.setId(rs.getInt(1));
            }
            preparedStatement.close();
            //JOptionPane.showMessageDialog(null, "La inserción de la persona fue exitosa.");
            System.out.println("La inserción de la persona fue exitosa.");
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Error al insertar la persona: "+e.getMessage());
            System.out.println("Error al insertar la persona: "+e.getMessage());
        }
        cerrarConexion();
        return objEmpleados;

    }

    @Override
    public boolean actualizar(Object obj) {
        Empleados objEmpleados = (Empleados) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
                String sql = "UPDATE Empleados SET id=?,documento_identidad=?,nombres_apellidos=?,email=?,telefono=?,clave=?,roles_id=? WHERE id=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objEmpleados.getId());
            preparedStatement.setString(2, objEmpleados.getDocumento_identidad());
            preparedStatement.setString(3, objEmpleados.getNombres_apellidos());
            preparedStatement.setString(4, objEmpleados.getEmail());
            preparedStatement.setString(5, objEmpleados.getTelefono());
            preparedStatement.setString(6, objEmpleados.getClave());
            preparedStatement.setInt(7, objEmpleados.getRoles_id());
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
         Empleados objEmpleados = (Empleados) obj;
         boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "DELETE FROM Empleados WHERE id=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objEmpleados.getId());
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
        Empleados objEmpleados;
        try {
            String sql = "SELECT * FROM Empleados ORDER BY documento_identidad ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objEmpleados = new Empleados();
                objEmpleados.setId(resultSet.getInt("id"));
                objEmpleados.setDocumento_identidad(resultSet.getString("documento_identidad"));
                objEmpleados.setNombres_apellidos(resultSet.getString("nombres_apellidos"));
                objEmpleados.setEmail(resultSet.getString("email"));
                objEmpleados.setTelefono(resultSet.getString("telefono"));
                objEmpleados.setClave(resultSet.getString("clave"));
                objEmpleados.setRoles_id(resultSet.getInt("roles_id"));
                rowsQuery.add(objEmpleados);
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
        Empleados objEmpleados = (Empleados) obj;
        try {
            String sql = "SELECT * FROM Empleados WHERE id = ?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objEmpleados.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objEmpleados = new Empleados();
                objEmpleados.setId(resultSet.getInt("id"));
                objEmpleados.setDocumento_identidad(resultSet.getString("documento_identidad"));
                objEmpleados.setNombres_apellidos(resultSet.getString("nombres_apellidos"));
                objEmpleados.setEmail(resultSet.getString("email"));
                objEmpleados.setTelefono(resultSet.getString("telefono"));
                objEmpleados.setClave(resultSet.getString("clave"));
                objEmpleados.setRoles_id(resultSet.getInt("id_roles"));              
            }

            preparedStatement.close();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Error en la adquisición de datos: "+ex.getMessage());
            System.out.println("Error en la adquisición de datos: "+ex.getMessage());
        }

        cerrarConexion();
        return objEmpleados;
    }
    
    
}
