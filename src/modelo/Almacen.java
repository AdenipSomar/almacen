/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class Almacen {
    
    private String claveMateriaPrima;
    private String nombreMateria;
    private int stockMinimo;
    private int cantidadDisp;

    public Almacen() {
    }

    public Almacen(String claveMateriaPrima, String nombreMateria, int stockMinimo, int cantidadDisp) {
        this.claveMateriaPrima = claveMateriaPrima;
        this.nombreMateria = nombreMateria;
        this.stockMinimo = stockMinimo;
        this.cantidadDisp = cantidadDisp;
    }

    public String getClaveMateriaPrima() {
        return claveMateriaPrima;
    }

    public void setClaveMateriaPrima(String claveMateriaPrima) {
        this.claveMateriaPrima = claveMateriaPrima;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
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
