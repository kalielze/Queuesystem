/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package display.user_interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import javax.swing.Timer;

/**
 *
 * @author user
 */
public class ui_number extends javax.swing.JInternalFrame {

    /**
     * Creates new form number_ui
     */
    public ui_number() {
        initComponents();
    }

    private final Calendar cal = Calendar.getInstance();
    private Timer t;

    @SuppressWarnings("Convert2Lambda")
    ActionListener taskPerformer = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            Date date_new = new Date();
            cal.setTime(date_new);
            if (cal.get(Calendar.SECOND) % 2 == 0) {
                jPanel1.setBackground(new java.awt.Color(255, 255, 255));
                kategori.setForeground(new java.awt.Color(0, 0, 0));
                info.setForeground(new java.awt.Color(0, 0, 0));
                nomor.setForeground(new java.awt.Color(0, 204, 0));
                meja.setForeground(new java.awt.Color(0, 204, 0));
            } else {
                jPanel1.setBackground(new java.awt.Color(0, 204, 0));
                kategori.setForeground(new java.awt.Color(255, 255, 0));
                info.setForeground(new java.awt.Color(255, 255, 0));
                nomor.setForeground(new java.awt.Color(255, 255, 255));
                meja.setForeground(new java.awt.Color(255, 255, 255));
            }
        }
    };

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        kategori = new javax.swing.JLabel();
        nomor = new javax.swing.JLabel();
        info = new javax.swing.JLabel();
        meja = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(0, 204, 0));

        kategori.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 55)); // NOI18N
        kategori.setForeground(new java.awt.Color(255, 255, 0));
        kategori.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kategori.setText("<html><center>ANTRIAN<br/>TABUNGAN</center></html>");
        kategori.setToolTipText("");

        nomor.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 105)); // NOI18N
        nomor.setForeground(new java.awt.Color(255, 255, 255));
        nomor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nomor.setText("1009");

        info.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 55)); // NOI18N
        info.setForeground(new java.awt.Color(255, 255, 0));
        info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info.setText("<html><center>KE MEJA<br/>INFORMASI</center></html>");

        meja.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 105)); // NOI18N
        meja.setForeground(new java.awt.Color(255, 255, 255));
        meja.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        meja.setText("1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kategori, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                    .addComponent(nomor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(info)
                    .addComponent(meja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(kategori, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomor)
                .addGap(15, 15, 15)
                .addComponent(info, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(meja)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void start_blink() {
        this.t = new Timer(1000, taskPerformer);
        t.start();
    }

    public void stop_blink() {
        t.stop();
        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        kategori.setForeground(new java.awt.Color(0, 0, 0));
        info.setForeground(new java.awt.Color(0, 0, 0));
        nomor.setForeground(new java.awt.Color(0, 204, 0));
        meja.setForeground(new java.awt.Color(0, 204, 0));
    }

    public void set_value(String kategori_, String nomor_, String meja_) {
        String data_nama[] = kategori_.split(" ");
        kategori.setText("<html><center>ANTRIAN<br/>" + data_nama[0] + "</center></html>");
        nomor.setText(nomor_);
        info.setText("<html><center>KE MEJA<br/>" + data_nama[1]+ "</center></html>");
        meja.setText(meja_);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel info;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel kategori;
    private javax.swing.JLabel meja;
    private javax.swing.JLabel nomor;
    // End of variables declaration//GEN-END:variables
}
