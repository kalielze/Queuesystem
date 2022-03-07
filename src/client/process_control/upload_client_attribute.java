/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.process_control;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class upload_client_attribute {
    
    @SuppressWarnings("null")
    public void upload(String category, String name, String number) {
        FileOutputStream out_stream = null;
        try {
            Properties config = new Properties();
            config.setProperty("category", category);
            config.setProperty("name", name);
            config.setProperty("number", number);
            out_stream = new FileOutputStream("config/conf-client_attribute.properties");
            config.store(out_stream, "edited conf-client_attribute");
            out_stream.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(upload_client_attribute.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(upload_client_attribute.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                out_stream.close();
            } catch (IOException ex) {
                Logger.getLogger(upload_client_attribute.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
