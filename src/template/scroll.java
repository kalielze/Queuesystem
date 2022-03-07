package template;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JScrollPane;

public class scroll extends JScrollPane {

    private Color warna;

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public scroll() {
        setOpaque(false);
        warna = new Color(getBackground().getRed(), getBackground().getGreen(), getBackground().getBlue(), 000);
    }

    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg);
        warna = new Color(getBackground().getRed(), getBackground().getGreen(), getBackground().getBlue(), 000);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(warna);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.dispose();
    }
}
