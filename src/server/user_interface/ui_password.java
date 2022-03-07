/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.user_interface;
/**
 *
 * @author user
 */
public class ui_password extends javax.swing.JDialog {

    /**
     * Creates new form ui_password
     */
    
    private final ui_help uh;
    
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public ui_password(ui_help uh) {
        initComponents();
        setLocationRelativeTo(null);
        this.setModal(true);
        /*BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
        this.getContentPane().setCursor(blankCursor);*/
        this.uh = uh;
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
        password = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("AccessCode v.19");
        setType(java.awt.Window.Type.UTILITY);

        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Masukkan Kode Akses");

        javax.swing.GroupLayout frame1Layout = new javax.swing.GroupLayout(frame1);
        frame1.setLayout(frame1Layout);
        frame1Layout.setHorizontalGroup(
            frame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(frame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(password)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
                .addContainerGap())
        );
        frame1Layout.setVerticalGroup(
            frame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    @SuppressWarnings("static-access")
    private void passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            if (!password.getText().isEmpty()) {
                String pswd = password.getText();
                if (pswd.equals("sbw55jaya")) {
                    this.dispose();
                    uh.setVisible(true);
                }
            }
        }
    }//GEN-LAST:event_passwordKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private template.frame frame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField password;
    // End of variables declaration//GEN-END:variables
}