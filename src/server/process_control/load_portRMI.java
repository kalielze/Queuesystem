/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.process_control;

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
public class load_portRMI {
    
    private String port;
    
    public String load() {
        String url = null;
        try {
            Properties config = new Properties();
            FileInputStream stream = new FileInputStream("config/conf-portRMI.properties");
            //FileInputStream stream = new FileInputStream(new File("config/conf-database_driver.properties").getAbsoluteFile());
            config.load(stream);
            String ip = config.getProperty("ip");
            port = config.getProperty("port");
            String id = config.getProperty("id");
            url = ip + port + id;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(load_database_driver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(load_database_driver.class.getName()).log(Level.SEVERE, null, ex);
        }
        return url;
    }
    
    public String port() {
        return port.replace("/", "");
    }
}
