/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacionsolid;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author daniel
 */
public class ConexionDB {
    
    private static volatile ConexionDB instance;
    
    private Connection connection;
    
    String pathProyecto = System.getProperty("user.dir");

    String rutaArchivo = pathProyecto + "/src/persistencia/bd/dbsql";

    private ConexionDB()
    {
        if (connection == null) {
            JOptionPane.showMessageDialog(null, "Creando nueva conexion");
            try {
                Class.forName("org.h2.Driver");
                String url = getUrl();
                System.out.println(url);
                connection = DriverManager.getConnection(url, "root", "root");
                JOptionPane.showMessageDialog(null, "Conexión establecida exitosamente");
            } catch (Exception e) {
                e.printStackTrace();
                
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }
    }
    
    public Connection getConexion() {
        return connection;
    }
    
    public static synchronized ConexionDB getInstance() {
        if (instance == null) { // Bloqueo doble para la seguridad de los hilos
            instance = new ConexionDB(); // Crea la instancia si no existe
        }
        return instance;
    }
    
    public String getUrl()
    {
       return "jdbc:h2:file:" + rutaArchivo; 
    }
}
