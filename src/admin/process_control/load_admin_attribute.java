/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.process_control;

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
public class load_admin_attribute {
    
    private String admin1, admin2, admin3;
    
    public void load() {
        try {
            Properties config = new Properties();
            FileInputStream stream = new FileInputStream("config/conf-admin_attribute.properties");
            //FileInputStream stream = new FileInputStream(new File("config/conf-database_driver.properties").getAbsoluteFile());
            config.load(stream);
            admin1 = config.getProperty("admin1");
            admin2 = config.getProperty("admin2");
            admin3 = config.getProperty("admin3");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(load_admin_attribute.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(load_admin_attribute.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String admin1() {
        return admin1;
    }
    
    public String admin2() {
        return admin2;
    }
    
    public String admin3() {
        return admin3;
    }
    
}
