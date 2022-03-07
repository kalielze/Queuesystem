package template;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class client_render extends javax.swing.table.DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable tabel, Object obj, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel component = (JLabel) super.getTableCellRendererComponent(tabel, obj, isSelected, hasFocus, row, column);
        component.setFont(new java.awt.Font("Cambria Math", 0, 12));
        component.setHorizontalAlignment(SwingConstants.CENTER);
        component.setBorder(javax.swing.BorderFactory.createRaisedSoftBevelBorder());
        component.setForeground(Color.BLACK);
        component.setBackground(Color.WHITE);
        if (isSelected) { // if (isSelected && tabel.getSelectedRow() == row) {
            component.setForeground(Color.WHITE);
            component.setBackground(new Color(0, 153, 0));
            component.setFont(new java.awt.Font("Cambria Math", 1, 14));
        }
        return component;
    }
}
