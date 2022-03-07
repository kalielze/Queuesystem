/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.query_control.update;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class update_attribute {
    
    private Connection con;
    
    public void connection(Connection con) {
        this.con = con;
    }
    
    @SuppressWarnings("ConvertToTryWithResources")
    public void set_counter(String data[]) {
        try {
            Statement st = con.createStatement();
            st.executeUpdate("update db_server.dbo.tb_counter set hostname = " + data[1] + ", nm_counter = " + data[2] + ", category = " + Integer.parseInt(data[3]) + ", status = " + Integer.parseInt(data[4]) + " WHERE id_counter = " + Integer.parseInt(data[0]));
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(update_attribute.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("ConvertToTryWithResources")
    public void set_display(String data[]) {
        try {
            Statement st = con.createStatement();
            st.executeUpdate("update db_server.dbo.tb_display set hostname = " + data[1] + ", status = " + Integer.parseInt(data[2]) + " WHERE id_display = " + Integer.parseInt(data[0]));
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(update_attribute.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("ConvertToTryWithResources")
    public void set_admin(String data[]) {
        try {
            Statement st = con.createStatement();
            st.executeUpdate("update db_server.dbo.tb_admin set hostname = " + data[1] + ", status = " + Integer.parseInt(data[2]) + " WHERE id_admin = " + Integer.parseInt(data[0]));
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(update_attribute.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
