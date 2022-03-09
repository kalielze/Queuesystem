/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author user
 */
public interface server extends Remote {
 
    
    public String get_number(int kategori, int kode) throws RemoteException;
    
    public String get_number_double_category(int kategori1, int kategori2) throws RemoteException;
    
    public int id_number(String nomor_antrian) throws RemoteException;
    
    public void refresh_queue(String nomor_antrian, int id_antrian, String nama, int status, int kategori, int nomor_meja) throws RemoteException;
        
    public void call_number(String nama_kategori, String nomor_antrian, int kategori, int nomor_meja, int inisial_button) throws RemoteException;
    
    public void fire_number(String nomor_antrian, int id_antrian, int kategori, int status, int nomor_meja) throws RemoteException;
    
    public void audit_number(String nomor_antrian, int id_antrian, int status, int nomor_meja) throws RemoteException;
    
    public void cashier_number(String nomor_antrian, int id_antrian, int kategori, int status_baru, int status, int nomor_meja) throws RemoteException;
    
    public void end_number(String nomor_antrian, int id_antrian, int status, int nomor_meja) throws RemoteException;
}
