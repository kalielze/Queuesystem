/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.process_control;

import implement.client.client;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import static java.rmi.server.UnicastRemoteObject.unexportObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;

/**
 *
 * @author user
 */
public class client_registry_lookupRMI {
    
    private final load_client_registry lcr = new load_client_registry();
    private Registry reg;
    
    public void registry(JLabel antrian, JTable table, int kode, InetAddress ip, int count) {
        try {
            System.setProperty("java.security.policy", "mypolicy");
            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());
            }
            client cln = new client();
            if (kode != 4) {
                cln.label_antrian_biasa(antrian);
            } else {
                cln.label_antrian_kasir(antrian);
            }
            if (kode == 1) {
                cln.table_spp(table);
            } else {
                cln.table_pj(table);
            }
            reg = LocateRegistry.createRegistry(count);
            Naming.rebind("rmi://" + ip.getHostAddress() + ":" + count + "/client", cln);
        } catch (RemoteException remote) {
            Logger.getLogger(client_registry_lookupRMI.class.getName()).log(Level.SEVERE, null, remote);
        } catch (MalformedURLException malform) {
            Logger.getLogger(client_registry_lookupRMI.class.getName()).log(Level.SEVERE, null, malform);
        }
    }
    
    public void close(InetAddress ip, int count) {
        try {
            Naming.unbind("rmi://" + ip.getHostAddress() + ":" + count + "/client");
            unexportObject(reg, true);
        } catch (RemoteException remote) {
            Logger.getLogger(client_registry_lookupRMI.class.getName()).log(Level.SEVERE, null, remote);
        } catch (NotBoundException notboud) {
            Logger.getLogger(client_registry_lookupRMI.class.getName()).log(Level.SEVERE, null, notboud);
        } catch (MalformedURLException malform) {
            Logger.getLogger(client_registry_lookupRMI.class.getName()).log(Level.SEVERE, null, malform);
        }
    }
    
    public interfaces.server.server lookup() {
        interfaces.server.server iss = null;
        try {
            System.setProperty("java.security.policy", "mypolicy");
            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());
            }
            iss = (interfaces.server.server) Naming.lookup("rmi://" + lcr.load());
        } catch (RemoteException remote) {
            Logger.getLogger(client_registry_lookupRMI.class.getName()).log(Level.SEVERE, null, remote);
        } catch (MalformedURLException malform) {
            Logger.getLogger(client_registry_lookupRMI.class.getName()).log(Level.SEVERE, null, malform);
        } catch (NotBoundException notbound) {
            Logger.getLogger(client_registry_lookupRMI.class.getName()).log(Level.SEVERE, null, notbound);
        }
        return iss;
    }
    
}
