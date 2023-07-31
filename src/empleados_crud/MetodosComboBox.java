package empleados_crud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * Emmanuel Campos 2022-1855
 * 
 */

public class MetodosComboBox {
    
    private Connection cn;
    
    public MetodosComboBox(Connection conexion) {
        this.cn = conexion;
    }
    
    public String getComboText(JComboBox comboBox) {
        String selected = (String) comboBox.getSelectedItem();

        if (selected.equals("Elegir")) {
            return null;
        } else if (selected.equals("Ninguno")) {
            return null;
        }
        return selected;
    }
    
    public String getSexo(JComboBox comboSexo) {
        String selected = (String) comboSexo.getSelectedItem();       
        switch (selected) {
            case "Masculino" -> {
                return "M";
            }
            case "Femenino" -> {
                return "F";
            }
            default -> {
                return null;
            }

        }
    }
    
    // Agrega las opciones al combo box tomándolas directamente de una tabla de la base de datos.    
    public void setComboOpciones(String tabla, JComboBox comboBox) {   
        String consultasql = "SELECT " + tabla + " FROM departamentos ORDER BY codDepto ASC;";
        String data;
        
        try
        {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consultasql);
            
            while (rs.next())
            {
                data = rs.getString(1);
                comboBox.addItem(data);
            }
        }
        catch (SQLException e)
        {
            System.out.println("Error al mostrar los datos: " + e);
        }
    }
}
