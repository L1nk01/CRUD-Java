package empleados_crud;

/**
 * Clase que proporciona métodos para realizar validaciones en diferentes tipos de datos.
 * Incluye métodos para validar campos de texto, valores seleccionados en JComboBox, valores float y fechas.
 * 
 * @author Emmanuel Campos 2022-1855
 */

public class MetodosValidacion {
    /**
     * Valida si el campo de entrada es válido.
     * Un campo se considera válido si no está vacío (espacios en blanco no cuentan como caracteres).
     * 
     * @param input
     * @return true si el cambo es válido, false si el campo está vacío o contiene solo espacios en blanco.
     */
    public boolean validarCampo(String input) {
        return input.trim().length() > 0;
    }
    
    /**
     * Valida si el valor seleccionado en un JComboBox es válido.
     * Un valor se considera válido si no es igual a "Elegir".
     * 
     * @param input El valor seleccionado en el JComboBox que se desea validar.
     * @return true si el valor seleccionado es válido, false si es igual a ''Elegir''.
     */
    public boolean validarComboBox(String input) {
        return !input.equals("Elegir");
    }
    
    /**
     * Valida si el valor float proporcionado es válido.
     * Un valor float se considera válido si no es igual a 0.
     * 
     * @param input El valor float que se desea validar.
     * @return true si el valor float es válido (distinto de 0), false si es igual a 0.
     */
    public boolean validarFloat(float input) {
        return input != 0;
    }
    
    /**
     * Valida si la fecha proporcionada es válida.
     * Una fecha se considera válida si no es nula (null).
     * 
     * @param fecha La fecha que se desea validar.
     * @return true si la fecha es válida (no es nula), false si es nula.
     */
    public boolean validarFecha(java.util.Date fecha) {
        return fecha != null;
    }
}
