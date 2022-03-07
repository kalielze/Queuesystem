/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package display.process_control;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 15my15
 */
public class load_display_attribute {
    
    private String port1, port2, width;
    
    public void load() {
        try {
            Properties config = new Properties();
            FileInputStream stream = new FileInputStream("config/conf-display_attribute.properties");
            //FileInputStream stream = new FileInputStream(new File("config/conf-database_driver.properties").getAbsoluteFile());
            config.load(stream);
            port1 = config.getProperty("port1");
            port2 = config.getProperty("port2");
            width = config.getProperty("width");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(load_display_attribute.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(load_display_attribute.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String port1() {
        return port1;
    }
    
    public String port2() {
        return port2;
    }
    
    public String width() {
        return width;
    }

}
