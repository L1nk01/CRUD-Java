package empleados_crud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;

/**
 * Clase que proporciona métodos para trabajar con objetos JComboBox y realizar operaciones relacionadas con ellos.
 * Utiliza una conexión de base de datos para algunas de sus operaciones.
 * 
 * @author Emmanuel Campos 2022-1855
 */

public class MetodosComboBox {
    
    private Connection cn;
    
    /**
     * Constructor de la clase MetodosComboBox.
     * 
     * @param conexion La conexión a la base de datos que se utilizará para algunas operaciones.
     */
    public MetodosComboBox(Connection conexion) {
        this.cn = conexion;
    }
    
    /**
     * Obtiene el texto seleccionado del JComboBox.
     * 
     * @param comboBox El JComboBox del cual se desea obtener el texto seleccionado.
     * @return El texto seleccionado en el JComboBox, o null si el texto seleccionado es "Elegir" o "Ninguno".
     */
    public String getComboText(JComboBox comboBox) {
        String selected = (String) comboBox.getSelectedItem();

        if (selected.equals("Elegir")) {
            return null;
        } else if (selected.equals("Ninguno")) {
            return null;
        }
        return selected;
    }
    
    /**
     * Obtiene el valor de sexo asociado al texto seleccionado en el JComboBox.
     * 
     * @param comboSexo El JComboBox que contiene las opciones de sexo ("Masculino" y "Femenino").
     * @return El valor de sexo asociado al texto seleccionado en el JComboBox ("M" para Masculino, "F" para Femenino), o null si el texto seleccionado no corresponde a ninguna de las opciones válidas.
     */
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
    
    /**
     * Establece las opciones del JComboBox a partir de los datos de una tabla en la base de datos.
     * 
     * @param tabla El nombre de la tabla de la cual se obtendrán los datos para llenar el JComboBox.
     * @param comboBox El JComboBox que se llenará con las opciones obtenidas de la tabla.
     */
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
