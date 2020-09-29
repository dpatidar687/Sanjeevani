/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sanjeevani.Dao;

import Sanjeevani.dbutil.DBConnection;
import Sanjeevani.pojo.DoctorPojo;
import Sanjeevani.pojo.UserPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Deepak Patidar
 */
public class DoctorDao {
    
    public static ArrayList<String> getAllDoctorId()throws SQLException
    {
        Statement st=DBConnection.getConnection().createStatement();
        ResultSet re=st.executeQuery("select doctorid from doctors");
        ArrayList<String>doid=new ArrayList<>();
        while(re.next())
        {
            doid.add(re.getString(1));
        }
        return doid;
    }
    public static ArrayList<DoctorPojo> getAllDoctors() throws SQLException {
        
        Statement st = DBConnection.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from doctors");
        ArrayList<DoctorPojo> list=new ArrayList<>();
        while(rs.next())
        {
            DoctorPojo e=new DoctorPojo();
            e.setUserid(rs.getString(1));
            e.setDoc_id(rs.getString(2));
             e.setQualification(rs.getString(3));
              e.setSpecialist(rs.getString(4));
               e.setActive(rs.getString(5).charAt(0));
                
               
            list.add(e);
           
        }
        return list;       
    }
    public static String getNewId() throws SQLException
    {
        Statement st = DBConnection.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select max(doctorid) from doctors");
        int id=1;
       rs.next();
            String empid=rs.getString(1);
            int eno=Integer.parseInt(empid.substring(3));
            id=id+eno;
        
        String sr="DOC"+id;
       // System.out.println(sr);
        return sr;
    }
    public static boolean addDoctor(UserPojo up,DoctorPojo dp) throws SQLException
    {
        PreparedStatement ps2=DBConnection.getConnection().prepareStatement("insert into users values(?,?,?,?,?)");
        ps2.setString(1,up.getUserid());
        ps2.setString(2,up.getUserName());
        ps2.setString(3,up.getEmpId());
        ps2.setString(4,up.getPassword());
        ps2.setString(5,up.getUserType());
        int i=ps2.executeUpdate();
        
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("insert into Doctors values(?,?,?,?,'Y')");
        ps.setString(1,dp.getUserid());
        ps.setString(2,dp.getDoc_id());
        ps.setString(3,dp.getQualification());
        ps.setString(4,dp.getSpecialist());
        int j=ps.executeUpdate();
        
        if(j==1)
            return true;
        else return false;
        
     }
    public static boolean deleteDoctor(String docid)throws SQLException{
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("update doctors set active='N'where doctorid=?");
        ps.setString(1,docid);
        int i=ps.executeUpdate();
        return i==1;
    }

public static HashMap<String, String> getRegisteredDoctorList()throws SQLException {
        Connection conn=DBConnection.getConnection();
         String qry="select doctorid,userid from doctors where Active='Y'";
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(qry);
        
        HashMap<String,String> doctor =new HashMap<>();
        while(rs.next())
        {
            String id=rs.getString(1);
            String name=rs.getString(2);
            doctor.put(id,name);
        }
        return doctor;
    }

   public static String getDocid(String userid) throws SQLException{
        
        
        PreparedStatement ps = DBConnection.getConnection().prepareStatement("select doctorid from doctors where userid=?");
        ps.setString(1,userid);
        ResultSet rs=ps.executeQuery();
       
        rs.next();
        
                       
       
        return rs.getString(1);       
    }
    
}