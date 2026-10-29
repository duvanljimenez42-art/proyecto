
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


public class AdminClientesDB extends Conexion implements CRUD{

    @Override
    public Object insertar(Object obj) {
        Connection conex = abrirConexion();
        Clientes objClientes = (Clientes) obj;
        try {
            String sql = "INSERT INTO Clientes(id,documento_nit,nombres_apellidos,direccion,telefono,email,nombre_comercial,contacto_autorizado,tipoCliente) VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, objClientes.getId());
            preparedStatement.setString(2, objClientes.getDocumento_nit());
            preparedStatement.setString(3, objClientes.getNombres_apellidos());
            preparedStatement.setString(4, objClientes.getDireccion());
            preparedStatement.setString(5, objClientes.getTelefono());
            preparedStatement.setString(6, objClientes.getEmail()); 
            preparedStatement.setString(7, objClientes.getNombre_comercial());
            preparedStatement.setString(8, objClientes.getContacto_autorizado());
            preparedStatement.setInt(9, objClientes.getTipoCliente_id());
            preparedStatement.execute();
            
            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                objClientes.setId(rs.getInt(1));
            }
            preparedStatement.close();
            //JOptionPane.showMessageDialog(null, "La inserción de la persona fue exitosa.");
            System.out.println("La inserción de la persona fue exitosa.");
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Error al insertar la persona: "+e.getMessage());
            System.out.println("Error al insertar la persona: "+e.getMessage());
        }
        cerrarConexion();
        return objClientes;
    }

    @Override
    public boolean actualizar(Object obj) {
        Clientes objClientes = (Clientes) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
                String sql = "UPDATE Clientes SET id=?,documento_nit=?,nombres_apellidos=?,direccion=?,telefono=?,email=?,nombre_comercial=?,cotacto_autorizado=?,tipoCliente_id=? WHERE id=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objClientes.getId());
            preparedStatement.setString(2, objClientes.getDocumento_nit());
            preparedStatement.setString(3, objClientes.getNombres_apellidos());
            preparedStatement.setString(4, objClientes.getDireccion());
            preparedStatement.setString(5, objClientes.getTelefono());
            preparedStatement.setString(6, objClientes.getEmail());
            preparedStatement.setString(7, objClientes.getNombre_comercial());
            preparedStatement.setString(8, objClientes.getContacto_autorizado());
            preparedStatement.setInt(9, objClientes.getTipoCliente_id());
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
        Clientes objClientes = (Clientes) obj;
         boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "DELETE FROM Clientes WHERE id=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objClientes.getId());
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
        Clientes objClientes;
        try {
            String sql = "SELECT * FROM Clientes ORDER BY documento_nit ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objClientes = new Clientes();
                objClientes.setId(resultSet.getInt("id"));
                objClientes.setDocumento_nit(resultSet.getString("documento_nit"));
                objClientes.setNombres_apellidos(resultSet.getString("nombres_apellidos"));
                objClientes.setDireccion(resultSet.getString("direccion"));
                objClientes.setTelefono(resultSet.getString("telefono"));
                objClientes.setEmail(resultSet.getString("email"));
                objClientes.setNombre_comercial(resultSet.getString("nombre_comercial"));
                objClientes.setContacto_autorizado(resultSet.getString("contacto_autorizado"));
                objClientes.setTipoCliente_id(resultSet.getInt("tipoCliente_id"));
                rowsQuery.add(objClientes);
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
        Clientes objClientes = (Clientes) obj;
        try {
            String sql = "SELECT * FROM Clientes WHERE id = ?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objClientes.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objClientes.setId(resultSet.getInt("id"));
                objClientes.setDocumento_nit(resultSet.getString("documento_it"));
                objClientes.setNombres_apellidos(resultSet.getString("nombres_apellido"));
                objClientes.setDireccion(resultSet.getString("direccion"));
                objClientes.setTelefono(resultSet.getString("telefono"));
                objClientes.setEmail(resultSet.getString("email"));
                objClientes.setNombre_comercial(resultSet.getString("nombre_comercial"));
                objClientes.setContacto_autorizado(resultSet.getString("contacto_autorizado"));
                objClientes.setTipoCliente_id(resultSet.getInt("tipoCliente_id"));
            }

            preparedStatement.close();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Error en la adquisición de datos: "+ex.getMessage());
            System.out.println("Error en la adquisición de datos: "+ex.getMessage());
        }

        cerrarConexion();
        return objClientes;
    }
    
}
