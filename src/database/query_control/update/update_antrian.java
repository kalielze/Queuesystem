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
public class update_antrian {
    
    private Connection con;
    
    public void connection(Connection con) {
        this.con = con;
    }
    
    @SuppressWarnings("ConvertToTryWithResources")
    public void change_visitor_status(String nomor_antrian, int status_antrian) {
        try {
            Statement st = con.createStatement();
            st.executeUpdate("update db_server.dbo.tb_visitor set id_status = " + status_antrian + " where no_queue = '" + nomor_antrian + "' and date = convert(date, getdate(), 103)");
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(update_antrian.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("ConvertToTryWithResources")
    public void change_visitor_kategori(String nomor_antrian, int kategori) {
        try {
            Statement st = con.createStatement();
            st.executeUpdate("update db_server.dbo.tb_visitor set id_category = " + kategori + " where no_queue = '" + nomor_antrian + "' and date = convert(date, getdate(), 103)");
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(update_antrian.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("ConvertToTryWithResources")
    public void audit_service_status(int id_antrian, int status_antrian, String audit, int nomor_meja) {
        try {
            Statement st = con.createStatement();
            st.executeUpdate("update db_server.dbo.tb_service set audit_service = '" + audit + "', id_status = " + status_antrian + " where id_visitor = '" + id_antrian + "' and date = convert(date, getdate(), 103) and id_counter = " + nomor_meja);
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(update_antrian.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("ConvertToTryWithResources")
    public void end_service_status(int id_antrian, int status_antrian, String berhenti, int nomor_meja) {
        try {
            Statement st = con.createStatement();
            st.executeUpdate("update db_server.dbo.tb_service set end_service = '" + berhenti + "', id_status = " + status_antrian + " where id_visitor = " + id_antrian + " and date = convert(date, getdate(), 103) and id_counter = " + nomor_meja);
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(update_antrian.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("ConvertToTryWithResources")
    public void end_visitor(String nomor_antrian, String berhenti) {
        try {
            Statement st = con.createStatement();
            st.executeUpdate("update db_server.dbo.tb_visitor set end_queue = '" + berhenti + "' where no_queue = '" + nomor_antrian + "' and date = convert(date, getdate(), 103)");
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(update_antrian.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("ConvertToTryWithResources")
    public void set_counter(String data[]) {
        try {
            Statement st = con.createStatement();
            st.executeUpdate("update db_server.dbo.tb_counter set hostname = " + data[1] + ", nm_counter = " + data[2] + ", category = " + Integer.parseInt(data[3]) + ", status = " + Integer.parseInt(data[4]) + " where id_counter = " + Integer.parseInt(data[0]));
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(update_attribute.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("ConvertToTryWithResources")
    public void set_display(String data[]) {
        try {
            Statement st = con.createStatement();
            st.executeUpdate("update db_server.dbo.tb_display set hostname = " + data[1] + ", status = " + Integer.parseInt(data[2]) + " where id_display = " + Integer.parseInt(data[0]));
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(update_attribute.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("ConvertToTryWithResources")
    public void set_admin(String data[]) {
        try {
            Statement st = con.createStatement();
            st.executeUpdate("update db_server.dbo.tb_admin set hostname = " + data[1] + ", status = " + Integer.parseInt(data[2]) + " where id_admin = " + Integer.parseInt(data[0]));
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(update_attribute.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
