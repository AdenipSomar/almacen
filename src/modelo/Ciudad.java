
package modelo;

/**
 *
 * @author ramos
 */
public class Ciudad {
    
    private String codPostal;
    private String nombreCiudad;

    public Ciudad() {
    }

    public Ciudad(String codPostal, String nombreCiudad) {
        this.codPostal = codPostal;
        this.nombreCiudad = nombreCiudad;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }
    
    
    
}
