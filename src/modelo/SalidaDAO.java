/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class SalidaDAO {
    
    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    
    public boolean registrarSalida(Salida sal){
        String sql = "INSERT INTO salidaMaterial_tbl (cveSalidaMaterial,cantidadSalida,detalleSalida,cveMateriaPrima)  VALUES (?,?,?,?)";    
       try{          
          con= cn.getConnection();
          ps= con.prepareStatement(sql);
          ps.setString(1,sal.getClaveSalidaMaterial());
          ps.setInt(2,sal.getCantidadSalida());
          ps.setString(3,sal.getDetalleSalida() );
          ps.setString(4,sal.getClaveMateriaPrimaSalida());
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
    
    public List listarSalida(){        
      List<Salida> ListaSalida = new ArrayList();       
        String sql = "call almacen_db.TABLA_SALIDA_MAT_PRIMA()";       
        try{
        con =cn.getConnection();
        ps = con.prepareStatement(sql);
        rs=ps.executeQuery();
        while(rs.next()){
            Salida sal = new Salida();
            sal.setClaveSalidaMaterial(rs.getString("cveSalidaMaterial"));
            sal.setNombreMateriaPrimaSalida(rs.getString("nombreMateria"));
            sal.setCantidadSalida(rs.getInt("cantidadSalida"));
            sal.setStockMinimo(rs.getInt("stockMinimo"));
            sal.setCantidadDisp(rs.getInt("cantidadDisp"));
            sal.setDetalleSalida(rs.getString("detalleSalida")); 
            ListaSalida.add(sal);
        }       
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"El error esta en " + e.toString() );
        }
        return ListaSalida;
    }
    
}
