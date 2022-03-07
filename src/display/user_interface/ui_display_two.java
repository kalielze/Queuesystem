/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package display.user_interface;

import database.query_control.connection;
import database.query_control.select.select_attribute;
import database.query_control.update.update_attribute;
import display.process_control.display_registry;
import display.process_control.load_display_attribute;
import display.process_control.load_image;
import implement.display.display;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import template.date_time;

/**
 *
 * @author 15my15
 */
public class ui_display_two extends javax.swing.JFrame {

    /**
     * Creates new form ui_display_one
     */
    private final date_time dt = new date_time();
    private final load_display_attribute lda = new load_display_attribute();
    private final connection con = new connection();
    private final select_attribute sa = new select_attribute();
    private final update_attribute ua = new update_attribute();
    private final display_registry dr = new display_registry();
    private final load_image li = new load_image();
    private ui_number un = new ui_number();
    private InetAddress ip;

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public ui_display_two() {
        try {
            initComponents();
            BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
            Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
            this.getContentPane().setCursor(blankCursor);
            setLocationRelativeTo(null);
            setExtendedState(MAXIMIZED_BOTH);
            lda.load();
            ImageIcon ico = new ImageIcon((getClass().getResource("/image/IconDisplay.png")));
            setIconImage(ico.getImage());
            setLocation(Integer.parseInt(lda.width()), 0);
            li.getImage(image_2);
            dt.run_time_display(label_waktu);
            String port2 = lda.port2();
            sa.connection(con.connection());
            ua.connection(con.connection());
            boolean bl = sa.check_display_status(Integer.parseInt(port2));
            if (bl == false) {
                for (int i = 0; i < 4; i++) {
                    label_category_number()[i].setText(sa.last_category_display(i + 1));
                }
                for (int i = 0; i < 6; i++) {
                    label_counter_number()[i].setText(sa.last_counter_display(i + 7));
                }
                data_antrian_2.setText(sa.last_visitor_display());
                ip = InetAddress.getLocalHost();
                ua.set_display(get_data_attribute("Mulai"));
                display dsp = new display();
                dsp.get_category_number_2(label_category_number());
                dsp.get_counter_number_2(label_counter_number());
                dsp.get_category_ground_2(panel_category_number());
                dsp.get_counter_ground_2(panel_counter_number());
                dsp.dekstop_2(desktop_2, un);
                dsp.set_queue_2(data_antrian_2);
                dr.registry(ip, Integer.parseInt(port2), dsp);
            } else {
                System.exit(0);
            }
        } catch (UnknownHostException ex) {
            Logger.getLogger(ui_display_two.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ui_display_two.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private JLabel[] label_counter_number() {
        JLabel nomor_meja[] = new JLabel[6];
        nomor_meja[0] = label_nomor_07;
        nomor_meja[1] = label_nomor_08;
        nomor_meja[2] = label_nomor_09;
        nomor_meja[3] = label_nomor_10;
        nomor_meja[4] = label_nomor_11;
        nomor_meja[5] = label_nomor_12;
        return nomor_meja;
    }

    private JLabel[] label_category_number() {
        JLabel nomor_kategori[] = new JLabel[4];
        nomor_kategori[0] = label_nomor_spp_2;
        nomor_kategori[1] = label_nomor_setoran_2;
        nomor_kategori[2] = label_nomor_tabungan_2;
        nomor_kategori[3] = label_nomor_kasir_2;
        return nomor_kategori;
    }

    private JPanel[] panel_counter_number() {
        JPanel gound_meja[] = new JPanel[6];
        gound_meja[0] = nomor_07;
        gound_meja[1] = nomor_08;
        gound_meja[2] = nomor_09;
        gound_meja[3] = nomor_10;
        gound_meja[4] = nomor_11;
        gound_meja[5] = nomor_12;
        return gound_meja;
    }

    private JPanel[] panel_category_number() {
        JPanel ground_kategori[] = new JPanel[4];
        ground_kategori[0] = nomor_spp_2;
        ground_kategori[1] = nomor_setoran_2;
        ground_kategori[2] = nomor_tabungan_2;
        ground_kategori[3] = nomor_kasir_2;
        return ground_kategori;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktop1 = new template.desktop();
        panel_b1 = new template.panel_b();
        panel_a1 = new template.panel_a();
        panel_a2 = new template.panel_a();
        panel_a12 = new template.panel_a();
        desktop_2 = new template.desktop();
        panel_b2 = new template.panel_b();
        image_2 = new javax.swing.JLabel();
        panel_b3 = new template.panel_b();
        jLabel1 = new javax.swing.JLabel();
        data_antrian_2 = new javax.swing.JLabel();
        panel_a13 = new template.panel_a();
        logo_srv1 = new template.logo_srv();
        waktu = new template.panel_b();
        label_waktu = new javax.swing.JLabel();
        panel_a15 = new template.panel_a();
        panel_a9 = new template.panel_a();
        spp_2 = new template.panel_b();
        label_spp_2 = new javax.swing.JLabel();
        panel_a10 = new template.panel_a();
        nomor_spp_2 = new template.panel_b();
        label_nomor_spp_2 = new javax.swing.JLabel();
        panel_a11 = new template.panel_a();
        setoran_2 = new template.panel_b();
        label_setoran_2 = new javax.swing.JLabel();
        panel_a14 = new template.panel_a();
        nomor_setoran_2 = new template.panel_b();
        label_nomor_setoran_2 = new javax.swing.JLabel();
        panel_a17 = new template.panel_a();
        tabungan_2 = new template.panel_b();
        label_tabungan_2 = new javax.swing.JLabel();
        panel_a18 = new template.panel_a();
        nomor_tabungan_2 = new template.panel_b();
        label_nomor_tabungan_2 = new javax.swing.JLabel();
        panel_a19 = new template.panel_a();
        kasir_2 = new template.panel_b();
        label_kasir_2 = new javax.swing.JLabel();
        panel_a20 = new template.panel_a();
        nomor_kasir_2 = new template.panel_b();
        label_nomor_kasir_2 = new javax.swing.JLabel();
        panel_a16 = new template.panel_a();
        panel_a3 = new template.panel_a();
        nomor_07 = new template.panel_b();
        label_nomor_07 = new javax.swing.JLabel();
        meja_07 = new template.panel_b();
        label_meja_07 = new javax.swing.JLabel();
        panel_a4 = new template.panel_a();
        nomor_08 = new template.panel_b();
        label_nomor_08 = new javax.swing.JLabel();
        meja_08 = new template.panel_b();
        label_meja_08 = new javax.swing.JLabel();
        panel_a5 = new template.panel_a();
        nomor_09 = new template.panel_b();
        label_nomor_09 = new javax.swing.JLabel();
        meja_09 = new template.panel_b();
        label_meja_09 = new javax.swing.JLabel();
        panel_a6 = new template.panel_a();
        nomor_10 = new template.panel_b();
        label_nomor_10 = new javax.swing.JLabel();
        meja_10 = new template.panel_b();
        label_meja_10 = new javax.swing.JLabel();
        panel_a7 = new template.panel_a();
        nomor_11 = new template.panel_b();
        label_nomor_11 = new javax.swing.JLabel();
        meja_11 = new template.panel_b();
        label_meja_11 = new javax.swing.JLabel();
        panel_a8 = new template.panel_a();
        nomor_12 = new template.panel_b();
        label_nomor_12 = new javax.swing.JLabel();
        meja_12 = new template.panel_b();
        label_meja_12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AntrianDisplayTwo v.19");
        setAlwaysOnTop(true);
        setUndecorated(true);
        setType(java.awt.Window.Type.UTILITY);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panel_b1.setBackground(new java.awt.Color(255, 255, 255));
        panel_b1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        panel_a1.setLayout(new java.awt.GridLayout(1, 0));

        panel_a2.setLayout(new java.awt.BorderLayout());

        panel_b2.setBackground(new java.awt.Color(255, 255, 255));
        panel_b2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        panel_b3.setBackground(new java.awt.Color(255, 255, 0));
        panel_b3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel1.setFont(new java.awt.Font("Cambria Math", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ANTRIAN HARI INI");

        data_antrian_2.setFont(new java.awt.Font("Cambria Math", 1, 75)); // NOI18N
        data_antrian_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        data_antrian_2.setText("0");

        javax.swing.GroupLayout panel_b3Layout = new javax.swing.GroupLayout(panel_b3);
        panel_b3.setLayout(panel_b3Layout);
        panel_b3Layout.setHorizontalGroup(
            panel_b3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_b3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_b3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(data_antrian_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel_b3Layout.setVerticalGroup(
            panel_b3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_b3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(data_antrian_2, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panel_b2Layout = new javax.swing.GroupLayout(panel_b2);
        panel_b2.setLayout(panel_b2Layout);
        panel_b2Layout.setHorizontalGroup(
            panel_b2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_b2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_b2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_b3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(image_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel_b2Layout.setVerticalGroup(
            panel_b2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_b2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image_2, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panel_b3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        desktop_2.setLayer(panel_b2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktop_2Layout = new javax.swing.GroupLayout(desktop_2);
        desktop_2.setLayout(desktop_2Layout);
        desktop_2Layout.setHorizontalGroup(
            desktop_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktop_2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_b2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        desktop_2Layout.setVerticalGroup(
            desktop_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktop_2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_b2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panel_a12Layout = new javax.swing.GroupLayout(panel_a12);
        panel_a12.setLayout(panel_a12Layout);
        panel_a12Layout.setHorizontalGroup(
            panel_a12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_a12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desktop_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel_a12Layout.setVerticalGroup(
            panel_a12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_a12Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(desktop_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        panel_a2.add(panel_a12, java.awt.BorderLayout.CENTER);

        panel_a13.setPreferredSize(new java.awt.Dimension(1266, 130));

        javax.swing.GroupLayout logo_srv1Layout = new javax.swing.GroupLayout(logo_srv1);
        logo_srv1.setLayout(logo_srv1Layout);
        logo_srv1Layout.setHorizontalGroup(
            logo_srv1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 456, Short.MAX_VALUE)
        );
        logo_srv1Layout.setVerticalGroup(
            logo_srv1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        waktu.setBackground(new java.awt.Color(255, 255, 102));
        waktu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        label_waktu.setFont(new java.awt.Font("Cambria Math", 1, 70)); // NOI18N
        label_waktu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_waktu.setText("00:00");

        javax.swing.GroupLayout waktuLayout = new javax.swing.GroupLayout(waktu);
        waktu.setLayout(waktuLayout);
        waktuLayout.setHorizontalGroup(
            waktuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, waktuLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(label_waktu, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );
        waktuLayout.setVerticalGroup(
            waktuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(waktuLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(label_waktu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout panel_a13Layout = new javax.swing.GroupLayout(panel_a13);
        panel_a13.setLayout(panel_a13Layout);
        panel_a13Layout.setHorizontalGroup(
            panel_a13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_a13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logo_srv1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 270, Short.MAX_VALUE)
                .addComponent(waktu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel_a13Layout.setVerticalGroup(
            panel_a13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_a13Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(panel_a13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(logo_srv1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(waktu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        panel_a2.add(panel_a13, java.awt.BorderLayout.PAGE_START);

        panel_a15.setPreferredSize(new java.awt.Dimension(270, 622));
        panel_a15.setLayout(new javax.swing.BoxLayout(panel_a15, javax.swing.BoxLayout.PAGE_AXIS));

        panel_a9.setPreferredSize(new java.awt.Dimension(298, 35));

        spp_2.setBackground(new java.awt.Color(153, 255, 255));
        spp_2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        label_spp_2.setFont(new java.awt.Font("Cambria Math", 1, 30)); // NOI18N
        label_spp_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_spp_2.setText("SPP");

        javax.swing.GroupLayout spp_2Layout = new javax.swing.GroupLayout(spp_2);
        spp_2.setLayout(spp_2Layout);
        spp_2Layout.setHorizontalGroup(
            spp_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_spp_2, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
        );
        spp_2Layout.setVerticalGroup(
            spp_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_spp_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_a9Layout = new javax.swing.GroupLayout(panel_a9);
        panel_a9.setLayout(panel_a9Layout);
        panel_a9Layout.setHorizontalGroup(
            panel_a9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spp_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_a9Layout.setVerticalGroup(
            panel_a9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spp_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panel_a15.add(panel_a9);

        nomor_spp_2.setBackground(new java.awt.Color(153, 255, 255));
        nomor_spp_2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        label_nomor_spp_2.setFont(new java.awt.Font("Cambria Math", 1, 75)); // NOI18N
        label_nomor_spp_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_nomor_spp_2.setText("0000");

        javax.swing.GroupLayout nomor_spp_2Layout = new javax.swing.GroupLayout(nomor_spp_2);
        nomor_spp_2.setLayout(nomor_spp_2Layout);
        nomor_spp_2Layout.setHorizontalGroup(
            nomor_spp_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_nomor_spp_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        nomor_spp_2Layout.setVerticalGroup(
            nomor_spp_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_nomor_spp_2, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_a10Layout = new javax.swing.GroupLayout(panel_a10);
        panel_a10.setLayout(panel_a10Layout);
        panel_a10Layout.setHorizontalGroup(
            panel_a10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nomor_spp_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_a10Layout.setVerticalGroup(
            panel_a10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_a10Layout.createSequentialGroup()
                .addComponent(nomor_spp_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        panel_a15.add(panel_a10);

        panel_a11.setPreferredSize(new java.awt.Dimension(298, 35));

        setoran_2.setBackground(new java.awt.Color(255, 255, 153));
        setoran_2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        label_setoran_2.setFont(new java.awt.Font("Cambria Math", 1, 30)); // NOI18N
        label_setoran_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_setoran_2.setText("SETORAN");

        javax.swing.GroupLayout setoran_2Layout = new javax.swing.GroupLayout(setoran_2);
        setoran_2.setLayout(setoran_2Layout);
        setoran_2Layout.setHorizontalGroup(
            setoran_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_setoran_2, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
        );
        setoran_2Layout.setVerticalGroup(
            setoran_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_setoran_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_a11Layout = new javax.swing.GroupLayout(panel_a11);
        panel_a11.setLayout(panel_a11Layout);
        panel_a11Layout.setHorizontalGroup(
            panel_a11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(setoran_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_a11Layout.setVerticalGroup(
            panel_a11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(setoran_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panel_a15.add(panel_a11);

        nomor_setoran_2.setBackground(new java.awt.Color(255, 255, 153));
        nomor_setoran_2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        label_nomor_setoran_2.setFont(new java.awt.Font("Cambria Math", 1, 75)); // NOI18N
        label_nomor_setoran_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_nomor_setoran_2.setText("0000");

        javax.swing.GroupLayout nomor_setoran_2Layout = new javax.swing.GroupLayout(nomor_setoran_2);
        nomor_setoran_2.setLayout(nomor_setoran_2Layout);
        nomor_setoran_2Layout.setHorizontalGroup(
            nomor_setoran_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_nomor_setoran_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        nomor_setoran_2Layout.setVerticalGroup(
            nomor_setoran_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_nomor_setoran_2, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_a14Layout = new javax.swing.GroupLayout(panel_a14);
        panel_a14.setLayout(panel_a14Layout);
        panel_a14Layout.setHorizontalGroup(
            panel_a14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nomor_setoran_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_a14Layout.setVerticalGroup(
            panel_a14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_a14Layout.createSequentialGroup()
                .addComponent(nomor_setoran_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        panel_a15.add(panel_a14);

        panel_a17.setPreferredSize(new java.awt.Dimension(298, 35));

        tabungan_2.setBackground(new java.awt.Color(153, 255, 153));
        tabungan_2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        label_tabungan_2.setFont(new java.awt.Font("Cambria Math", 1, 30)); // NOI18N
        label_tabungan_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_tabungan_2.setText("TABUNGAN");

        javax.swing.GroupLayout tabungan_2Layout = new javax.swing.GroupLayout(tabungan_2);
        tabungan_2.setLayout(tabungan_2Layout);
        tabungan_2Layout.setHorizontalGroup(
            tabungan_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_tabungan_2, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
        );
        tabungan_2Layout.setVerticalGroup(
            tabungan_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_tabungan_2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_a17Layout = new javax.swing.GroupLayout(panel_a17);
        panel_a17.setLayout(panel_a17Layout);
        panel_a17Layout.setHorizontalGroup(
            panel_a17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabungan_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_a17Layout.setVerticalGroup(
            panel_a17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabungan_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panel_a15.add(panel_a17);

        panel_a18.setBackground(new java.awt.Color(51, 255, 0));
        panel_a18.setPreferredSize(new java.awt.Dimension(298, 105));

        nomor_tabungan_2.setBackground(new java.awt.Color(153, 255, 153));
        nomor_tabungan_2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        label_nomor_tabungan_2.setFont(new java.awt.Font("Cambria Math", 1, 75)); // NOI18N
        label_nomor_tabungan_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_nomor_tabungan_2.setText("0000");

        javax.swing.GroupLayout nomor_tabungan_2Layout = new javax.swing.GroupLayout(nomor_tabungan_2);
        nomor_tabungan_2.setLayout(nomor_tabungan_2Layout);
        nomor_tabungan_2Layout.setHorizontalGroup(
            nomor_tabungan_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_nomor_tabungan_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        nomor_tabungan_2Layout.setVerticalGroup(
            nomor_tabungan_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_nomor_tabungan_2, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_a18Layout = new javax.swing.GroupLayout(panel_a18);
        panel_a18.setLayout(panel_a18Layout);
        panel_a18Layout.setHorizontalGroup(
            panel_a18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nomor_tabungan_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_a18Layout.setVerticalGroup(
            panel_a18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_a18Layout.createSequentialGroup()
                .addComponent(nomor_tabungan_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        panel_a15.add(panel_a18);

        panel_a19.setPreferredSize(new java.awt.Dimension(298, 35));

        kasir_2.setBackground(new java.awt.Color(255, 153, 255));
        kasir_2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        label_kasir_2.setFont(new java.awt.Font("Cambria Math", 1, 30)); // NOI18N
        label_kasir_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_kasir_2.setText("KASIR");

        javax.swing.GroupLayout kasir_2Layout = new javax.swing.GroupLayout(kasir_2);
        kasir_2.setLayout(kasir_2Layout);
        kasir_2Layout.setHorizontalGroup(
            kasir_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_kasir_2, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
        );
        kasir_2Layout.setVerticalGroup(
            kasir_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_kasir_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_a19Layout = new javax.swing.GroupLayout(panel_a19);
        panel_a19.setLayout(panel_a19Layout);
        panel_a19Layout.setHorizontalGroup(
            panel_a19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kasir_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_a19Layout.setVerticalGroup(
            panel_a19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kasir_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panel_a15.add(panel_a19);

        panel_a20.setBackground(new java.awt.Color(255, 153, 255));
        panel_a20.setPreferredSize(new java.awt.Dimension(298, 105));

        nomor_kasir_2.setBackground(new java.awt.Color(255, 153, 255));
        nomor_kasir_2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        label_nomor_kasir_2.setFont(new java.awt.Font("Cambria Math", 1, 75)); // NOI18N
        label_nomor_kasir_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_nomor_kasir_2.setText("0000");

        javax.swing.GroupLayout nomor_kasir_2Layout = new javax.swing.GroupLayout(nomor_kasir_2);
        nomor_kasir_2.setLayout(nomor_kasir_2Layout);
        nomor_kasir_2Layout.setHorizontalGroup(
            nomor_kasir_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_nomor_kasir_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        nomor_kasir_2Layout.setVerticalGroup(
            nomor_kasir_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_nomor_kasir_2, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_a20Layout = new javax.swing.GroupLayout(panel_a20);
        panel_a20.setLayout(panel_a20Layout);
        panel_a20Layout.setHorizontalGroup(
            panel_a20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nomor_kasir_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_a20Layout.setVerticalGroup(
            panel_a20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_a20Layout.createSequentialGroup()
                .addComponent(nomor_kasir_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        panel_a15.add(panel_a20);

        panel_a2.add(panel_a15, java.awt.BorderLayout.LINE_END);

        panel_a16.setPreferredSize(new java.awt.Dimension(270, 622));
        panel_a16.setLayout(new javax.swing.BoxLayout(panel_a16, javax.swing.BoxLayout.PAGE_AXIS));

        panel_a3.setPreferredSize(new java.awt.Dimension(398, 105));

        nomor_07.setBackground(new java.awt.Color(255, 255, 0));
        nomor_07.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        label_nomor_07.setFont(new java.awt.Font("Cambria Math", 1, 60)); // NOI18N
        label_nomor_07.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_nomor_07.setText("0000");

        javax.swing.GroupLayout nomor_07Layout = new javax.swing.GroupLayout(nomor_07);
        nomor_07.setLayout(nomor_07Layout);
        nomor_07Layout.setHorizontalGroup(
            nomor_07Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_nomor_07, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        nomor_07Layout.setVerticalGroup(
            nomor_07Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_nomor_07, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );

        meja_07.setBackground(new java.awt.Color(0, 255, 0));
        meja_07.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        meja_07.setPreferredSize(new java.awt.Dimension(90, 81));

        label_meja_07.setFont(new java.awt.Font("Cambria Math", 1, 60)); // NOI18N
        label_meja_07.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_meja_07.setText("07");

        javax.swing.GroupLayout meja_07Layout = new javax.swing.GroupLayout(meja_07);
        meja_07.setLayout(meja_07Layout);
        meja_07Layout.setHorizontalGroup(
            meja_07Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_meja_07, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
        );
        meja_07Layout.setVerticalGroup(
            meja_07Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_meja_07, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_a3Layout = new javax.swing.GroupLayout(panel_a3);
        panel_a3.setLayout(panel_a3Layout);
        panel_a3Layout.setHorizontalGroup(
            panel_a3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_a3Layout.createSequentialGroup()
                .addComponent(meja_07, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nomor_07, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
        );
        panel_a3Layout.setVerticalGroup(
            panel_a3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_a3Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(panel_a3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomor_07, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(meja_07, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
                .addGap(3, 3, 3))
        );

        panel_a16.add(panel_a3);

        panel_a4.setPreferredSize(new java.awt.Dimension(398, 105));

        nomor_08.setBackground(new java.awt.Color(255, 255, 0));
        nomor_08.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        label_nomor_08.setFont(new java.awt.Font("Cambria Math", 1, 60)); // NOI18N
        label_nomor_08.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_nomor_08.setText("0000");

        javax.swing.GroupLayout nomor_08Layout = new javax.swing.GroupLayout(nomor_08);
        nomor_08.setLayout(nomor_08Layout);
        nomor_08Layout.setHorizontalGroup(
            nomor_08Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_nomor_08, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        nomor_08Layout.setVerticalGroup(
            nomor_08Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_nomor_08, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );

        meja_08.setBackground(new java.awt.Color(0, 255, 0));
        meja_08.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        meja_08.setPreferredSize(new java.awt.Dimension(90, 81));

        label_meja_08.setFont(new java.awt.Font("Cambria Math", 1, 60)); // NOI18N
        label_meja_08.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_meja_08.setText("08");

        javax.swing.GroupLayout meja_08Layout = new javax.swing.GroupLayout(meja_08);
        meja_08.setLayout(meja_08Layout);
        meja_08Layout.setHorizontalGroup(
            meja_08Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_meja_08, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
        );
        meja_08Layout.setVerticalGroup(
            meja_08Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_meja_08, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_a4Layout = new javax.swing.GroupLayout(panel_a4);
        panel_a4.setLayout(panel_a4Layout);
        panel_a4Layout.setHorizontalGroup(
            panel_a4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_a4Layout.createSequentialGroup()
                .addComponent(meja_08, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nomor_08, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
        );
        panel_a4Layout.setVerticalGroup(
            panel_a4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_a4Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(panel_a4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomor_08, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(meja_08, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
                .addGap(3, 3, 3))
        );

        panel_a16.add(panel_a4);

        panel_a5.setPreferredSize(new java.awt.Dimension(398, 105));

        nomor_09.setBackground(new java.awt.Color(255, 255, 0));
        nomor_09.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        label_nomor_09.setFont(new java.awt.Font("Cambria Math", 1, 60)); // NOI18N
        label_nomor_09.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_nomor_09.setText("0000");

        javax.swing.GroupLayout nomor_09Layout = new javax.swing.GroupLayout(nomor_09);
        nomor_09.setLayout(nomor_09Layout);
        nomor_09Layout.setHorizontalGroup(
            nomor_09Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_nomor_09, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        nomor_09Layout.setVerticalGroup(
            nomor_09Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_nomor_09, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );

        meja_09.setBackground(new java.awt.Color(0, 255, 0));
        meja_09.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        meja_09.setPreferredSize(new java.awt.Dimension(90, 81));

        label_meja_09.setFont(new java.awt.Font("Cambria Math", 1, 60)); // NOI18N
        label_meja_09.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_meja_09.setText("09");

        javax.swing.GroupLayout meja_09Layout = new javax.swing.GroupLayout(meja_09);
        meja_09.setLayout(meja_09Layout);
        meja_09Layout.setHorizontalGroup(
            meja_09Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_meja_09, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
        );
        meja_09Layout.setVerticalGroup(
            meja_09Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_meja_09, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_a5Layout = new javax.swing.GroupLayout(panel_a5);
        panel_a5.setLayout(panel_a5Layout);
        panel_a5Layout.setHorizontalGroup(
            panel_a5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_a5Layout.createSequentialGroup()
                .addComponent(meja_09, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nomor_09, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
        );
        panel_a5Layout.setVerticalGroup(
            panel_a5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_a5Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(panel_a5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomor_09, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(meja_09, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
                .addGap(3, 3, 3))
        );

        panel_a16.add(panel_a5);

        panel_a6.setPreferredSize(new java.awt.Dimension(398, 105));

        nomor_10.setBackground(new java.awt.Color(255, 255, 0));
        nomor_10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        label_nomor_10.setFont(new java.awt.Font("Cambria Math", 1, 60)); // NOI18N
        label_nomor_10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_nomor_10.setText("0000");

        javax.swing.GroupLayout nomor_10Layout = new javax.swing.GroupLayout(nomor_10);
        nomor_10.setLayout(nomor_10Layout);
        nomor_10Layout.setHorizontalGroup(
            nomor_10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_nomor_10, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        nomor_10Layout.setVerticalGroup(
            nomor_10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_nomor_10, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );

        meja_10.setBackground(new java.awt.Color(0, 255, 0));
        meja_10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        meja_10.setPreferredSize(new java.awt.Dimension(90, 81));

        label_meja_10.setFont(new java.awt.Font("Cambria Math", 1, 60)); // NOI18N
        label_meja_10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_meja_10.setText("10");

        javax.swing.GroupLayout meja_10Layout = new javax.swing.GroupLayout(meja_10);
        meja_10.setLayout(meja_10Layout);
        meja_10Layout.setHorizontalGroup(
            meja_10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_meja_10, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
        );
        meja_10Layout.setVerticalGroup(
            meja_10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_meja_10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_a6Layout = new javax.swing.GroupLayout(panel_a6);
        panel_a6.setLayout(panel_a6Layout);
        panel_a6Layout.setHorizontalGroup(
            panel_a6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_a6Layout.createSequentialGroup()
                .addComponent(meja_10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nomor_10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
        );
        panel_a6Layout.setVerticalGroup(
            panel_a6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_a6Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(panel_a6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomor_10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(meja_10, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
                .addGap(3, 3, 3))
        );

        panel_a16.add(panel_a6);

        panel_a7.setPreferredSize(new java.awt.Dimension(398, 105));

        nomor_11.setBackground(new java.awt.Color(255, 255, 0));
        nomor_11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        label_nomor_11.setFont(new java.awt.Font("Cambria Math", 1, 60)); // NOI18N
        label_nomor_11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_nomor_11.setText("0000");

        javax.swing.GroupLayout nomor_11Layout = new javax.swing.GroupLayout(nomor_11);
        nomor_11.setLayout(nomor_11Layout);
        nomor_11Layout.setHorizontalGroup(
            nomor_11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_nomor_11, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        nomor_11Layout.setVerticalGroup(
            nomor_11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_nomor_11, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );

        meja_11.setBackground(new java.awt.Color(0, 255, 0));
        meja_11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        meja_11.setPreferredSize(new java.awt.Dimension(90, 81));

        label_meja_11.setFont(new java.awt.Font("Cambria Math", 1, 60)); // NOI18N
        label_meja_11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_meja_11.setText("11");

        javax.swing.GroupLayout meja_11Layout = new javax.swing.GroupLayout(meja_11);
        meja_11.setLayout(meja_11Layout);
        meja_11Layout.setHorizontalGroup(
            meja_11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_meja_11, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
        );
        meja_11Layout.setVerticalGroup(
            meja_11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_meja_11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_a7Layout = new javax.swing.GroupLayout(panel_a7);
        panel_a7.setLayout(panel_a7Layout);
        panel_a7Layout.setHorizontalGroup(
            panel_a7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_a7Layout.createSequentialGroup()
                .addComponent(meja_11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nomor_11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
        );
        panel_a7Layout.setVerticalGroup(
            panel_a7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_a7Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(panel_a7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomor_11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(meja_11, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
                .addGap(3, 3, 3))
        );

        panel_a16.add(panel_a7);

        panel_a8.setPreferredSize(new java.awt.Dimension(398, 105));

        nomor_12.setBackground(new java.awt.Color(255, 255, 0));
        nomor_12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        label_nomor_12.setFont(new java.awt.Font("Cambria Math", 1, 60)); // NOI18N
        label_nomor_12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_nomor_12.setText("0000");

        javax.swing.GroupLayout nomor_12Layout = new javax.swing.GroupLayout(nomor_12);
        nomor_12.setLayout(nomor_12Layout);
        nomor_12Layout.setHorizontalGroup(
            nomor_12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_nomor_12, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        nomor_12Layout.setVerticalGroup(
            nomor_12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_nomor_12, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );

        meja_12.setBackground(new java.awt.Color(0, 255, 0));
        meja_12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        meja_12.setPreferredSize(new java.awt.Dimension(90, 81));

        label_meja_12.setFont(new java.awt.Font("Cambria Math", 1, 60)); // NOI18N
        label_meja_12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_meja_12.setText("12");

        javax.swing.GroupLayout meja_12Layout = new javax.swing.GroupLayout(meja_12);
        meja_12.setLayout(meja_12Layout);
        meja_12Layout.setHorizontalGroup(
            meja_12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_meja_12, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
        );
        meja_12Layout.setVerticalGroup(
            meja_12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_meja_12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_a8Layout = new javax.swing.GroupLayout(panel_a8);
        panel_a8.setLayout(panel_a8Layout);
        panel_a8Layout.setHorizontalGroup(
            panel_a8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_a8Layout.createSequentialGroup()
                .addComponent(meja_12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nomor_12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
        );
        panel_a8Layout.setVerticalGroup(
            panel_a8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_a8Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(panel_a8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomor_12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(meja_12, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
                .addGap(3, 3, 3))
        );

        panel_a16.add(panel_a8);

        panel_a2.add(panel_a16, java.awt.BorderLayout.LINE_START);

        panel_a1.add(panel_a2);

        javax.swing.GroupLayout panel_b1Layout = new javax.swing.GroupLayout(panel_b1);
        panel_b1.setLayout(panel_b1Layout);
        panel_b1Layout.setHorizontalGroup(
            panel_b1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_a1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        panel_b1Layout.setVerticalGroup(
            panel_b1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_a1, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
        );

        desktop1.setLayer(panel_b1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktop1Layout = new javax.swing.GroupLayout(desktop1);
        desktop1.setLayout(desktop1Layout);
        desktop1Layout.setHorizontalGroup(
            desktop1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktop1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_b1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        desktop1Layout.setVerticalGroup(
            desktop1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktop1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_b1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private String[] get_data_attribute(String mulai) {
        String id_display = lda.port2(), hostname = null, status = "0";
        if ("Mulai".equals(mulai)) {
            try {
                ip = InetAddress.getLocalHost();
                hostname = "'" + ip.getHostAddress() + "'";
                status = String.valueOf(1);
            } catch (UnknownHostException ex) {
                Logger.getLogger(ui_display_two.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        String data[] = new String[]{id_display, hostname, status};
        return data;
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        ua.set_display(get_data_attribute("Berhenti"));
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("Convert2Lambda")
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ui_display_two.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ui_display_two.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ui_display_two.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ui_display_two.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ui_display_two().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel data_antrian_2;
    private template.desktop desktop1;
    private template.desktop desktop_2;
    private javax.swing.JLabel image_2;
    private javax.swing.JLabel jLabel1;
    private template.panel_b kasir_2;
    private javax.swing.JLabel label_kasir_2;
    private javax.swing.JLabel label_meja_07;
    private javax.swing.JLabel label_meja_08;
    private javax.swing.JLabel label_meja_09;
    private javax.swing.JLabel label_meja_10;
    private javax.swing.JLabel label_meja_11;
    private javax.swing.JLabel label_meja_12;
    private javax.swing.JLabel label_nomor_07;
    private javax.swing.JLabel label_nomor_08;
    private javax.swing.JLabel label_nomor_09;
    private javax.swing.JLabel label_nomor_10;
    private javax.swing.JLabel label_nomor_11;
    private javax.swing.JLabel label_nomor_12;
    private javax.swing.JLabel label_nomor_kasir_2;
    private javax.swing.JLabel label_nomor_setoran_2;
    private javax.swing.JLabel label_nomor_spp_2;
    private javax.swing.JLabel label_nomor_tabungan_2;
    private javax.swing.JLabel label_setoran_2;
    private javax.swing.JLabel label_spp_2;
    private javax.swing.JLabel label_tabungan_2;
    private javax.swing.JLabel label_waktu;
    private template.logo_srv logo_srv1;
    private template.panel_b meja_07;
    private template.panel_b meja_08;
    private template.panel_b meja_09;
    private template.panel_b meja_10;
    private template.panel_b meja_11;
    private template.panel_b meja_12;
    private template.panel_b nomor_07;
    private template.panel_b nomor_08;
    private template.panel_b nomor_09;
    private template.panel_b nomor_10;
    private template.panel_b nomor_11;
    private template.panel_b nomor_12;
    private template.panel_b nomor_kasir_2;
    private template.panel_b nomor_setoran_2;
    private template.panel_b nomor_spp_2;
    private template.panel_b nomor_tabungan_2;
    private template.panel_a panel_a1;
    private template.panel_a panel_a10;
    private template.panel_a panel_a11;
    private template.panel_a panel_a12;
    private template.panel_a panel_a13;
    private template.panel_a panel_a14;
    private template.panel_a panel_a15;
    private template.panel_a panel_a16;
    private template.panel_a panel_a17;
    private template.panel_a panel_a18;
    private template.panel_a panel_a19;
    private template.panel_a panel_a2;
    private template.panel_a panel_a20;
    private template.panel_a panel_a3;
    private template.panel_a panel_a4;
    private template.panel_a panel_a5;
    private template.panel_a panel_a6;
    private template.panel_a panel_a7;
    private template.panel_a panel_a8;
    private template.panel_a panel_a9;
    private template.panel_b panel_b1;
    private template.panel_b panel_b2;
    private template.panel_b panel_b3;
    private template.panel_b setoran_2;
    private template.panel_b spp_2;
    private template.panel_b tabungan_2;
    private template.panel_b waktu;
    // End of variables declaration//GEN-END:variables
}
