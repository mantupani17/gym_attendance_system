/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gas_0.pkg2;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.io.File;
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DailyReg extends javax.swing.JFrame{
Connection con;
Statement stm,stm1;
ResultSet rs,rs1;
GregorianCalendar cal;
int cdate,cyear,cmonth;
    Vector row,col;
PreparedStatement pst;
String path="/gas_0/pkg2/pp.png";
    public DailyReg() throws SQLException {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        con= DbConnection.getConnection();
        

        //addCombo();
        //cal=new BuddhistCalendar();
        cal=new GregorianCalendar();
        cdate=cal.get(GregorianCalendar.DAY_OF_MONTH);
        cyear=cal.get(GregorianCalendar.YEAR);
        cmonth=cal.get(GregorianCalendar.MONTH);
        jTextField1.setText((cmonth+1)+"/"+cdate+"/"+cyear);
        countRecord();
        jTextField5.setText(jTextField1.getText());
        jLabel8.setText(null);
        setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gas_0/pkg2/pp.png"))); 
    }
    public void setTableCol()
    {
        row=new Vector();
        col=new Vector();
        row.clear();
        col.add("S.no");
        col.add("MID");
        col.add("Adder");
        col.add("Name");
        //col.add("Rupees");
    }
    public void countRecord()
    {
        try{
            int x=1;
            rs1=con.createStatement().executeQuery("select * from Reg_tab");
            while(rs1.next())
            {
                x++;
            }
           autodelete(x);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    public void tableData2(String st)//this method is used to find the member information 
    {
         try{
          setTableCol();
          String nm=null;
          int x=1;
          rs=con.createStatement().executeQuery("select * from Member_tab where Mid='"+st+"'");
          while(rs.next())
          {
              Vector v=new Vector();
              v.add(x++);
              v.add(rs.getString("Mid"));
              v.add(rs.getString("Adder"));
               nm=rs.getString("Mname");
               v.add(nm);
              row.add(v);
          }
          jLabel8.setText(nm);
          jTable2.setModel(new  DefaultTableModel(row,col));
      }
      catch(Exception e)
      {
          JOptionPane.showMessageDialog(null, e.toString());
      }
        
    }
    public void searchDate()//this method is used to search a particular date record
    {
          try{
          setTabledata();
          int x=1;
          rs=con.createStatement().executeQuery("select * from Reg_tab where Edt=#"+jTextField5.getText()+"#");
          while(rs.next())
          {
              Vector v=new Vector();
              v.add(x++);
              v.add(rs.getString("Mid"));
              v.add(rs.getDate("Edt").toString());
              row.add(v);
          }
          jTable1.setModel(new  DefaultTableModel(row,col));
      }
      catch(Exception e)
      {
          JOptionPane.showMessageDialog(null, e.toString());
      }
    }
    public void setTabledata()//this method is used to set table model
    {
        row=new Vector();
        col=new Vector();
        row.clear();
        col.add("Sr.no");
        col.add("ID");
        col.add("Register Date");
    }
    /*
     * //this method is used to find the monthly paid of the member
     * 
     */
    public void showMonthly()
    {
        try{
            row=new Vector();
            col=new Vector();
            row.clear();
            int x=1;
            col.add("serial No");
            col.add("Date of paid");
            col.add("Rupees");
            String sql="select * from Paid_tab where Mid='"+jTextField6.getText().trim()+"'";
            rs=con.createStatement().executeQuery(sql);
            String mname = null;
            while(rs.next())
            {
                Vector v=new Vector();
                v.add(x++);
                v.add(rs.getString("DOP").toString());
                v.add(rs.getString("Rs"));
                
                row.add(v);
            }
            rs1=con.createStatement().executeQuery("select * from Member_tab where Mid='"+jTextField6.getText()+"'");
            while(rs1.next())
            {
                mname=rs1.getString("Mname");
            }
            jLabel8.setText(mname);
            jTable2.setModel(new DefaultTableModel(row,col));
            rs.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    /*
     * this method is used to view the data according to the date
     */
    public void  addTable()
    {
        try{
         setTabledata();
         int x=1;
         String sql="select * from Reg_tab where Edt=#"+jTextField1.getText().trim()+"#";
         rs=con.createStatement().executeQuery(sql);
         while(rs.next())
         {
             Vector v=new Vector();
             v.add(x++);
             v.add(rs.getString("Mid"));
             v.add(rs.getDate("Edt").toString());
             row.add(v);
         }
         autodelete(x);
         jTable1.setModel(new DefaultTableModel(row,col));
        }catch(Exception e)
        { 
            JOptionPane.showMessageDialog(null, e.toString());
        }  
    }
    /*
     * this method is delete automatically the records from 
     * the database when the no of records croses 18000
     */
    public void autodelete(int cnt)
    {
         if(cnt>18000)
            {
        int res=JOptionPane.showConfirmDialog(null, "Are you sure to clear all data from Daily register ?", "Clear Register", JOptionPane.YES_NO_OPTION);
        if(res==JOptionPane.YES_OPTION)
        {
           
        try{
        stm=con.createStatement();
        String sql="delete from Reg_tab";
        int x=stm.executeUpdate(sql);
        if(x>0)
        {
            con.commit();
            JOptionPane.showMessageDialog(null, "data cleared....");
        }
        else
        {
           JOptionPane.showMessageDialog(null, "Database is Empty !"); 
        }
        }catch(SQLException e){JOptionPane.showMessageDialog(null, e.toString());
        }
            }
        
        else
        {
            JOptionPane.showMessageDialog(null, "Database is not Secure please Clear the Data");
        }
            }
    }
    /*
    clear daily register of a  member
    * 
    */
    public void clearRegister()
    {
        int res=JOptionPane.showConfirmDialog(null, "Are you sure To Clear the register ?", "Clear Register ", JOptionPane.YES_NO_OPTION);
        if(res==JOptionPane.YES_OPTION)
        {
            int r=jTable1.getSelectedRow();
            try{
                String sql="delete from Reg_tab where Mid='"+(String)jTable1.getValueAt(r, 1)+"'";
                stm=con.createStatement();
                int x=stm.executeUpdate(sql);
                if(x>0)
                {
                    JOptionPane.showMessageDialog(null, "All Cleared");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Database is empty !");
                }
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e.toString());
            
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Cancelled !","Clear Register ",JOptionPane.ERROR_MESSAGE);
        }
    }
    /*
     * daily register for member
     * 
     */
public void dataRegister()
{
    try{
        
        String sql="insert into Reg_tab(Mid,Edt) values('"+jTextField6.getText().trim()+"',#"+jTextField1.getText()+"#)";
        stm=con.createStatement();
        stm.execute(sql);
        JOptionPane.showMessageDialog(null, "Registered Succefully !");
        
    }catch(SQLException e)
    {
        JOptionPane.showMessageDialog(null, e.toString()+"this");
    }
}
    
  /*
   * public void addCombo()//this method is used to set the data into the combo
  {
  try{
      pst=con.prepareStatement("select * from Member_tab");
      rs=pst.executeQuery();
      while(rs.next())
      {
          String x=rs.getString("Mid");
          //JOptionPane.showMessageDialog(null, x);
         // jComboBox1.addItem(x);
      }
      rs.close();
      pst.close();
  }catch(Exception e)
  {
      JOptionPane.showMessageDialog(null, e.toString());
  }
  }*/

  /*
   *  this method showinfo() is used to view the information of the member
   */
  public void showinfo(String sql)
  {
       try{
         setTableCol();
          int x=1;
          rs=con.createStatement().executeQuery(sql);
          while(rs.next())
          {
              Vector v=new Vector();
              v.add(x++);
              v.add(rs.getString("Mid"));
             
              //v.add(rs.getString("Gname"));
              //v.add(rs.getDouble("Amnt"));
              v.add(rs.getString("Adder"));
               v.add(rs.getString("Mname"));
              //v.add(rs.getString("Mno"));
              row.add(v);
          }
          jTable2.setModel(new  DefaultTableModel(row,col));
      }
      catch(Exception e)
      {
          JOptionPane.showMessageDialog(null, e.toString());
      }
  }
  /*
   * the showRegister() method is used to view the current dates register form
   */
  public void showImage(String id)
  {
     
        try{
            stm=con.createStatement();
            rs=stm.executeQuery("select * from Member_tab where Mid='"+id+"'");
            if(rs.next())
            {
                path=rs.getString("path");
            }
            else
            {
                path="/gas_0/pkg2/pp.png";
            }
          File file=new File(path);
          Image img=null;
          img=ImageIO.read(file);
          jLabel10.setIcon(new ImageIcon(img));
            }catch(Exception e){
               JOptionPane.showMessageDialog(rootPane, e.toString());
            }
      
  }
  public void showRegister()
  {
      try{
          setTabledata();
          int x=1;
          rs=con.createStatement().executeQuery("select * from Reg_tab where Mid='"+jTextField2.getText()+"'");
          while(rs.next())
          {
              Vector v=new Vector();
              v.add(x++);
              v.add(rs.getString("Mid"));
              v.add(rs.getDate("Edt").toString());
              //path=rs.getString("path");
              row.add(v);
          }
          jTable1.setModel(new  DefaultTableModel(row,col));
          
      }
      catch(Exception e)
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 102, 24));

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

        jPanel2.setBackground(new java.awt.Color(247, 214, 249));

        jLabel1.setText("Enter Membership No:");

        jButton1.setMnemonic('E');
        jButton1.setText("Entry");
        jButton1.setToolTipText("Daily Entry Alt+E");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Date:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton3.setMnemonic('D');
        jButton3.setText("Delete");
        jButton3.setToolTipText("Delete A particular member daily register Alt+D");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel6.setText("Enter Name:");

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField6KeyTyped(evt);
            }
        });

        jButton4.setMnemonic('S');
        jButton4.setText("Show Monthly paid");
        jButton4.setToolTipText("Monthly bill information Alt+S");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("jLabel8");
        jLabel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(255, 51, 255), new java.awt.Color(51, 0, 255), new java.awt.Color(255, 255, 51), new java.awt.Color(255, 0, 0)));

        jLabel9.setText("Enter Mobile No:");

        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(jTextField7))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(jLabel6)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

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

        jPanel3.setBackground(new java.awt.Color(255, 51, 102));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("DAILY REGISTER");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204), 2));

        jLabel4.setText("PAID DETAILS");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204), 2));

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField3KeyPressed(evt);
            }
        });

        jLabel5.setText("Enter MembershipNo:");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButton2.setMnemonic('F');
        jButton2.setText("Find");
        jButton2.setToolTipText("Search a member record Alt+F");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setText("Enter Date:");

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(37, 37, 37))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jLabel7)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jPanel4.setBackground(new java.awt.Color(255, 153, 255));

        jButton5.setMnemonic('P');
        jButton5.setText("Payment");
        jButton5.setToolTipText("Monthly Bill Alt+P");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setMnemonic('N');
        jButton6.setText("New Register");
        jButton6.setToolTipText("New Member Register Alt+N");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setMnemonic('Q');
        jButton7.setText("Exit");
        jButton7.setToolTipText("Quit Alt+Q");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gas_0/pkg2/pp.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton7)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
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
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       dataRegister();
       addTable();
       showImage(jTextField6.getText());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
       dataRegister();
       addTable();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       showRegister();
       showImage(jTextField2.getText());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyPressed
     tableData2(jTextField3.getText());
    }//GEN-LAST:event_jTextField3KeyPressed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        String sql="select * from Member_tab where Mname='"+jTextField4.getText()+"'";
        showinfo(sql);
        
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
      searchDate();
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
       dataRegister();
       showMonthly();
       addTable();
       showImage(jTextField6.getText());
      jTextField6.setText(null);
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyTyped
      jTextField3.setText(jTextField6.getText());
    }//GEN-LAST:event_jTextField6KeyTyped

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        jTextField2.setText(jTextField3.getText());
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       showMonthly();
       showImage(jTextField6.getText());
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
     clearRegister();
     addTable();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
      int r;
      r=jTable1.getSelectedRow();
      String bid=jTable1.getValueAt(r, 1).toString();
      tableData2(bid);
      setpay(bid);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       int res=JOptionPane.showConfirmDialog(rootPane, "Are you you sure to quit the daily register","Daily Register",JOptionPane.YES_NO_OPTION);
       if(res==JOptionPane.YES_OPTION)
       {
           this.dispose();
       }
       
    }//GEN-LAST:event_jButton7ActionPerformed

    /*
     * this button works for key value for opening the payment slip
     */
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       try{
        String x=JOptionPane.showInputDialog(rootPane, "Enter Key Value:");
        if(x.equals(""))
        {
        JOptionPane.showMessageDialog(rootPane, "input the key value...");
        }
        else{
            rs=con.createStatement().executeQuery("select * from KeyTab where key="+1+" and pass='"+x+"'");
            if(rs.next())
            {
                paidForm pf=new paidForm();
                pf.setSize(900, 550);
                pf.setVisible(rootPaneCheckingEnabled);
                pf.jComboBox1.setSelectedItem(jTextField6.getText());
            }
        }
    }catch(Exception e){}
    }//GEN-LAST:event_jButton5ActionPerformed
   
    /*
     * this method is for set the table 3 values that is 
     * payment values
     */
    
    public void setpay(String bid)
    {
       try{
           Vector col1=new Vector();
           Vector row1=new Vector();
           col1.add("MID");
           col1.add("Date Of Pay");
           col1.add("Rupees");
           rs=con.createStatement().executeQuery("select * from Paid_tab where Mid='"+bid+"'");
           while(rs.next())
           {
            Vector v=new Vector();
            v.add(rs.getString("Mid"));
            v.add(rs.getDate("DOP").toString());
            v.add(rs.getInt("Rs"));
            row1.add(v);
           }
           jTable3.setModel(new DefaultTableModel(row1, col1));
       }catch(Exception e){}
        
    }
    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
      int r=jTable2.getSelectedRow();
        String x=jTable2.getValueAt(r, 1).toString();
       setpay(x);
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            EntryForm ef=new EntryForm();
            ef.setVisible(rootPaneCheckingEnabled);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DailyReg.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DailyReg.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        String sql="select * from Member_tab where Mno='"+jTextField7.getText()+"'";
        showinfo(sql);
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        try{
       
        }catch(Exception e)
        {
          jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mypackage/pp.png")));  
        }
    }//GEN-LAST:event_jTextField2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws ClassNotFoundException {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    new DailyReg().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(DailyReg.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables

   
}
