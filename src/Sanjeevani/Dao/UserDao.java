/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sanjeevani.Dao;

import Sanjeevani.dbutil.DBConnection;
import Sanjeevani.pojo.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;


public class UserDao {
    public static String validateUser(User user) throws SQLException
    {
        String qry="select username from users where userid=? and password =? and usertype=?";
        PreparedStatement ps=DBConnection.getConnection().prepareStatement(qry);
        ps.setString(1,user.getUserId());
        ps.setString(2,user.getPassword());
        ps.setString(3,user.getUsertype());
        ResultSet rs=ps.executeQuery();
        String username=null;
        if(rs.next())
            username=rs.getString(1);
         return username;
    }
    public static boolean changePassword(String userid,String pwd) throws SQLException
    {
      PreparedStatement ps=  DBConnection.getConnection ().prepareStatement("update users set password=? where userid=?");
      ps.setString(1,pwd);
      ps.setString(2,userid);
      return (ps.executeUpdate()!=0);
    }
    public static HashMap<String,String> getReceptionistList() throws SQLException{
        
        Connection conn=DBConnection.getConnection();
         String qry="select empid,empname from employees where role='RECEPTIONIST'";
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(qry);
        HashMap<String,String> receptionist=new HashMap<>();
        while(rs.next())
        {
            String id=rs.getString(1);
            String name=rs.getString(2);
            receptionist.put(id,name);
        }
        return receptionist;
     }
    public static HashMap<String,String> getRegisteredList() throws SQLException
     {
         Connection conn=DBConnection.getConnection();
         String qry="select empid,username from users where usertype='RECEPTIONIST'";
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(qry);
        HashMap<String,String> registered=new HashMap<>();
        while(rs.next())
        {
            String id=rs.getString(1);
            String name=rs.getString(2);
            registered.put(id,name);
        }
        return registered;
     }
    
}
