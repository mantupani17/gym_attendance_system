/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gymattendence;

//import com.sun.org.apache.xml.internal.resolver.helpers.Debug;
import java.awt.*;
import java.io.File;
import javax.swing.*;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mantu
 */
public class DailyRegister extends javax.swing.JFrame {
GregorianCalendar cal;
int dd,mm,yy;
String mnth,user,pass;
Vector col,row;
Connection con;
testHint th;

//Vector row,col;
    public DailyRegister() throws ClassNotFoundException {
        super("Daily Register...!");
        initComponents();
        setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH);
        cal=new GregorianCalendar();
        dd=cal.get(GregorianCalendar.DAY_OF_MONTH);
        mm=cal.get(GregorianCalendar.MONTH);
        yy=cal.get(GregorianCalendar.YEAR);
        
        switch(mm)
        {
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
        jTextField2.setText(dd+"-"+mnth+"-"+yy);
        jTextField4.setText(dd+"-"+mnth+"-"+yy);
        getContentPane().setBackground(new Color(87,79,191));
        //getContentPane().setForeground(Color.white);
        Class.forName("oracle.jdbc.OracleDriver");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getconn("user1","user1");
       
    }
    public void getconn(String uname,String pa)//this method is used to get a connection
    {
        try{
            user=uname;
            pass=pa;
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",uname,pa);
            jLabel9.setText(uname);
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }
    public void setColumn(int x)
    {
        try{
            col=new Vector();
            row=new Vector();
            row.clear();
            col.clear();
            col.add("Sr/no");
            col.add("ID");
            col.add("MANE");
            col.add("Gurdian");
            col.add("Address");
            col.add("Age");
            col.add("Height");
            col.add("Weight");
            col.add("Blood group");
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }
    public void selectPerMember(String sql)//this method is used to find a perticular record
    {
        try{
            //String sql="select * from MEMBERINFO_TAB where MID="
            setColumn(1);
            Vector v;
            Statement stm=con.createStatement();
            ResultSet res=stm.executeQuery(sql);
            int x=1;
            String imgpath=null;
            if(res.next())
            {
                v=new Vector();
                v.add(x++);
                v.add(res.getString("MID"));
                v.add(res.getString("MNAME"));
                v.add(res.getString("GNAME"));
                v.add(res.getString("ADDER"));
                v.add(res.getInt("AGE"));
                v.add(res.getDouble("Height"));
                v.add(res.getDouble("WEIGHT"));
                v.add(res.getString("BG"));
                imgpath=res.getString("IMG_PATH");
                row.add(v);
            }
           /* if(imgpath.equals(null))
            {
                imgpath="..\\GymAttendence\\src\\pp.png";
                JOptionPane.showMessageDialog(rootPane, "Data Not Available...!","INformation",JOptionPane.ERROR_MESSAGE);
            }
            File file=new File(imgpath);
          Image img=null;
          img=ImageIO.read(file);
          jLabel8.setIcon(new ImageIcon(img));*/
          jTable2.setModel(new DefaultTableModel(row, col));
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }
    public void selectNames()//this method is used to set the name and mobile no
    {
        try{
            String sql="select mname,mno from MEMBERINFO_TAB";
            Statement stm=con.createStatement();
            ResultSet res=stm.executeQuery(sql);
            while(res.next()){
                jComboBox1.addItem(res.getString("MNAME"));
                jComboBox2.addItem(res.getString("MNO"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }
    public void getMemName()//this method is used to view the name of the memer
    {
        try{
            String sql="select mname,IMG_PATH from memberinfo_tab where MID='"+jTextField1.getText()+"'";
            Statement stm=con.createStatement();
            ResultSet res=stm.executeQuery(sql);
            String imgp = null;
            if(res.next())
            {
                jLabel1.setText(res.getString("mname"));
                imgp=res.getString("IMG_PATH");
            }
          File file=new File(imgp);
          Image img=null;
          img=ImageIO.read(file);
          jLabel8.setIcon(new ImageIcon(img));
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("User");
        jLabel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 51, 51), new java.awt.Color(255, 51, 51), new java.awt.Color(0, 255, 255), new java.awt.Color(255, 255, 51)));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Handshake, Handshakegym@gmail.com,9861873099,Developed by: MDP softwares,mantupani17@gmail.com, mobile NO: 7873160006");
        jLabel10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 51, 51), new java.awt.Color(255, 51, 51), new java.awt.Color(0, 255, 255), new java.awt.Color(255, 255, 51)));

        jPanel3.setBackground(new java.awt.Color(87, 79, 191));

        jPanel1.setBackground(new java.awt.Color(87, 79, 191));

        jTextField1.setBackground(new java.awt.Color(204, 204, 0));
        jTextField1.setPreferredSize(new java.awt.Dimension(10, 19));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Date:");

        jButton2.setMnemonic('E');
        jButton2.setText("Entry");
        jButton2.setToolTipText("Daily Entry");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setMnemonic('M');
        jButton1.setText("Monthly Information");
        jButton1.setToolTipText("View Monthly Information");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Name:");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Mobile No:");

        jComboBox1.setBackground(new java.awt.Color(102, 255, 51));
        jComboBox1.setEditable(true);
        jComboBox1.setToolTipText("Select Name");
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jTextField2.setBackground(new java.awt.Color(204, 204, 0));
        jTextField2.setPreferredSize(new java.awt.Dimension(10, 19));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Enter Membership no:");

        jButton3.setMnemonic('D');
        jButton3.setText("Delete");
        jButton3.setToolTipText("Delete All Entries");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mantu");
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 51, 51), new java.awt.Color(255, 51, 51), new java.awt.Color(0, 255, 255), new java.awt.Color(255, 255, 51)));

        jComboBox2.setBackground(new java.awt.Color(102, 255, 51));
        jComboBox2.setEditable(true);
        jComboBox2.setToolTipText("SelectMobile number");
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });

        jTextField3.setBackground(new java.awt.Color(204, 204, 0));
        jTextField3.setPreferredSize(new java.awt.Dimension(10, 19));
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Enter Membership no:");

        jButton4.setMnemonic('V');
        jButton4.setText("View");
        jButton4.setToolTipText("View the Daily Attendance");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Enter Date:");

        jTextField4.setBackground(new java.awt.Color(204, 204, 0));
        jTextField4.setToolTipText("Enter Date by this Format 1-jan-2016");
        jTextField4.setPreferredSize(new java.awt.Dimension(10, 19));
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jButton5.setMnemonic('N');
        jButton5.setText("New Register");
        jButton5.setToolTipText("New Member can added also from here");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setMnemonic('B');
        jButton6.setText("Bill");
        jButton6.setToolTipText("open monthly information form");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setMnemonic('x');
        jButton7.setText("Exit");
        jButton7.setToolTipText("Exit the form");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setMnemonic('V');
        jButton8.setText("View All");
        jButton8.setToolTipText("View All  Register Data");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("BMI Report");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(5, 5, 5)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton8)))
                .addGap(44, 44, 44))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1)
                            .addComponent(jButton5)
                            .addComponent(jButton6)
                            .addComponent(jButton8)
                            .addComponent(jButton7)
                            .addComponent(jLabel3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)
                        .addComponent(jButton4)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9))
                .addGap(12, 12, 12))
        );

        jPanel2.setBackground(new java.awt.Color(87, 79, 191));

        jTable1.setBackground(new java.awt.Color(87, 79, 191));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
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

        jTable2.setBackground(new java.awt.Color(87, 79, 191));
        jTable2.setForeground(new java.awt.Color(255, 255, 255));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable2.setToolTipText("Information table");
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jTable3.setBackground(new java.awt.Color(87, 79, 191));
        jTable3.setForeground(new java.awt.Color(255, 255, 255));
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gymattendence/pp.png"))); // NOI18N
        jLabel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Profile Picture", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Arial", 0, 12), java.awt.Color.white)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       try{
           Entry_form ef=new Entry_form();
           ef.setGymInfo(user, pass);
           ef.setVisible(rootPaneCheckingEnabled);
       }catch(Exception e){
           JOptionPane.showMessageDialog(rootPane, e.toString());
       }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        //getconn("user1","user1");
        dailyRegister();
        dailyEntry(jTextField2.getText().trim());
        getMemName();
        viewParPaid(jTextField1.getText());
        jTextField1.setText(null);
        //jTextField3.setText(mnth);
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
      // getconn("user1","user1");
       dailyEntry(jTextField2.getText().trim()); 
       selectNames();
       // jTextField1.setUI(new testHint("Name", Color.red));
        
    }//GEN-LAST:event_formWindowOpened

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
     //getconn("user1", "user1");
        selectPerMember("select * from MEMBERINFO_tab where MNAME='"+(String)jComboBox1.getSelectedItem()+"'");
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
       selectPerMember("select * from MEMBERINFO_tab where MNO='"+(String)jComboBox2.getSelectedItem()+"'");
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        String mid=(String)jTable1.getValueAt(jTable1.getSelectedRow(), 1);
        selectPerMember("select * from MEMBERINFO_TAB where MID='"+mid+"'");
    }//GEN-LAST:event_jTable1MouseClicked
    
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
       dailyEntry(jTextField4.getText().trim());
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String key=JOptionPane.showInputDialog(rootPane, "Enter Key: ", "Key Confirmation");
        if(key.equals(null))
        {
            JOptionPane.showMessageDialog(rootPane, "Enter Key...!");
        }
        else
        {
         try {
           String sql="select * from KEY_TAB where value='"+key+"'";
           ResultSet rs;
                try {
                    rs = con.createStatement().executeQuery(sql);
                        if(rs.next())
                        {
                         MonthlyBill mb=new MonthlyBill();
                         mb.getconn(user, pass);
                         mb.setVisible(rootPaneCheckingEnabled);
                         /*mb.jButton3.setEnabled(false);
                         mb.jButton5.setEnabled(false);
                         mb.jButton1.setEnabled(true);*/
                        } 
                        else
                        {
                            JOptionPane.showMessageDialog(rootPane, "Key is nvalid...!");
                        }
                } catch (SQLException ex) {
                    Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
                }
                 
           }
            catch (ClassNotFoundException ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        }
    }//GEN-LAST:event_jButton6ActionPerformed
    public void removeAllReg( String dt)//this method is used to remove all the records
    {
        try{
            String sql="delete  from DAILY_REG_TAB where MID='"+jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString()+"' and EDT='"+dt+"'";
            Statement stm=con.createStatement();
            int x=stm.executeUpdate(sql);
            if(x>0)
            {
                JOptionPane.showMessageDialog(rootPane, "All Data Removed...!");
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Data Not Present...!");
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       viewData();
    }//GEN-LAST:event_jButton4ActionPerformed
    public void setcolumnThree()
    {
        try{
            col=new Vector();
            row=new Vector();
            row.clear();
            col.add("Sr/no");
            col.add("Name");
            col.add("Paid");
            col.add("Date");
        }catch(Exception  e){
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }
    public void viewMonthPaid()//this method is used to view the information of the whole month
    {
        try{
            setcolumnThree();
            //JOptionPane.showMessageDialog(rootPane, pass);
            String stdt,endt;
            int mn=mm+1;
            String month;
            switch(mn)
            {
            case 0:month="jan";
                break;
            case 1:month="feb";
                break;
            case 2:month="mar";
                break;
            case 3:month="apr";
                break;
            case 4:month="may";
                break;
            case 5:month="jun";
                break;
            case 6:month="jul";
                break;
            case 7:month="aug";
                break;
            case 8:month="sep";
                break;
            case 9:month="oct";
                break;
            case 10:month="nov";
                break;
            case 11:month="dec";
                break;
            default:month=null;
                break;
            }
            stdt=1+"-"+mnth+"-"+yy;
            endt=1+"-"+month+"-"+yy;
            String sql="select * from MONTHLY_PAID_TAB where DOP between '"+stdt+"' and '"+endt+"'";
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery(sql);
            int x=1;
            Vector v;
            while(rs.next())
            {
                v=new Vector();
                v.add(x++);
                v.add(rs.getString("MNAME"));
                v.add(rs.getInt("RS"));
                v.add(rs.getDate("DOP").toString());
                //JOptionPane.showMessageDialog(rootPane, rs.getString(stdt));
                row.add(v);
            }
            jTable3.setModel(new DefaultTableModel(row, col));
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        viewMonthPaid();
    }//GEN-LAST:event_jButton1ActionPerformed
    public void viewParPaid(String id)//this method is used to show a particular members register
    {
        try{
            setcolumnThree();
            Vector v;
            int x=1;
            String sql="select * from MONTHLY_PAID_TAB where MID='"+id+"'";
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery(sql);
            while(rs.next())
            {
                v=new Vector();
                v.add(x++);
                v.add(rs.getString("MNAME"));
                v.add(rs.getInt("RS"));
                v.add(rs.getDate("DOP").toString());
                //JOptionPane.showMessageDialog(rootPane, rs.getString(stdt));
                row.add(v);
            }
            jTable3.setModel(new DefaultTableModel(row, col));
        }catch(Exception e ){
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }
    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
       viewParPaid((String)jTable2.getValueAt(jTable2.getSelectedRow(), 1));
       
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       dailyRegister();
        dailyEntry(jTextField2.getText().trim());
        getMemName();
        jTextField1.setText(null);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
       //
        int d,m,y;
        String mn=null;
       String dt=String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 2));
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
       //JOptionPane.showMessageDialog(rootPane,date);
       removeAllReg(date);
       dailyEntry(jTextField2.getText().trim());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
      viewAllReg();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        viewData();
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        jTextField3.setText(jTextField1.getText());// TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
      BmiChart mc=new BmiChart();
      String weight=String.valueOf(jTable2.getValueAt(jTable2.getSelectedRow(), 7));
      String height=String.valueOf(jTable2.getValueAt(jTable2.getSelectedRow(), 6));
      String name=String.valueOf(jTable2.getValueAt(jTable2.getSelectedRow(), 2));
      mc.setVisible(rootPaneCheckingEnabled);
      mc.jTextField1.setText(name);
      mc.jTextField2.setText(weight);
      mc.jTextField3.setText(height);
      
    }//GEN-LAST:event_jButton9ActionPerformed
    public void dailyRegister()//this method is usedt to make a attendance
    {
        try{
            String mid;
            String sql;
            mid=jTextField1.getText();
            if(mid.equals(""))
            {
             mid="M";
             sql="insert into Daily_reg_tab values('"+mid+"','"+jTextField2.getText().trim()+"')";  
            Statement stm=con.createStatement();
            stm.executeQuery(sql);
            }
            else
            {
              sql="insert into Daily_reg_tab values('"+mid+"','"+jTextField2.getText().trim()+"')";
              Statement stm=con.createStatement();
              stm.executeQuery(sql);
            }
           
            JOptionPane.showMessageDialog(rootPane, "Attended...!");
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }
    public void setColumn()//Set column for the table 1
    {
        try{
            col=new Vector();
            row=new Vector();
            row.clear();
            col.add("Sr/no");
            col.add("ID");
            col.add("Date");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }
    public void viewData()//this method is used to display the data of the member
    {
        try{
            setColumn();
            Vector v;
            int x=1;
            String sql="select * from Daily_reg_tab where MID='"+jTextField3.getText()+"'";
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery(sql);
            while(rs.next())
            {
                v=new Vector();
                v.add(x++);
                v.add(rs.getString("MID"));
                v.add(rs.getDate("EDT").toString());
                row.add(v);
            }
            jTable1.setModel(new DefaultTableModel(row, col));
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }
            
    public void viewAllReg()//view all register data
    {
        try{
            
            setColumn();
            Vector v;
            int x=1;
            Statement stm=con.createStatement();
            ResultSet res=stm.executeQuery("select * from Daily_reg_tab");
            while(res.next())
            {
                v=new Vector();
                v.add(x++);
                v.add(res.getString("MID"));
                v.add(res.getDate("EDT").toString());
                row.add(v);
            }
            jTable1.setModel(new DefaultTableModel(row, col));
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }
    public void dailyEntry(String dt)//show the daily Entry
    {
        try{
            
            setColumn();
            Vector v;
            int x=1;
            Statement stm=con.createStatement();
            ResultSet res=stm.executeQuery("select * from Daily_reg_tab where edt='"+dt+"'");
            while(res.next())
            {
                v=new Vector();
                v.add(x++);
                v.add(res.getString("MID"));
                v.add(res.getDate("EDT").toString());
                row.add(v);
            }
            jTable1.setModel(new DefaultTableModel(row, col));
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
                    new DailyRegister().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DailyRegister.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
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
    // End of variables declaration//GEN-END:variables
}
