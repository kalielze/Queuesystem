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
import static java.awt.Frame.MAXIMIZED_BOTH;
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
 * @author user
 */
public class ui_display_one_change extends javax.swing.JFrame {

    /**
     * Creates new form ui_display_one_change
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
    public ui_display_one_change() {
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
            li.getImage(image_1);
            String port1 = lda.port1();
            sa.connection(con.connection());
            ua.connection(con.connection());
            boolean bl = sa.check_display_status(Integer.parseInt(port1));
            if (bl == false) {
                for (int i = 0; i < 4; i++) {
                    label_category_number()[i].setText(sa.last_category_display(i + 1));
                }
                for (int i = 0; i < 7; i++) {
                    label_counter_number()[i].setText(sa.last_counter_display(i + 1));
                }
                data_antrian_1.setText(sa.last_visitor_display());
                ip = InetAddress.getLocalHost();
                ua.set_display(get_data_attribute("Mulai"));
                display dsp = new display();
                dsp.get_category_number_1(label_category_number());
                dsp.get_counter_number_1(label_counter_number());
                dsp.get_category_ground_1(panel_category_number());
                dsp.get_counter_ground_1(panel_counter_number());
                dsp.dekstop_1(desktop_1, un);
                dsp.set_queue_1(data_antrian_1);
                dr.registry(ip, Integer.parseInt(port1), dsp);
            } else {
                System.exit(0);
            }
        } catch (UnknownHostException ex) {
            Logger.getLogger(ui_display_one_change.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ui_display_one_change.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private JLabel[] label_counter_number() {
        JLabel nomor_meja[] = new JLabel[7];
        nomor_meja[0] = label_nomor_01;
        nomor_meja[1] = label_nomor_02;
        nomor_meja[2] = label_nomor_03;
        nomor_meja[3] = label_nomor_04;
        nomor_meja[4] = label_nomor_05;
        nomor_meja[5] = label_nomor_06;
        nomor_meja[6] = label_nomor_07;
        return nomor_meja;
    }
    
    private JLabel[] label_category_number() {
        JLabel nomor_kategori[] = new JLabel[4];
        nomor_kategori[0] = label_nomor_spp_1;
        nomor_kategori[1] = label_nomor_setoran_1;
        nomor_kategori[2] = label_nomor_tabungan_1;
        nomor_kategori[3] = label_nomor_kasir_1;
        return nomor_kategori;
    }
    
    private JPanel[] panel_counter_number() {
        JPanel gound_meja[] = new JPanel[7];
        gound_meja[0] = nomor_01;
        gound_meja[1] = nomor_02;
        gound_meja[2] = nomor_03;
        gound_meja[3] = nomor_04;
        gound_meja[4] = nomor_05;
        gound_meja[5] = nomor_06;
        gound_meja[6] = nomor_07;
        return gound_meja;
    }
    
    private JPanel[] panel_category_number() {
        JPanel ground_kategori[] = new JPanel[4];
        ground_kategori[0] = nomor_spp_1;
        ground_kategori[1] = nomor_setoran_1;
        ground_kategori[2] = nomor_tabungan_1;
        ground_kategori[3] = nomor_kasir_1;
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
        desktop_1 = new template.desktop();
        panel_b2 = new template.panel_b();
        image_1 = new javax.swing.JLabel();
        panel_b3 = new template.panel_b();
        jLabel1 = new javax.swing.JLabel();
        data_antrian_1 = new javax.swing.JLabel();
        panel_a3 = new template.panel_a();
        logo_srv1 = new template.logo_srv();
        panel_a7 = new template.panel_a();
        panel_a5 = new template.panel_a();
        spp_1 = new template.panel_b();
        label_spp_1 = new javax.swing.JLabel();
        panel_a6 = new template.panel_a();
        nomor_spp_1 = new template.panel_b();
        label_nomor_spp_1 = new javax.swing.JLabel();
        panel_a8 = new template.panel_a();
        setoran_1 = new template.panel_b();
        label_setoran_1 = new javax.swing.JLabel();
        panel_a9 = new template.panel_a();
        nomor_setoran_1 = new template.panel_b();
        label_nomor_setoran_1 = new javax.swing.JLabel();
        panel_a10 = new template.panel_a();
        tabungan_1 = new template.panel_b();
        label_tabungan_1 = new javax.swing.JLabel();
        panel_a11 = new template.panel_a();
        nomor_tabungan_1 = new template.panel_b();
        label_nomor_tabungan_1 = new javax.swing.JLabel();
        panel_a12 = new template.panel_a();
        kasir_1 = new template.panel_b();
        label_kasir_1 = new javax.swing.JLabel();
        panel_a13 = new template.panel_a();
        nomor_kasir_1 = new template.panel_b();
        label_nomor_kasir_1 = new javax.swing.JLabel();
        panel_a4 = new template.panel_a();
        panel_a14 = new template.panel_a();
        nomor_01 = new template.panel_b();
        label_nomor_01 = new javax.swing.JLabel();
        meja_01 = new template.panel_b();
        label_meja_01 = new javax.swing.JLabel();
        panel_a15 = new template.panel_a();
        nomor_02 = new template.panel_b();
        label_nomor_02 = new javax.swing.JLabel();
        meja_02 = new template.panel_b();
        label_meja_02 = new javax.swing.JLabel();
        panel_a16 = new template.panel_a();
        nomor_03 = new template.panel_b();
        label_nomor_03 = new javax.swing.JLabel();
        meja_03 = new template.panel_b();
        label_meja_03 = new javax.swing.JLabel();
        panel_a17 = new template.panel_a();
        nomor_04 = new template.panel_b();
        label_nomor_04 = new javax.swing.JLabel();
        meja_04 = new template.panel_b();
        label_meja_04 = new javax.swing.JLabel();
        panel_a18 = new template.panel_a();
        nomor_05 = new template.panel_b();
        label_nomor_05 = new javax.swing.JLabel();
        meja_05 = new template.panel_b();
        label_meja_05 = new javax.swing.JLabel();
        panel_a19 = new template.panel_a();
        nomor_06 = new template.panel_b();
        label_nomor_06 = new javax.swing.JLabel();
        meja_06 = new template.panel_b();
        label_meja_06 = new javax.swing.JLabel();
        panel_a20 = new template.panel_a();
        nomor_07 = new template.panel_b();
        label_nomor_07 = new javax.swing.JLabel();
        meja_07 = new template.panel_b();
        label_meja_07 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setType(java.awt.Window.Type.UTILITY);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panel_b1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        panel_b1.setLayout(new java.awt.BorderLayout());

        panel_a1.setLayout(new java.awt.BorderLayout());

        panel_b2.setBackground(new java.awt.Color(255, 255, 255));
        panel_b2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        panel_b3.setBackground(new java.awt.Color(255, 255, 0));
        panel_b3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel1.setFont(new java.awt.Font("Cambria Math", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ANTRIAN HARI INI");

        data_antrian_1.setFont(new java.awt.Font("Cambria Math", 1, 75)); // NOI18N
        data_antrian_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        data_antrian_1.setText("0");

        javax.swing.GroupLayout panel_b3Layout = new javax.swing.GroupLayout(panel_b3);
        panel_b3.setLayout(panel_b3Layout);
        panel_b3Layout.setHorizontalGroup(
            panel_b3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_b3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_b3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                    .addComponent(data_antrian_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel_b3Layout.setVerticalGroup(
            panel_b3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_b3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(data_antrian_1, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
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
                    .addComponent(image_1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel_b2Layout.setVerticalGroup(
            panel_b2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_b2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image_1, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel_b3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        desktop_1.setLayer(panel_b2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktop_1Layout = new javax.swing.GroupLayout(desktop_1);
        desktop_1.setLayout(desktop_1Layout);
        desktop_1Layout.setHorizontalGroup(
            desktop_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktop_1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_b2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        desktop_1Layout.setVerticalGroup(
            desktop_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktop_1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_b2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panel_a2Layout = new javax.swing.GroupLayout(panel_a2);
        panel_a2.setLayout(panel_a2Layout);
        panel_a2Layout.setHorizontalGroup(
            panel_a2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_a2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desktop_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel_a2Layout.setVerticalGroup(
            panel_a2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop_1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panel_a1.add(panel_a2, java.awt.BorderLayout.CENTER);

        panel_a3.setPreferredSize(new java.awt.Dimension(728, 130));

        logo_srv1.setPreferredSize(new java.awt.Dimension(456, 100));

        javax.swing.GroupLayout logo_srv1Layout = new javax.swing.GroupLayout(logo_srv1);
        logo_srv1.setLayout(logo_srv1Layout);
        logo_srv1Layout.setHorizontalGroup(
            logo_srv1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 456, Short.MAX_VALUE)
        );
        logo_srv1Layout.setVerticalGroup(
            logo_srv1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 105, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_a3Layout = new javax.swing.GroupLayout(panel_a3);
        panel_a3.setLayout(panel_a3Layout);
        panel_a3Layout.setHorizontalGroup(
            panel_a3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_a3Layout.createSequentialGroup()
                .addContainerGap(137, Short.MAX_VALUE)
                .addComponent(logo_srv1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(137, Short.MAX_VALUE))
        );
        panel_a3Layout.setVerticalGroup(
            panel_a3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_a3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logo_srv1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        panel_a1.add(panel_a3, java.awt.BorderLayout.PAGE_START);

        panel_a7.setPreferredSize(new java.awt.Dimension(270, 630));
        panel_a7.setLayout(new javax.swing.BoxLayout(panel_a7, javax.swing.BoxLayout.PAGE_AXIS));

        panel_a5.setPreferredSize(new java.awt.Dimension(268, 35));

        spp_1.setBackground(new java.awt.Color(153, 255, 255));
        spp_1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        label_spp_1.setFont(new java.awt.Font("Cambria Math", 1, 30)); // NOI18N
        label_spp_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_spp_1.setText("SPP");

        javax.swing.GroupLayout spp_1Layout = new javax.swing.GroupLayout(spp_1);
        spp_1.setLayout(spp_1Layout);
        spp_1Layout.setHorizontalGroup(
            spp_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_spp_1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
        );
        spp_1Layout.setVerticalGroup(
            spp_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_spp_1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_a5Layout = new javax.swing.GroupLayout(panel_a5);
        panel_a5.setLayout(panel_a5Layout);
        panel_a5Layout.setHorizontalGroup(
            panel_a5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spp_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_a5Layout.setVerticalGroup(
            panel_a5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spp_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panel_a7.add(panel_a5);

        nomor_spp_1.setBackground(new java.awt.Color(153, 255, 255));
        nomor_spp_1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        label_nomor_spp_1.setFont(new java.awt.Font("Cambria Math", 1, 75)); // NOI18N
        label_nomor_spp_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_nomor_spp_1.setText("0000");

        javax.swing.GroupLayout nomor_spp_1Layout = new javax.swing.GroupLayout(nomor_spp_1);
        nomor_spp_1.setLayout(nomor_spp_1Layout);
        nomor_spp_1Layout.setHorizontalGroup(
            nomor_spp_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_nomor_spp_1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
        );
        nomor_spp_1Layout.setVerticalGroup(
            nomor_spp_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_nomor_spp_1, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_a6Layout = new javax.swing.GroupLayout(panel_a6);
        panel_a6.setLayout(panel_a6Layout);
        panel_a6Layout.setHorizontalGroup(
            panel_a6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nomor_spp_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_a6Layout.setVerticalGroup(
            panel_a6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nomor_spp_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panel_a7.add(panel_a6);

        panel_a8.setPreferredSize(new java.awt.Dimension(268, 35));

        setoran_1.setBackground(new java.awt.Color(255, 255, 153));
        setoran_1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        label_setoran_1.setFont(new java.awt.Font("Cambria Math", 1, 30)); // NOI18N
        label_setoran_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_setoran_1.setText("SETORAN");

        javax.swing.GroupLayout setoran_1Layout = new javax.swing.GroupLayout(setoran_1);
        setoran_1.setLayout(setoran_1Layout);
        setoran_1Layout.setHorizontalGroup(
            setoran_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_setoran_1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
        );
        setoran_1Layout.setVerticalGroup(
            setoran_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_setoran_1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_a8Layout = new javax.swing.GroupLayout(panel_a8);
        panel_a8.setLayout(panel_a8Layout);
        panel_a8Layout.setHorizontalGroup(
            panel_a8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(setoran_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_a8Layout.setVerticalGroup(
            panel_a8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(setoran_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panel_a7.add(panel_a8);

        nomor_setoran_1.setBackground(new java.awt.Color(255, 255, 153));
        nomor_setoran_1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        label_nomor_setoran_1.setFont(new java.awt.Font("Cambria Math", 1, 75)); // NOI18N
        label_nomor_setoran_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_nomor_setoran_1.setText("0000");

        javax.swing.GroupLayout nomor_setoran_1Layout = new javax.swing.GroupLayout(nomor_setoran_1);
        nomor_setoran_1.setLayout(nomor_setoran_1Layout);
        nomor_setoran_1Layout.setHorizontalGroup(
            nomor_setoran_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_nomor_setoran_1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
        );
        nomor_setoran_1Layout.setVerticalGroup(
            nomor_setoran_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_nomor_setoran_1, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_a9Layout = new javax.swing.GroupLayout(panel_a9);
        panel_a9.setLayout(panel_a9Layout);
        panel_a9Layout.setHorizontalGroup(
            panel_a9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nomor_setoran_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_a9Layout.setVerticalGroup(
            panel_a9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nomor_setoran_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panel_a7.add(panel_a9);

        panel_a10.setPreferredSize(new java.awt.Dimension(268, 35));

        tabungan_1.setBackground(new java.awt.Color(153, 255, 153));
        tabungan_1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        label_tabungan_1.setFont(new java.awt.Font("Cambria Math", 1, 30)); // NOI18N
        label_tabungan_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_tabungan_1.setText("TABUNGAN");

        javax.swing.GroupLayout tabungan_1Layout = new javax.swing.GroupLayout(tabungan_1);
        tabungan_1.setLayout(tabungan_1Layout);
        tabungan_1Layout.setHorizontalGroup(
            tabungan_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_tabungan_1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
        );
        tabungan_1Layout.setVerticalGroup(
            tabungan_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_tabungan_1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_a10Layout = new javax.swing.GroupLayout(panel_a10);
        panel_a10.setLayout(panel_a10Layout);
        panel_a10Layout.setHorizontalGroup(
            panel_a10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabungan_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_a10Layout.setVerticalGroup(
            panel_a10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabungan_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panel_a7.add(panel_a10);

        nomor_tabungan_1.setBackground(new java.awt.Color(153, 255, 153));
        nomor_tabungan_1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        label_nomor_tabungan_1.setFont(new java.awt.Font("Cambria Math", 1, 75)); // NOI18N
        label_nomor_tabungan_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_nomor_tabungan_1.setText("0000");

        javax.swing.GroupLayout nomor_tabungan_1Layout = new javax.swing.GroupLayout(nomor_tabungan_1);
        nomor_tabungan_1.setLayout(nomor_tabungan_1Layout);
        nomor_tabungan_1Layout.setHorizontalGroup(
            nomor_tabungan_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_nomor_tabungan_1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
        );
        nomor_tabungan_1Layout.setVerticalGroup(
            nomor_tabungan_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_nomor_tabungan_1, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_a11Layout = new javax.swing.GroupLayout(panel_a11);
        panel_a11.setLayout(panel_a11Layout);
        panel_a11Layout.setHorizontalGroup(
            panel_a11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nomor_tabungan_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_a11Layout.setVerticalGroup(
            panel_a11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nomor_tabungan_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panel_a7.add(panel_a11);

        panel_a12.setPreferredSize(new java.awt.Dimension(268, 35));

        kasir_1.setBackground(new java.awt.Color(255, 153, 255));
        kasir_1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        label_kasir_1.setFont(new java.awt.Font("Cambria Math", 1, 30)); // NOI18N
        label_kasir_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_kasir_1.setText("KASIR");

        javax.swing.GroupLayout kasir_1Layout = new javax.swing.GroupLayout(kasir_1);
        kasir_1.setLayout(kasir_1Layout);
        kasir_1Layout.setHorizontalGroup(
            kasir_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_kasir_1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
        );
        kasir_1Layout.setVerticalGroup(
            kasir_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_kasir_1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_a12Layout = new javax.swing.GroupLayout(panel_a12);
        panel_a12.setLayout(panel_a12Layout);
        panel_a12Layout.setHorizontalGroup(
            panel_a12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kasir_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_a12Layout.setVerticalGroup(
            panel_a12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kasir_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panel_a7.add(panel_a12);

        nomor_kasir_1.setBackground(new java.awt.Color(255, 153, 255));
        nomor_kasir_1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        label_nomor_kasir_1.setFont(new java.awt.Font("Cambria Math", 1, 75)); // NOI18N
        label_nomor_kasir_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_nomor_kasir_1.setText("0000");

        javax.swing.GroupLayout nomor_kasir_1Layout = new javax.swing.GroupLayout(nomor_kasir_1);
        nomor_kasir_1.setLayout(nomor_kasir_1Layout);
        nomor_kasir_1Layout.setHorizontalGroup(
            nomor_kasir_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_nomor_kasir_1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
        );
        nomor_kasir_1Layout.setVerticalGroup(
            nomor_kasir_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_nomor_kasir_1, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_a13Layout = new javax.swing.GroupLayout(panel_a13);
        panel_a13.setLayout(panel_a13Layout);
        panel_a13Layout.setHorizontalGroup(
            panel_a13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nomor_kasir_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_a13Layout.setVerticalGroup(
            panel_a13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nomor_kasir_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panel_a7.add(panel_a13);

        panel_a1.add(panel_a7, java.awt.BorderLayout.LINE_START);

        panel_b1.add(panel_a1, java.awt.BorderLayout.CENTER);

        panel_a4.setPreferredSize(new java.awt.Dimension(270, 734));
        panel_a4.setLayout(new javax.swing.BoxLayout(panel_a4, javax.swing.BoxLayout.PAGE_AXIS));

        nomor_01.setBackground(new java.awt.Color(255, 255, 0));
        nomor_01.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        label_nomor_01.setFont(new java.awt.Font("Cambria Math", 1, 60)); // NOI18N
        label_nomor_01.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_nomor_01.setText("0000");

        javax.swing.GroupLayout nomor_01Layout = new javax.swing.GroupLayout(nomor_01);
        nomor_01.setLayout(nomor_01Layout);
        nomor_01Layout.setHorizontalGroup(
            nomor_01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_nomor_01, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
        );
        nomor_01Layout.setVerticalGroup(
            nomor_01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_nomor_01, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        meja_01.setBackground(new java.awt.Color(0, 255, 0));
        meja_01.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        label_meja_01.setFont(new java.awt.Font("Cambria Math", 1, 60)); // NOI18N
        label_meja_01.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_meja_01.setText("01");

        javax.swing.GroupLayout meja_01Layout = new javax.swing.GroupLayout(meja_01);
        meja_01.setLayout(meja_01Layout);
        meja_01Layout.setHorizontalGroup(
            meja_01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_meja_01, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
        );
        meja_01Layout.setVerticalGroup(
            meja_01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_meja_01, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_a14Layout = new javax.swing.GroupLayout(panel_a14);
        panel_a14.setLayout(panel_a14Layout);
        panel_a14Layout.setHorizontalGroup(
            panel_a14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_a14Layout.createSequentialGroup()
                .addComponent(nomor_01, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(meja_01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel_a14Layout.setVerticalGroup(
            panel_a14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(meja_01, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(nomor_01, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panel_a4.add(panel_a14);

        nomor_02.setBackground(new java.awt.Color(255, 255, 0));
        nomor_02.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        label_nomor_02.setFont(new java.awt.Font("Cambria Math", 1, 60)); // NOI18N
        label_nomor_02.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_nomor_02.setText("0000");

        javax.swing.GroupLayout nomor_02Layout = new javax.swing.GroupLayout(nomor_02);
        nomor_02.setLayout(nomor_02Layout);
        nomor_02Layout.setHorizontalGroup(
            nomor_02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_nomor_02, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
        );
        nomor_02Layout.setVerticalGroup(
            nomor_02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_nomor_02, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        meja_02.setBackground(new java.awt.Color(0, 255, 0));
        meja_02.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        label_meja_02.setFont(new java.awt.Font("Cambria Math", 1, 60)); // NOI18N
        label_meja_02.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_meja_02.setText("02");

        javax.swing.GroupLayout meja_02Layout = new javax.swing.GroupLayout(meja_02);
        meja_02.setLayout(meja_02Layout);
        meja_02Layout.setHorizontalGroup(
            meja_02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_meja_02, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
        );
        meja_02Layout.setVerticalGroup(
            meja_02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_meja_02, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_a15Layout = new javax.swing.GroupLayout(panel_a15);
        panel_a15.setLayout(panel_a15Layout);
        panel_a15Layout.setHorizontalGroup(
            panel_a15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_a15Layout.createSequentialGroup()
                .addComponent(nomor_02, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(meja_02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel_a15Layout.setVerticalGroup(
            panel_a15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(meja_02, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(nomor_02, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panel_a4.add(panel_a15);

        nomor_03.setBackground(new java.awt.Color(255, 255, 0));
        nomor_03.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        label_nomor_03.setFont(new java.awt.Font("Cambria Math", 1, 60)); // NOI18N
        label_nomor_03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_nomor_03.setText("0000");

        javax.swing.GroupLayout nomor_03Layout = new javax.swing.GroupLayout(nomor_03);
        nomor_03.setLayout(nomor_03Layout);
        nomor_03Layout.setHorizontalGroup(
            nomor_03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_nomor_03, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
        );
        nomor_03Layout.setVerticalGroup(
            nomor_03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_nomor_03, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        meja_03.setBackground(new java.awt.Color(0, 255, 0));
        meja_03.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        label_meja_03.setFont(new java.awt.Font("Cambria Math", 1, 60)); // NOI18N
        label_meja_03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_meja_03.setText("03");

        javax.swing.GroupLayout meja_03Layout = new javax.swing.GroupLayout(meja_03);
        meja_03.setLayout(meja_03Layout);
        meja_03Layout.setHorizontalGroup(
            meja_03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_meja_03, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
        );
        meja_03Layout.setVerticalGroup(
            meja_03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_meja_03, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_a16Layout = new javax.swing.GroupLayout(panel_a16);
        panel_a16.setLayout(panel_a16Layout);
        panel_a16Layout.setHorizontalGroup(
            panel_a16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_a16Layout.createSequentialGroup()
                .addComponent(nomor_03, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(meja_03, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel_a16Layout.setVerticalGroup(
            panel_a16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(meja_03, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(nomor_03, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panel_a4.add(panel_a16);

        nomor_04.setBackground(new java.awt.Color(255, 255, 0));
        nomor_04.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        label_nomor_04.setFont(new java.awt.Font("Cambria Math", 1, 60)); // NOI18N
        label_nomor_04.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_nomor_04.setText("0000");

        javax.swing.GroupLayout nomor_04Layout = new javax.swing.GroupLayout(nomor_04);
        nomor_04.setLayout(nomor_04Layout);
        nomor_04Layout.setHorizontalGroup(
            nomor_04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_nomor_04, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
        );
        nomor_04Layout.setVerticalGroup(
            nomor_04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_nomor_04, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        meja_04.setBackground(new java.awt.Color(0, 255, 0));
        meja_04.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        label_meja_04.setFont(new java.awt.Font("Cambria Math", 1, 60)); // NOI18N
        label_meja_04.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_meja_04.setText("04");

        javax.swing.GroupLayout meja_04Layout = new javax.swing.GroupLayout(meja_04);
        meja_04.setLayout(meja_04Layout);
        meja_04Layout.setHorizontalGroup(
            meja_04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_meja_04, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
        );
        meja_04Layout.setVerticalGroup(
            meja_04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_meja_04, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_a17Layout = new javax.swing.GroupLayout(panel_a17);
        panel_a17.setLayout(panel_a17Layout);
        panel_a17Layout.setHorizontalGroup(
            panel_a17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_a17Layout.createSequentialGroup()
                .addComponent(nomor_04, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(meja_04, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel_a17Layout.setVerticalGroup(
            panel_a17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(meja_04, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(nomor_04, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panel_a4.add(panel_a17);

        nomor_05.setBackground(new java.awt.Color(255, 255, 0));
        nomor_05.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        label_nomor_05.setFont(new java.awt.Font("Cambria Math", 1, 60)); // NOI18N
        label_nomor_05.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_nomor_05.setText("0000");

        javax.swing.GroupLayout nomor_05Layout = new javax.swing.GroupLayout(nomor_05);
        nomor_05.setLayout(nomor_05Layout);
        nomor_05Layout.setHorizontalGroup(
            nomor_05Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_nomor_05, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
        );
        nomor_05Layout.setVerticalGroup(
            nomor_05Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_nomor_05, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        meja_05.setBackground(new java.awt.Color(0, 255, 0));
        meja_05.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        label_meja_05.setFont(new java.awt.Font("Cambria Math", 1, 60)); // NOI18N
        label_meja_05.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_meja_05.setText("05");

        javax.swing.GroupLayout meja_05Layout = new javax.swing.GroupLayout(meja_05);
        meja_05.setLayout(meja_05Layout);
        meja_05Layout.setHorizontalGroup(
            meja_05Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_meja_05, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
        );
        meja_05Layout.setVerticalGroup(
            meja_05Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_meja_05, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_a18Layout = new javax.swing.GroupLayout(panel_a18);
        panel_a18.setLayout(panel_a18Layout);
        panel_a18Layout.setHorizontalGroup(
            panel_a18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_a18Layout.createSequentialGroup()
                .addComponent(nomor_05, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(meja_05, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel_a18Layout.setVerticalGroup(
            panel_a18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(meja_05, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(nomor_05, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panel_a4.add(panel_a18);

        nomor_06.setBackground(new java.awt.Color(255, 255, 0));
        nomor_06.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        label_nomor_06.setFont(new java.awt.Font("Cambria Math", 1, 60)); // NOI18N
        label_nomor_06.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_nomor_06.setText("0000");

        javax.swing.GroupLayout nomor_06Layout = new javax.swing.GroupLayout(nomor_06);
        nomor_06.setLayout(nomor_06Layout);
        nomor_06Layout.setHorizontalGroup(
            nomor_06Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_nomor_06, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
        );
        nomor_06Layout.setVerticalGroup(
            nomor_06Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_nomor_06, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        meja_06.setBackground(new java.awt.Color(0, 255, 0));
        meja_06.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        label_meja_06.setFont(new java.awt.Font("Cambria Math", 1, 60)); // NOI18N
        label_meja_06.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_meja_06.setText("06");

        javax.swing.GroupLayout meja_06Layout = new javax.swing.GroupLayout(meja_06);
        meja_06.setLayout(meja_06Layout);
        meja_06Layout.setHorizontalGroup(
            meja_06Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_meja_06, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
        );
        meja_06Layout.setVerticalGroup(
            meja_06Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_meja_06, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_a19Layout = new javax.swing.GroupLayout(panel_a19);
        panel_a19.setLayout(panel_a19Layout);
        panel_a19Layout.setHorizontalGroup(
            panel_a19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_a19Layout.createSequentialGroup()
                .addComponent(nomor_06, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(meja_06, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel_a19Layout.setVerticalGroup(
            panel_a19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(meja_06, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(nomor_06, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panel_a4.add(panel_a19);

        nomor_07.setBackground(new java.awt.Color(255, 255, 0));
        nomor_07.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        label_nomor_07.setFont(new java.awt.Font("Cambria Math", 1, 60)); // NOI18N
        label_nomor_07.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_nomor_07.setText("0000");

        javax.swing.GroupLayout nomor_07Layout = new javax.swing.GroupLayout(nomor_07);
        nomor_07.setLayout(nomor_07Layout);
        nomor_07Layout.setHorizontalGroup(
            nomor_07Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_nomor_07, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
        );
        nomor_07Layout.setVerticalGroup(
            nomor_07Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_nomor_07, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        meja_07.setBackground(new java.awt.Color(0, 255, 0));
        meja_07.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        label_meja_07.setFont(new java.awt.Font("Cambria Math", 1, 60)); // NOI18N
        label_meja_07.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_meja_07.setText("07");

        javax.swing.GroupLayout meja_07Layout = new javax.swing.GroupLayout(meja_07);
        meja_07.setLayout(meja_07Layout);
        meja_07Layout.setHorizontalGroup(
            meja_07Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_meja_07, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
        );
        meja_07Layout.setVerticalGroup(
            meja_07Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_meja_07, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_a20Layout = new javax.swing.GroupLayout(panel_a20);
        panel_a20.setLayout(panel_a20Layout);
        panel_a20Layout.setHorizontalGroup(
            panel_a20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_a20Layout.createSequentialGroup()
                .addComponent(nomor_07, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(meja_07, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel_a20Layout.setVerticalGroup(
            panel_a20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(meja_07, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(nomor_07, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panel_a4.add(panel_a20);

        panel_b1.add(panel_a4, java.awt.BorderLayout.LINE_END);

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
                .addComponent(panel_b1, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
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
        String id_display = lda.port1(), hostname = null, status = "0";
        if ("Mulai".equals(mulai)) {
            try {
                ip = InetAddress.getLocalHost();
                hostname = "'" + ip.getHostAddress() + "'";
                status = String.valueOf(1);
            } catch (UnknownHostException ex) {
                Logger.getLogger(ui_display_one_change.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(ui_display_one_change.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ui_display_one_change.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ui_display_one_change.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ui_display_one_change.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ui_display_one_change().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel data_antrian_1;
    private template.desktop desktop1;
    private template.desktop desktop_1;
    private javax.swing.JLabel image_1;
    private javax.swing.JLabel jLabel1;
    private template.panel_b kasir_1;
    private javax.swing.JLabel label_kasir_1;
    private javax.swing.JLabel label_meja_01;
    private javax.swing.JLabel label_meja_02;
    private javax.swing.JLabel label_meja_03;
    private javax.swing.JLabel label_meja_04;
    private javax.swing.JLabel label_meja_05;
    private javax.swing.JLabel label_meja_06;
    private javax.swing.JLabel label_meja_07;
    private javax.swing.JLabel label_nomor_01;
    private javax.swing.JLabel label_nomor_02;
    private javax.swing.JLabel label_nomor_03;
    private javax.swing.JLabel label_nomor_04;
    private javax.swing.JLabel label_nomor_05;
    private javax.swing.JLabel label_nomor_06;
    private javax.swing.JLabel label_nomor_07;
    private javax.swing.JLabel label_nomor_kasir_1;
    private javax.swing.JLabel label_nomor_setoran_1;
    private javax.swing.JLabel label_nomor_spp_1;
    private javax.swing.JLabel label_nomor_tabungan_1;
    private javax.swing.JLabel label_setoran_1;
    private javax.swing.JLabel label_spp_1;
    private javax.swing.JLabel label_tabungan_1;
    private template.logo_srv logo_srv1;
    private template.panel_b meja_01;
    private template.panel_b meja_02;
    private template.panel_b meja_03;
    private template.panel_b meja_04;
    private template.panel_b meja_05;
    private template.panel_b meja_06;
    private template.panel_b meja_07;
    private template.panel_b nomor_01;
    private template.panel_b nomor_02;
    private template.panel_b nomor_03;
    private template.panel_b nomor_04;
    private template.panel_b nomor_05;
    private template.panel_b nomor_06;
    private template.panel_b nomor_07;
    private template.panel_b nomor_kasir_1;
    private template.panel_b nomor_setoran_1;
    private template.panel_b nomor_spp_1;
    private template.panel_b nomor_tabungan_1;
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
    private template.panel_b setoran_1;
    private template.panel_b spp_1;
    private template.panel_b tabungan_1;
    // End of variables declaration//GEN-END:variables
}
