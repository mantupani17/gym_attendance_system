/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gymattendence;
import java.awt.Toolkit;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mantu
 */
public class DatabaseUserLogin extends javax.swing.JFrame {
Connection con=null;
String uname=null;
String pass=null;
String key="PRODUCTMANTU";
public DatabaseUserLogin() throws ClassNotFoundException {
        super("Database User Form...!");
        initComponents();
        setResizable(false);
        Class.forName("oracle.jdbc.OracleDriver");
        setBounds(150, 100, 388, 580);
        setIconImage(Toolkit.getDefaultToolkit().getImage("icon1.png"));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(383, 580));
        getContentPane().setLayout(null);

        jButton1.setBackground(new java.awt.Color(54, 146, 54));
        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(140, 270, 90, 40);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(130, 180, 190, 30);
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(130, 220, 190, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banner.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 380, 550);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       try{
           String username=jTextField1.getText();
           String password=new String(jPasswordField1.getPassword());
           String connect="jdbc:oracle:thin:@localhost:1521:XE";
           uname=username;
           pass=password;
           con=DriverManager.getConnection(connect, username, password);
           if(con!=null)
           {
               /**/
               JOptionPane.showMessageDialog(rootPane, "Connected...!");
               Homepage hp=new Homepage();
               hp.setVisible(rootPaneCheckingEnabled);
               hp.con=con;
               hp.setWallpaper(uname, pass);
               //hp.checkProduct();
               this.dispose();
                       
           }
           else
           {
               JOptionPane.showMessageDialog(rootPane, "not connected");
           }
       }catch(Exception e){
           JOptionPane.showMessageDialog(rootPane, e.toString());
       }
    }//GEN-LAST:event_jButton1ActionPerformed
   
        
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DatabaseUserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DatabaseUserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DatabaseUserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DatabaseUserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    new DatabaseUserLogin().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DatabaseUserLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JPasswordField jPasswordField1;
    public javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
