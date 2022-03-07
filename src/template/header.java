package template;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class header extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable tabel, Object obj, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel component = (JLabel) super.getTableCellRendererComponent(tabel, obj, isSelected, hasFocus, row, column);
        tabel.setShowGrid(true);
        tabel.getTableHeader().setDefaultRenderer(new render());
	int colWidth = tabel.getColumnModel().getTotalColumnWidth();
        tabel.getTableHeader().setPreferredSize(new Dimension(colWidth, 25));
        component.setHorizontalAlignment(SwingConstants.CENTER);
        component.setForeground(Color.BLACK);
        component.setBackground(Color.WHITE);
        component.setFont(new java.awt.Font("Times New Roman", 0, 14));
        if (isSelected && tabel.getSelectedRow() == row && tabel.getSelectedColumn() == column) {
            component.setForeground(Color.WHITE);
            component.setBackground(new Color(0, 153, 0));
        }
        return component;
    }
}
