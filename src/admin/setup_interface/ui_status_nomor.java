/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.setup_interface;

import database.query_control.select.select_attribute;
import java.awt.Component;
import javax.swing.ImageIcon;

/**
 *
 * @author 15my15
 */
public class ui_status_nomor extends javax.swing.JDialog {

    /**
     * Creates new form ui_status_nomor
     */
    private final select_attribute sa;

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public ui_status_nomor(select_attribute sa, Component com) {
        initComponents();
        setLocationRelativeTo(com);
        this.setModal(true);
        ImageIcon ico = new ImageIcon((getClass().getResource("/image/IconDisplay.png")));
        setIconImage(ico.getImage());
        this.sa = sa;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frame1 = new template.frame();
        panel_b1 = new template.panel_b();
        jLabel1 = new javax.swing.JLabel();
        nomor = new javax.swing.JFormattedTextField();
        lihat = new javax.swing.JButton();
        panel_b2 = new template.panel_b();
        data_antrian = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("NomorAntrianStatus v.19");

        panel_b1.setBackground(new java.awt.Color(255, 255, 153));
        panel_b1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        jLabel1.setText("Nomor Antrian");

        try {
            nomor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        nomor.setText("0000");
        nomor.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        nomor.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        nomor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nomorFocusGained(evt);
            }
        });
        nomor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nomorKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nomorKeyTyped(evt);
            }
        });

        lihat.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        lihat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/View File.png"))); // NOI18N
        lihat.setText("Lihat");
        lihat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lihat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lihatActionPerformed(evt);
            }
        });
        lihat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lihatKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout panel_b1Layout = new javax.swing.GroupLayout(panel_b1);
        panel_b1.setLayout(panel_b1Layout);
        panel_b1Layout.setHorizontalGroup(
            panel_b1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_b1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nomor, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lihat)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_b1Layout.setVerticalGroup(
            panel_b1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_b1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_b1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nomor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lihat))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_b2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        data_antrian.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        data_antrian.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        data_antrian.setText("<html>\n<tr style='border-bottom:1pt'><td>Nomor Antrian</td><td>: -</td></tr>\n<tr style='border-bottom:1pt'><td>Kategori</td><td>: -</td></tr>\n<tr style='border-bottom:1pt'><td>Tanggal Antri</td><td>: -</td></tr>\n<tr style='border-bottom:1pt'><td>Jam Antri</td><td>: -</td></tr>\n<tr style='border-bottom:1pt'><td>Selesai Antri</td><td>: -</td></tr>\n<tr style='border-bottom:1pt'><td>Status Antrian</td><td>: -</td></tr>\n</html>");
        data_antrian.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout panel_b2Layout = new javax.swing.GroupLayout(panel_b2);
        panel_b2.setLayout(panel_b2Layout);
        panel_b2Layout.setHorizontalGroup(
            panel_b2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_b2Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(data_antrian)
                .addGap(3, 3, 3))
        );
        panel_b2Layout.setVerticalGroup(
            panel_b2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_b2Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(data_antrian, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout frame1Layout = new javax.swing.GroupLayout(frame1);
        frame1.setLayout(frame1Layout);
        frame1Layout.setHorizontalGroup(
            frame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frame1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(frame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel_b1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_b2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );
        frame1Layout.setVerticalGroup(
            frame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frame1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(panel_b1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_b2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(frame1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(frame1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nomorFocusGained
        nomor.setCaretPosition(0);
    }//GEN-LAST:event_nomorFocusGained

    @SuppressWarnings("static-access")
    private void nomorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomorKeyTyped
        if (!(evt.getKeyChar() == evt.VK_DELETE || evt.getKeyChar() == evt.VK_BACK_SPACE)) {
            if (nomor.getCaretPosition() == 3) {
                nomor.transferFocus();
            }
        }
    }//GEN-LAST:event_nomorKeyTyped

    @SuppressWarnings("static-access")
    private void nomorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomorKeyPressed
        if (evt.getKeyCode() == evt.VK_RIGHT) {
            if (nomor.getCaretPosition() == 4) {
                nomor.transferFocus();
            }
        }
        if (evt.getKeyCode() == evt.VK_DOWN) {
            nomor.transferFocus();
        }
        if (evt.getKeyCode() == evt.VK_LEFT) {
            if (nomor.getCaretPosition() == 0) {
                nomor.transferFocusBackward();
            }
        }
        if (evt.getKeyCode() == evt.VK_UP) {
            nomor.transferFocusBackward();
        }
        if (evt.getKeyCode() == evt.VK_ENTER) {
            if (nomor.getText().replace(" ", "") != null) {
                String nomor_antrian = nomor.getText();
                int id_antrian = sa.id_queue(nomor_antrian);
                sa.get_number_status(data_antrian, nomor.getText(), id_antrian);
            }
        }
    }//GEN-LAST:event_nomorKeyPressed

    private void lihatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lihatActionPerformed
        if (nomor.getText().replace(" ", "") != null) {
            String nomor_antrian = nomor.getText();
            int id_antrian = sa.id_queue(nomor_antrian);
            sa.get_number_status(data_antrian, nomor.getText(), id_antrian);
        }
    }//GEN-LAST:event_lihatActionPerformed

    @SuppressWarnings("static-access")
    private void lihatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lihatKeyPressed
        if (evt.getKeyCode() == evt.VK_RIGHT || evt.getKeyCode() == evt.VK_DOWN) {
            lihat.transferFocus();
        }
        if (evt.getKeyCode() == evt.VK_LEFT || evt.getKeyCode() == evt.VK_UP) {
            lihat.transferFocusBackward();
        }
        if (evt.getKeyCode() == evt.VK_ENTER) {
            if (nomor.getText().replace(" ", "") != null) {
                String nomor_antrian = nomor.getText();
                int id_antrian = sa.id_queue(nomor_antrian);
                sa.get_number_status(data_antrian, nomor.getText(), id_antrian);
            }
        }
    }//GEN-LAST:event_lihatKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel data_antrian;
    private template.frame frame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton lihat;
    private javax.swing.JFormattedTextField nomor;
    private template.panel_b panel_b1;
    private template.panel_b panel_b2;
    // End of variables declaration//GEN-END:variables
}
