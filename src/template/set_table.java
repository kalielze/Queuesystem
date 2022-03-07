package template;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class set_table {

    public void table(JTable table1, JTable table2) {
        ((DefaultTableCellRenderer) table1.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        table1.getTableHeader().setFont(new java.awt.Font("Times New Roman", 1, 13));
        table1.setDefaultRenderer(Object.class, new admin_render());
        if (table2 != null) {
            ((DefaultTableCellRenderer) table2.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
            table2.getTableHeader().setFont(new java.awt.Font("Times New Roman", 1, 13));
            table2.setDefaultRenderer(Object.class, new admin_render());
        }
    }
}
