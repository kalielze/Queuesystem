package interfaces.admin;

import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 15my15
 */
public interface admin extends Remote {
    
    public void set_queue_list(String data_antrian_biasa, String data_antrian_kasir) throws RemoteException;
    
}
