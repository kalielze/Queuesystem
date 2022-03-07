package template;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class render extends javax.swing.table.DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable tabel, Object obj, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel component = (JLabel) super.getTableCellRendererComponent(tabel, obj, isSelected, hasFocus, row, column);
        component.setFont(new java.awt.Font("Times New Roman", 1, 14));
        component.setHorizontalAlignment(SwingConstants.CENTER);
        component.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        return component;
    }
}
