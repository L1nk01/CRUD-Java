package empleados_crud;

import javax.swing.JComboBox;

/**
 * Clase que contiene métodos para obtener información relacionada con la búsqueda y ordenación de empleados.
 * 
 * @author Emmanuel Campos 2022-1855
 */

public class MetodosBusqueda {
    
    /**
     * Obtiene el campo por el cual se realizará la búsqueda en la base de datos según la opción seleccionada en un JComboBox.
     * 
     * @param comboBuscar El JComboBox que contiene las opciones de búsqueda.
     * @return El nombre del campo de la base de datos a utilizar en la búsqueda. Retorna null si la opción no está definida.
     */
    public String getBuscarPor(JComboBox comboBuscar) {
        String selected = (String) comboBuscar.getSelectedItem();
        
        switch (selected) {
            case "Nombre de Empleado":
                return "nomEmp";
            case "ID":
                return "nDIEmp";
            case "Sexo":
                return "sexEmp";
            case "Fecha de Nacimiento":
                return "fecNac";
            case "Fecha de Incorporación":
                return "fecIncorporacion";
            case "Salario":
                return "salEmp";
            case "Comisión":
                return "comisionE";
            case "Cargo":
                return "cargoE";
            case "ID de Jefe":
                return "jefeID";
            case "Código de Departamento":
                return "codDepto";
        }
        return null;
    }
    
    /**
     * Obtiene el criterio de ordenación para realizar una consulta en la base de datos según la opción seleccionada en un JComboBox.
     * 
     * @param comboOrdenar El JComboBox que contiene las opciones de ordenación.
     * @return El criterio de ordenación (ASC o DESC) a utilizar en la consulta. Retorna null si la opción no está definida.
     */
    public String getOrdenarPor(JComboBox comboOrdenar) {
        String selected = (String) comboOrdenar.getSelectedItem();
        
        switch (selected) {
            case "Ascendente":
                return "ASC";
            case "Descendente":
                return "DESC";
        }
        return null;
    }
    
    /**
     * Obtiene el formato de búsqueda para realizar una consulta en la base de datos según la opción seleccionada en un JComboBox.
     * 
     * @param busqueda La cadena de texto que se utilizará para realizar la búsqueda.
     * @param comboTipoBusqueda El JComboBox que contiene las opciones de formato de búsqueda ("Empieza por", "Termina con" o "Contiene").
     * @return El formato de búsqueda (LIKE UPPER(...)) a utilizar en la consulta. Retorna null si la opción no está definida.
     * 
     * El formato de búsqueda "LIKE UPPER(...)" permite realizar la búsqueda sin tener en cuenta si el texto ingresado en 'busqueda' está en mayúsculas o minúsculas. 
     * De esta manera, la consulta se realizará de forma insensible a mayúsculas y minúsculas para mejorar la precisión de los resultados.
     */
    public String getFormatoBusqueda(String busqueda, JComboBox comboTipoBusqueda) {
        String selected = (String) comboTipoBusqueda.getSelectedItem();
        
        switch (selected) {
            case "Empieza por":
                return "LIKE UPPER('" + busqueda + "%')";
            case "Termina con":
                return "LIKE UPPER('%" + busqueda + "')";
            case "Contiene":
                return "LIKE UPPER('%" + busqueda + "%')";
        }
        return null;
    }
}
