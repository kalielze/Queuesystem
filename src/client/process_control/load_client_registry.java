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
public class load_client_registry {
        
    public String load() {
        String url = null;
        try {
            Properties config = new Properties();
            FileInputStream stream = new FileInputStream("config/conf-client_registry.properties");
            //FileInputStream stream = new FileInputStream(new File("config/conf-database_driver.properties").getAbsoluteFile());
            config.load(stream);
            String ip_server = config.getProperty("ip-server");
            String port_server = config.getProperty("port-server");
            String id_server = config.getProperty("id-server");
            url = ip_server + port_server + id_server;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(load_client_registry.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(load_client_registry.class.getName()).log(Level.SEVERE, null, ex);
        }
        return url;
    }
    
}
