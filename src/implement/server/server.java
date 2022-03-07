/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implement.server;

import database.query_control.insert.insert_antrian;
import database.query_control.select.select_antrian;
import database.query_control.update.update_antrian;
import java.awt.Color;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import server.process_control.create_antrian;
import server.process_control.load_sound;
import template.date_time;

/**
 *
 * @author user
 */
public class server extends UnicastRemoteObject implements interfaces.server.server {

    private final select_antrian sa;
    private final insert_antrian ia;
    private final update_antrian ua;
    private final create_antrian ca;
    private final load_sound ls = new load_sound();

    public server(select_antrian sa, insert_antrian ia, update_antrian ua, create_antrian ca) throws RemoteException {
        this.sa = sa;
        this.ia = ia;
        this.ua = ua;
        this.ca = ca;
    }

    @Override
    public String get_number(int kategori, int kode) throws RemoteException {
        String nomor_antrian;
        if (kategori != 4) {
            nomor_antrian = sa.number_queue(kategori);
        } else {
            nomor_antrian = sa.number_queue_cashier(kategori, kode);
        }
        return nomor_antrian;
    }

    @Override
    public String get_number_double_category(int kategori1, int kategori2) throws RemoteException {
        String nomor_antrian = sa.number_queue_double_category(kategori1, kategori2);
        return nomor_antrian;
    }

    @Override
    public int id_number(String nomor_antrian) throws RemoteException {
        int id_antrian = sa.id_queue(nomor_antrian);
        return id_antrian;
    }

    @Override
    public void refresh_queue(String nomor_antrian, int id_antrian, String nama, int status, int kategori, int nomor_meja) throws RemoteException {
        ua.change_visitor_status(nomor_antrian, status);//update visitor status
        date_time dt = new date_time();
        ia.insert_service(id_antrian, dt.time(), nama, kategori, nomor_meja);//insert service
        for (int i = 1; i < 4; i++) {
            ca.lookup_client_list_normal(sa, ua, i);
        }
        ca.lookup_client_list_cashier(sa, ua, 4);
        ca.lookup_admin_list(sa, ua);
    }

    @Override
    public void call_number(String nama_kategori, String nomor_antrian, int kategori, int nomor_meja, int inisial_button) throws RemoteException {
        synchronized (this) {
            ca.lookup_display_open(sa, ua, nama_kategori, nomor_antrian, nomor_meja);
            ca.lookup_display_number(sa, ua, nomor_antrian, kategori, nomor_meja);
            ca.lookup_display_ground(sa, ua, nomor_antrian, kategori, nomor_meja, Color.red, Color.green);
            if (inisial_button == 1) {
                ls.call_number(nomor_antrian, String.valueOf(nomor_meja));
            }
            Color cr = null;
            switch (kategori) {
                case 1:
                    cr = new java.awt.Color(153, 255, 255);
                    break;
                case 2:
                    cr = new java.awt.Color(255, 255, 153);
                    break;
                case 3:
                    cr = new java.awt.Color(153, 255, 153);
                    break;
                case 4:
                    cr = new java.awt.Color(255, 153, 153);
                    break;
                default:
                    break;
            }
            ca.lookup_display_close(sa, ua);
            ca.lookup_display_ground(sa, ua, nomor_antrian, kategori, nomor_meja, cr, new java.awt.Color(255, 255, 0));
        }
    }

    @Override
    public void fire_number(String nomor_antrian, int id_antrian, int kategori, int status, int nomor_meja) throws RemoteException {
        date_time dt = new date_time();
        String time = dt.time();
        ua.change_visitor_status(nomor_antrian, status);
        ua.end_visitor(nomor_antrian, time);
        ua.end_service_status(id_antrian, status, time, nomor_meja);
        ca.lookup_client_fire(sa, ua, nomor_antrian, kategori);
    }

    @Override
    public void audit_number(String nomor_antrian, int id_antrian, int status, int nomor_meja) throws RemoteException {
        date_time dt = new date_time();
        ua.change_visitor_status(nomor_antrian, status);
        ua.audit_service_status(id_antrian, status, dt.time(), nomor_meja);
    }

    @Override
    public void cashier_number(String nomor_antrian, int id_antrian, int kategori, int status_baru, int status, int nomor_meja) throws RemoteException {
        date_time dt = new date_time();
        ua.change_visitor_kategori(nomor_antrian, kategori);//update visitor status
        ua.change_visitor_status(nomor_antrian, status_baru);
        ua.end_service_status(id_antrian, status, dt.time(), nomor_meja);
        for (int i = 1; i < 4; i++) {
            ca.lookup_client_list_normal(sa, ua, i);
        }
        ca.lookup_client_list_cashier(sa, ua, 4);
        ca.lookup_admin_list(sa, ua);
    }

    @Override
    public void end_number(String nomor_antrian, int id_antrian, int status, int nomor_meja) throws RemoteException {
        date_time dt = new date_time();
        String time = dt.time();
        ua.change_visitor_status(nomor_antrian, status);
        ua.end_visitor(nomor_antrian, time);
        ua.end_service_status(id_antrian, status, time, nomor_meja);
        for (int i = 1; i < 4; i++) {
            ca.lookup_client_list_normal(sa, ua, i);
        }
        ca.lookup_client_list_cashier(sa, ua, 4);
        ca.lookup_admin_list(sa, ua);
    }

}
