
package modelo;

/**
 *
 * @author ramos
 */
public class Proveedor {
    
    private String cveProveedor;
    private String nombreEmpresa;
    private String nombreEncargado;
    private String apePatEncargado;
    private String apeMatEncargado;
    private String telefonoProveedor;
    private String correoProveedor;
    private String rfc;
    private String ciudadProveedor;
    private String nombreCiudadProveedor;

    public Proveedor() {
    }

    public Proveedor(String cveProveedor, String nombreEmpresa, String nombreEncargado, String apePatEncargado, String apeMatEncargado, String telefonoProveedor, String correoProveedor, String rfc, String ciudadProveedor, String nombreCiudadProveedor) {
        this.cveProveedor = cveProveedor;
        this.nombreEmpresa = nombreEmpresa;
        this.nombreEncargado = nombreEncargado;
        this.apePatEncargado = apePatEncargado;
        this.apeMatEncargado = apeMatEncargado;
        this.telefonoProveedor = telefonoProveedor;
        this.correoProveedor = correoProveedor;
        this.rfc = rfc;
        this.ciudadProveedor = ciudadProveedor; //Codigo postal de la ciudad
        this.nombreCiudadProveedor = nombreCiudadProveedor;//Nombre de la ciudad
    }

    public String getCveProveedor() {
        return cveProveedor;
    }

    public void setCveProveedor(String cveProveedor) {
        this.cveProveedor = cveProveedor;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getNombreEncargado() {
        return nombreEncargado;
    }

    public void setNombreEncargado(String nombreEncargado) {
        this.nombreEncargado = nombreEncargado;
    }

    public String getApePatEncargado() {
        return apePatEncargado;
    }

    public void setApePatEncargado(String apePatEncargado) {
        this.apePatEncargado = apePatEncargado;
    }

    public String getApeMatEncargado() {
        return apeMatEncargado;
    }

    public void setApeMatEncargado(String apeMatEncargado) {
        this.apeMatEncargado = apeMatEncargado;
    }

    public String getTelefonoProveedor() {
        return telefonoProveedor;
    }

    public void setTelefonoProveedor(String telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }

    public String getCorreoProveedor() {
        return correoProveedor;
    }

    public void setCorreoProveedor(String correoProveedor) {
        this.correoProveedor = correoProveedor;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getCiudadProveedor() {
        return ciudadProveedor;
    }

    public void setCiudadProveedor(String ciudadProveedor) {
        this.ciudadProveedor = ciudadProveedor;
    }

    public String getNombreCiudadProveedor() {
        return nombreCiudadProveedor;
    }

    public void setNombreCiudadProveedor(String nombreCiudadProveedor) {
        this.nombreCiudadProveedor = nombreCiudadProveedor;
    }

    
    
    
    
}
