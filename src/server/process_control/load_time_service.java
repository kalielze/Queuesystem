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
public class load_time_service {
    
    private int time, date, close, time_fasting, date_fasting, close_fasting;
    private String code, type;
    
    public void load() {
        try {
            Properties config = new Properties();
            FileInputStream stream = new FileInputStream("config/conf-time_service.properties");
            //FileInputStream stream = new FileInputStream(new File("config/conf-database_driver.properties").getAbsoluteFile());
            config.load(stream);
            code = config.getProperty("code");
            type = config.getProperty("type");
            time = Integer.parseInt(config.getProperty("time"));
            date = Integer.parseInt(config.getProperty("date"));
            close = Integer.parseInt(config.getProperty("close"));
            time_fasting = Integer.parseInt(config.getProperty("time_fasting"));
            date_fasting = Integer.parseInt(config.getProperty("date_fasting"));
            close_fasting = Integer.parseInt(config.getProperty("close_fasting"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(load_database_driver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(load_database_driver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String code() {
        return code;
    }
    
    public String type() {
        return type;
    }
    
    public int time() {
        return time;
    }
    
    public int date() {
        return date;
    }
    
    public int close() {
        return close;
    }
    
    public int time_fasting() {
        return time_fasting;
    }
    
    public int date_fasting() {
        return date_fasting;
    }
    
    public int close_fasting() {
        return close_fasting;
    }
    
}
