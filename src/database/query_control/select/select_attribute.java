/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.query_control.select;

import java.awt.Component;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class select_attribute {

    private Connection con;

    public void connection(Connection con) {
        this.con = con;
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public ArrayList<String> get_queue_category() {
        @SuppressWarnings("Convert2Diamond")
        ArrayList<String> kategori = new ArrayList<String>();
        try {
            Statement st = con.createStatement();
            ResultSet rs;
            rs = st.executeQuery("select nm_category from db_server.dbo.tb_category order by id_category asc");
            while (rs.next()) {
                kategori.add(rs.getString(1));
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(select_attribute.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kategori;
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public ArrayList<String> get_queue_counter() {
        @SuppressWarnings("Convert2Diamond")
        ArrayList<String> nomor_meja = new ArrayList<String>();
        try {
            Statement st = con.createStatement();
            ResultSet rs;
            rs = st.executeQuery("select id_counter from db_server.dbo.tb_counter");
            while (rs.next()) {
                nomor_meja.add(rs.getString(1));
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(select_attribute.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nomor_meja;
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public ArrayList<String> get_queue_admin() {
        @SuppressWarnings("Convert2Diamond")
        ArrayList<String> nomor_meja = new ArrayList<String>();
        try {
            Statement st = con.createStatement();
            ResultSet rs;
            rs = st.executeQuery("select id_admin from db_server.dbo.tb_admin");
            while (rs.next()) {
                nomor_meja.add(rs.getString(1));
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(select_attribute.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nomor_meja;
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public boolean check_client_status(int nomor_meja) {
        boolean bl = false;
        try {
            Statement st = con.createStatement();
            ResultSet rs;
            rs = st.executeQuery("select hostname, nm_counter, status from db_server.dbo.tb_counter where id_counter = " + nomor_meja);
            while (rs.next()) {
                if (rs.getString(3).equals("1")) {
                    bl = true;
                    JOptionPane.showMessageDialog(null, "<html>ip_detected <b>" + rs.getString(1) + "</b><br/>nomor meja sudah digunakan user <b>" + rs.getString(2) + "</b></html>", "Failed", JOptionPane.PLAIN_MESSAGE);
                }
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(select_attribute.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bl;
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public boolean check_display_status(int id_display) {
        boolean bl = false;
        try {
            Statement st = con.createStatement();
            ResultSet rs;
            rs = st.executeQuery("select hostname, status from db_server.dbo.tb_display where id_display = " + id_display);
            while (rs.next()) {
                if (rs.getString(2).equals("1")) {
                    bl = true;
                    JOptionPane.showMessageDialog(null, "<html>ip_detected <b>" + rs.getString(1) + "</b><br/>display sudah aktif</html>", "Failed", JOptionPane.PLAIN_MESSAGE);
                }
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(select_attribute.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bl;
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public boolean check_admin_status(int id_admin, Component com) {
        boolean bl = false;
        try {
            Statement st = con.createStatement();
            ResultSet rs;
            rs = st.executeQuery("select hostname, status from db_server.dbo.tb_admin where id_admin = " + id_admin);
            while (rs.next()) {
                if (rs.getString(2).equals("1")) {
                    bl = true;
                    JOptionPane.showMessageDialog(com, "<html>ip_detected <b>" + rs.getString(1) + "</b><br/>admin <b>" + id_admin + "</b> sudah aktif</html>", "Failed", JOptionPane.PLAIN_MESSAGE);
                }
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(select_attribute.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bl;
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public void get_client_list_normal(JLabel antrian) {
        try {
            Statement st = con.createStatement();
            ResultSet rs;
            rs = st.executeQuery("select tb_category.id_category, tb_category.nm_category, isnull(count_, 0) from (select tb_visitor.id_category as id_, count(tb_visitor.id_category) as count_ from db_server.dbo.tb_visitor where tb_visitor.date = convert(date, getdate(), 103) and tb_visitor.id_status = 1  group by tb_visitor.id_category) as data right join db_server.dbo.tb_category on tb_category.id_category = data.id_");
            String data = "<html>";
            while (rs.next()) {
                data += "<tr style='border-bottom:1pt'><td>" + rs.getString(2) + "</td>";
                if (rs.getString(3).equals("0")) {
                    data += "<td> : <font color=red>" + rs.getString(3) + "</font></td></tr>";
                } else {
                    data += "<td> : <font color=blue>" + rs.getString(3) + "</font></td></tr>";
                }
            }
            data += "</html>";
            antrian.setText(data);
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(select_attribute.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public void get_client_list_admin(JLabel antrian) {
        try {
            Statement st = con.createStatement();
            ResultSet rs;
            rs = st.executeQuery("select tb_category.id_category, tb_category.nm_category, isnull(count_, 0) from (select tb_visitor.id_category as id_, count(tb_visitor.id_category) as count_ from db_server.dbo.tb_visitor where tb_visitor.date = convert(date, getdate(), 103) and tb_visitor.id_status = 1  group by tb_visitor.id_category) as data right join db_server.dbo.tb_category on tb_category.id_category = data.id_ where tb_category.id_category != 4");
            String data = "<html>";
            while (rs.next()) {
                data += "<tr style='border-bottom:1pt'><td>" + rs.getString(2) + "</td>";
                if (rs.getString(3).equals("0")) {
                    data += "<td> : <font color=red>" + rs.getString(3) + "</font></td></tr>";
                } else {
                    data += "<td> : <font color=blue>" + rs.getString(3) + "</font></td></tr>";
                }
            }
            data += "</html>";
            antrian.setText(data);
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(select_attribute.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public String get_client_list_cashier(JLabel antrian) {
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
            antrian.setText(data);
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(select_attribute.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public ArrayList<String> get_last_number(int status, int nomor_meja) {
        @SuppressWarnings("Convert2Diamond")
        ArrayList<String> nomor_antrian = new ArrayList<String>();
        try {
            Statement st = con.createStatement();
            ResultSet rs;
            rs = st.executeQuery("select tb_visitor.no_queue, tb_service.start_service from db_server.dbo.tb_service inner join db_server.dbo.tb_visitor on tb_visitor.id_visitor = tb_service.id_visitor where tb_service.date = convert(date, getdate(), 103) and tb_service.id_status = " + status + " and tb_service.id_counter = " + nomor_meja + " order by tb_service.start_service asc");
            while (rs.next()) {
                nomor_antrian.add(rs.getString(1));
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(select_attribute.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nomor_antrian;
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public ArrayList<String> get_fire_number(int kategori1, int kategori2) {
        @SuppressWarnings("Convert2Diamond")
        ArrayList<String> nomor_antrian = new ArrayList<String>();
        try {
            Statement st = con.createStatement();
            ResultSet rs;
            rs = st.executeQuery("select no_queue from db_server.dbo.tb_visitor where id_status = 4 and (id_category = " + kategori1 + " or id_category = " + kategori2 + ") and date = convert(date, getdate(), 103) order by tb_visitor.end_queue asc");
            while (rs.next()) {
                nomor_antrian.add(rs.getString(1));
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(select_attribute.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nomor_antrian;
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public ArrayList<String> get_audit_number(int nomor_meja) {
        @SuppressWarnings("Convert2Diamond")
        ArrayList<String> nomor_antrian = new ArrayList<String>();
        try {
            Statement st = con.createStatement();
            ResultSet rs;
            rs = st.executeQuery("select tb_visitor.no_queue from db_server.dbo.tb_service left join db_server.dbo.tb_visitor on tb_service.id_visitor = tb_visitor.id_visitor where tb_service.id_status = 3 and tb_service.id_counter = " + nomor_meja + " and tb_service.date = convert(date, getdate(), 103) order by tb_service.audit_service asc");
            while (rs.next()) {
                nomor_antrian.add(rs.getString(1));
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(select_attribute.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nomor_antrian;
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public ArrayList<String> get_end_number(int kategori, int status, int nomor_meja) {
        @SuppressWarnings("Convert2Diamond")
        ArrayList<String> nomor_antrian = new ArrayList<String>();
        try {
            Statement st = con.createStatement();
            ResultSet rs;
            rs = st.executeQuery("select tb_visitor.no_queue from db_server.dbo.tb_service inner join db_server.dbo.tb_visitor on tb_visitor.id_visitor = tb_service.id_visitor where tb_service.date = convert(date, getdate(), 103) and tb_visitor.id_category = " + kategori + " and tb_visitor.id_status = " + status + " and tb_service.id_counter = " + nomor_meja + " order by tb_visitor.end_queue asc");
            while (rs.next()) {
                nomor_antrian.add(rs.getString(1));
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(select_attribute.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nomor_antrian;
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public String last_counter_display(int nomor_meja) {
        String nomor_antrian = "0000";
        try {
            Statement st = con.createStatement();
            ResultSet rs;
            rs = st.executeQuery("select top 1 tb_visitor.no_queue from db_server.dbo.tb_service inner join db_server.dbo.tb_visitor on tb_visitor.id_visitor = tb_service.id_visitor where tb_service.date = convert(date, getdate(), 103) and tb_service.id_counter = " + nomor_meja + " and tb_service.id_status = 2 order by tb_service.start_service desc");
            while (rs.next()) {
                nomor_antrian = rs.getString(1);
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(select_attribute.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nomor_antrian;
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public String last_category_display(int kategori) {
        String nomor_antrian = "0000";
        try {
            Statement st = con.createStatement();
            ResultSet rs;
            rs = st.executeQuery("select top 1 tb_visitor.no_queue from db_server.dbo.tb_service inner join db_server.dbo.tb_visitor on tb_visitor.id_visitor = tb_service.id_visitor where tb_service.date = convert(date, getdate(), 103) and tb_service.id_category = " + kategori + " and (tb_service.id_status = 2 or tb_service.id_status = 4 or tb_service.id_status = 5) order by tb_service.start_service desc");
            while (rs.next()) {
                nomor_antrian = rs.getString(1);
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(select_attribute.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nomor_antrian;
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
            Logger.getLogger(select_attribute.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jumlah_antrian;
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
            Logger.getLogger(select_attribute.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id_antrian;
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public void get_number_status(JLabel data_antrian, String nomor_antrian, int id_antrian) {
        try {
            Statement st_visitor = con.createStatement();
            ResultSet rs_visitor;
            rs_visitor = st_visitor.executeQuery("select tb_visitor.no_queue, case when substring(tb_visitor.no_queue,1,1) = 1 then 'SPP' when substring(tb_visitor.no_queue,1,1) = 3 then 'Setoran' when substring(tb_visitor.no_queue,1,1) = 5 then 'Tab./T-Angs.' end, convert(varchar(10), tb_visitor.date, 103), isnull(tb_visitor.start_queue, ''), isnull(tb_visitor.end_queue, ''), tb_status.nm_status + ' (' + tb_category.nm_category + ')' from db_server.dbo.tb_visitor left join db_server.dbo.tb_category on tb_category.id_category = tb_visitor.id_category left join db_server.dbo.tb_status on tb_status.id_status = tb_visitor.id_status where tb_visitor.date = convert(date, getdate(), 103) and tb_visitor.no_queue = " + nomor_antrian);
            String data = "<html>";
            boolean bl = true;
            while (rs_visitor.next()) {
                if (rs_visitor.getString(1) == null) {
                    bl = false;
                    data += "Nomor Antrian " + nomor_antrian + " Tidak Ada";
                } else {
                    bl = true;
                    data += "<tr style='border-bottom:1pt'><td>Nomor Antrian</td><td>: " + rs_visitor.getString(1) + "</td></tr>"
                            + "<tr style='border-bottom:1pt'><td>Kategori</td><td>: " + rs_visitor.getString(2) + "</td></tr>"
                            + "<tr style='border-bottom:1pt'><td>Tanggal Antri</td><td>: " + rs_visitor.getString(3) + "</td></tr>"
                            + "<tr style='border-bottom:1pt'><td>Jam Antri</td><td>: " + rs_visitor.getString(4) + "</td></tr>"
                            + "<tr style='border-bottom:1pt'><td>Selesai Antri</td><td>: " + rs_visitor.getString(5) + "</td></tr>"
                            + "<tr style='border-bottom:1pt'><td>Status</td><td>: " + rs_visitor.getString(6) + "</td></tr>";
                }
            }
            if (bl == true) {
                Statement st_service = con.createStatement();
                ResultSet rs_service;
                rs_service = st_service.executeQuery("select tb_category.nm_category, tb_status.nm_status, isnull(tb_service.start_service, ''), isnull(tb_service.audit_service, ''), isnull(tb_service.end_service, ''), tb_service.nm_customer, tb_service.id_counter from db_server.dbo.tb_service left join db_server.dbo.tb_category on tb_category.id_category = tb_service.id_category left join db_server.dbo.tb_status on tb_status.id_status = tb_service.id_status where tb_service.date = convert(date, getdate(), 103) and tb_service.id_visitor = " + id_antrian);
                while (rs_service.next()) {
                    data += "<tr style='border-bottom:1pt'><td></td><td></td></tr>"
                            + "<tr style='border-bottom:1pt'><td>Pelayanan</td><td>: " + rs_service.getString(1) + "</td></tr>"
                            + "<tr style='border-bottom:1pt'><td>Status</td><td>: " + rs_service.getString(2) + "</td></tr>"
                            + "<tr style='border-bottom:1pt'><td>Jam Pelayanan</td><td>: " + rs_service.getString(3) + "</td></tr>"
                            + "<tr style='border-bottom:1pt'><td>Audit Pelayanan</td><td>: " + rs_service.getString(4) + "</td></tr>"
                            + "<tr style='border-bottom:1pt'><td>Selesai Pelayanan</td><td>: " + rs_service.getString(5) + "</td></tr>"
                            + "<tr style='border-bottom:1pt'><td>Dilayani</td><td>: " + rs_service.getString(6) + " (Meja " + rs_service.getString(7) + ")</td></tr>";
                }
                st_service.close();
            }
            data += "</html>";
            data_antrian.setText(data);
            st_visitor.close();
        } catch (SQLException ex) {
            Logger.getLogger(select_attribute.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public void get_counter_status(JLabel data_meja, int nomor_meja) {
        try {
            Statement st_data = con.createStatement();
            ResultSet rs_data;
            rs_data = st_data.executeQuery("select tb_counter.id_counter, isnull(tb_counter.nm_counter, '-'), isnull(tb_category.nm_category, '-'), case when tb_counter.status = 0 then 'Tidak Aktif' else 'Aktif' end from db_server.dbo.tb_counter left join db_server.dbo.tb_category on tb_category.id_category = tb_counter.category where id_counter = " + nomor_meja);
            String data = "<html>";
            while (rs_data.next()) {
                data += "<tr style='border-bottom:1pt'><td>Nomor Meja</td><td>: " + rs_data.getString(1) + "</td></tr>"
                        + "<tr style='border-bottom:1pt'><td>Nama Pengguna</td><td>: " + rs_data.getString(2) + "</td></tr>"
                        + "<tr style='border-bottom:1pt'><td>Kategori</td><td>: " + rs_data.getString(3) + "</td></tr>"
                        + "<tr style='border-bottom:1pt'><td>Status</td><td>: " + rs_data.getString(4) + "</td></tr>";
            }

            Statement st_kategori = con.createStatement();
            ResultSet rs_kategori;
            rs_kategori = st_kategori.executeQuery("select tb_service.id_category, tb_category.nm_category, count(tb_service.id_category) from db_server.dbo.tb_service left join db_server.dbo.tb_category on tb_category.id_category = tb_service.id_category where tb_service.date = convert(date, getdate(), 103) and tb_service.id_counter = " + nomor_meja + " group by tb_service.id_category, tb_category.nm_category");
            int k = 0;
            while (rs_kategori.next()) {
                data += "<tr style='border-bottom:1pt'><td></td><td></td></tr>";
                if (k < 1) {
                    data += "<tr style='border-bottom:1pt'><td>Data Pelayanan</td><td></td></tr>";
                }
                if (Integer.parseInt(rs_kategori.getString(1)) != 4) {
                    data += "<tr style='border-bottom:1pt'><td>Kategori</td><td>: " + rs_kategori.getString(2) + " (Jumlah : " + rs_kategori.getString(3) + ")</td></tr>";
                    Statement st_status = con.createStatement();
                    ResultSet rs_status;
                    rs_status = st_status.executeQuery("select tb_status.nm_status, count(tb_service.id_status) as count_status from db_server.dbo.tb_service left join db_server.dbo.tb_status on tb_status.id_status = tb_service.id_status where tb_service.date = convert(date, getdate(), 103) and tb_service.id_category = " + rs_kategori.getString(1) + " and tb_service.id_counter = " + nomor_meja + " group by tb_status.nm_status");
                    while (rs_status.next()) {
                        data += "<tr style='border-bottom:1pt'><td>" + rs_status.getString(1) + "</td><td>: " + rs_status.getString(2) + "</td></tr>";
                    }
                    st_status.close();
                } else {
                    Statement st_kasir = con.createStatement();
                    ResultSet rs_kasir;
                    rs_kasir = st_kasir.executeQuery("select substring(tb_visitor.no_queue, 1, 1), tb_number.nm_number, count(tb_service.id_visitor) as count_category from db_server.dbo.tb_service left join db_server.dbo.tb_visitor on tb_visitor.id_visitor = tb_service.id_visitor left join db_server.dbo.tb_number on tb_number.id_number = substring(tb_visitor.no_queue, 1, 1) where tb_service.date = convert(date, getdate(), 103) and tb_service.id_counter = " + nomor_meja + " group by substring(tb_visitor.no_queue, 1, 1), tb_number.nm_number order by substring(tb_visitor.no_queue, 1, 1)");
                    while (rs_kasir.next()) {
                        data += "<tr style='border-bottom:1pt'><td>Kategori</td><td>: K-" + rs_kasir.getString(2) + " (Jumlah : " + rs_kasir.getString(3) + ")</td></tr>";
                        Statement st_status = con.createStatement();
                        ResultSet rs_status;
                        rs_status = st_status.executeQuery("select tb_status.nm_status, count(tb_service.id_status) as count_status from db_server.dbo.tb_service left join db_server.dbo.tb_status on tb_status.id_status = tb_service.id_status left join db_server.dbo.tb_visitor on tb_visitor.id_visitor = tb_service.id_visitor where tb_service.date = convert(date, getdate(), 103) and substring(tb_visitor.no_queue, 1, 1) = " + rs_kasir.getString(1) + " and tb_service.id_counter = " + nomor_meja + " group by tb_status.nm_status");
                        while (rs_status.next()) {
                            data += "<tr style='border-bottom:1pt'><td>" + rs_status.getString(1) + "</td><td>: " + rs_status.getString(2) + "</td></tr>";
                        }
                        data += "<tr style='border-bottom:1pt'><td></td><td></td></tr>";
                        st_status.close();
                    }
                    st_kasir.close();
                }
                k += 1;
            }
            st_kategori.close();
            data += "</html>";
            data_meja.setText(data);
            st_data.close();
        } catch (SQLException ex) {
            Logger.getLogger(select_attribute.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
