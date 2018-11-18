/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gymattendence;

public class GymAttendence {
    String username,pasword;
public void getconn(String uname,String pass)
{
    try{
        username=uname;
        pasword=pass;
    }catch(Exception e){
        e.getMessage();
    }
}
   
}
