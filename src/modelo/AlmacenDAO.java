
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
    
    public List listarAlamacen(){        
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
     
    public boolean ModificarAlmacen(Almacen alm) {
    String sql = "UPDATE materiaPrima_tbl SET cveMateriaPrima=?, nombreMateria=?, stockMinimo=?, cantidadDisp=? WHERE cveMateriaPrima=?";
    try {
        ps = con.prepareStatement(sql);
        ps.setString(1,alm.getClaveMateriaPrima());
        ps.setString(2, alm.getNombreMateria());
        ps.setInt(3, alm.getStockMinimo()); 
        ps.setInt(4, alm.getCantidadDisp());
        ps.setString(5, alm.getClaveMateriaPrima());// Este setString() está de más pero  no se debe borrar
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
    
    public boolean eliminarAlmacen(String id) {
        String sql = "DELETE FROM materiaPrima_tbl WHERE cveMateriaPrima=?";
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
    
    // Método para obtener la lista de materia prima desde la base de datos
    public List<Almacen> obtenerMateria() {
        List<Almacen> materias = new ArrayList<>();
        String query = "SELECT nombreMateria, cveMateriaPrima FROM materiaprima_tbl";
        try (Connection con = conexion.getConnection();
             PreparedStatement pst = con.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                String nombreMateria = rs.getString("nombreMateria");
                String claveMateriaPrima = rs.getString("cveMateriaPrima");
                // Crear objeto Ciudad y agregarlo a la lista
                Almacen almacen = new Almacen(claveMateriaPrima, nombreMateria ,0,0);
                materias.add(almacen);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener ciudades desde la base de datos: " + e.getMessage());
        }
        return materias;
    }

    
    
//    
//    public int obtenerCantidadDisponible(String claveMateria) {
//    int cantidadDisponible = 0;  
//    Connection con = cn.getConnection(); // Asumiendo que tienes un método para obtener la conexión a la base de datos
//   
//    try {
//        String sql = "SELECT cantidadDisp FROM materiaprima_tbl  WHERE cveMateriaPrima = ?";
//        ps = con.prepareStatement(sql);
//        ps.setString(1, claveMateria);
//        rs = ps.executeQuery();
//      
//        if (rs.next()) {
//            cantidadDisponible = rs.getInt("cantidadDisp");
//        }
//    } catch (SQLException e) {
//        e.printStackTrace();
//    } finally {
//        try {
//            if (rs != null) rs.close();
//            if (ps != null) ps.close();
//            if (con != null) con.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    return cantidadDisponible;
//}
//
//    public void actualizarCantidadDisponible(String claveMateria, int nuevaCantidad) {
//    Connection con = cn.getConnection(); // 
//   
//
//    try {
//        String sql = "UPDATE materiaPrima_tbl SET cantidadDisp = ? WHERE cveMateriaPrima = ?";
//        ps = con.prepareStatement(sql);
//        ps.setInt(1, nuevaCantidad);
//        ps.setString(2, claveMateria);
//        ps.executeUpdate();
//    } catch (SQLException e) {
//        e.printStackTrace();
//    } finally {
//        try {
//            if (ps != null) ps.close();
//            if (con != null) con.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}

    public Almacen BuscarMateria(String cod) {
        Almacen almacen = new Almacen();

        String sql = "SELECT * From materiaPrima_tbl WHERE cveMateriaPrima=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cod);
            rs = ps.executeQuery();
            if (rs.next()) {
                almacen.setClaveMateriaPrima(rs.getString("cveMateriaPrima"));
                almacen.setCantidadDisp(rs.getInt("cantidadDisp"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return almacen;
    }
    
    
    
    
    
}
