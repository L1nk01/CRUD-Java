package empleados_crud;

import javax.swing.JComboBox;

/**
 *
 * Emmanuel Campos 2022-1855
 * 
 */

public class MetodosBusqueda {
        
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
