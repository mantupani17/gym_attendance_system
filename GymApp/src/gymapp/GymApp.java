/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymapp;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import mantu.com.gymapp.MainForm;

/**
 *
 * @author Mantu
 */
public class GymApp {

    /**
     * @param args the command line arguments
     */
//    this is for db url
      private static File file = new File("./myDB/Mydatabase.accdb") ;
      private static String dbUrl1 ="jdbc:ucanaccess://"+file.getAbsoluteFile();
    static {
        try{
            
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            System.out.println("Driver Loaded");
        }catch(ClassNotFoundException e){
            System.out.println(e.toString());
        }
    }
       public static Connection getConnection()throws SQLException{
        //  getting the path
            return DriverManager.getConnection(dbUrl1, "", "");
        }
        public static void main(String args[]) throws ClassNotFoundException{
            try{
                Connection con = GymApp.getConnection();
                 MainForm mf=new MainForm();
                  mf.setVisible(true);
                System.out.println("Connection Enabled");
            }catch(SQLException e){
                System.out.println(e.toString());
            }
        }
    
}
