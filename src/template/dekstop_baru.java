/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package template;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JDesktopPane;

public class dekstop_baru extends JDesktopPane {

    private Color warna;

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public dekstop_baru() {
        setOpaque(false);
        warna = new Color(getBackground().getRed(), getBackground().getGreen(), getBackground().getBlue(), 001);
    }

    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg);
        warna = new Color(getBackground().getRed(), getBackground().getGreen(), getBackground().getBlue(), 001);
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