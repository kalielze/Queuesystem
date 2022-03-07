/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implement.admin;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JLabel;

/**
 *
 * @author 15my15
 */
public class admin extends UnicastRemoteObject implements interfaces.admin.admin {
    
    private final JLabel antrian_biasa, antrian_kasir;
    
    public admin(JLabel antrian_biasa, JLabel antrian_kasir) throws RemoteException {
        this.antrian_biasa = antrian_biasa;
        this.antrian_kasir = antrian_kasir;
    }

    @Override
    public void set_queue_list(String data_antrian_biasa, String data_antrian_kasir) throws RemoteException {
        antrian_biasa.setText(data_antrian_biasa);
        antrian_kasir.setText(data_antrian_kasir);
    }
    
}
