/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.process_control;

import database.query_control.load_database_driver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class load_client_attribute {
    
    private String category, name, number;
    
    public void load() {
        try {
            Properties config = new Properties();
            FileInputStream stream = new FileInputStream("config/conf-client_attribute.properties");
            //FileInputStream stream = new FileInputStream(new File("config/conf-database_driver.properties").getAbsoluteFile());
            config.load(stream);
            category = config.getProperty("category");
            name = config.getProperty("name");
            number = config.getProperty("number");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(load_client_attribute.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(load_client_attribute.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String category() {
        return category;
    }
    
    public String name() {
        return name;
    }
    
    public String number() {
        return number;
    }
}
