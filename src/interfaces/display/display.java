/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.display;

import java.awt.Color;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author user
 */
public interface display extends Remote {
    
    public void category_number(String nomor_antrian, int kategori, int id_display) throws RemoteException;
    
    public void counter_number(String nomor_antrian, int nomor_meja_, int id_display) throws RemoteException;
    
    public void category_ground(String nomor_antrian, int kategori, int id_display, Color cr) throws RemoteException;
    
    public void counter_ground(String nomor_antrian, int nomor_meja, int id_display, Color cr) throws RemoteException;
    
    public void dekstop_open(String nama_kategori, String nomor_antrian, int nomor_meja, int id_display) throws RemoteException;
    
    public void dekstop_close(int id_display) throws RemoteException;
    
    public void data_queue(int count, int id_display) throws RemoteException;
    
}
