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


public class AdminRolesDB extends Conexion implements CRUD{

    @Override
    public Object insertar(Object obj) {
                Connection conex = abrirConexion();
        Roles objRoles = (Roles) obj;
        try {
            String sql = "INSERT INTO Roles(id,nombre) VALUES(?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, objRoles.getId());
            preparedStatement.setString(2, objRoles.getNombre());
            preparedStatement.execute();
            
            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                objRoles.setId(rs.getInt(1));
            }
            preparedStatement.close();
            //JOptionPane.showMessageDialog(null, "La inserción de la persona fue exitosa.");
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Error al insertar la persona: "+e.getMessage());
        }
        cerrarConexion();
        return objRoles;

    }

    @Override
    public boolean actualizar(Object obj) {
                Roles objRoles = (Roles) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
                String sql = "UPDATE Roles SET id=?,nombre=? WHERE id=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objRoles.getId());
            preparedStatement.setString(2, objRoles.getNombre());
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
        Roles objRoles = (Roles) obj;
         boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "DELETE FROM Roles WHERE id=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objRoles.getId());
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
        Roles objRoles;
        try {
            String sql = "SELECT * FROM Roles ORDER BY nombre ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objRoles = new Roles();
                objRoles.setId(resultSet.getInt("id"));
                objRoles.setNombre(resultSet.getString("nombre"));
                rowsQuery.add(objRoles);
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
        Roles objRoles = (Roles) obj;
        try {
            String sql = "SELECT * FROM Roles WHERE id = ?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objRoles.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objRoles.setId(resultSet.getInt("id"));
                objRoles.setNombre(resultSet.getString("nombre"));
              
            }

            preparedStatement.close();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Error en la adquisición de datos: "+ex.getMessage());
            System.out.println("Error en la adquisición de datos: "+ex.getMessage());

        }

        cerrarConexion();
        return objRoles;

    }
    
}
