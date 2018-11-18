/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import java.sql.*;
import java.text.MessageFormat;
import java.util.GregorianCalendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
/**
 *
 * @author mantu
 */
public class paidForm extends javax.swing.JFrame implements Printable{
Connection con;
Statement stm;
ResultSet rs;
GregorianCalendar cal;
int cdate,cyear,cmonth;
    Vector row,col;
PreparedStatement pst;
   String mno,dop,nm;
   TableColumnModel model;
   DefaultTableModel model1;
   
    public paidForm() throws SQLException {
        super("Monthy Paid...");
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        con=DriverManager.getConnection("jdbc:odbc:MDB","mantu","deepi");
        GregorianCalendar cal=new GregorianCalendar();
        cdate=cal.get(GregorianCalendar.DAY_OF_MONTH);
        cyear=cal.get(GregorianCalendar.YEAR);
        cmonth=cal.get(GregorianCalendar.MONTH);
        jTextField5.setText((cmonth+1)+"/"+cdate+"/"+cyear);
        setResizable(false);
        setComponents();
    }
    public void setComponents()
    {
        this.setSize(945, 620);
        jPanel1.setBounds(0, 10,this.getWidth()+510, this.getHeight()+500);
        this.add(jPanel1);
        jPanel2.setBounds(0, 5,jPanel1.getWidth(), 30);
        jLabel1.setBounds(410, 3, 250, 20);
        jLabel2.setBounds(300, 13, 100, 20);
        jLabel18.setBounds(270, 43, 100, 20);
        jLabel22.setBounds(270, 73, 100, 20);
        jTextField7.setBounds(350, 70, 150, 30);
        jComboBox2.setBounds(350, 40, 150, 30);
        jTextField1.setBounds(350, 10, 100, 30);
        jLabel3.setBounds(10, 10, 150, 20);
        jTextField8.setBounds(110, 8, 150, 30);
        jLabel4.setBounds(10, 40, 150, 20);
        jPanel3.add(jLabel4);
        jPanel3.add(jLabel22);
        jPanel3.add(jTextField7);
        jTextField2.setBounds(110, 40, 150, 30);
        jLabel5.setBounds(10, 70, 150, 20);
        jTextField3.setBounds(110, 70, 150, 30);
        jLabel6.setBounds(10, 100, 150, 20);
        jTextField4.setBounds(110, 100, 150, 30);
        jLabel7.setBounds(10, 130, 150, 20);
        jTextField5.setBounds(110, 130, 150, 30);
        jLabel8.setBounds(10, 160, 150, 20);
        jTextField6.setBounds(110, 160, 150, 30);
        jButton1.setBounds(15, 200, 80, 30);
        jButton2.setBounds(100, 200, 80, 30);
        jButton3.setBounds(185, 200, 120, 30);
        jButton4.setBounds(310, 200, 80, 30);
        jButton5.setBounds(400, 200, 80, 30);
        jButton7.setBounds(400, 550, 150, 30);
        jTextField7.setEnabled(false);
        jPanel1.add(jButton7);
        jPanel3.add(jButton5);
        jPanel3.add(jButton4);
        jPanel3.add(jButton3);
        jPanel3.add(jButton2);
        jPanel3.add(jButton1);
        jPanel3.add(jLabel8);
        jPanel3.add(jLabel18);
        jPanel3.add(jTextField6);
        jPanel3.add(jLabel7);
        jPanel3.add(jTextField5);
        jPanel3.add(jLabel6);
        jPanel3.add(jTextField4);
        jPanel3.add(jLabel5);
        jPanel3.add(jTextField3);
        jPanel3.add(jTextField2);
        jPanel3.add(jTextField8);
        jPanel3.add(jComboBox2);
        jPanel3.add(jLabel3);
        jPanel3.add(jTextField1);
        jPanel3.add(jLabel2);
        jPanel2.add(jLabel1);
        jPanel3.setBounds(5, 45,520, 250);
        //jPanel4.setBounds(5, 300,100,80);
        jScrollPane1.setBounds(5, 300,this.getWidth()-15, 250);
        jTable1.setBounds(0, 0, jScrollPane1.getWidth(), jScrollPane1.getHeight());
        jScrollPane1.setViewportView(jTable1);
        jPanel5.setBounds(530, 45, 400, 250);
        jLabel10.setBounds(10, 20,50, 10);
        jLabel11.setBounds(50, 20, 100, 10);
        jLabel17.setBounds(300, 20, 30, 10);
        jLabel12.setBounds(10, 150, 50, 10);
        jLabel14.setBounds(50, 150, 150, 10);
        jLabel20.setBounds(10, 170, 30, 10);
        jLabel21.setBounds(50, 170, 50, 10);
        jLabel16.setBounds(100, 30, 200, 100);
        jLabel13.setBounds(250, 150, 70, 10);
        jLabel15.setBounds(302, 150, 100, 10);
        jLabel19.setBounds(250, 200, 100, 30);
        jButton6.setBounds(10, 200, 80, 30);
        jPanel1.add(jScrollPane1);
        jPanel5.add(jLabel19);
        jPanel5.add(jButton6);
        jPanel5.add(jLabel15);
        jPanel5.add(jLabel13);
        jPanel5.add(jLabel16);
        jPanel5.add(jLabel21);
        jPanel5.add(jLabel20);
        jPanel5.add(jLabel14);
        jPanel5.add(jLabel12);
        jPanel5.add(jLabel17);
        jPanel5.add(jLabel11);
        jPanel5.add(jLabel10);
        jPanel1.add(jPanel5);
        jPanel1.add(jPanel2);
        //jPanel1.add(jPanel4);
        jPanel1.add(jPanel3);
    }
    public void setColumndata()
    {
        
        model=jTable1.getColumnModel();
        model.getColumn(0).setPreferredWidth(10);
        model.getColumn(1).setPreferredWidth(10);
        model.getColumn(2).setPreferredWidth(10);
        model.getColumn(3).setPreferredWidth(150);
        model.getColumn(4).setPreferredWidth(200);
        model.getColumn(5).setPreferredWidth(50);
        model.getColumn(6).setPreferredWidth(50);
        model.getColumn(7).setPreferredWidth(40);
        /*col.add("Sr.No");
        col.add("Bill No");
        col.add("Membership Id");
        col.add("Member Name");
        col.add("Address");
        col.add("Mobile No");
        col.add("Paid Date");
        col.add("Rupees");
        model1.addColumn("Sr.No");
        model1.addColumn("Bill No");
        model1.addColumn("Membership Id");
        model1.addColumn("Member Name");
        model1.addColumn("Address");
        model1.addColumn("Mobile No");
        model1.addColumn("Paid Date");
        model1.addColumn("Rupees");*/
    }
    public DefaultTableModel viewData()
    {
        DefaultTableModel tmodel=new DefaultTableModel();
        tmodel.addColumn("sno");
        tmodel.addColumn("Bno");
        tmodel.addColumn("MId");
        tmodel.addColumn("Member Name");
        tmodel.addColumn("Address");
        tmodel.addColumn("Mobile No");
        tmodel.addColumn("Paid Date");
        tmodel.addColumn("Rupees");
        String sql="select * from Paid_tab";
        try{
            stm=con.createStatement();
            rs=stm.executeQuery(sql);
            int x=1;
            while(rs.next()){
             tmodel.addRow(new Object[]{x++,rs.getInt("Bid"),rs.getString("Mid"),rs.getString("Mname"),rs.getString("Adder"),rs.getString("Mno"),rs.getDate("DOP").toString(),rs.getDouble("Rs")});   
            }
            return tmodel;
        }catch(Exception e)
        {
        }
                return tmodel;
    }
   /* public void showTableData()
    {
        try{
           // model1=new DefaultTableModel();
            setColumndata();
            String sql="select * from Paid_tab";
            stm=con.createStatement();
            rs=stm.executeQuery(sql);
            int x=1;
            while(rs.next())
            {
               /* Vector v=new Vector();
                v.add(x++);
                v.add(rs.getInt("Bid"));
                v.add(rs.getString("Mid"));
                v.add(rs.getString("Mname"));
                v.add(rs.getString("Adder"));
                v.add(rs.getString("Mno"));
                v.add(rs.getDate("DOP").toString());
                double d=rs.getDouble("Rs");
                v.add(Double.toString(d));
                row.add(v); 
                //model1.addRow(row);
                model1.addRow(new Object[]{x++,rs.getInt("Bid"),rs.getString("Mid"),rs.getString("Mname"),rs.getString("Adder"),rs.getString("Mno"),rs.getDate("DOP").toString(),rs.getDouble("Rs")});
            }
           jTable1=new JTable(model1);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }*/
  /* public void addCombo()//this method is used to set the data into the combo
  {
  try{
      pst=con.prepareStatement("select * from Member_tab");
      rs=pst.executeQuery();
      stm=con.createStatement();
      rs=stm.executeQuery("select * from Member_tab");
      while(rs.next())
      {
          String x;
          jComboBox1.addItem(rs.getString("Mid"));
      }
      //rs.close();
      //pst.close();
  }catch(Exception e)
  {
      JOptionPane.showMessageDialog(null, e.toString());
  }
  }*/
   public void setTextbox()//this method is used to find the number of records present in the Paid_tab table
   {
       try{
           ResultSet res1=stm.executeQuery("select COUNT(*) from Paid_tab");
           res1.next();
           int x =res1.getInt(1);
          jTextField1.setText(Integer.toString(x));
         }catch(SQLException e)
       {
         JOptionPane.showMessageDialog(null, e.toString());  
       }
   }
   //this method update the data of the member
   public void updateData()
   {
       try{
          String sql1="update Member_tab set pbasis='"+(String)jComboBox2.getSelectedItem()+"',lpaid=#"+jTextField5.getText()+"# where MID='"+jTextField8.getText()+"'";
           stm=con.createStatement();
           stm.execute(sql1);
       }catch(Exception e){
       JOptionPane.showMessageDialog(rootPane, e.toString());
       }
   }
   public void paidMember()
   {
    try{
        String mid,mnm,dop,rs,mad;
        double x;
        mid=jTextField8.getText();
        //findName(mid);
        mnm=jTextField2.getText();
        mad=jTextField3.getText();
        mno=jTextField4.getText();
        rs=jTextField6.getText();
        x=Double.parseDouble(rs);
        dop=jTextField5.getText();
        //String pbasis=(String)jComboBox2.getSelectedItem();
        String sql="insert into Paid_tab(Mid,Mname,Adder,Mno,DOP,Rs) values('"+mid+"','"+mnm+"','"+mad+"','"+mno+"',#"+dop+"#,"+x+")";
        stm=con.createStatement();
        stm.execute(sql);
        JOptionPane.showMessageDialog(null,"Paid Successfull !");
    }   
   catch(SQLException e)
   {
       JOptionPane.showMessageDialog(null, e.toString());
      
   }
   }
   public DefaultTableModel searchTable()
   {
    DefaultTableModel tmodel=new DefaultTableModel();
         tmodel.addColumn("sno");
        tmodel.addColumn("Bno");
        tmodel.addColumn("MId");
        tmodel.addColumn("Member Name");
        tmodel.addColumn("Address");
        tmodel.addColumn("Mobile No");
        tmodel.addColumn("Paid Date");
        tmodel.addColumn("Rupees");
         String sql="select * from Paid_tab where Mid='"+jTextField8.getText()+"'";
        try{
            stm=con.createStatement();
            rs=stm.executeQuery(sql);
            int x=1;
            while(rs.next()){
             tmodel.addRow(new Object[]{x++,rs.getInt("Bid"),rs.getString("Mid"),rs.getString("Mname"),rs.getString("Adder"),rs.getString("Mno"),rs.getDate("DOP").toString(),rs.getDouble("Rs")});   
            }
            return tmodel;
        }catch(Exception e)
        {
        }
                return tmodel;
   }
   public void modifyData()//this method is used to modify the payment
   {
       try{
           String id=jTextField8.getText();
           String mnm=jTextField2.getText();
           String madr=jTextField3.getText();
           String mno=jTextField4.getText();
           String dt=jTextField5.getText();
           String rs=jTextField6.getText();
           double x=Double.parseDouble(rs);
           String sql="update Paid_tab set Mid='"+id+"',Mname='"+mnm+"',Adder='"+madr+"',Mno='"+mno+"',DOP=#"+dt+"#,Rs="+x+" where Bid="+jTextField1.getText()+"";
           stm=con.createStatement();
           stm.execute(sql);
           JOptionPane.showMessageDialog(null, "data Reseted successfully !");
       }catch(SQLException e)
       {
           JOptionPane.showMessageDialog(null, e.toString());
       }
   }
   public void deleteData()
   {
       int res=JOptionPane.showConfirmDialog(null, "Are you sure to Remove this record ?", "Delete Record !", JOptionPane.YES_NO_OPTION);
       if(res==JOptionPane.YES_OPTION)
       {
           try{
               String sql="delete from Paid_tab where Bid="+jTextField1.getText()+"";
               stm=con.createStatement();
               int x=stm.executeUpdate(sql);
               if(x>0)
               {
                   JOptionPane.showMessageDialog(null, "delete Data successfully !");
               }
               else
               {
                   JOptionPane.showMessageDialog(null, "Record not Found");
               }
           }catch(SQLException e)
           {
               JOptionPane.showMessageDialog(null, e.toString());
           }
       }
       else
       {
           JOptionPane.showMessageDialog(null, "delete Cancelled !","Delete Record",JOptionPane.ERROR_MESSAGE);
       }
   }
   
   
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jTextField8 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        jLabel9.setText("jLabel9");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(28, 212, 122));

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("MONTHLY PAID FORM");

        jLabel2.setText("Bill No:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addComponent(jLabel1)
                .addGap(96, 96, 96)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel3.setText("Membership No:");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Name Of Member:");

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

        jLabel5.setText("Address:");

        jLabel6.setText("Mobile No:");

        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });

        jLabel7.setText("Date(mm/dd/yy):");

        jLabel8.setText("Rupees:");

        jPanel3.setBackground(new java.awt.Color(240, 141, 244));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 51, 51)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 133, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 161, Short.MAX_VALUE)
        );

        jButton7.setMnemonic('R');
        jButton7.setText("Search Record");
        jButton7.setToolTipText("Search a Particular record");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton1.setMnemonic('P');
        jButton1.setText("Paid");
        jButton1.setToolTipText("Paid monthly bill");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setMnemonic('S');
        jButton2.setText("Search");
        jButton2.setToolTipText("Search All the bill");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setMnemonic('C');
        jButton5.setText("Change");
        jButton5.setToolTipText("Modify the info");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton4.setMnemonic('D');
        jButton4.setText("Delete");
        jButton4.setToolTipText("Delete the record");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setMnemonic('A');
        jButton3.setText("Delete All  Data");
        jButton3.setToolTipText("Delete All  Data from the database permanently");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Monthly(32 Days)", "Quarterly(93 Days)", "Half yearly(186 days)", "Yearly (372 Days)", "Permanent", "Others", " " }));

        jLabel18.setText("Monthly Basis:");

        jLabel22.setText("Date Of Join:");

        jButton6.setMnemonic('P');
        jButton6.setText("Print");
        jButton6.setToolTipText("Print bill");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Money Reciept", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP));

        jLabel15.setBackground(new java.awt.Color(153, 255, 153));
        jLabel15.setText("Member No");

        jLabel14.setBackground(new java.awt.Color(153, 255, 153));
        jLabel14.setText("Name");

        jLabel17.setText("Date");

        jLabel11.setBackground(new java.awt.Color(153, 255, 153));
        jLabel11.setText("bill no");

        jLabel12.setText("Name:");

        jLabel13.setText("Mem/NO:");

        jLabel19.setText("Signature");

        jLabel20.setText("Rs:");

        jLabel21.setText("Rupees");

        jLabel10.setText("bill no:");

        jLabel16.setIcon(new javax.swing.ImageIcon("G:\\java\\GymAutomation\\src\\mypackage\\Logo.jpg")); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel17)
                                .addContainerGap(284, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addGap(51, 51, 51))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel13)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(jLabel20))
                        .addGap(4, 4, 4))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel19)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(550, 550, 550)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField2)
                                    .addComponent(jTextField3)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButton7)
                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextField8)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3)))
                        .addGap(191, 191, 191))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(140, 140, 140)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel18))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(770, 770, 770)
                    .addComponent(jButton6)
                    .addContainerGap(770, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(107, 107, 107)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton5)
                    .addComponent(jButton4)
                    .addComponent(jButton3))
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(jButton7)
                .addGap(172, 172, 172)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addGap(38, 38, 38))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(557, 557, 557)
                    .addComponent(jButton6)
                    .addContainerGap(558, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 822, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyTyped
    
    }//GEN-LAST:event_jTextField4KeyTyped
    public void setPrint()
    {
        jLabel11.setText(jTextField1.getText());
        jLabel14.setText(jTextField2.getText());
        jLabel15.setText(jTextField8.getText());
        jLabel17.setText(jTextField5.getText());
        jLabel21.setText(jTextField6.getText());
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     showData();
     updateData();
     paidMember();
     setTextbox();
     DefaultTableModel tm=viewData();
     jTable1.setModel(tm);
     setColumndata();
     setPrint();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
     findName(jTextField8.getText());
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
     int r=jTable1.getSelectedRow();
     jTextField1.setText(jTable1.getValueAt(r, 1).toString());
     jTextField8.setText(jTable1.getValueAt(r, 2).toString());
     jTextField2.setText(jTable1.getValueAt(r, 3).toString());
     jTextField3.setText(jTable1.getValueAt(r, 4).toString());
     jTextField4.setText(jTable1.getValueAt(r, 5).toString());
     jTextField5.setText(jTable1.getValueAt(r, 6).toString());
     jTextField6.setText(jTable1.getValueAt(r, 7).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       DefaultTableModel tm=searchTable();
       jTable1.setModel(tm);
       setColumndata();
       try{
           rs=con.createStatement().executeQuery("select * from member_tab where MID='"+jTextField8.getText()+"'");
            if(rs.next())
            {
            jTextField7.setText(rs.getDate("edt").toString());
            }
       }catch(Exception e){}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      clearData();
      DefaultTableModel tm=viewData();
     jTable1.setModel(tm);
     setColumndata();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       deleteData();
       DefaultTableModel tm=viewData();
     jTable1.setModel(tm);
     setColumndata();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
      //updateData();
      modifyData();
      
      DefaultTableModel tm=viewData();
     jTable1.setModel(tm);
     setColumndata();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
      PrinterJob job=PrinterJob.getPrinterJob();
      jButton6.setVisible(false);
            job.setPrintable(this);
             boolean ok=job.printDialog();
             if(ok)
                    {
                      try{
                        job.print();
                        this.dispose();
                        }catch(PrinterException pe){}
                     }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {
            rs=con.createStatement().executeQuery("select * from member_tab where MID='"+jTextField8.getText()+"'");
            if(rs.next())
            {
                jTextField2.setText(rs.getString("Mname"));
                jTextField3.setText(rs.getString("Adder"));
                jTextField4.setText(rs.getString("Mno"));
                jTextField7.setText(rs.getDate("edt").toString());
                DefaultTableModel tm=searchTable();
                jTable1.setModel(tm);
                setColumndata();
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Record not Exist");
            }
        } catch (SQLException ex) {
            Logger.getLogger(paidForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        setTextbox();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //addCombo();
        //showTableData();
        DefaultTableModel tm=viewData();
        jTable1.setModel(tm);
        setColumndata();
    }//GEN-LAST:event_formWindowOpened

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
         showData();
    }//GEN-LAST:event_jTextField8ActionPerformed
    public void showData()
    {
        String mid=jTextField8.getText();
        try{
            String sql="select * from Member_tab where MID='"+mid+"'";
            
            rs=con.createStatement().executeQuery(sql);
            while(rs.next())
            {
                jTextField2.setText(rs.getString("Mname"));
                jTextField3.setText(rs.getString("Adder"));
                jTextField4.setText(rs.getString("Mno"));
                jTextField7.setText(rs.getDate("edt").toString());
                jComboBox2.setSelectedItem(rs.getString("pbasis"));
            }
        }catch(Exception e)
        {
            
        }
            
    }
    public void findName(String n)
    {
        try{
           rs=con.createStatement().executeQuery("select * from Member_tab where Mid='"+n+"'");
           while(rs.next())
           {
              jTextField2.setText(rs.getString("Mname"));
              jTextField3.setText(rs.getString("Adder"));
              jTextField4.setText(rs.getString("Mno"));
           }
         //rs.close();  
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
   public void clearData()
   {
       int res=JOptionPane.showConfirmDialog(null, "Are you sure to remove all data?", "delete All !", JOptionPane.YES_OPTION);
       if(res==JOptionPane.YES_OPTION)
       {
           try{
               String sql="delete from Paid_tab";
               stm=con.createStatement();
               int x=stm.executeUpdate(sql);
               if(x>0)
               {
                   JOptionPane.showMessageDialog(null, "All Data Cleared", "delete All !", JOptionPane.INFORMATION_MESSAGE);
               }
               else
               {
                   JOptionPane.showMessageDialog(null, "database is Empty !");
               }
           }catch(Exception e)
           {
              JOptionPane.showMessageDialog(null, e.toString()); 
           }
       }
       else
       {
           JOptionPane.showMessageDialog(null, "cancelled !","Clear Data",JOptionPane.ERROR_MESSAGE);
       }
   }
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
            java.util.logging.Logger.getLogger(paidForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(paidForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(paidForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(paidForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    new paidForm().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(paidForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    public javax.swing.JTextField jTextField7;
    public javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables

    @Override
    public int print(Graphics g,PageFormat pf,int page) throws PrinterException {
        if(page>0)
        {
            return NO_SUCH_PAGE;
        }
        Graphics2D g2=(Graphics2D)g;
        g2.translate(pf.getImageableX(), pf.getImageableY());
        jPanel5.printAll(g.create(120,50,400,300));
        return PAGE_EXISTS;
    }

  
}
