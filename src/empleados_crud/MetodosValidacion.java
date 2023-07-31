package empleados_crud;

/**
 *
 * Emmanuel Campos 2022-1855
 * 
 */
public class MetodosValidacion {
    public boolean validarCampo(String input) {
        if (input.trim().length() <= 0) {
            return false;
        }
        return true;
    }
    
    public boolean validarComboBox(String input) {
        return !input.equals("Elegir");
    }
    
    public boolean validarFloat(float input) {
        return input != 0;
    }
    
    public boolean validarFecha(java.util.Date fecha) {
        return fecha != null;
    }
}
