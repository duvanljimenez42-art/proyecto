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

public class AdminCategoriaDB extends Conexion implements CRUD{

    @Override
    public Object insertar(Object obj) {
        Connection conex = abrirConexion();
        Categoria objCategoria = (Categoria) obj;
        try {
            String sql = "INSERT INTO Categoria(id,nombre,descripcion) VALUES(?,?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, objCategoria.getId());
            preparedStatement.setString(2, objCategoria.getNombre());
            preparedStatement.setString(3, objCategoria.getDescripcion());
            preparedStatement.execute();
            
            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                objCategoria.setId(rs.getInt(1));
            }
            preparedStatement.close();
          //JOptionPane.showMessageDialog(null, "La inserción de la persona fue exitosa.");
            System.out.println("La inserción de la persona fue exitosa.");
        } catch (Exception e) {
         // JOptionPane.showMessageDialog(null, "Error al insertar la persona: "+e.getMessage());
            System.out.println("Error al insertar la persona: "+e.getMessage());
        }
        cerrarConexion();
        return objCategoria;
    }

    @Override
    public boolean actualizar(Object obj) {
        Categoria objCategoria = (Categoria) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
                String sql = "UPDATE Categoria SET id=?,nombre=?,descripcion=? WHERE id=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objCategoria.getId());
            preparedStatement.setString(2, objCategoria.getNombre());
            preparedStatement.setString(3, objCategoria.getDescripcion());
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
         Categoria objCategoria = (Categoria) obj;
         boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "DELETE FROM Categoria WHERE id=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objCategoria.getId());
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
        Categoria objCategoria;
        try {
            String sql = "SELECT * FROM Categoria ORDER BY nombre ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objCategoria = new Categoria();
                objCategoria.setId(resultSet.getInt("id"));
                objCategoria.setNombre(resultSet.getString("nombre"));
                objCategoria.setDescripcion(resultSet.getString("descripcion"));
                rowsQuery.add(objCategoria);
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
        Categoria objCategoria = (Categoria) obj;
        try {
            String sql = "SELECT * FROM Categoria WHERE id = ?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objCategoria.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objCategoria.setId(resultSet.getInt("id"));
                objCategoria.setNombre(resultSet.getString("nombre"));
                objCategoria.setDescripcion(resultSet.getString("descripcion"));               
            }

            preparedStatement.close();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Error en la adquisición de datos: "+ex.getMessage());

        }

        cerrarConexion();
        return objCategoria;

    }
    
    
}
