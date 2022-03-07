/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.process_control;

import database.query_control.insert.insert_antrian;
import database.query_control.select.select_antrian;
import database.query_control.update.update_antrian;
import implement.server.server;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import static java.rmi.server.UnicastRemoteObject.unexportObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class server_registryRMI {

    private final load_portRMI lpr = new load_portRMI();
    private Registry reg;
    String url;
    
    public void registry(select_antrian sa, insert_antrian ia, update_antrian ua, create_antrian ca) {
        try {
            System.setProperty("java.security.policy", "mypolicy");
            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());
            }
            url = lpr.load();
            int port = 0;
            if (lpr.port() != null) {
                port = Integer.parseInt(lpr.port());
            }
            server svr = new server(sa, ia, ua, ca);
            reg = LocateRegistry.createRegistry(port);
            Naming.rebind("rmi://" + url, svr);
        } catch (RemoteException remote) {
            Logger.getLogger(server_registryRMI.class.getName()).log(Level.SEVERE, null, remote);
        } catch (MalformedURLException malform) {
            Logger.getLogger(server_registryRMI.class.getName()).log(Level.SEVERE, null, malform);
        }
    }

    public void close() {
        try {
            Naming.unbind("rmi://" + url);
            unexportObject(reg, true);
        } catch (RemoteException remote) {
            Logger.getLogger(server_registryRMI.class.getName()).log(Level.SEVERE, null, remote);
        } catch (NotBoundException notboud) {
            Logger.getLogger(server_registryRMI.class.getName()).log(Level.SEVERE, null, notboud);
        } catch (MalformedURLException malform) {
            Logger.getLogger(server_registryRMI.class.getName()).log(Level.SEVERE, null, malform);
        }
    }
}
