package empleados_crud;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Clase que proporciona métodos para conectarse y desconectarse de una base de datos MySQL.
 * Utiliza el controlador JDBC "com.mysql.cj.jdbc.Driver" para establecer la conexión.
 * 
 * Emmanuel Campos 2022-1855
 */

public class ConexionMySQL
{
    Connection cn;
    
    /**
     * Establece una conexión con la base de datos MySQL utilizando los parámetros proporcionados.
     * 
     * @param usuario El nombre de usuario para la conexión a la base de datos.
     * @param password La contraseña del usuario para la conexión a la base de datos.
     * @param ip La dirección IP o nombre del servidor de la base de datos.
     * @param baseDeDatos El nombre de la base de datos a la que se desea conectar.
     * @return La conexión establecida (objeto Connection) si la conexión es exitosa, o null si ocurre un error.
     */
    public Connection conectar(String usuario, String password, String ip, String baseDeDatos)
    {
        String direccion = String.format(
            "jdbc:mysql://"
            + "%s/"
            + "%s"
            , ip, baseDeDatos
        );
        
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(direccion, usuario, password);
            System.out.println("CONECTADO");
        }
        catch (ClassNotFoundException | SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "No se pudo conectar.\nRevise los datos\n");
            JOptionPane.showMessageDialog(null, "Error de conexión: " + ex);
            System.out.println("NO SE PUDO CONECTAR");
            System.out.println("ERROR: " + ex);
        }
        
        return cn;
    }
    
    /**
     * Cierra la conexión actual con la base de datos MySQL.
     */
    public void desconectar()
    {
        try
        {
            cn.close();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(ConexionMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
