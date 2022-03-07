/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.query_control;

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
public class load_database_driver {
   
    private String driver, url;
    
    public void load() {
        try {
            Properties config = new Properties();
            FileInputStream stream = new FileInputStream("config/conf-database_driver.properties");
            //FileInputStream stream = new FileInputStream(new File("config/conf-database_driver.properties").getAbsoluteFile());
            config.load(stream);
            driver = config.getProperty("driver");
            String jdbc = config.getProperty("jdbc");
            String ip = config.getProperty("ip");
            String port = config.getProperty("port");
            String database = "database=" + config.getProperty("database");
            String username = "user=" + config.getProperty("username");
            String password= "password=" + config.getProperty("password");
            url = jdbc + ip + port + database + username + password;       
        } catch (FileNotFoundException ex) {
            Logger.getLogger(load_database_driver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(load_database_driver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String driver() {
        return driver;
    }
    
    public String url() {
        return url;
    }
    
}
