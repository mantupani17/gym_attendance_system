/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author mantu
 */
public class Showbillinfo extends javax.swing.JFrame {

Connection cn;
Statement stm,stm2;
ResultSet rs,rs2;
Vector row,col;
    public Showbillinfo() throws ClassNotFoundException {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        connection con1=new connection();
        cn=con1.con;
        viewData();
        viewData1();
        setResizable(false);
    }
    public void setcolData()
    {
        try{
        col=new Vector();
        row=new Vector();
        row.clear();
        col.add("Date");
        col.add("Name");
        col.add("Customer No");
        col.add("Amount");
        }
        catch(NullPointerException n)
        {
            JOptionPane.showMessageDialog(null, n.toString());
        }
    }
   public void viewData()
   {
       try{
           setcolData();
           stm=cn.createStatement();
           rs=stm.executeQuery("select * from DEPO_TAB");
           while(rs.next())
           {
               Vector v=new Vector();
               String cid;
               v.add(rs.getDate("PDATE"));
               cid=rs.getString("CID");
               rs2=cn.createStatement().executeQuery("select * from CUSTB_TAB where CID='"+cid+"'");
               while(rs2.next())
               {
                   v.add(rs2.getString("CNAME"));
               }
               v.add(cid);
               v.add(rs.getDouble("PAMNT"));
               row.add(v);
           }
           jTable2.setModel(new DefaultTableModel(row,col));
           stm.close();
          // rs2.close();
           rs.close();
       }catch(SQLException e)
       {
          // JOptionPane.showMessageDialog(null, e.toString());
       }
   }
   public void viewData1()
   {
      try{
           setcolData();
           stm=cn.createStatement();
           rs=stm.executeQuery("select * from DEB_TAB");
           while(rs.next())
           {
               Vector v=new Vector();
               String cid;
               v.add(rs.getDate("DDATE"));
               cid=rs.getString("CID");
               rs2=cn.createStatement().executeQuery("select * from CUSTB_TAB where CID='"+cid+"'");
               while(rs2.next())
               {
                   v.add(rs2.getString("CNAME"));
               }
               v.add(cid);
               v.add(rs.getDouble("DAMNT"));
               row.add(v);
           }
           jTable1.setModel(new DefaultTableModel(row,col));
       }catch(SQLException e)
       {
          // JOptionPane.showMessageDialog(null, e.toString());
       } 
   }
   public void search1()
   {
        try{
           setcolData();
           stm=cn.createStatement();
           rs=stm.executeQuery("select * from DEB_TAB where CID='"+jTextField1.getText()+"'");
           while(rs.next())
           {
               Vector v=new Vector();
               String cid;
               v.add(rs.getDate("DDATE"));
               cid=rs.getString("CID");
               rs2=cn.createStatement().executeQuery("select * from CUSTB_TAB where CID='"+cid+"'");
               while(rs2.next())
               {
                   v.add(rs2.getString("CNAME"));
               }
               v.add(cid);
               v.add(rs.getDouble("DAMNT"));
               row.add(v);
           }
           jTable1.setModel(new DefaultTableModel(row,col));
       }catch(SQLException e)
       {
          // JOptionPane.showMessageDialog(null, e.toString());
       } 
   }
   public void search2()
   {
         try{
           setcolData();
           stm=cn.createStatement();
           rs=stm.executeQuery("select * from DEPO_TAB where CID='"+jTextField1.getText()+"'");
           while(rs.next())
           {
               Vector v=new Vector();
               String cid;
               v.add(rs.getDate("PDATE"));
               cid=rs.getString("CID");
               rs2=cn.createStatement().executeQuery("select * from CUSTB_TAB where CID='"+cid+"'");
               while(rs2.next())
               {
                   v.add(rs2.getString("CNAME"));
               }
               v.add(cid);
               v.add(rs.getDouble("PAMNT"));
               row.add(v);
           }
           jTable2.setModel(new DefaultTableModel(row,col));
           stm.close();
           rs2.close();
           rs.close();
       }catch(SQLException e)
       {
          // JOptionPane.showMessageDialog(null, e.toString());
       }
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setText("DEPOSITE AND DEBIT INFORMATION OF A CUSTOMER");

        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setText("REFRESH");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(127, 127, 127)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel2.setText("DEBIT INFORMATION");

        jLabel3.setText("DEPOSITE INFORMATION");

        jLabel4.setText("ENTER CUSTOMER NO:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(204, 255, 204));
        jButton1.setText("Search Debit and Deposite Account of Customer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Delete ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(105, 105, 105))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(37, Short.MAX_VALUE))
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

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       int r;
       r=jTable1.getSelectedRow();
       jTextField1.setText(jTable1.getValueAt(r, 2).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
      search1();
      search2();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      int res=JOptionPane.showConfirmDialog(null, "What you want ,if you want to view deposite information of a customer then click yes otherwise click no?", "Show deposite and debit information ", JOptionPane.YES_NO_OPTION);
      if(res==JOptionPane.YES_OPTION)
      {
          search2();
      }
      else
      {
          search1();
      }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
       viewData();
       viewData1();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
       int r;
       r=jTable2.getSelectedRow();
       jTextField1.setText(jTable2.getValueAt(r, 2).toString());
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      int res=JOptionPane.showConfirmDialog(null, "Are you sure delete all the information about the Customer", "Delete Deposite and Debit information ", JOptionPane.YES_NO_OPTION);
        if(res==JOptionPane.YES_OPTION)
        {
            deleteData();
            deleteData1();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Delete Cancelled");
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    public void deleteData1()
    {
        try{
           stm=cn.createStatement();
          // stm2=cn.createStatement();
           String sql="delete from DEB_TAB where CID='"+jTextField1.getText()+"'";
           int x=stm.executeUpdate(sql);
           if(x>0)
           {
               JOptionPane.showMessageDialog(null, "delete Successfully");
           }
           else
           {
               JOptionPane.showMessageDialog(null, "The record doesn't exist");
           }
           stm.close();
           
       }catch(SQLException e)
       {
           JOptionPane.showMessageDialog(null, e.toString());
       }
    }
    public void deleteData()
    {
       
       try{
           stm=cn.createStatement();
          // stm2=cn.createStatement();
           String sql="delete from DEPO_TAB where CID='"+jTextField1.getText()+"'";
           int x=stm.executeUpdate(sql);
           if(x>0)
           {
               JOptionPane.showMessageDialog(null, "delete Successfully");
           }
           else
           {
               JOptionPane.showMessageDialog(null, "The record doesn't exist");
           }
           stm.close();
           
       }catch(SQLException e)
       {
           JOptionPane.showMessageDialog(null, e.toString());
       }
  
    }
    
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
            java.util.logging.Logger.getLogger(Showbillinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Showbillinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Showbillinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Showbillinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    new Showbillinfo().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Showbillinfo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
