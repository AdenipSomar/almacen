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

public class ProveedorDAO {
    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean registrarProveedor(Proveedor prov){
        String sql = "INSERT INTO proveedor_tbl (cveProveedor,nombreEmpresa,nombreEncargado,apePatEncargado,apeMatEncargado,telefonoProveedor,correoProveedor,rfc, codPostal)  VALUES (?,?,?,?,?,?,?,?,?)";    
       try{          
           con= cn.getConnection();
           ps= con.prepareStatement(sql);
           ps.setString(1,prov.getCveProveedor());
           ps.setString(2, prov.getNombreEmpresa());
           ps.setString(3, prov.getNombreEncargado());
           ps.setString(4, prov.getApePatEncargado());
           ps.setString(5, prov.getApeMatEncargado());
           ps.setString(6, prov.getTelefonoProveedor());
           ps.setString(7, prov.getCorreoProveedor());
           ps.setString(8, prov.getRfc());
           ps.setString(9, prov.getCiudadProveedor());
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
    
    public List listarProveedor(){        
      List<Proveedor> ListaProv = new ArrayList();       
        String sql = "call almacen_db.TABLA_PROVEEDOR_CIUDAD()";       
        try{
        con =cn.getConnection();
        ps = con.prepareStatement(sql);
        rs=ps.executeQuery();
        while(rs.next()){
            Proveedor prov = new Proveedor();
            prov.setCveProveedor(rs.getString("cveProveedor"));
            prov.setNombreEmpresa(rs.getString("nombreEmpresa"));
            prov.setNombreEncargado(rs.getString("nombreEncargado"));
            prov.setApePatEncargado(rs.getString("apePatEncargado"));
            prov.setApeMatEncargado(rs.getString("apeMatEncargado"));
            prov.setTelefonoProveedor(rs.getString("telefonoProveedor"));
            prov.setCorreoProveedor(rs.getString("correoProveedor"));
            prov.setRfc(rs.getString("rfc"));
            prov.setCiudadProveedor(rs.getString("codPostal"));  
            prov.setNombreCiudadProveedor(rs.getString("nombreCiudad"));
            ListaProv.add(prov);
        }       
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"El error esta en " + e.toString() );
        }
        return ListaProv;
    }
    
    public boolean ModificarProveedor(Proveedor prov) {
    String sql = "UPDATE proveedor_tbl SET cveProveedor=?, nombreEmpresa=?, nombreEncargado=?, apePatEncargado=?, apeMatEncargado=?, telefonoProveedor=?, correoProveedor=?, rfc=?, codPostal=? WHERE cveProveedor=?";
    try {
        ps = con.prepareStatement(sql);
        ps.setString(1,prov.getCveProveedor());
        ps.setString(2, prov.getNombreEmpresa());
        ps.setString(3, prov.getNombreEncargado());
        ps.setString(4,prov.getApePatEncargado());
        ps.setString(5, prov.getApeMatEncargado());
        ps.setString(6, prov.getTelefonoProveedor());
        ps.setString(7, prov.getCorreoProveedor());
        ps.setString(8,prov.getRfc());
        ps.setString(9, prov.getCiudadProveedor());
       
        ps.setString(10,prov.getCveProveedor()); // Este setString() está de más NO borrar
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
    
    public boolean eliminarProveedor(String id) {
        String sql = "DELETE FROM proveedor_tbl WHERE cveProveedor=?";

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
    
         // Método para obtener la lista de proveedores desde la base de datos
    public List<Proveedor> obtenerProveedor() {
        List<Proveedor> proveedores = new ArrayList<>();
        String query = "SELECT nombreEmpresa, cveProveedor FROM proveedor_tbl";
        try (Connection con = conexion.getConnection();
             PreparedStatement pst = con.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                String nombreEmpresa = rs.getString("nombreEmpresa");
                String cveProveedor = rs.getString("cveProveedor");
                // Crear objeto Ciudad y agregarlo a la lista
               // Proveedor proveedor = new Proveedor(claveProveedor, nombreProveedor);
                Proveedor proveedor = new Proveedor(cveProveedor, nombreEmpresa,"","","","","","","","");
                proveedores.add(proveedor);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener ciudades desde la base de datos: " + e.getMessage());
        }
        return proveedores;
    }
    
    
}
