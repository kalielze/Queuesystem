/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.query_control.insert;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class insert_antrian {
    
    private Connection con;
    
    public void connection(Connection con) {
        this.con = con;
    }
    
    @SuppressWarnings("ConvertToTryWithResources")
    public void insert_visitor(int nomor_antrian, String mulai, int kategori, int kode_nomor) {
        try {
            Statement st = con.createStatement();
            st.executeUpdate("insert into db_server.dbo.tb_visitor (no_queue, date, start_queue, id_number, id_status, id_category) values (" + nomor_antrian + ", convert(date, getdate(), 103), '" + mulai + "', " + kode_nomor + ", 1, " + kategori + ")");
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(insert_antrian.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("ConvertToTryWithResources")
    public void insert_service(int id_antrian, String mulai, String nama, int kategori, int nomor_meja) {
        try {
            Statement st = con.createStatement();
            st.executeUpdate("insert into db_server.dbo.tb_service (id_visitor, date, start_service, nm_customer, id_category, id_counter, id_status) values (" + id_antrian + ", convert(date, getdate(), 103), '" + mulai + "', '" + nama + "', " + kategori + "," + nomor_meja + ", 2)");
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(insert_antrian.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
