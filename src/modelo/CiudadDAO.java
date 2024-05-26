
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ramos
 */
public class CiudadDAO {
    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean registrarCiudad(Ciudad cd){
        String sql = "INSERT INTO ciudad_tbl (codPostal,nombreCiudad)  VALUES (?,?)";    
       try{          
           con= cn.getConnection();
           ps= con.prepareStatement(sql);
           ps.setString(1,cd.getCodPostal());
           ps.setString(2,cd.getNombreCiudad());
          ps.execute();
          return true;
           
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null, e.toString());
              return false;
       }
       finally {
       try{
       con.close();
       }catch(SQLException e){
           System.out.println(e.toString());
       }
       }
    
    }
    
    public List listarCiudad(){        
      List<Ciudad> ListaCd = new ArrayList();       
        String sql = "SELECT * FROM ciudad_tbl";       
        try{
        con =cn.getConnection();
        ps = con.prepareStatement(sql);
        rs=ps.executeQuery();
        while(rs.next()){
            Ciudad cd = new Ciudad();
            cd.setCodPostal(rs.getString("codPostal"));
            cd.setNombreCiudad(rs.getString("nombreCiudad"));           
            ListaCd.add(cd);
        }       
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null, e.toString());
        }
        return ListaCd;
    }
    
    public boolean ModificarCiudad(Ciudad cd) {
    String sql = "UPDATE ciudad_tbl SET codPostal=?, nombreCiudad=? WHERE codPostal=?";
    try {
        ps = con.prepareStatement(sql);
        ps.setString(1, cd.getCodPostal());
        ps.setString(2, cd.getNombreCiudad());
        ps.setString(3, cd.getCodPostal()); // Este setString() está de más en tu caso
        ps.execute();
        return true;
    } catch (SQLException e) {
        System.out.println(e.toString());
        return false;
    } finally {
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
}

    public boolean eliminarCiudad(String id) {
        String sql = "DELETE FROM ciudad_tbl WHERE codPostal=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.out.println(e.toString());
           JOptionPane.showMessageDialog(null, "No es posible eliminar este registro \n "
                    + "Está siendo utilizado", "Error de borrado", JOptionPane.WARNING_MESSAGE);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }

    }
      
// Método para obtener la lista de ciudades desde la base de datos
    public List<Ciudad> obtenerCiudades() {
        List<Ciudad> ciudades = new ArrayList<>();
        String query = "SELECT nombreCiudad, codPostal FROM ciudad_tbl";
        try (Connection con = conexion.getConnection();
             PreparedStatement pst = con.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                String nombreCiudad = rs.getString("nombreCiudad");
                String codPostal = rs.getString("codPostal");
                // Crear objeto Ciudad y agregarlo a la lista
                Ciudad ciudad = new Ciudad(codPostal, nombreCiudad);
                ciudades.add(ciudad);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener ciudades desde la base de datos: " + e.getMessage());
        }
        return ciudades;
    }
    
}
