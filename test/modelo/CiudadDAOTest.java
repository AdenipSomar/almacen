/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ramos
 */
public class CiudadDAOTest {
    
    public CiudadDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

   /**
     * Test of registrarCiudad method, of class CiudadDAO.
     */
    @Test
    public void testRegistrarCiudadNull() {
        System.out.println("registrarCiudad con null");
        Ciudad cd = null;
        CiudadDAO instance = new CiudadDAO();
        boolean expResult = false; // Esperamos que registrar una ciudad nula falle.
        boolean result = instance.registrarCiudad(cd);
        assertEquals(expResult, result);
    }

    @Test
    public void testRegistrarCiudadValida() {
        System.out.println("registrarCiudad con ciudad válida");
        Ciudad cd = new Ciudad("70110", "CIUDAD IXTEPEC");
        CiudadDAO instance = new CiudadDAO();
        boolean expResult = true; // Esperamos que registrar una ciudad válida tenga éxito.
        boolean result = instance.registrarCiudad(cd);
        assertEquals(expResult, result);
    }

    /**
     * Test of ModificarCiudad method, of class CiudadDAO.
     */
   @Test
    public void testModificarCiudadNull() {
        System.out.println("ModificarCiudad con null");
        Ciudad cd = null;
        CiudadDAO instance = new CiudadDAO();
        boolean expResult = false; // Esperamos que modificar una ciudad nula falle.
        boolean result = instance.ModificarCiudad(cd);
        assertEquals(expResult, result);
    }

    @Test
    public void testModificarCiudadValida() {
        System.out.println("ModificarCiudad con ciudad válida");
        Ciudad cd = new Ciudad("70110", "IXTEPEC");
        CiudadDAO instance = new CiudadDAO();
        boolean expResult = true; // Esperamos que modificar una ciudad válida tenga éxito.
        boolean result = instance.ModificarCiudad(cd);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of listarCiudad method, of class CiudadDAO.
     */
    @Test
    public void testListarCiudad() {
        System.out.println("listarCiudad");
        CiudadDAO instance = new CiudadDAO();
        List<Ciudad> result = instance.listarCiudad();        
        // Verifica que la lista no sea nula
        assertNotNull("La lista no debería ser nula", result);       
        // Imprimir todas las ciudades recuperadas para depuración
        for (Ciudad ciudad : result) {
            System.out.println("Ciudad recuperada: " + ciudad.getCodPostal() + ", " + ciudad.getNombreCiudad());
        }       
        // Busca una ciudad específica con codPostal = "70110" y nombreCiudad = "IXTEPEC"
        boolean found = false;
        for (Ciudad ciudad : result) {
            if ("70000".equals(ciudad.getCodPostal()) && "JUCHITAN DE ZARAGOZA".equals(ciudad.getNombreCiudad())) {
                found = true;
                break;
            }
        }     
        // Verifica que se haya encontrado la ciudad específica
        assertTrue("La ciudad con codPostal '70110' y nombreCiudad 'IXTEPEC' debería estar en la lista", found);
    }
    /**
     * Test of eliminarCiudad method, of class CiudadDAO.
     */
    // Método auxiliar para agregar una ciudad a la base de datos para pruebas
    private void insertarCiudadPrueba(String codPostal, String nombreCiudad) {
        String sql = "INSERT INTO ciudad_tbl (codPostal, nombreCiudad) VALUES (?, ?)";
        try (Connection con = conexion.getConnection(); 
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, codPostal);
            ps.setString(2, nombreCiudad);
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    @Test
    public void testEliminarCiudad() {
        System.out.println("eliminarCiudad");
        String codPostal = "70110";
        String nombreCiudad = "IXTEPEC";
        // Insertar la ciudad de prueba
        insertarCiudadPrueba(codPostal, nombreCiudad);
        // Instancia del DAO
        CiudadDAO instance = new CiudadDAO();
        // Intentar eliminar la ciudad insertada
        boolean expResult = true;
        boolean result = instance.eliminarCiudad(codPostal);
        assertEquals(expResult, result);
        // Verificar que la ciudad ya no está en la base de datos
        List<Ciudad> resultList = instance.listarCiudad();
        boolean found = false;
        for (Ciudad ciudad : resultList) {
            if (codPostal.equals(ciudad.getCodPostal()) && nombreCiudad.equals(ciudad.getNombreCiudad())) {
                found = true;
                break;
            }
        }
        // La ciudad no debería estar en la lista
        assertFalse("La ciudad con codPostal '70110' y nombreCiudad 'IXTEPEC' no debería estar en la lista después de eliminarla", found);
    }
//    /**
//     * Test of obtenerCiudades method, of class CiudadDAO.
//     */
//    @Test
//    public void testObtenerCiudades() {
//        System.out.println("obtenerCiudades");
//        CiudadDAO instance = new CiudadDAO();
//        List<Ciudad> expResult = null;
//        List<Ciudad> result = instance.obtenerCiudades();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
}
