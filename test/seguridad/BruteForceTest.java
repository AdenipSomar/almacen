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
   
    public static final String[][] userCredentials = {
        {"rosita.santiago", " "}, // Se omite la contraseña para crear un banco de contraseñas para el ataque
        {"admin", "administradorjoa"}, // Estos son otros usuarios y sus contraseñas
        {"respaldo", "administradorrespaldo"}
    };

    public static final String[] passwordDictionary = {
        "12345", "password", "admin", "123456", "welcome", "qwerty", 
        "tortilleria", "administradorjoa", "administradorrespaldo", 
        "password1", "12345678", "iloveyou", "abc123", "123123", "admin1"
    };

    public static void main(String[] args) {
        LoginView loginView = new LoginView();

        for (String[] userCredential : userCredentials) {
            String username = userCredential[0];
            for (String password : passwordDictionary) {
                if (loginView.tryLogin(username, password)) {
                    System.out.println("Login successful for user: " 
                         + username + " with password: " + password);
                    break;
                } else {
                    System.out.println("Failed login attempt for user: "
                            + username + " with password: " + password);
                }
            }
        }
    }
}

class LoginView {

    public static final String[][] userCredentials = {
        {"rosita.santiago", ""}, // Omití la contraseña para que puedas crear un banco de contraseñas para el ataque
        {"admin", "administradorjoa"}, // Estos son otros usuarios y sus contraseñas
        {"respaldo", "administradorrespaldo"}
    };

    public boolean tryLogin(String usuario, String contrasena) {
        if (!usuario.isEmpty() && !contrasena.isEmpty()) {
            // Verificar las credenciales
            for (String[] credential : userCredentials) {
                if (credential[0].equals(usuario) && credential[1].equals(contrasena)) {
                    return true;
                }
            }
        }
        return false;
    }
   
}