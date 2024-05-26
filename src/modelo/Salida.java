/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author ramos
 */
public class Salida {
    
    private String claveSalidaMaterial;
    private int cantidadSalida;
    private String fechaSalida;
    private String detalleSalida;
    
    private String claveMateriaPrimaSalida;
    private String nombreMateriaPrimaSalida;
    private int stockMinimo;
    private int cantidadDisp;
    

    public Salida() {
    }

    public Salida(String claveSalidaMaterial, int cantidadSalida, String fechaSalida, String detalleSalida, String claveMateriaPrimaSalida, String nombreMateriaPrimaSalida, int stockMinimo, int cantidadDisp) {
        this.claveSalidaMaterial = claveSalidaMaterial;
        this.cantidadSalida = cantidadSalida;
        this.fechaSalida = fechaSalida;
        this.detalleSalida = detalleSalida;
        this.claveMateriaPrimaSalida = claveMateriaPrimaSalida;
        this.nombreMateriaPrimaSalida = nombreMateriaPrimaSalida;
        this.stockMinimo = stockMinimo;
        this.cantidadDisp = cantidadDisp;
    }

    public String getClaveSalidaMaterial() {
        return claveSalidaMaterial;
    }

    public void setClaveSalidaMaterial(String claveSalidaMaterial) {
        this.claveSalidaMaterial = claveSalidaMaterial;
    }

    public int getCantidadSalida() {
        return cantidadSalida;
    }

    public void setCantidadSalida(int cantidadSalida) {
        this.cantidadSalida = cantidadSalida;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getDetalleSalida() {
        return detalleSalida;
    }

    public void setDetalleSalida(String detalleSalida) {
        this.detalleSalida = detalleSalida;
    }

    public String getClaveMateriaPrimaSalida() {
        return claveMateriaPrimaSalida;
    }

    public void setClaveMateriaPrimaSalida(String claveMateriaPrimaSalida) {
        this.claveMateriaPrimaSalida = claveMateriaPrimaSalida;
    }

    public String getNombreMateriaPrimaSalida() {
        return nombreMateriaPrimaSalida;
    }

    public void setNombreMateriaPrimaSalida(String nombreMateriaPrimaSalida) {
        this.nombreMateriaPrimaSalida = nombreMateriaPrimaSalida;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public int getCantidadDisp() {
        return cantidadDisp;
    }

    public void setCantidadDisp(int cantidadDisp) {
        this.cantidadDisp = cantidadDisp;
    }

   
    
    
    
}
