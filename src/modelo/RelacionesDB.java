package modelo;

import static dao.Conexion.abrirConexion;
import static dao.Conexion.cerrarConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class RelacionesDB {
    
    public List<RelaTotalVentasRegistradas> relaTotalVentasRegistradas(String fechaIni, String fechaFin) {
        List<RelaTotalVentasRegistradas> rowsQuery = new ArrayList<RelaTotalVentasRegistradas>();
        Connection conex = abrirConexion();
        RelaTotalVentasRegistradas objRelaTotalVentasRegistradas;
        try {
            String sql = "SELECT vf.numero_factura, cl.nombres_apellidos AS cliente, e.nombres_apellidos AS vendedor, vf.fecha_hora, vf.total\n" +
                         "FROM ventasfactura vf\n" +
                         "INNER JOIN clientes cl ON cl.id = vf.clientes_id\n" +
                         "INNER JOIN empleados e ON e.id = vf.empleados_id\n" +
                         "WHERE vf.fecha_hora BETWEEN ? AND ? ;";
            
            
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            
            preparedStatement.setString(1, fechaIni);
            preparedStatement.setString(2, fechaFin);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objRelaTotalVentasRegistradas = new RelaTotalVentasRegistradas();
                objRelaTotalVentasRegistradas.setNumero_factura(resultSet.getString("numero_factura"));
                objRelaTotalVentasRegistradas.setCliente(resultSet.getString("cliente"));
                objRelaTotalVentasRegistradas.setVendedor(resultSet.getString("vendedor"));
                objRelaTotalVentasRegistradas.setFecha_hora(resultSet.getString("fecha_hora"));
                rowsQuery.add(objRelaTotalVentasRegistradas);
            }
            preparedStatement.close();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            System.out.println("Error en la adquisición de datos"+ex.getMessage());
        }
        cerrarConexion();
        return rowsQuery;
    }
}
