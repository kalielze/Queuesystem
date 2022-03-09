/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author user
 */
public interface client extends Remote {
    
    public void set_queue_list_normal(String data_antrian_biasa) throws RemoteException;
    
    public void set_queue_list_cashier(String data_antrian_kasir) throws RemoteException;
    
    public void set_queue_fire(String nomor_antrian[], int kategori) throws RemoteException;
    
}
