
package modelo;

import java.util.Date;

/**
 *
 * @author ramos
 */
public class IngresoPedidos {
    
    private String claveIngresoMaterial;
    private String detallePedido;
    
    private int estado;
    private String estadoDescripcion;
    
    private int cantidadPedido;
    
    private String fechaPedido;
    private String fechaIngreso;
    private float costoTotal;
    
    private String claveProveedor;
    private String nombreProveedor;
    
    private String claveMateria;
    private String nombreMateria;
    
    
    

    public IngresoPedidos() {
    }

    public IngresoPedidos(String claveIngresoMaterial, String detallePedido, int estado, String estadoDescripcion, int cantidadPedido, String fechaPedido, String fechaIngreso, float costoTotal, String claveProveedor, String nombreProveedor, String claveMateria, String nombreMateria) {
        this.claveIngresoMaterial = claveIngresoMaterial;
        this.detallePedido = detallePedido;
        this.estado = estado;
        this.estadoDescripcion = estadoDescripcion;
        this.cantidadPedido = cantidadPedido;
        this.fechaPedido = fechaPedido;
        this.fechaIngreso = fechaIngreso;
        this.costoTotal = costoTotal;
        this.claveProveedor = claveProveedor;
        this.nombreProveedor = nombreProveedor;
        this.claveMateria = claveMateria;
        this.nombreMateria = nombreMateria;
    }

    public String getClaveIngresoMaterial() {
        return claveIngresoMaterial;
    }

    public void setClaveIngresoMaterial(String claveIngresoMaterial) {
        this.claveIngresoMaterial = claveIngresoMaterial;
    }

    public String getDetallePedido() {
        return detallePedido;
    }

    public void setDetallePedido(String detallePedido) {
        this.detallePedido = detallePedido;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getEstadoDescripcion() {
        return estadoDescripcion;
    }

    public void setEstadoDescripcion(String estadoDescripcion) {
        this.estadoDescripcion = estadoDescripcion;
    }

    public int getCantidadPedido() {
        return cantidadPedido;
    }

    public void setCantidadPedido(int cantidadPedido) {
        this.cantidadPedido = cantidadPedido;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public float getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(float costoTotal) {
        this.costoTotal = costoTotal;
    }

    public String getClaveProveedor() {
        return claveProveedor;
    }

    public void setClaveProveedor(String claveProveedor) {
        this.claveProveedor = claveProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getClaveMateria() {
        return claveMateria;
    }

    public void setClaveMateria(String claveMateria) {
        this.claveMateria = claveMateria;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    
    

   
    
    
    
    
}
