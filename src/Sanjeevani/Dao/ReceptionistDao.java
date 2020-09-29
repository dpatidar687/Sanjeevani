/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sanjeevani.Dao;

import Sanjeevani.dbutil.DBConnection;
import Sanjeevani.pojo.UserPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Deepak Patidar
 */
public class ReceptionistDao {
    public static boolean addReceptionist(UserPojo up) throws SQLException {
        Connection con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement("insert into users values(?,?,?,?,?)");
        ps.setString(1,up.getUserid());
        ps.setString(2,up.getUserName());
        ps.setString(3,up.getEmpId());
        ps.setString(4,up.getPassword());
        ps.setString(5,up.getUserType());
        int r=ps.executeUpdate();
        return r>0;
    }
   
    /* public static boolean updateReceptionistPassword(String userId,String pass) throws SQLException{
         Connection con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement("update users set password=? where empid=?");
        ps.setString(1,pass);
        ps.setString(2,userId);
        int i= ps.executeUpdate();
        if(i==1)return true;
        else
            return false;
     }*/
     /*public boolean matchUserid(String userid) throws SQLException
     {
          Connection con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement("select * from user where userid=?");
        ps.setString(1,userid);
        int b=ps.executeU();
        
     }*/
     
}