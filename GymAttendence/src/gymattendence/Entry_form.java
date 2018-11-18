/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gymattendence;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.Date;
import java.text.SimpleDateFormat;
/**
 *
 * @author mantu
 */
public class Entry_form extends javax.swing.JFrame implements Printable{
Connection con;
Statement stm;
String gen=null,edt;
Calendar cal;
int mm,dd,yy;
String month=null;
String path=null;//"..\\GymAttendence\\src\\pp.png";

String msts=null;
ResultSet res1;
Statement stm1;
    public Entry_form() throws ClassNotFoundException {
        super("Entry Form...!");
        initComponents();
        setExtendedState(getExtendedState()|JFrame.MAXIMIZED_VERT);
        Class.forName("oracle.jdbc.OracleDriver");
        //jLabel1.setBounds(50, 50, 100, 50);
        setResizable(false);
        setBounds(200, 0, 575, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cal=new GregorianCalendar();
        mm=cal.get(cal.MONTH);
        dd=cal.get(cal.DAY_OF_MONTH);
        yy=cal.get(cal.YEAR);
        switch(mm)
        {
            case 0: month="jan";
                    break;
            case 1: month="feb";
                    break;
            case 2: month="mar";
                    break;
            case 3: month="apr";
                    break;
            case 4: month="may";
                    break;
            case 5: month="jun";
                    break;
            case 6: month="jul";
                    break;
            case 7: month="aug";
                    break;
            case 8: month="sep";
                    break;
            case 9: month="oct";
                    break;
            case 10: month="nov";
                    break;
            case 11: month="dec";
                    break;
            default: month=null;
                    break;
            
        }
        edt=dd+"-"+month+"-"+yy;
        jTextField3.setText(edt);
        setIconImage(Toolkit.getDefaultToolkit().getImage("icon1.png"));
    }
   public void getMID()//this method is used to get the id 
   {
       try{
           String sql="select count(*) from MEMBERINFO_TAB";
           Statement stm=con.createStatement();
           ResultSet rs=stm.executeQuery(sql);
           if(rs.next())
           {
               int x=rs.getInt(1);
               jTextField1.setText("m"+String.valueOf(x));
           }
       }catch(Exception e){
           JOptionPane.showMessageDialog(rootPane, e.toString());
       }
   }
    public void setGymInfo(String uname,String pass)//this method is used to get a connection
    {
        try{
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",uname,pass);
            stm=con.createStatement();
            ResultSet res=stm.executeQuery("select * from adv_tab where id=1");
            if(res.next())
            {
                jLabel1.setText(res.getString("Gname"));
                jLabel2.setText(res.getString("Adder"));
                jLabel3.setText(res.getString("Mno"));
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jLabel19 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel20 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel22 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel23 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox();
        jLabel24 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                windowOpen(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Mobile no");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Address");

        jLabel1.setFont(new java.awt.Font("Jokerman", 0, 24)); // NOI18N
        jLabel1.setText("Gym Name");

        buttonGroup1.add(jCheckBox1);
        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jCheckBox1.setText("Male");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckBox2);
        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jCheckBox2.setText("Female");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckBox3);
        jCheckBox3.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jCheckBox3.setText("kids");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gymattendence/pp.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(175, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jCheckBox1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox3))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addComponent(jLabel7)
                .addGap(19, 19, 19))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox1)
                            .addComponent(jCheckBox2)
                            .addComponent(jCheckBox3))))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel4.setText("Membership No:");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel5.setText("Candidate Name:");

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel6.setText("Date:");

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel8.setText("Father/Guardian Name:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel9.setText("Address:");

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel10.setText("Age:");

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel11.setText("Cell No:");

        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel12.setText("Occupation:");

        jTextField8.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel13.setText("Qualification:");

        jTextField9.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel14.setText("Weight:");

        jTextField10.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel15.setText("Height:");

        jTextField11.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel16.setText("B.group:");

        jTextField12.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel18.setText("Marital Status:");

        buttonGroup2.add(jCheckBox6);
        jCheckBox6.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jCheckBox6.setText("Married");
        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jCheckBox7);
        jCheckBox7.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jCheckBox7.setText("Un-Married");
        jCheckBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox7ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel19.setText("Candidate belongs To:");

        jComboBox1.setEditable(true);
        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Gen", "Sc", "ST", "OBC" }));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel20.setText("Nationality:");

        jTextField13.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel21.setText("Member of any other gym:");

        jComboBox2.setEditable(true);
        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "yes", "no" }));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel22.setText("Any Criminal case:");

        jComboBox3.setEditable(true);
        jComboBox3.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "yes", "no" }));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel23.setText("Practice Time:");

        jComboBox4.setEditable(true);
        jComboBox4.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Morning", "Evening" }));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel24.setText("Mark in body:");

        jTextField14.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel25.setText("Rupees/Fees:");

        jTextField15.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(68, 68, 68)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel4))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(65, 65, 65)
                                            .addComponent(jLabel6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(53, 53, 53)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel12)
                                .addComponent(jLabel9)
                                .addComponent(jLabel10)
                                .addComponent(jLabel13)
                                .addComponent(jLabel14)
                                .addComponent(jLabel18)
                                .addComponent(jLabel19)
                                .addComponent(jLabel21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel25)
                                        .addComponent(jLabel24))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField9)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jTextField8)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel15)
                                    .addGap(2, 2, 2)
                                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel16)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel20)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField13))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jCheckBox6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jCheckBox7))
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel22)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addComponent(jTextField14)
                                .addComponent(jTextField15, javax.swing.GroupLayout.Alignment.TRAILING)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox6)
                    .addComponent(jLabel18)
                    .addComponent(jCheckBox7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jButton5.setMnemonic('S');
        jButton5.setText("Save");
        jButton5.setToolTipText("Save the record");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jButton6.setMnemonic('C');
        jButton6.setText("Cancel");
        jButton6.setToolTipText("Cancel The information");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jButton7.setMnemonic('S');
        jButton7.setText("search");
        jButton7.setToolTipText("Search information");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jButton8.setMnemonic('P');
        jButton8.setText("Print");
        jButton8.setToolTipText("Print the information");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jButton9.setMnemonic('E');
        jButton9.setText("Exit");
        jButton9.setToolTipText("Quit The form");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jButton10.setMnemonic('U');
        jButton10.setText("Update");
        jButton10.setToolTipText("update the existing Record");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jButton1.setMnemonic('F');
        jButton1.setText("FIRST");
        jButton1.setToolTipText("First Record");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jButton2.setMnemonic('L');
        jButton2.setText("LAST");
        jButton2.setToolTipText("Last Record");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(18, 18, 18)
                        .addComponent(jButton10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton8)
                        .addGap(18, 18, 18)
                        .addComponent(jButton9))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton7)
                    .addComponent(jButton8)
                    .addComponent(jButton9)
                    .addComponent(jButton10)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
       this.dispose();
    }//GEN-LAST:event_jButton9ActionPerformed
    public void searchInformation(){
        try{
            //String st1,st2,st3,st4,st5,
            Statement pst=con.createStatement();
            ResultSet res=pst.executeQuery(("select * from MemberInfo_tab where mid='"+jTextField1.getText()+"'"));
           if(res.next())
           {
               //jTextField1.setText(res.getString("Mid"));
               jTextField2.setText(res.getString("MNAME"));
               jTextField4.setText(res.getString("GNAME"));
               jTextField5.setText(res.getString("ADDER"));
               jTextField6.setText(String.valueOf(res.getInt("AGE")));
               jTextField7.setText(res.getString("MNO"));
               jTextField8.setText(res.getString("OCCP"));
               jTextField9.setText(res.getString("QUAL"));
               jTextField10.setText(res.getString("WEIGHT"));
               jTextField11.setText(res.getString("HEIGHT"));
               jTextField12.setText(res.getString("BG"));
               jTextField13.setText(res.getString("NATION"));
               jTextField14.setText(res.getString("IDENTITY"));
               jTextField15.setText(String.valueOf(res.getInt("JAMNT")));
               //jTextField3.setText();
               int d,m,y;
        String mn=null;
       String dt=String.valueOf(res.getDate("DOE").toString());
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
       jTextField3.setText(date);
               jComboBox1.setSelectedItem(res.getString("CAST").toString());
               jComboBox2.setSelectedItem(res.getString("OGYM").toString());
               jComboBox3.setSelectedItem(res.getString("CRIME").toString());
               jComboBox4.setSelectedItem(res.getString("PTIME").toString());
               String gen=res.getString("GENDER").toString();
               if(gen.equalsIgnoreCase("male"))
               {
                   jCheckBox1.setSelected(rootPaneCheckingEnabled);
               }
               else if(gen.equalsIgnoreCase("female"))
               {
                   jCheckBox2.setSelected(rootPaneCheckingEnabled);
               }
               else
               {
                   jCheckBox3.setSelected(rootPaneCheckingEnabled);
               }
               String sts=res.getString("MSTATUS").toString();
               if(sts.equalsIgnoreCase("married"))
               {
                   jCheckBox6.setSelected(rootPaneCheckingEnabled);
               }
               else
               {
                   jCheckBox7.setSelected(rootPaneCheckingEnabled);
               }
               path=res.getString("IMG_PATH");
               File file=new File(path);
               Image img=null;
               img=ImageIO.read(file);
               jLabel7.setIcon(new ImageIcon(img));
                    
           }
           else
           {
               JOptionPane.showMessageDialog(rootPane, "Record not Found...!");
           }
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }
    /*public int inserInformation()
    {
        int res=0;
        SimpleDateFormat format=new SimpleDateFormat();
        java.sql.Date d;
        java.util.Date date;
        try{
            String name,adder,fname,mno,ogym,crime,ptime,doe,ide,cast,weight,bg,height,id,occp,qual,nat;
            int age=0,amnt=0;
            long doj;
            id=jTextField1.getText();
            name=jTextField2.getText();
            doe=jTextField3.getText();
            date=format.parse(doe);
            d=new java.sql.Date(age);
            fname=jTextField4.getText();
            adder=jTextField5.getText();
            age=Integer.parseInt(jTextField6.getText());
            mno=jTextField7.getText();
            occp=jTextField8.getText();
            qual=jTextField9.getText();
            weight=jTextField10.getText();
            height=jTextField11.getText();
            bg=jTextField12.getText();
            nat=jTextField13.getText();
            ide=jTextField14.getText();
            amnt=Integer.parseInt(jTextField15.getText());
            cast=(String)jComboBox1.getSelectedItem();
            ogym=(String)jComboBox2.getSelectedItem();
            crime=(String)jComboBox3.getSelectedItem();
            ptime=(String)jComboBox4.getSelectedItem();
            PreparedStatement pst=con.prepareStatement("insert into memberinfo_tab values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, id);
            pst.setString(2, name);
            pst.setString(3, fname);
            pst.setString(4, adder);
            pst.setInt(5, age);
            pst.setString(6, gen);
            pst.setString(7, msts);
            pst.setString(8, nat);
            pst.setString(9, cast);
            pst.setString(10, mno);
            pst.setString(11, crime);
            pst.setString(12, ogym);
            pst.setString(13, ptime);
            pst.setString(14, height);
            pst.setString(15, weight);
            pst.setDate(amnt, d, cal);
            pst.setInt(17, amnt);
            pst.setString(18, bg);
            pst.setString(19, path);
            pst.setString(20, occp);
            pst.setString(21, qual);
            pst.setString(22, ide);
            pst.executeQuery();
            pst.close();
            res=1;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e.toString());
            return 0;
        }
        return res;
    }*/
    public int insetStatement()//insert information of the gym member
    {
        int res=0;
        try{
            String name,adder,fname,mno,ogym,crime,ptime,doe,ide,cast,weight,bg,height,id,occp,qual,nat;
            int age=0,amnt=0;
            id=jTextField1.getText();
            name=jTextField2.getText();
            doe=jTextField3.getText();
            fname=jTextField4.getText();
            adder=jTextField5.getText();
            age=Integer.parseInt(jTextField6.getText());
            mno=jTextField7.getText();
            occp=jTextField8.getText();
            qual=jTextField9.getText();
            weight=jTextField10.getText();
            height=jTextField11.getText();
            bg=jTextField12.getText();
            nat=jTextField13.getText();
            ide=jTextField14.getText();
            amnt=Integer.parseInt(jTextField15.getText());
            cast=(String)jComboBox1.getSelectedItem();
            ogym=(String)jComboBox2.getSelectedItem();
            crime=(String)jComboBox3.getSelectedItem();
            ptime=(String)jComboBox4.getSelectedItem();
            String sql="insert into memberinfo_tab values('"+id+"','"+name+"','"+fname+"','"+adder+"',"+age+",'"+gen+"','"+msts+"','"+nat+"','"+cast+"','"+mno+"','"+crime+"','"+ogym+"','"+ptime+"','"+height+"','"+weight+"','"+doe+"',"+amnt+",'"+bg+"','"+path+"','"+occp+"','"+qual+"','"+ide+"')";
            Statement stm=con.createStatement();
            stm.executeQuery(sql);
            res=1;
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
        return res;
    }
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       searchInformation();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        gen="male";
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        gen="female";
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        gen="kid";
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        //JOptionPane.showMessageDialog(rootPane,new java.util.Date().toString());
        PrinterJob job=PrinterJob.getPrinterJob();
         jPanel1.setBackground(Color.white);
         jButton1.setVisible(false);
         jButton10.setVisible(false);
         jButton7.setVisible(false);
         jButton5.setVisible(false);
         jButton6.setVisible(false);
         jButton9.setVisible(false);
         jButton2.setVisible(false);
         jButton8.setVisible(false);
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
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if(insetStatement()==1)
        {
            JOptionPane.showMessageDialog(rootPane, "Data Saved Successfull...!");
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Data Not Saved...!");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        try {
            JFileChooser jf = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", ".png", ".jpg", ".gif");
            jf.setFileFilter(filter);
            jf.setCurrentDirectory(new File(System.getProperty("user.home")));
            int res = jf.showOpenDialog(null);
            if (res == JFileChooser.APPROVE_OPTION) {
                File file = jf.getSelectedFile();
                if (file.getName().endsWith(".png") || file.getName().endsWith(".jpg") || file.getName().endsWith(".gif")) {
                    path = file.getAbsolutePath();
                    Image img = null;
                    img = ImageIO.read(file);
                    jLabel7.setIcon(new ImageIcon(img));
                    //JOptionPane.showMessageDialog(rootPane, path);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Your selected a wrong format File !");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed
        msts="married";
    }//GEN-LAST:event_jCheckBox6ActionPerformed

    private void jCheckBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox7ActionPerformed
       msts="un_married";
    }//GEN-LAST:event_jCheckBox7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
               jTextField1.setText(null);
               jTextField2.setText(null);
               jTextField4.setText(null);
               jTextField5.setText(null);
               jTextField6.setText(null);
               jTextField7.setText(null);
               jTextField8.setText(null);
               jTextField9.setText(null);
               jTextField10.setText(null);
               jTextField11.setText(null);
               jTextField12.setText(null);
               jTextField13.setText(null);
               jTextField14.setText(null);
               jTextField15.setText(null);
               jTextField3.setText(null);
               jComboBox1.setSelectedItem(null);
               jComboBox2.setSelectedItem(null);
               jComboBox3.setSelectedItem(null);
               jComboBox4.setSelectedItem(null); 
               jCheckBox1.setSelected(false);
               jCheckBox2.setSelected(false);
               jCheckBox3.setSelected(false);
               jCheckBox6.setSelected(false);
               jCheckBox7.setSelected(false);
    }//GEN-LAST:event_jButton6ActionPerformed
    public void updateInformation()//update the information about the member
    {
        try{
            String name,adder,fname,mno,ogym,crime,ptime,doe,ide,cast,weight,bg,height,id,occp,qual,nat;
            int age=0,amnt=0;
            id=jTextField1.getText();
            name=jTextField2.getText();
            doe=jTextField3.getText();
            fname=jTextField4.getText();
            adder=jTextField5.getText();
            age=Integer.parseInt(jTextField6.getText());
            mno=jTextField7.getText();
            occp=jTextField8.getText();
            qual=jTextField9.getText();
            weight=jTextField10.getText();
            height=jTextField11.getText();
            bg=jTextField12.getText();
            nat=jTextField13.getText();
            ide=jTextField14.getText();
            amnt=Integer.parseInt(jTextField15.getText());
            cast=(String)jComboBox1.getSelectedItem();
            ogym=(String)jComboBox2.getSelectedItem();
            crime=(String)jComboBox3.getSelectedItem();
            ptime=(String)jComboBox4.getSelectedItem();
            Statement pst=con.createStatement();
            String sql="update MemberInfo_tab set MNAME='"+name+"',GNAME='"+fname+"',ADDER='"+adder+"',AGE="+age+",GENDER='"+gen+"',MSTATUS='"+msts+"',NATION='"+nat+"',CAST='"+cast+"',MNO='"+mno+"',CRIME='"+crime+"',OGYM='"+ogym+"',PTIME='"+ptime+"',HEIGHT='"+height+"',WEIGHT='"+weight+"',DOE='"+doe+"',JAMNT="+amnt+",BG='"+bg+"',IMG_PATH='"+path+"',OCCP='"+occp+"',QUAL='"+qual+"',IDENTITY='"+ide+"' WHERE MID='"+id+"'";
            int x=pst.executeUpdate(sql);
           if(x>0)
            {
                JOptionPane.showMessageDialog(rootPane, "Information Updated...!");
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Not Updated...!");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
       updateInformation();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
           setResandSta();
           res1.first();
               jTextField1.setText(res1.getString("MID"));
               jTextField2.setText(res1.getString("MNAME"));
               jTextField4.setText(res1.getString("GNAME"));
               jTextField5.setText(res1.getString("ADDER"));
               jTextField6.setText(String.valueOf(res1.getInt("AGE")));
               jTextField7.setText(res1.getString("MNO"));
               jTextField8.setText(res1.getString("OCCP"));
               jTextField9.setText(res1.getString("QUAL"));
               jTextField10.setText(res1.getString("WEIGHT"));
               jTextField11.setText(res1.getString("HEIGHT"));
               jTextField12.setText(res1.getString("BG"));
               jTextField13.setText(res1.getString("NATION"));
               jTextField14.setText(res1.getString("IDENTITY"));
               jTextField15.setText(String.valueOf(res1.getInt("JAMNT")));
               jTextField3.setText(res1.getDate("DOE").toString());
               jComboBox1.setSelectedItem(res1.getString("CAST").toString());
               jComboBox2.setSelectedItem(res1.getString("OGYM").toString());
               jComboBox3.setSelectedItem(res1.getString("CRIME").toString());
               jComboBox4.setSelectedItem(res1.getString("PTIME").toString());
               String gen=res1.getString("GENDER").toString();
               if(gen.equalsIgnoreCase("male"))
               {
                   jCheckBox1.setSelected(rootPaneCheckingEnabled);
               }
               else if(gen.equalsIgnoreCase("female"))
               {
                   jCheckBox2.setSelected(rootPaneCheckingEnabled);
               }
               else
               {
                   jCheckBox3.setSelected(rootPaneCheckingEnabled);
               }
               String sts=res1.getString("MSTATUS").toString();
               if(sts.equalsIgnoreCase("married"))
               {
                   jCheckBox6.setSelected(rootPaneCheckingEnabled);
               }
               else
               {
                   jCheckBox7.setSelected(rootPaneCheckingEnabled);
               }
               path=res1.getString("IMG_PATH");
               File file=new File(path);
               Image img=null;
               img=ImageIO.read(file);
               jLabel7.setIcon(new ImageIcon(img));
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       try{
           setResandSta();
           res1.last();
               jTextField1.setText(res1.getString("MID"));
               jTextField2.setText(res1.getString("MNAME"));
               jTextField4.setText(res1.getString("GNAME"));
               jTextField5.setText(res1.getString("ADDER"));
               jTextField6.setText(String.valueOf(res1.getInt("AGE")));
               jTextField7.setText(res1.getString("MNO"));
               jTextField8.setText(res1.getString("OCCP"));
               jTextField9.setText(res1.getString("QUAL"));
               jTextField10.setText(res1.getString("WEIGHT"));
               jTextField11.setText(res1.getString("HEIGHT"));
               jTextField12.setText(res1.getString("BG"));
               jTextField13.setText(res1.getString("NATION"));
               jTextField14.setText(res1.getString("IDENTITY"));
               jTextField15.setText(String.valueOf(res1.getInt("JAMNT")));
               jTextField3.setText(res1.getDate("DOE").toString());
               jComboBox1.setSelectedItem(res1.getString("CAST").toString());
               jComboBox2.setSelectedItem(res1.getString("OGYM").toString());
               jComboBox3.setSelectedItem(res1.getString("CRIME").toString());
               jComboBox4.setSelectedItem(res1.getString("PTIME").toString());
               String gen=res1.getString("GENDER").toString();
               if(gen.equalsIgnoreCase("male"))
               {
                   jCheckBox1.setSelected(rootPaneCheckingEnabled);
               }
               else if(gen.equalsIgnoreCase("female"))
               {
                   jCheckBox2.setSelected(rootPaneCheckingEnabled);
               }
               else
               {
                   jCheckBox3.setSelected(rootPaneCheckingEnabled);
               }
               String sts=res1.getString("MSTATUS").toString();
               if(sts.equalsIgnoreCase("married"))
               {
                   jCheckBox6.setSelected(rootPaneCheckingEnabled);
               }
               else
               {
                   jCheckBox7.setSelected(rootPaneCheckingEnabled);
               }
               path=res1.getString("IMG_PATH");
               File file=new File(path);
               Image img=null;
               img=ImageIO.read(file);
               jLabel7.setIcon(new ImageIcon(img));
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void windowOpen(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_windowOpen
        getMID();
        //TestPane tp=new TestPane();
        //tp.setpane();
    }//GEN-LAST:event_windowOpen
    public void setResandSta()
    {
        try{
           stm1=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
           res1=stm1.executeQuery("select * from memberInfo_tab");
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
            java.util.logging.Logger.getLogger(Entry_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Entry_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Entry_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Entry_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    new Entry_form().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Entry_form.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    public javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    public javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    public javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
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
        print(g2);
        return PAGE_EXISTS;
    
    }
}
