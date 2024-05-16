
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
public class AlmacenDAO {
    
    conexion cn = new conexion();
    Connection con;
    
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean registrarAlmacen(Almacen alm){
        String sql = "INSERT INTO materiaPrima_tbl (cveMateriaPrima,nombreMateria,stockMinimo,cantidadDisp)  VALUES (?,?,?,?)";    
       try{          
          con= cn.getConnection();
          ps= con.prepareStatement(sql);
          ps.setString(1,alm.getClaveMateriaPrima());
          ps.setString(2,alm.getNombreMateria());
          ps.setInt(3, alm.getStockMinimo());
          ps.setInt(4, alm.getCantidadDisp());
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
      List<Almacen> ListaAlm = new ArrayList();       
        String sql = "SELECT * FROM materiaPrima_tbl";       
        try{
        con =cn.getConnection();
        ps = con.prepareStatement(sql);
        rs=ps.executeQuery();
        while(rs.next()){
            Almacen alm = new Almacen();
            alm.setClaveMateriaPrima(rs.getString("cveMateriaPrima"));
            alm.setNombreMateria(rs.getString("nombreMateria"));
            alm.setStockMinimo(rs.getInt("stockMinimo"));
            alm.setCantidadDisp(rs.getInt("cantidadDisp"));
            ListaAlm.add(alm);
        }       
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null, e.toString());
        }
        return ListaAlm;
    }
}
