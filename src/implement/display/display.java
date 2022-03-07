/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implement.display;

import display.user_interface.ui_number;
import java.awt.Color;
import java.beans.PropertyVetoException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class display extends UnicastRemoteObject implements interfaces.display.display {

    public display() throws RemoteException {
    }

    private JLabel nomor_kategori_1[] = new JLabel[4];
    private JLabel nomor_kategori_2[] = new JLabel[4];

    public void get_category_number_1(JLabel[] nomor_kategori_1) {
        this.nomor_kategori_1 = nomor_kategori_1;
    }

    public void get_category_number_2(JLabel[] nomor_kategori_2) {
        this.nomor_kategori_2 = nomor_kategori_2;
    }

    private JPanel ground_kategori_1[] = new JPanel[4];
    private JPanel ground_kategori_2[] = new JPanel[4];

    public void get_category_ground_1(JPanel[] ground_kategori_1) {
        this.ground_kategori_1 = ground_kategori_1;
    }

    public void get_category_ground_2(JPanel[] ground_kategori_2) {
        this.ground_kategori_2 = ground_kategori_2;
    }

    private final JLabel nomor_meja_[] = new JLabel[14];

    public void get_counter_number_1(JLabel[] nomor_meja) {
        this.nomor_meja_[0] = nomor_meja[0];
        this.nomor_meja_[1] = nomor_meja[1];
        this.nomor_meja_[2] = nomor_meja[2];
        this.nomor_meja_[3] = nomor_meja[3];
        this.nomor_meja_[4] = nomor_meja[4];
        this.nomor_meja_[5] = nomor_meja[5];
        this.nomor_meja_[6] = nomor_meja[6];
    }

    public void get_counter_number_2(JLabel[] nomor_meja) {
        this.nomor_meja_[7] = nomor_meja[0];
        this.nomor_meja_[8] = nomor_meja[1];
        this.nomor_meja_[9] = nomor_meja[2];
        this.nomor_meja_[10] = nomor_meja[3];
        this.nomor_meja_[11] = nomor_meja[4];
        this.nomor_meja_[12] = nomor_meja[5];
        this.nomor_meja_[13] = nomor_meja[6];
    }

    private final JPanel ground_meja[] = new JPanel[14];

    public void get_counter_ground_1(JPanel[] ground_meja) {
        this.ground_meja[0] = ground_meja[0];
        this.ground_meja[1] = ground_meja[1];
        this.ground_meja[2] = ground_meja[2];
        this.ground_meja[3] = ground_meja[3];
        this.ground_meja[4] = ground_meja[4];
        this.ground_meja[5] = ground_meja[5];
        this.ground_meja[6] = ground_meja[6];
    }

    public void get_counter_ground_2(JPanel[] ground_meja) {
        this.ground_meja[7] = ground_meja[0];
        this.ground_meja[8] = ground_meja[1];
        this.ground_meja[9] = ground_meja[2];
        this.ground_meja[10] = ground_meja[3];
        this.ground_meja[11] = ground_meja[4];
        this.ground_meja[12] = ground_meja[5];
        this.ground_meja[13] = ground_meja[6];
    }

    private JDesktopPane desktop_1;
    private ui_number un_1;

    public void dekstop_1(JDesktopPane desktop_1, ui_number un_1) {
        this.desktop_1 = desktop_1;
        this.un_1 = un_1;
        desktop_1.add(un_1);
    }

    private JDesktopPane desktop_2;
    private ui_number un_2;

    public void dekstop_2(JDesktopPane desktop_2, ui_number un_2) {
        this.desktop_2 = desktop_2;
        this.un_2 = un_2;
        desktop_2.add(un_2);
    }
    
    JLabel data_antrian_1;
    
    public void set_queue_1(JLabel data_antrian_1) {
        this.data_antrian_1 = data_antrian_1;
    }
    
    JLabel data_antrian_2;
    
    public void set_queue_2(JLabel data_antrian_2) {
        this.data_antrian_2 = data_antrian_2;
    }

    @Override
    public void category_number(String nomor_antrian, int kategori, int id_display) throws RemoteException {
        if (kategori != 0) {
            if (id_display == 92) {
                nomor_kategori_1[kategori - 1].setText(nomor_antrian);
            } else if (id_display == 94) {
                nomor_kategori_2[kategori - 1].setText(nomor_antrian);
            }
        }
    }

    @Override
    public void counter_number(String nomor_antrian, int nomor_meja, int id_display) throws RemoteException {
        if (nomor_meja != 0) {
            if (id_display == 92) {
                nomor_meja_[nomor_meja - 1].setText(nomor_antrian);
            } else if (id_display == 94) {
                nomor_meja_[nomor_meja - 1].setText(nomor_antrian);
            }
        }
    }

    @Override
    public void category_ground(String nomor_antrian, int kategori, int id_display, Color cr) throws RemoteException {
        if (kategori != 0) {
            if (id_display == 92) {
                ground_kategori_1[kategori - 1].setBackground(cr);
            } else if (id_display == 94) {
                ground_kategori_2[kategori - 1].setBackground(cr);
            }
        }
    }

    @Override
    public void counter_ground(String nomor_antrian, int nomor_meja, int id_display, Color cr) throws RemoteException {
        if (nomor_meja != 0) {
            if (id_display == 92) {
                ground_meja[nomor_meja - 1].setBackground(cr);
            } else if (id_display == 94) {
                ground_meja[nomor_meja - 1].setBackground(cr);
            }
        }
    }

    @Override
    public void dekstop_open(String nama_kategori, String nomor_antrian, int nomor_meja, int id_display) throws RemoteException {
        if (nomor_meja != 0) {
            if (id_display == 92) {
                try {
                    un_1.set_value(nama_kategori, nomor_antrian, String.valueOf(nomor_meja));
                    un_1.show();
                    un_1.setIcon(false);
                    un_1.start_blink();
                    un_1.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    //Logger.getLogger(bottom_ui.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (id_display == 94) {
                try {
                    un_2.set_value(nama_kategori, nomor_antrian, String.valueOf(nomor_meja));
                    un_2.show();
                    un_2.setIcon(false);
                    un_2.start_blink();
                    un_2.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    //Logger.getLogger(bottom_ui.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void dekstop_close(int id_display) throws RemoteException {
        if (id_display == 92) {
            try {
                un_1.stop_blink();
                un_1.setIcon(true);
            } catch (PropertyVetoException ex) {
                //Logger.getLogger(bottom_ui.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (id_display == 94) {
            try {
                un_2.stop_blink();
                un_2.setIcon(true);
            } catch (PropertyVetoException ex) {
                //Logger.getLogger(bottom_ui.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public void data_queue(int jumlah_antrian, int id_display) throws RemoteException {
        if (id_display == 92) {
            data_antrian_1.setText(String.valueOf(jumlah_antrian));
        } else if (id_display == 94) {
            data_antrian_2.setText(String.valueOf(jumlah_antrian));
        }
    }

}
