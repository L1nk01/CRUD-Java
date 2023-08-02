package empleados_crud;

import javax.swing.table.DefaultTableModel;

/**
 * Clase personalizada que extiende DefaultTableModel y permite crear tablas no editables.
 * Esta clase proporciona una implementación del método isCellEditable que siempre devuelve false.
 * 
 * @author Emmanuel Campos 2022-1855
 */

public class TablaNoEditable extends DefaultTableModel {
    /**
     * Determina si una celda en la tabla es editable o no.
     * En esta implementación, todas las celdas son no editables y siempre devuelve false.
     * 
     * @param row El índice de la fila de la celda.
     * @param column El índice de la columna de la celda.
     * @return false siempre, ya que las columnas no son editables.
     */
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
