/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implement.client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class client extends UnicastRemoteObject implements interfaces.client.client {
    
    private JLabel antrian_biasa, antrian_kasir;
    private JTable table_spp, table_pj;
    
    public client() throws RemoteException {
    }
    
    public void label_antrian_biasa(JLabel antrian_biasa) {
        this.antrian_biasa = antrian_biasa;
    }
    
    public void label_antrian_kasir(JLabel antrian_kasir) {
        this.antrian_kasir = antrian_kasir;
    }
    
    public void table_spp(JTable table_spp) {
        this.table_spp = table_spp;
    }
    
    @SuppressWarnings("SillyAssignment")
    public void table_pj(JTable table_pj) {
        this.table_pj = table_pj;
    }

    @Override
    public void set_queue_list_normal(String data_antrian_biasa) throws RemoteException {
        antrian_biasa.setText(data_antrian_biasa);
    }
    
    @Override
    public void set_queue_list_cashier(String data_antrian_kasir) throws RemoteException {
        antrian_kasir.setText(data_antrian_kasir);
    }
    
    @Override
    public void set_queue_fire(String nomor_antrian[], int kategori) throws RemoteException {
        DefaultTableModel dtm;
        if (kategori == 1) {
            dtm = (DefaultTableModel) table_spp.getModel();
        } else {
            dtm = (DefaultTableModel) table_pj.getModel();
        }
        dtm.addRow(nomor_antrian);
    }
}
