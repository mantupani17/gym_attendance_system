package mypackage;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class Custfrm extends javax.swing.JFrame {

   Connection con;
   Statement stm;
   ResultSet rs,rs1,rs2;
   Vector row,col;
   int r;
    public Custfrm() throws SQLException {
       super("show details");
       initComponents();
       con=DriverManager.getConnection("jdbc:odbc:BDB", "mantu", "DEEPS");
        row=new Vector();
        col=new Vector();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void setField3()
    {
         row.clear();
        col.add("Serial No");
        col.add("Customer ID");
        col.add("Bill no");
        col.add("Name");
        col.add("Particular");
        col.add("Quantity");
        col.add("PCS");
        col.add("Unit/price");
        col.add("Total");
        col.add("Discount");
        col.add("Net");
    }
    public void displayData()
    {
        try{
            col.clear();
            setField3();
            int x=1;
            stm=con.createStatement();
            String sql="select * from PART_TAB";
            rs=stm.executeQuery(sql);
            while(rs.next())
            {
                Vector v=new Vector();
                v.add(x++);
                  v.add(rs.getString("CID"));
                  v.add(rs.getString("BID"));
                    v.add(rs.getString("CNAME"));
                    v.add(rs.getString("PARTI"));
                    v.add(rs.getString("QUAN"));
                    v.add(rs.getInt("PCS"));
                    v.add(rs.getDouble("UPRICE"));
                    v.add(rs.getDouble("TOT"));
                    v.add(rs.getDouble("DISC"));
                    v.add(rs.getDouble("NET"));
                    row.add(v);
            }
            jTable1.setModel(new DefaultTableModel(row,col));
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    public void setField()
    {
        
        row.clear();
        col.add("serial no");
        col.add("Bill no");
        col.add("Customer Name");
        col.add("Total Amount");
        col.add("Discount amount");
        col.add("Net Amount");
    }
    public void setField1()
    {
        row.clear();
        col.add("Serial no");
        col.add("Bill no");
        col.add("Date");
        col.add("Total Amount");
        col.add("Discount Amount");
        col.add("Net Amount");
    }
    public void viewData1()
    {
        try{
            col.clear();
            setField1();
            int x=1;
            stm=con.createStatement();
            String sql="select * from PART_TAB where CNAME='"+jTextField1.getText()+"'";
            rs=stm.executeQuery(sql);
            while(rs.next())
            {
                Vector v=new Vector();
                v.add(x++);
                String bid=rs.getString("BID");
                v.add(bid);
                rs1=con.createStatement().executeQuery("select * from BILL_TAB where BID='"+bid+"'");
                while(rs1.next())
                {
                v.add(rs1.getDate("BDATE"));
                //row.add(v);
                }
                v.add(rs.getDouble("TOT"));
                v.add(rs.getDouble("DISC"));
                v.add(rs.getDouble("NET"));
                row.add(v);
            }
            jTable1.setModel(new DefaultTableModel(row,col));
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
      public void setField2()
    {
        row.clear();
        col.add("Serial No");
        col.add("Customer ID");
        col.add("Name");
        col.add("Particular");
        col.add("Quantity");
        col.add("PCS");
        col.add("Unit/price");
        col.add("Total");
        col.add("Discount");
        col.add("Net");
       // col.add("Date");
    }
    public void viewData2()
    {
         try{
            col.clear();
            setField2();
            int x=1;
            stm=con.createStatement();
            String sql="select * from BILL_TAB where BDATE=#"+jTextField3.getText()+"#";
            rs=stm.executeQuery(sql);
            while(rs.next())
            {
                Vector v=new Vector();
                v.add(x++);
                String bid=rs.getString("BId");
                rs1=con.createStatement().executeQuery("select * from PART_TAB where BID='"+bid+"'");
                while(rs1.next()){
                    v.add(rs1.getString("CID"));
                    v.add(rs1.getString("CNAME"));
                    v.add(rs1.getString("PARTI"));
                    v.add(rs1.getString("QUAN"));
                    v.add(rs1.getInt("PCS"));
                    v.add(rs1.getDouble("UPRICE"));
                    v.add(rs1.getDouble("TOT"));
                    v.add(rs1.getDouble("DISC"));
                    v.add(rs1.getDouble("NET"));
                   
                }
                // v.add(rs.getDate("BDATE"));
                row.add(v);
            }
            jTable1.setModel(new DefaultTableModel(row,col));
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    public void viewData()//this method is used for show only the bill information and search throufh bill no
    {
        try{
            col.clear();
            setField();
            int x=1;
            stm=con.createStatement();
            String sql="select * from PART_TAB where BID='"+jTextField2.getText()+"'";
            rs=stm.executeQuery(sql);
            while(rs.next())
            {
                Vector v=new Vector();
                v.add(x++);
                String bid=rs.getString("BID");
                v.add(bid);
                //rs1=con.createStatement().executeQuery("select * from BILL_TAB where BID='"+bid+"'");
                
                v.add(rs.getString("CNAME"));
                v.add(rs.getDouble("TOT"));
                v.add(rs.getDouble("DISC"));
                v.add(rs.getDouble("NET"));
                row.add(v);
            }
            jTable1.setModel(new DefaultTableModel(row,col));
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 153, 255));

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Enter Name:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Enter Bill No:");

        jLabel3.setText("Enter Date:");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        jLabel4.setText("CUSTOMER BILLING INFORMATION");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51), 2));

        jLabel5.setForeground(new java.awt.Color(0, 51, 204));
        jLabel5.setText("REFRESH");
        jLabel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(255, 102, 51), new java.awt.Color(255, 204, 255), new java.awt.Color(255, 204, 255), new java.awt.Color(0, 255, 204)));
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(182, 182, 182)
                .addComponent(jLabel5)
                .addGap(49, 49, 49))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextField1)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1))
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2))
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
      viewData();
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
      viewData1();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
      viewData2();
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
      displayData();
    }//GEN-LAST:event_jLabel5MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws ClassNotFoundException {
       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
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
            java.util.logging.Logger.getLogger(Custfrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Custfrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Custfrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Custfrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    new Custfrm().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Custfrm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
