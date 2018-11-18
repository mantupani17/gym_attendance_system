/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gas_0.pkg2;

import java.sql.*;

/**
 *
 * @author Handshakeyou
 */
public class DbConnection {
    private static String dbUrl ;
   
    
    static {
        dbUrl = "jdbc:ucanaccess:///E:\\java\\GAS_0.2\\Mydatabase.accdb";
        
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            System.out.println("Driver Loaded");
        }catch(ClassNotFoundException e){
            System.out.println(e.toString());
        }
    }
        static Connection getConnection()throws SQLException{
            
            return DriverManager.getConnection(dbUrl, "", "");
        }
        public static void main(String args[]){
            try{
                Connection con = DbConnection.getConnection();
                System.out.println("Connection Enabled");
            }catch(SQLException e){
                System.out.println(e.toString());
            }
        }
    
}
