/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sanjeevani.Dao;

import Sanjeevani.dbutil.DBConnection;
import Sanjeevani.pojo.EmpPojo;
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
public class EmpDao {
    public static String getNewId()throws SQLException{
        Statement st = DBConnection.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select max(empid) from employees");
        int id=1;
       rs.next();
            String empid=rs.getString(1);
            int eno=Integer.parseInt(empid.substring(1));
            id=id+eno;
        
        String sr="E"+id;
        return sr;
        
    }
    public static boolean addEmployee(EmpPojo e)throws SQLException{
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("insert into employees values(?,?,?,?)");
        ps.setString(1,e.getEmpid());
        ps.setString(2,e.getEmpname());
        ps.setString(3,e.getJob().toUpperCase());
        ps.setDouble(4,e.getSal());
        int i=ps.executeUpdate();
        if (i>=1)
            return true;
        else
            return false;
              
    }
    public static ArrayList<EmpPojo> getAllEmp() throws SQLException {
        
        Statement st = DBConnection.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from employees");
        ArrayList<EmpPojo> emplist=new ArrayList<>();
        while(rs.next())
        {
            EmpPojo e=new EmpPojo();
            e.setEmpid(rs.getString(1));
            e.setEmpname(rs.getString(2));
            e.setJob(rs.getString(3));
            e.setSal(rs.getDouble(4));
            emplist.add(e);
        }
        return emplist;       
    }
    public static ArrayList<EmpPojo> getAllReceptionist() throws SQLException {
        
        Statement st = DBConnection.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from employees where role='RECEPTIONIST'");
        ArrayList<EmpPojo> emplist=new ArrayList<>();
        while(rs.next())
        {
            EmpPojo e=new EmpPojo();
            e.setEmpid(rs.getString(1));
            e.setEmpname(rs.getString(2));
            e.setJob(rs.getString(3));
            e.setSal(rs.getDouble(4));
            emplist.add(e);
        }
        return emplist;       
    }
    public static boolean removeEmp(String empid) throws SQLException
     {
         Connection con=DBConnection.getConnection();
            
                    PreparedStatement ps=con.prepareStatement("delete from users where empid=?");
                    ps.setString(1,empid);
                    int j=ps.executeUpdate();
                     //System.out.println(j);
                     
                     
                    PreparedStatement ps2=con.prepareStatement("delete from employees where empid=?");
                    ps2.setString(1,empid);
                    int l=ps2.executeUpdate();
                   // System.out.println(l);
                    
                    if(l>=1)return true;
                    else return false;
       
    }
     public static HashMap<String,String> getNonRegisteredReceptionistList() throws SQLException
     {
         Connection conn=DBConnection.getConnection();
         String qry="select empid,empname from employees where role='RECEPTIONIST' and empid not in (Select empid from users where usertype ='RECEPTIONIST')";
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
     public static boolean updateEmp(EmpPojo e)throws SQLException {
       PreparedStatement ps=DBConnection.getConnection().prepareStatement("Update employees set empname=?,sal=? where empid=?");
       
        ps.setString(1,e.getEmpname());
        ps.setDouble(2,e.getSal());
        ps.setString(3,e.getEmpid());
        
        int i=ps.executeUpdate();
        if(i>=1)
            return true;
        else 
            return false;
         
     }
     public static HashMap<String ,String> getEmpList() throws SQLException
     {
         Connection conn=DBConnection.getConnection();
         String qry="select empid,empname from employees";
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(qry);
        
        HashMap<String,String> employee =new HashMap<>();
        while(rs.next())
        {
            String id=rs.getString(1);
            String name=rs.getString(2);
            employee.put(id,name);
        }
        return employee;
     }

    public static HashMap<String, String> getNonRegisteredDoctorList() throws SQLException
    {
        Connection conn=DBConnection.getConnection();
         String qry="select empid,empname from employees where role='DOCTOR' and empid not in (Select empid from users where usertype ='DOCTOR')";
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

    
     
     
     
}
    