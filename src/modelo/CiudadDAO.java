
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

    
    

}
