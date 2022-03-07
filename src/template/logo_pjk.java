package template;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class logo_pjk extends JPanel {

    private final Image gambar;

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public logo_pjk() {
        setOpaque(false);
        gambar = new ImageIcon(getClass().getResource("/image/SP.png")).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setComposite(AlphaComposite.SrcOver.derive(1F));
        g2d.drawImage(gambar, 0, 0, getWidth(), getHeight(), null);
        g2d.dispose();
    }
}
