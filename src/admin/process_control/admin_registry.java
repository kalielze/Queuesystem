/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.process_control;

import implement.admin.admin;
import implement.display.display;
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

/**
 *
 * @author 15my15
 */
public class admin_registry {
    
    private Registry reg;
    
    public void registry(InetAddress ip, int admin, admin adm) {
        try {
            System.setProperty("java.security.policy", "mypolicy");
            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());
            }
            reg = LocateRegistry.createRegistry(admin);
            Naming.rebind("rmi://" + ip.getHostAddress() + ":" + admin + "/admin", adm);
        } catch (RemoteException remote) {
            Logger.getLogger(admin_registry.class.getName()).log(Level.SEVERE, null, remote);
        } catch (MalformedURLException malform) {
            Logger.getLogger(admin_registry.class.getName()).log(Level.SEVERE, null, malform);
        }
    }
    
    public void close(InetAddress ip, int admin) {
        try {
            Naming.unbind("rmi://" + ip.getHostAddress() + ":" + admin + "/admin");
            unexportObject(reg, true);
        } catch (RemoteException remote) {
            Logger.getLogger(admin_registry.class.getName()).log(Level.SEVERE, null, remote);
        } catch (NotBoundException notboud) {
            Logger.getLogger(admin_registry.class.getName()).log(Level.SEVERE, null, notboud);
        } catch (MalformedURLException malform) {
            Logger.getLogger(admin_registry.class.getName()).log(Level.SEVERE, null, malform);
        }
    }
    
}
