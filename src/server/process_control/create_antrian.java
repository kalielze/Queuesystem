/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.process_control;

import database.query_control.insert.insert_antrian;
import database.query_control.select.select_antrian;
import database.query_control.update.update_antrian;
import java.awt.Color;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashAttributeSet;
import javax.print.attribute.standard.PrinterName;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import template.date_time;

/**
 *
 * @author user
 */
public class create_antrian {

    @SuppressWarnings("UnusedAssignment")
    public void create(int nomor_antrian, select_antrian sa, date_time dt, int kategori, int kode_nomor, insert_antrian ia) {
        String date = dt.date();
        String time = dt.time();
        int count;
        if (sa.check_queue_number(kode_nomor) == true) {
            nomor_antrian = Integer.parseInt(sa.get_queue_number(kode_nomor)) + 1;
        } else {
            nomor_antrian = nomor_antrian + 1;
        }
        switch (kategori) {
            case 1:
                if (nomor_antrian <= 2999) {
                    ia.insert_visitor(nomor_antrian, time, kategori, kode_nomor);
                    print_queue(nomor_antrian, date, time, sa.get_queue_category(kategori), sa.get_queue_count(kategori));
                } else {
                    JOptionPane.showMessageDialog(null, "<html>Mohon maaf, <b>batas nomor kategori pelayanan <u>SPP</u> sudah maksimal</b></html>", "LimitLine", JOptionPane.PLAIN_MESSAGE);
                }
                break;
            case 2:
                if (nomor_antrian <= 4999) {
                    ia.insert_visitor(nomor_antrian, time, kategori, kode_nomor);
                    print_queue(nomor_antrian, date, time, sa.get_queue_category(kategori), sa.get_queue_count(kategori));
                } else {
                    JOptionPane.showMessageDialog(null, "<html>Mohon maaf, <b>batas nomor kategori pelayanan <u>SETORAN</u> sudah maksimal</b></html>", "LimitLine", JOptionPane.PLAIN_MESSAGE);
                }
                break;
            case 3:
                if (nomor_antrian <= 6999) {
                    ia.insert_visitor(nomor_antrian, time, kategori, kode_nomor);
                    print_queue(nomor_antrian, date, time, sa.get_queue_category(kategori), sa.get_queue_count(kategori));
                } else {
                    JOptionPane.showMessageDialog(null, "<html>Mohon maaf, <b>batas nomor kategori pelayanan <u>TAB./T-ANGS.</u> sudah maksimal</b></html>", "LimitLine", JOptionPane.PLAIN_MESSAGE);
                }
                break;
            default:
                break;
        }
        
    }

    private final load_printer lp = new load_printer();
    private final MessageFormat head = new MessageFormat("");
    private final MessageFormat foot = new MessageFormat("");

    private void print_queue(int nomor_antrian, String date, String time, String kategori, String count) {
        PrinterJob job = PrinterJob.getPrinterJob();
        PageFormat pf = job.defaultPage();
        Paper paper = new Paper();
        double cm = 72.0 / 2.54;
        paper.setSize(5.5 * cm, 5 * cm);
        paper.setImageableArea(0.5 * cm, 0 * cm, 6.5 * cm, 5 * cm);
        pf.setPaper(paper);
        if (job.getPrintService() != null) {
            HashAttributeSet attributes = new HashAttributeSet();
            attributes.add(new PrinterName(lp.load(), null));
            PrintService[] services = PrintServiceLookup.lookupPrintServices(null, attributes);
            if (services.length > 0) {
                try {
                    job.setPrintService(services[0]);
                    JEditorPane text = new JEditorPane("text/html", ""
                            + "<center style='font-family: arial; font-weight: bold;font-size: 8;'>"
                            + "KOPERASI WANITA<br/>SETIA BHAKTI WANITA JAWA TIMUR"
                            + "</center>"
                            + "<center style='font-family: arial; font-weight: bold;font-size: 8;'>"
                            + "Jl. Jemur Andayani No. 55 Surabaya<hr/>"
                            + "</center>"
                            + "<div style='font-family: arial; font-size: 8;padding-top: -4;' align='left'>"
                            + "Tgl : " + date
                            + "</div>"
                            + "<div style='font-family: arial; font-size: 8;padding-top: -10;' align='right'>"
                            + "Jm : " + time
                            + "</div>"
                            + "<center style='font-family: arial; font-size: 8;padding-top: -1;'>"
                            + "<u>NOMOR ANTRIAN<br/></u>"
                            + "</center>"
                            + "<center style='font-family: arial; font-weight: bold;font-size: 30; padding-top: -5; padding-bottom: -3;'>"
                            + nomor_antrian
                            + "</center>"
                            + "<center style='font-family: arial; font-size: 9;padding-top: -2;'>"
                            + "<hr/></center>"
                            + "<center style='font-family: arial; font-size: 9;padding-top: -5;'>"
                            + "<b>" + kategori.toUpperCase() + "</b><br/>Sisa Antrian : <b>" + count + " Orang</b><hr/>"
                            + "</center><center style='font-family: arial;font-size: 8; padding-top: -4;'>"
                            + "Terima kasih atas kunjungan Anda,<br/>mohon antri dengan tertib."
                            + "</center>"
                            + "<center style='font-family: arial; font-size: 5; padding-top: 1;'>"
                            + "<i>©KOPWAN_SBW_JATIM</i>"
                            + "</center>");
                    text.repaint();
                    job.setPrintable(text.getPrintable(head, foot), pf);
                    job.print();
                } catch (PrinterException ex) {
                    Logger.getLogger(create_antrian.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void lookup_client_list_normal(select_antrian sa, update_antrian ua, int kategori) {
        ArrayList<String> data = sa.get_counter(kategori);
        for (int i = 0; i < data.size(); i++) {
            String part[] = data.get(i).split(" ");
            try {
                interfaces.client.client icc = (interfaces.client.client) Naming.lookup("rmi://" + part[1] + ":" + part[0] + "/client");
                icc.set_queue_list_normal(sa.get_queue_list_normal());
            } catch (NotBoundException notbound) {
                Logger.getLogger(create_antrian.class.getName()).log(Level.SEVERE, null, notbound);
            } catch (MalformedURLException malform) {
                Logger.getLogger(create_antrian.class.getName()).log(Level.SEVERE, null, malform);
            } catch (RemoteException remote) {
                String hostname = null, name = null, category = "0", status = "0";
                String[] data_close = new String[]{part[0], hostname, name, category, status};
                ua.set_counter(data_close);
            }
        }
    }
    
    public void lookup_client_list_cashier(select_antrian sa, update_antrian ua, int kategori) {
        ArrayList<String> data = sa.get_counter(kategori);
        for (int i = 0; i < data.size(); i++) {
            String part[] = data.get(i).split(" ");
            try {
                interfaces.client.client icc = (interfaces.client.client) Naming.lookup("rmi://" + part[1] + ":" + part[0] + "/client");
                icc.set_queue_list_cashier(sa.get_queue_list_cashier());
            } catch (NotBoundException notbound) {
                Logger.getLogger(create_antrian.class.getName()).log(Level.SEVERE, null, notbound);
            } catch (MalformedURLException malform) {
                Logger.getLogger(create_antrian.class.getName()).log(Level.SEVERE, null, malform);
            } catch (RemoteException remote) {
                String hostname = null, name = null, category = "0", status = "0";
                String[] data_close = new String[]{part[0], hostname, name, category, status};
                ua.set_counter(data_close);
            }
        }
    }
    
    @SuppressWarnings("null")
    public void lookup_client_fire(select_antrian sa, update_antrian ua, String nomor_antrian, int kategori) {
        ArrayList<String> data = sa.get_counter_category(kategori);
        for (int i = 0; i < data.size(); i++) {
            String part[] = data.get(i).split(" ");
            try {
                interfaces.client.client icc = (interfaces.client.client) Naming.lookup("rmi://" + part[1] + ":" + part[0] + "/client");
                String number_fire[] = new String[]{nomor_antrian};
                icc.set_queue_fire(number_fire, kategori);
            } catch (NotBoundException notbound) {
                Logger.getLogger(create_antrian.class.getName()).log(Level.SEVERE, null, notbound);
            } catch (MalformedURLException malform) {
                Logger.getLogger(create_antrian.class.getName()).log(Level.SEVERE, null, malform);
            } catch (RemoteException remote) {
                String hostname = null, name = null, category = "0", status = "0";
                String[] data_close = new String[]{part[0], hostname, name, category, status};
                ua.set_counter(data_close);
            }
        }
    }
    
    public void lookup_display_number(select_antrian sa, update_antrian ua, String nomor_antrian, int kategori, int nomor_meja) {
        String data_pertama = sa.get_display(92);
        if (data_pertama != null) {
            String part[] = data_pertama.split(" ");
            try {
                interfaces.display.display idd = (interfaces.display.display) Naming.lookup("rmi://" + part[1] + ":" + part[0] + "/display");
                if (nomor_meja < 8) {
                    idd.counter_number(nomor_antrian, nomor_meja, Integer.parseInt(part[0]));
                }
                idd.category_number(nomor_antrian, kategori, Integer.parseInt(part[0]));
            } catch (NotBoundException ex) {
                Logger.getLogger(create_antrian.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(create_antrian.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RemoteException ex) {
                String hostname = null, status = "0";
                String[] data_close = new String[]{part[0], hostname, status};
                ua.set_display(data_close);
            }
        }
        String data_kedua = sa.get_display(94);
        if (data_kedua != null) {
            String part[] = data_kedua.split(" ");
            try {
                interfaces.display.display idd = (interfaces.display.display) Naming.lookup("rmi://" + part[1] + ":" + part[0] + "/display");
                if (nomor_meja >= 8) {
                    idd.counter_number(nomor_antrian, nomor_meja, Integer.parseInt(part[0]));
                }
                idd.category_number(nomor_antrian, kategori, Integer.parseInt(part[0]));
            } catch (NotBoundException ex) {
                Logger.getLogger(create_antrian.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(create_antrian.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RemoteException ex) {
                String hostname = null, status = "0";
                String[] data_close = new String[]{part[0], hostname, status};
                ua.set_display(data_close);
            }
        }
    }
    
    public void lookup_display_ground(select_antrian sa, update_antrian ua, String nomor_antrian, int kategori, int nomor_meja, Color cr, Color cl) {
        String data_pertama = sa.get_display(92);
        if (data_pertama != null) {
            String part[] = data_pertama.split(" ");
            try {                
                interfaces.display.display idd = (interfaces.display.display) Naming.lookup("rmi://" + part[1] + ":" + part[0] + "/display");
                if (nomor_meja < 8) {
                    idd.counter_ground(nomor_antrian, nomor_meja, Integer.parseInt(part[0]), cl);
                }
                idd.category_ground(nomor_antrian, kategori, Integer.parseInt(part[0]), cr);
            } catch (NotBoundException ex) {
                Logger.getLogger(create_antrian.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(create_antrian.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RemoteException ex) {
                String hostname = null, status = "0";
                String[] data_close = new String[]{part[0], hostname, status};
                ua.set_display(data_close);
            }
        }
        String data_kedua = sa.get_display(94);
        if (data_kedua != null) {
            String part[] = data_kedua.split(" ");
            try {
                interfaces.display.display idd = (interfaces.display.display) Naming.lookup("rmi://" + part[1] + ":" + part[0] + "/display");
                if (nomor_meja >= 8) {
                    idd.counter_ground(nomor_antrian, nomor_meja, Integer.parseInt(part[0]), cl);
                }
                idd.category_ground(nomor_antrian, kategori, Integer.parseInt(part[0]), cr);
            } catch (NotBoundException ex) {
                Logger.getLogger(create_antrian.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(create_antrian.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RemoteException ex) {
                String hostname = null, status = "0";
                String[] data_close = new String[]{part[0], hostname, status};
                ua.set_display(data_close);
            }
        }
    }
    
    public void lookup_display_open(select_antrian sa, update_antrian ua, String nama_kategori, String nomor_antrian, int nomor_meja) {
        String data_pertama = sa.get_display(92);
        if (data_pertama != null) {
            String part[] = data_pertama.split(" ");
            try {
                interfaces.display.display idd = (interfaces.display.display) Naming.lookup("rmi://" + part[1] + ":" + part[0] + "/display");
                idd.dekstop_open(nama_kategori, nomor_antrian, nomor_meja, Integer.parseInt(part[0]));
            } catch (NotBoundException ex) {
                Logger.getLogger(create_antrian.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(create_antrian.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RemoteException ex) {
                String hostname = null, status = "0";
                String[] data_close = new String[]{part[0], hostname, status};
                ua.set_display(data_close);
            }
        }
        String data_kedua = sa.get_display(94);
        if (data_kedua != null) {
            String part[] = data_kedua.split(" ");
            try {
                interfaces.display.display idd = (interfaces.display.display) Naming.lookup("rmi://" + part[1] + ":" + part[0] + "/display");
                idd.dekstop_open(nama_kategori, nomor_antrian, nomor_meja, Integer.parseInt(part[0]));
            } catch (NotBoundException ex) {
                Logger.getLogger(create_antrian.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(create_antrian.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RemoteException ex) {
                String hostname = null, status = "0";
                String[] data_close = new String[]{part[0], hostname, status};
                ua.set_display(data_close);
            }
        }
    }
    
    public void lookup_display_close(select_antrian sa, update_antrian ua) {
        String data_pertama = sa.get_display(92);
        if (data_pertama != null) {
            String part[] = data_pertama.split(" ");
            try {
                interfaces.display.display idd = (interfaces.display.display) Naming.lookup("rmi://" + part[1] + ":" + part[0] + "/display");
                idd.dekstop_close(Integer.parseInt(part[0]));
            } catch (NotBoundException ex) {
                Logger.getLogger(create_antrian.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(create_antrian.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RemoteException ex) {
                String hostname = null, status = "0";
                String[] data_close = new String[]{part[0], hostname, status};
                ua.set_display(data_close);
            }
        }
        String data_kedua = sa.get_display(94);
        if (data_kedua != null) {
            String part[] = data_kedua.split(" ");
            try {
                interfaces.display.display idd = (interfaces.display.display) Naming.lookup("rmi://" + part[1] + ":" + part[0] + "/display");
                idd.dekstop_close(Integer.parseInt(part[0]));
            } catch (NotBoundException ex) {
                Logger.getLogger(create_antrian.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(create_antrian.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RemoteException ex) {
                String hostname = null, status = "0";
                String[] data_close = new String[]{part[0], hostname, status};
                ua.set_display(data_close);
            }
        }
    }
    
    public void lookup_display_data(select_antrian sa, update_antrian ua) {
        String data_pertama = sa.get_display(92);
        if (data_pertama != null) {
            String part[] = data_pertama.split(" ");
            try {
                interfaces.display.display idd = (interfaces.display.display) Naming.lookup("rmi://" + part[1] + ":" + part[0] + "/display");
                idd.data_queue(Integer.parseInt(sa.last_visitor_display()), Integer.parseInt(part[0]));
            } catch (NotBoundException ex) {
                Logger.getLogger(create_antrian.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(create_antrian.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RemoteException ex) {
                String hostname = null, status = "0";
                String[] data_close = new String[]{part[0], hostname, status};
                ua.set_display(data_close);
            }
        }
        String data_kedua = sa.get_display(94);
        if (data_kedua != null) {
            String part[] = data_kedua.split(" ");
            try {
                interfaces.display.display idd = (interfaces.display.display) Naming.lookup("rmi://" + part[1] + ":" + part[0] + "/display");
                idd.data_queue(Integer.parseInt(sa.last_visitor_display()), Integer.parseInt(part[0]));
            } catch (NotBoundException ex) {
                Logger.getLogger(create_antrian.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(create_antrian.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RemoteException ex) {
                String hostname = null, status = "0";
                String[] data_close = new String[]{part[0], hostname, status};
                ua.set_display(data_close);
            }
        }
    }
    
    public void lookup_admin_list(select_antrian sa, update_antrian ua) {
        ArrayList<String> data = sa.get_admin();
        for (int i = 0; i < data.size(); i++) {
            String part[] = data.get(i).split(" ");
            try {
                interfaces.admin.admin iaa = (interfaces.admin.admin) Naming.lookup("rmi://" + part[1] + ":" + part[0] + "/admin");
                iaa.set_queue_list(sa.get_queue_list_admin(), sa.get_queue_list_cashier());
            } catch (NotBoundException notbound) {
                Logger.getLogger(create_antrian.class.getName()).log(Level.SEVERE, null, notbound);
            } catch (MalformedURLException malform) {
                Logger.getLogger(create_antrian.class.getName()).log(Level.SEVERE, null, malform);
            } catch (RemoteException remote) {
                String hostname = null, status = "0";
                String[] data_close = new String[]{part[0], hostname, status};
                ua.set_admin(data_close);
            }
        }
    }
}
