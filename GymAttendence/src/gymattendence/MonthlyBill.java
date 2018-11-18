/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gymattendence;


import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mantu
 */
public class MonthlyBill extends javax.swing.JFrame implements Printable{
String username,password,mnth;
Connection con;
int dd,mm,yy;
Vector row,col;
GregorianCalendar cal;
testHint th;
    public MonthlyBill() throws ClassNotFoundException {
        super("Monthly Paid Form...!");
        initComponents();
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(73,68,124));
        Class.forName("oracle.jdbc.OracleDriver");
        cal=new GregorianCalendar();
        dd=cal.get(GregorianCalendar.DAY_OF_MONTH);
        mm=cal.get(GregorianCalendar.MONTH);
        yy=cal.get(GregorianCalendar.YEAR);
        
        switch(mm){
             case 0:mnth="jan";
                break;
            case 1:mnth="feb";
                break;
            case 2:mnth="mar";
                break;
            case 3:mnth="apr";
                break;
            case 4:mnth="may";
                break;
            case 5:mnth="jun";
                break;
            case 6:mnth="jul";
                break;
            case 7:mnth="aug";
                break;
            case 8:mnth="sep";
                break;
            case 9:mnth="oct";
                break;
            case 10:mnth="nov";
                break;
            case 11:mnth="dec";
                break;
            default:mnth=null;
                break;
        }
        jTextField5.setText(dd+"-"+mnth+"-"+yy);
        setBounds(150, 100, getWidth(), getHeight());
    }
    public void setGym()//set gym name
    {
        try{
            String sql="select * from ADV_TAB where id=1";
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery(sql);
            String adder,mno;
            if(rs.next())
            {
                jLabel9.setText(rs.getString("GNAME"));
                adder=rs.getString("Adder");
                mno=rs.getString("MNO");
                jLabel11.setText(adder+" , "+mno);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }
    public void setColumn()//Set column values
    {
        try{
           row=new Vector();
           col=new Vector();
           row.clear();
           col.add("Sr/no");
           col.add("BID");
           col.add("MID");
           col.add("NAME");
           col.add("ADDRESS");
           col.add("MOBILE");
           col.add("DOE");
           col.add("RUPEES");
           
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }
    public void viewAll()//this method is used to display all Monthly paid information
    {
         try{
            setColumn();
            //String mid=(String)jComboBox1.getSelectedItem();
            String sql="select * from MONTHLY_PAID_TAB ";
            Vector v;
            int x=1;
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery(sql);
            while(rs.next())
            {
                v=new Vector();
                v.add(x++);
                v.add(rs.getString("BID"));
                v.add(rs.getString("MID"));
                v.add(rs.getString("MNAME"));
                v.add(rs.getString("ADDER"));
                v.add(rs.getString("MNO"));
                v.add(rs.getDate("DOP").toString());
                v.add(rs.getInt("RS"));
                row.add(v);
            }
            jTable1.setModel(new DefaultTableModel(row, col));
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }
    public void searchDate()//this method is used to search the records using Date
    {
        try{
            setColumn();
            String mid=jTextField5.getText();
            String sql="select * from MONTHLY_PAID_TAB where DOP='"+mid+"'";
            Vector v;
            int x=1;
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery(sql);
            while(rs.next())
            {
                v=new Vector();
                v.add(x++);
                v.add(rs.getString("BID"));
                v.add(rs.getString("MID"));
                v.add(rs.getString("MNAME"));
                v.add(rs.getString("ADDER"));
                v.add(rs.getString("MNO"));
                v.add(rs.getDate("DOP").toString());
                v.add(rs.getInt("RS"));
                row.add(v);
            }
            jTable1.setModel(new DefaultTableModel(row, col));
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }
    public void viewPaid()//this method is used to view the data of the particular member's monthly pid
    {
        try{
            setColumn();
            String mid=(String)jComboBox1.getSelectedItem();
            String sql="select * from MONTHLY_PAID_TAB where MID='"+mid+"'";
            Vector v;
            int x=1;
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery(sql);
            while(rs.next())
            {
                v=new Vector();
                v.add(x++);
                v.add(rs.getString("BID"));
                v.add(rs.getString("MID"));
                v.add(rs.getString("MNAME"));
                v.add(rs.getString("ADDER"));
                v.add(rs.getString("MNO"));
                v.add(rs.getDate("DOP").toString());
                v.add(rs.getInt("RS"));
                row.add(v);
            }
            jTable1.setModel(new DefaultTableModel(row, col));
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }
    public void showPaid(String bid)//this method is used to show the particular bill
    {
        try{
           
            String sql="select * from MONTHLY_PAID_TAB where BID='"+bid+"'";
            Statement stm=con.createStatement();
            ResultSet res=stm.executeQuery(sql);
            jTextField4.setText(bid);
            if(res.next())
            {
                jTextField1.setText(res.getString("MNAME"));
                jTextField2.setText(res.getString("ADDER"));
                jTextField3.setText(res.getString("MNO"));
                
                      int d,m,y;
        String mn=null;
       String dt=String.valueOf(res.getDate("DOP").toString());
       d=Integer.parseInt(dt.substring(8,10));
       m=Integer.parseInt(dt.substring(5,7));
       y=Integer.parseInt(dt.substring(0, 4));
       switch(m-1)
        {
            case 0:mn="jan";
                break;
            case 1:mn="feb";
                break;
            case 2:mn="mar";
                break;
            case 3:mn="apr";
                break;
            case 4:mn="may";
                break;
            case 5:mn="jun";
                break;
            case 6:mn="jul";
                break;
            case 7:mn="aug";
                break;
            case 8:mn="sep";
                break;
            case 9:mn="oct";
                break;
            case 10:mn="nov";
                break;
            case 11:mn="dec";
                break;
            default:mn=null;
                break;
        }
       String date=d+"-"+mn+"-"+y;
       jTextField5.setText(date);
                jTextField6.setText(String.valueOf(res.getInt("RS")));
                jComboBox1.setSelectedItem(res.getString("MID").toString());
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "The Record is not Exist...!");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }
    public void getconn(String uname,String pass)//get a connection
    {
        try{
            username=uname;
            password=pass;
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", username, password);
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }
    public void setPaid()//this method is used to paid the member monthly fees
    {
        try{
            String bid,mid,mname,adder,mno,doe;
            int amnt;
            bid=jTextField4.getText();
            mname=jTextField1.getText();
            mid=(String)jComboBox1.getSelectedItem();
            adder=jTextField2.getText();
            mno=jTextField3.getText();
            doe=jTextField5.getText();
            amnt=Integer.parseInt(jTextField6.getText());
            String sql="insert into MONTHLY_PAID_TAB values('"+bid+"','"+mid+"','"+mname+"','"+adder+"','"+mno+"','"+doe+"',"+amnt+")";
            Statement stm=con.createStatement();
            stm.execute(sql);
            JOptionPane.showMessageDialog(rootPane, "Paid successfully...!");
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }
    public void getBillID()//this method is used to get the bill id;
    {
        try{
            //String billno="b";
            String sql="select count(*) from MONTHLY_PAID_TAB";
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery(sql);
            if(rs.next())
            {
                int x=rs.getInt(1);
                jTextField4.setText("b"+x);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }
    public void removePaid()//this method is used to remove the record
    {
         int res=JOptionPane.showConfirmDialog(rootPane, "Are you sure to Remove the record ?", "Remove Record", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
         if(res==JOptionPane.YES_OPTION)
            {
            
       try{
            String bid;
            bid=jTextField4.getText();
            String sql="delete from MONTHLY_PAID_TAB where BID='"+bid+"'";
            Statement stm=con.createStatement();
            int x=stm.executeUpdate(sql);
           if(x>0)
           {
               JOptionPane.showMessageDialog(rootPane, "Record Removed...!");
           }
           else
           {
              JOptionPane.showMessageDialog(rootPane, "Record not Found...!"); 
           }
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
           
            }
         else
         {
             JOptionPane.showMessageDialog(rootPane, "Remove cancelled...!", "Remove Record", JOptionPane.ERROR_MESSAGE);
         }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jTextField6 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                windowOpen(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(73, 68, 124));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gymattendence/pp.png"))); // NOI18N
        jLabel8.setToolTipText("Show the image");
        jLabel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Profile Picture", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Arial", 0, 12))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel6.setText("Date:");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel4.setText("Mobile No:");

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel7.setText("Paid Amount:");

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel1.setText("Choose Member ID:");

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jTextField5.setToolTipText("Enter to search the record using date");
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel3.setText("Address:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel2.setText("Name:");

        jComboBox1.setEditable(true);
        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel5.setText("Bill no:");

        jButton7.setText("Print");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel9.setText("Gym Name");

        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1)
                            .addComponent(jTextField2)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(36, 36, 36)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTable1.setBackground(new java.awt.Color(73, 68, 124));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mouseClick(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Handshake, Handshakegym@gmail.com,9861873099,Developed by: MDP softwares,mantupani17@gmail.com, mobile NO: 7873160006");
        jLabel10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 51, 51), new java.awt.Color(255, 51, 51), new java.awt.Color(0, 255, 255), new java.awt.Color(255, 255, 51)));

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton6.setMnemonic('E');
        jButton6.setText("Exit");
        jButton6.setToolTipText("Exit the form");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton2.setMnemonic('R');
        jButton2.setText("Print");
        jButton2.setToolTipText("Print the information");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton1.setMnemonic('P');
        jButton1.setText("Paid");
        jButton1.setToolTipText("Paid the monthly information");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton5.setMnemonic('R');
        jButton5.setText("Remove");
        jButton5.setToolTipText("Remove the selected record");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton4.setMnemonic('C');
        jButton4.setText("Cancel");
        jButton4.setToolTipText("Cancel the transcation");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton3.setMnemonic('U');
        jButton3.setText("Update");
        jButton3.setToolTipText("Update the information");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton8.setMnemonic('E');
        jButton8.setText("Search");
        jButton8.setToolTipText("Exit the form");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(28, 28, 28)
                .addComponent(jButton4)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addGap(31, 31, 31)
                .addComponent(jButton1)
                .addGap(28, 28, 28)
                .addComponent(jButton2)
                .addGap(26, 26, 26)
                .addComponent(jButton8)
                .addGap(29, 29, 29)
                .addComponent(jButton6)
                .addGap(104, 104, 104))
            .addComponent(jScrollPane1)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jButton5)
                    .addComponent(jButton4)
                    .addComponent(jButton3)
                    .addComponent(jButton8))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void selectMember()//this method is used to select the data about a particular record
    {
        try{
            String mid=(String)jComboBox1.getSelectedItem();
            String sql="select MNAME,ADDER,MNO,IMG_PATH from MEMBERINFO_TAB where MID='"+mid+"'";
            Statement stm=con.createStatement();
            ResultSet res=stm.executeQuery(sql);
            String path=null;
            if(res.next())
            {
                jTextField1.setText(res.getString("MNAME"));
                jTextField2.setText(res.getString("ADDER"));
                jTextField3.setText(res.getString("MNO"));
                path=res.getString("IMG_PATH");
            }
            File file=new File(path);
          Image img=null;
          img=ImageIO.read(file);
          jLabel8.setIcon(new ImageIcon(img));
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }
    public void selectMEMID()//this method is used to select the member ID from the membership entry table
    {
        try{
            Statement stm=con.createStatement();
            ResultSet res=stm.executeQuery("select * from MEMBERINFO_TAB");
            while(res.next())
            {
                jComboBox1.addItem(res.getString("MID"));
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }
    private void windowOpen(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_windowOpen
       viewAll();
       getBillID();
       selectMEMID();
       setGym();
    }//GEN-LAST:event_windowOpen

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       setPaid();
       viewAll();
       getBillID();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       updatePaid();
       viewAll();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       removePaid();
       viewAll();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
       showPaid(jTextField4.getText());
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void mouseClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseClick
       showPaid(String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 1)));
    }//GEN-LAST:event_mouseClick

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
       selectMember();
       viewPaid();
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        searchDate();
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       jTextField1.setText(null);
       jTextField2.setText(null);
       jTextField3.setText(null);
       jTextField4.setText(null);
       jTextField5.setText(null);
       jTextField6.setText(null);
       jComboBox1.setSelectedItem(null);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         try{
             MessageFormat head=new MessageFormat("Bill Report Of the Member "+jTextField1.getText());
             MessageFormat foot=new  MessageFormat("Page{0}");
             jTable1.setSize(jTable1.getWidth()-100, jTable1.getHeight()-100);
             jTable1.print(JTable.PrintMode.NORMAL, head, foot);
         }catch(Exception e){
             
         }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try{
            PrinterJob job=PrinterJob.getPrinterJob();
            jButton7.setVisible(false);
            job.setPrintable(this);
             boolean ok=job.printDialog();
             if(ok)
                    {
                      try{
                        job.print();
                        this.dispose();
                        }catch(PrinterException pe){
                        JOptionPane.showMessageDialog(rootPane, pe.toString());
                      }
                     }
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
       
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
        viewPaid();
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        showPaid(jTextField4.getText());
    }//GEN-LAST:event_jButton8ActionPerformed
    public void updatePaid()//this method is used to update the information
    {
        try{
            String bid,mid,mname,adder,mno,doe;
            int amnt;
            bid=jTextField4.getText();
            mname=jTextField1.getText();
            mid=(String)jComboBox1.getSelectedItem();
            adder=jTextField2.getText();
            mno=jTextField3.getText();
            doe=jTextField5.getText();
            amnt=Integer.parseInt(jTextField6.getText());
            String sql="update MONTHLY_PAID_TAB set MID='"+mid+"',MNAME='"+mname+"',ADDER='"+adder+"',MNO='"+mno+"',DOP='"+doe+"',RS="+amnt+" where BID='"+bid+"'";
            Statement stm=con.createStatement();
            stm.execute(sql);
            /*if(stm.execute(sql))
            {
            JOptionPane.showMessageDialog(rootPane, "Updated Successfully...!");
            }
            else
            {
             JOptionPane.showMessageDialog(rootPane, "Record not found...!");   
            }*/
            JOptionPane.showMessageDialog(rootPane, "Updated Successfully...!");
        }catch(Exception e){
         JOptionPane.showMessageDialog(rootPane, e.toString());   
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
            java.util.logging.Logger.getLogger(MonthlyBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MonthlyBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MonthlyBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MonthlyBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    new MonthlyBill().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MonthlyBill.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    public javax.swing.JButton jButton3;
    public javax.swing.JButton jButton4;
    public javax.swing.JButton jButton5;
    public javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    public javax.swing.JButton jButton8;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if(pageIndex>0)
        {
            return NO_SUCH_PAGE;
        }
        Graphics2D g2=(Graphics2D)graphics;
        g2.translate(pageFormat.getImageableX(),pageFormat.getImageableY());
        //g2.drawString(jTextField1.getText(), TOP_ALIGNMENT, TOP_ALIGNMENT);
        g2.setFont(new Font("Arial", Font.PLAIN,10));
        jPanel2.print(g2);
        return PAGE_EXISTS;
    }
}
