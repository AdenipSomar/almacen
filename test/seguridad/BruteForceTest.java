/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad;

import javax.swing.JOptionPane;

/**
 *
 * @author ramos
 */
public class BruteForceTest {
   private static final String[][] userCredentials = {
    {"rosita.santiago", "rositasantiago"},
        {"admin", "admin"},
        {"respaldo", "respaldo"}
  
    };

    public static void main(String[] args) {
        for (String[] credential : userCredentials) {
            String username = credential[0];
            String password = credential[1];

            boolean authenticated = iniciarSesion(username, password);
            if (authenticated) {
                JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso con " + username + ":" + password);
            } else {
                JOptionPane.showMessageDialog(null, "Inicio de sesión fallido con " + username + ":" + password);
            }
        }
    }

    private static boolean iniciarSesion(String usuario, String contrasena) {
        // Simulación de componente de interfaz gráfica
        // Verificar las credenciales
        boolean authenticated = false;
        for (String[] credential : userCredentials) {
            if (credential[0].equals(usuario) && credential[1].equals(contrasena)) {
                authenticated = true;
                break;
            }
        }
        return authenticated;
    }
}