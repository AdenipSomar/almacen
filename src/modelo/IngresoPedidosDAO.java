/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.Date;
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
public class IngresoPedidosDAO {
    conexion cn = new conexion();
    Connection con;
    
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean registrarIngresoPedido(IngresoPedidos ingP) {
        String sql = "INSERT INTO ingresoMaterial_tbl (cveIngresoMaterial,detallePedido,estado,cantidadPedido, fechaIngreso,costoTotal, cveProveedor,cveMateriaPrima)  VALUES (?,?,?,?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, ingP.getClaveIngresoMaterial());
            ps.setString(2, ingP.getDetallePedido());
            ps.setInt(3, ingP.getEstado());
            ps.setInt(4, ingP.getCantidadPedido());
            ps.setString(5, ingP.getFechaIngreso());
            ps.setFloat(6, ingP.getCostoTotal());
            ps.setString(7, ingP.getClaveProveedor());
            ps.setString(8, ingP.getClaveMateria());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    public List listarIngresoPedido() {
        List<IngresoPedidos> ListaIngreso = new ArrayList();
        String sql = "call almacen_db.TABLA_INGRESOMATERIAL_PROV_MAT()";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                IngresoPedidos ingP = new IngresoPedidos();
                ingP.setClaveIngresoMaterial(rs.getString("cveIngresoMaterial"));
                ingP.setDetallePedido(rs.getString("detallePedido"));

                ingP.setEstado(rs.getInt("estado"));
                ingP.setEstadoDescripcion(rs.getString("estado_descripcion"));

                ingP.setCantidadPedido(rs.getInt("cantidadPedido"));
                ingP.setFechaPedido(rs.getString("fechaPedido"));
                ingP.setFechaIngreso(rs.getString("fechaIngreso"));
                ingP.setCostoTotal(rs.getFloat("costoTotal"));

                ingP.setClaveProveedor(rs.getString("cveProveedor"));
                ingP.setNombreProveedor(rs.getString("nombreProveedor"));

                ingP.setClaveMateria(rs.getString("cveMateriaPrima"));
                ingP.setNombreMateria(rs.getString("nombreMateria"));

                ListaIngreso.add(ingP);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return ListaIngreso;
    }

    public boolean moficarIngresoPedido(IngresoPedidos ingP) {
        String sql = "UPDATE ingresoMaterial_tbl SET cveIngresoMaterial=?, detallePedido=?, estado=?, cantidadPedido=?, fechaIngreso=?, costoTotal=?, cveProveedor=?, cveMateriaPrima=? WHERE cveIngresoMaterial=?";
        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, ingP.getClaveIngresoMaterial());
            ps.setString(2, ingP.getDetallePedido());
            ps.setInt(3, ingP.getEstado());
            ps.setInt(4, ingP.getCantidadPedido());

            ps.setString(5, ingP.getFechaIngreso());
            ps.setFloat(6, ingP.getCostoTotal());
            ps.setString(7, ingP.getClaveProveedor());
            ps.setString(8, ingP.getClaveMateria());
            ps.setString(9, ingP.getClaveIngresoMaterial());// Este setString() está de más pero  no se debe borrar
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "Primer Error");
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
                JOptionPane.showMessageDialog(null, "Segundo Error");
            }
        }
    }

    public boolean eliminarIngresoPedido(String id) {
        String sql = "DELETE FROM ingresoMaterial_tbl WHERE cveIngresoMaterial=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }
    
    public boolean actualizasStock(int cant, String cod) {

        String sql = " UPDATE materiaPrima_tbl SET cantidadDisp =? WHERE cveMateriaPrima=?";
        try {

            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cant);
            ps.setString(2, cod);
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return false;
    }

     
 
}
