/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.user_interface;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author user
 */
public class ui_loading extends javax.swing.JFrame {

    JFrame f;
    private final loading_run lr = new loading_run();
    
    /**
     * Creates new form ui_loading
     */
    @SuppressWarnings({"OverridableMethodCallInConstructor", "LeakingThisInConstructor", "CallToThreadStartDuringObjectConstruction"})
    public ui_loading() {
        initComponents();
        ImageIcon ico = new ImageIcon((getClass().getResource("/image/IconSBW.png")));
        setIconImage(ico.getImage());
        setLocationRelativeTo(null);
        f = this;
        Thread t = new Thread(lr);
        t.start();
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
        jLabel1 = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("loading");
        setAlwaysOnTop(true);
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Cambria Math", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("sedang proses loading ...");

        progressBar.setFont(new java.awt.Font("Cambria Math", 1, 11)); // NOI18N
        progressBar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        progressBar.setStringPainted(true);
        UIManager.put("nimbusOrange", new Color(255, 255, 102));

        desktop1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop1.setLayer(progressBar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktop1Layout = new javax.swing.GroupLayout(desktop1);
        desktop1.setLayout(desktop1Layout);
        desktop1Layout.setHorizontalGroup(
            desktop1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktop1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(desktop1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                .addContainerGap())
        );
        desktop1Layout.setVerticalGroup(
            desktop1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktop1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private class loading_run implements Runnable {

        Thread t;
        
        public void loading_run() {
        }

        @Override
        @SuppressWarnings({"static-access", "CallToThreadStopSuspendOrResumeManager"})
        public void run() {
            for (int i = 0; i <= 100; i++) {
                try {
                    progressBar.setValue(i);
                    if (i == 99) {
                        new ui_server().setVisible(true);
                        f.dispose();
                    }
                    t.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ui_loading.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
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
            java.util.logging.Logger.getLogger(ui_loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ui_loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ui_loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ui_loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ui_loading().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private template.desktop desktop1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JProgressBar progressBar;
    // End of variables declaration//GEN-END:variables
}
