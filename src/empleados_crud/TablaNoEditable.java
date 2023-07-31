package empleados_crud;

import javax.swing.table.DefaultTableModel;

/**
 *
 * Emmanuel Campos 2022-1855
 * 
 */
public class TablaNoEditable extends DefaultTableModel {
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
