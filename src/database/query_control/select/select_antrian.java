/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.query_control.select;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class select_antrian {
    
    private Connection con;
    
    public void connection(Connection con) {
        this.con = con;
    }
    
    @SuppressWarnings("ConvertToTryWithResources")
    public void close_admin() {
        try {
            Statement st = con.createStatement();
            st.executeUpdate("update db_server.dbo.tb_admin set hostname = null, status = 0");
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(select_antrian.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("ConvertToTryWithResources")
    public void close_counter() {
        try {
            Statement st = con.createStatement();
            st.executeUpdate("update db_server.dbo.tb_counter set hostname = null, nm_counter = null, category = 0, status = 0");
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(select_antrian.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("ConvertToTryWithResources")
    public void close_display() {
        try {
            Statement st = con.createStatement();
            st.executeUpdate("update db_server.dbo.tb_display set hostname = null, status = 0");
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(select_antrian.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("ConvertToTryWithResources")
    public boolean check_queue_number(int kode_nomor) {
        boolean bl = false;
        try {
            Statement st = con.createStatement();
            ResultSet rs;
            rs = st.executeQuery("select date from db_server.dbo.tb_visitor where date = convert(date, getdate(), 103) and id_number = " + kode_nomor);
            while (rs.next()) {
                if (rs.getString(1) != null) {
                    bl = true;
                }
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(select_antrian.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bl;
    }
    
    @SuppressWarnings("ConvertToTryWithResources")
    public String get_queue_number(int kode_nomor) {
        String number = null;
        try {
            Statement st = con.createStatement();
            ResultSet rs;
            rs = st.executeQuery("select max(no_queue) from db_server.dbo.tb_visitor where date = convert(date, getdate(), 103) and id_number = " + kode_nomor);
            while (rs.next()) {
                number = rs.getString(1);
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(select_antrian.class.getName()).log(Level.SEVERE, null, ex);
        }
        return number;
    }
    
    @SuppressWarnings("ConvertToTryWithResources")
    public String get_queue_category(int kategori) {
        String category = null;
        try {
            Statement st = con.createStatement();
            ResultSet rs;
            rs = st.executeQuery("select nm_category from db_server.dbo.tb_category where id_category = " + kategori);
            while (rs.next()) {
                category = rs.getString(1);
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(select_antrian.class.getName()).log(Level.SEVERE, null, ex);
        }
        return category;
    }
    
    @SuppressWarnings("ConvertToTryWithResources")
    public String get_queue_count(int kategori) {
        String count = null;
        try {
            Statement st = con.createStatement();
            ResultSet rs;
            rs = st.executeQuery("select count(no_queue) from db_server.dbo.tb_visitor where date = convert(date, getdate(), 103) and id_category = " + kategori);
            while (rs.next()) {
                count = rs.getString(1);
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(select_antrian.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
    
    @SuppressWarnings("ConvertToTryWithResources")
    public ArrayList<String> get_counter(int kategori) {
        @SuppressWarnings("Convert2Diamond")
        ArrayList<String> data = new ArrayList<String>();
        try {
            Statement st = con.createStatement();
            ResultSet rs;
            if (kategori != 4) {
                rs = st.executeQuery("select id_counter, hostname from db_server.dbo.tb_counter where status = 1 and category != 4 ");
            } else {
                rs = st.executeQuery("select id_counter, hostname from db_server.dbo.tb_counter where status = 1 and category = 4");
            }
            while (rs.next()) {
                data.add(rs.getString(1) + " " + rs.getString(2));
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(select_antrian.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    @SuppressWarnings("ConvertToTryWithResources")
    public String get_display(int id_display) {
        @SuppressWarnings("Convert2Diamond")
        String data = null;
        try {
            Statement st = con.createStatement();
            ResultSet rs;
            rs = st.executeQuery("select id_display, hostname from db_server.dbo.tb_display where status = 1 and id_display = " + id_display);
            while (rs.next()) {
                data = rs.getString(1) + " " + rs.getString(2);
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(select_antrian.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    @SuppressWarnings("ConvertToTryWithResources")
    public ArrayList<String> get_admin() {
        @SuppressWarnings("Convert2Diamond")
        ArrayList<String> data = new ArrayList<String>();
        try {
            Statement st = con.createStatement();
            ResultSet rs;
            rs = st.executeQuery("select id_admin, hostname from db_server.dbo.tb_admin where status = 1");
            while (rs.next()) {
                data.add(rs.getString(1) + " " + rs.getString(2));
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(select_antrian.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    @SuppressWarnings("ConvertToTryWithResources")
    public ArrayList<String> get_counter_category(int kategori) {
        int kategori2 = 0;
        switch (kategori) {
            case 1:
                kategori2 = 1;
                break;
            case 2:
                kategori2 = 3;
                break;
            case 3:
                kategori2 = 2;
                break;
            default:
                break;
        }
        @SuppressWarnings("Convert2Diamond")
        ArrayList<String> data = new ArrayList<String>();
        try {
            Statement st = con.createStatement();
            ResultSet rs;
            rs = st.executeQuery("select id_counter, hostname from db_server.dbo.tb_counter where (category = " + kategori + " or category = " + kategori2 + ") and status = 1");
            while (rs.next()) {
                data.add(rs.getString(1) + " " + rs.getString(2));
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(select_antrian.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    @SuppressWarnings("ConvertToTryWithResources")
    public String get_queue_list_normal() {
        String data = "";
        try {
            Statement st = con.createStatement();
            ResultSet rs;
            rs = st.executeQuery("select tb_category.id_category, tb_category.nm_category, isnull(count_, 0) from (select tb_visitor.id_category as id_, count(tb_visitor.id_category) as count_ from db_server.dbo.tb_visitor where tb_visitor.date = convert(date, getdate(), 103) and tb_visitor.id_status = 1  group by tb_visitor.id_category) as data right join db_server.dbo.tb_category on tb_category.id_category = data.id_");
            data = "<html>";
            while (rs.next()) {
                data += "<tr style='border-bottom:1pt'><td>" + rs.getString(2) + "</td>";
                if (rs.getString(3).equals("0")) {
                    data += "<td> : <font color=red>" + rs.getString(3) + "</font></td></tr>";
                } else {
                    data += "<td> : <font color=blue>" + rs.getString(3) + "</font></td></tr>";
                }
            }
            data += "</html>";
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(select_antrian.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    @SuppressWarnings("ConvertToTryWithResources")
    public String get_queue_list_admin() {
        String data = "";
        try {
            Statement st = con.createStatement();
            ResultSet rs;
            rs = st.executeQuery("select tb_category.id_category, tb_category.nm_category, isnull(count_, 0) from (select tb_visitor.id_category as id_, count(tb_visitor.id_category) as count_ from db_server.dbo.tb_visitor where tb_visitor.date = convert(date, getdate(), 103) and tb_visitor.id_status = 1  group by tb_visitor.id_category) as data right join db_server.dbo.tb_category on tb_category.id_category = data.id_ where tb_category.id_category != 4");
            data = "<html>";
            while (rs.next()) {
                data += "<tr style='border-bottom:1pt'><td>" + rs.getString(2) + "</td>";
                if (rs.getString(3).equals("0")) {
                    data += "<td> : <font color=red>" + rs.getString(3) + "</font></td></tr>";
                } else {
                    data += "<td> : <font color=blue>" + rs.getString(3) + "</font></td></tr>";
                }
            }
            data += "</html>";
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(select_antrian.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    @SuppressWarnings("ConvertToTryWithResources")
    public String get_queue_list_cashier() {
        String data = "";
        try {
            Statement st = con.createStatement();
            ResultSet rs;
            rs = st.executeQuery("select 'K-' + tb_number.nm_number, isnull(count_, 0) from (select tb_visitor.id_number, count(tb_visitor.id_number) as count_ from db_server.dbo.tb_visitor where tb_visitor.id_category = 4 and tb_visitor.date = convert(date, getdate(), 103) and tb_visitor.id_status = 1 group by tb_visitor.id_number) as data right join db_server.dbo.tb_number on tb_number.id_number = data.id_number");
            data = "<html>";
            while (rs.next()) {
                data += "<tr style='border-bottom:1pt'><td>" + rs.getString(1) + "</td>";
                if (rs.getString(2).equals("0")) {
                    data += "<td> : <font color=red>" + rs.getString(2) + "</font></td></tr>";
                } else {
                    data += "<td> : <font color=blue>" + rs.getString(2) + "</font></td></tr>";
                }
            }
            data += "</html>";
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(select_antrian.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    @SuppressWarnings("ConvertToTryWithResources")
    public String number_queue(int kategori) {
        String nomor_antrian = null;
        try {
            Statement st = con.createStatement();
            ResultSet rs;
            rs = st.executeQuery("select top 1 no_queue from db_server.dbo.tb_visitor where id_category = " + kategori + " and date = convert(date, getdate(), 103) and id_status = 1 order by start_queue, no_queue asc");
            while (rs.next()) {
                nomor_antrian = rs.getString(1);
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(select_antrian.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nomor_antrian;
    }
    
    @SuppressWarnings("ConvertToTryWithResources")
    public String number_queue_double_category(int kategori1, int kategori2) {
        String nomor_antrian = null;
        try {
            Statement st = con.createStatement();
            ResultSet rs;
            rs = st.executeQuery("select top 1 no_queue from db_server.dbo.tb_visitor where (id_category = " + kategori1 + " or id_category = " + kategori2 + ") and date = convert(date, getdate(), 103) and id_status = 1 order by start_queue, no_queue asc");
            while (rs.next()) {
                nomor_antrian = rs.getString(1);
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(select_antrian.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nomor_antrian;
    }
    
    @SuppressWarnings("ConvertToTryWithResources")
    public String number_queue_cashier(int kategori, int kode) {
        String nomor_antrian = null;
        try {
            Statement st = con.createStatement();
            ResultSet rs;
            rs = st.executeQuery("select top 1 no_queue from db_server.dbo.tb_visitor where id_category = " + kategori + " and id_number = " + kode + " and date = convert(date, getdate(), 103) and id_status = 1 order by start_queue, no_queue asc");
            while (rs.next()) {
                nomor_antrian = rs.getString(1);
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(select_antrian.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nomor_antrian;
    }
    
    @SuppressWarnings("ConvertToTryWithResources")
    public int id_queue(String nomor_antrian) {
        int id_antrian = 0;
        try {
            Statement st = con.createStatement();
            ResultSet rs;
            rs = st.executeQuery("select id_visitor from db_server.dbo.tb_visitor where no_queue = '" + nomor_antrian + "' and date = convert(date, getdate(), 103)");
            while (rs.next()) {
                id_antrian = Integer.parseInt(rs.getString(1));
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(select_antrian.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id_antrian;
    }
    
    @SuppressWarnings("ConvertToTryWithResources")
    public String get_id_number(String number) {
        String id = null;
        try {
            Statement st = con.createStatement();
            ResultSet rs;
            rs = st.executeQuery("select id_visitor from db_server.dbo.tb_visitor where no_queue = '" + number + "' and date = convert(date, getdate(), 103)");
            while (rs.next()) {
                id = rs.getString(1);
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(select_antrian.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    @SuppressWarnings("ConvertToTryWithResources")
    public String last_visitor_display() {
        String jumlah_antrian = "0";
        try {
            Statement st = con.createStatement();
            ResultSet rs;
            rs = st.executeQuery("select count(no_queue) from db_server.dbo.tb_visitor where date = convert(date, getdate(), 103)");
            while (rs.next()) {
                jumlah_antrian = rs.getString(1);
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(select_antrian.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jumlah_antrian;
    }
}
