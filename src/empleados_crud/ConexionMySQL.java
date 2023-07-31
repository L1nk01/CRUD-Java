package empleados_crud;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * Emmanuel Campos 2022-1855
 * 
 */

public class ConexionMySQL
{
    Connection cn;
    
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
        catch(ClassNotFoundException | SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "No se pudo conectar.\nRevise los datos\n");
            JOptionPane.showMessageDialog(null, "Error de conexión: " + ex);
            System.out.println("NO SE PUDO CONECTAR");
            System.out.println("ERROR: " + ex);
        }
        
        return cn;
    }
    
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
