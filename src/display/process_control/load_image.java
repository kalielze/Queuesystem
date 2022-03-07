/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package display.process_control;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author 15my15
 */
public class load_image {
    
    private void setImage(JLabel image, File file, int i) {
        String file_path = file.getAbsoluteFile().toString().replace("\"", "/") + "/";
        File[] listOfFiles = file.listFiles();
        if (listOfFiles[i].isFile()) {
            file = new File(file_path + listOfFiles[i].getName());
        }
        ImageIcon icn = new ImageIcon(file.getAbsolutePath());
        Image img = icn.getImage();
        Image scl;
        if (icn.getIconWidth() < icn.getIconHeight()) {
            scl = img.getScaledInstance(image.getWidth() - ((55 * image.getWidth()) / 100), image.getHeight(), Image.SCALE_SMOOTH);
        } else {
            scl = img.getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_SMOOTH);
        }
        ImageIcon nwicn = new ImageIcon(scl);
        image.setIcon(nwicn);
    }

    private int x = 0;

    public void getImage(JLabel image) {
        try {
            FileInputStream stream = new FileInputStream("config/conf-image.properties");
            Properties config = new Properties();
            config.load(stream);
            String drive = config.getProperty("drive");
            File file = new File(drive);
            int y = file.listFiles().length - 1;
            setImage(image, file, 0);
            @SuppressWarnings("Convert2Lambda")
            Timer tm = new Timer(5000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setImage(image, file, x);
                    x += 1;
                    if (x >= y) {
                        x = 0;
                    }
                }
            });
            tm.start();
        } catch (IOException ex) {
            Logger.getLogger(load_image.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
