/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sanjeevani.Dao;

import Sanjeevani.dbutil.DBConnection;
import Sanjeevani.pojo.PatientPojo;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Deepak Patidar
 */
public class PatientDao {
    public static boolean addPatient(PatientPojo e) throws SQLException
   {
       PreparedStatement ps=DBConnection.getConnection().prepareStatement("insert into patient values(?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1,e.getP_id());
        ps.setString(2,e.getF_name());
        ps.setString(3,e.getS_name());
        ps.setInt(4,e.getAge());
        ps.setString(5,e.getOpd());
        ps.setString(6,e.getGender());
        ps.setString(7,e.getM_status());
        ps.setDate(8,e.getP_date());
        ps.setString(9,e.getAddress());
        ps.setString(10,e.getCity());
        ps.setString(11,e.getPhone_no());
        ps.setString(12,e.getDoctor_id());
        int re=ps.executeUpdate();
        return re==1;
   }
    public static String getNewId() throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select max(p_id) from patient");
        int id=1;
        if(rs.next()){
            String empid=rs.getString(1);
            //System.out.println(empid.substring(1));
            
            int eno=Integer.parseInt(empid.substring(1));
            id=id+eno;
            String sr="P"+id;
            return sr;
        }
        else
            return "P101";
        
    }
    public static ArrayList<PatientPojo> getAllPatients() throws SQLException {
        
        Statement st = DBConnection.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from patient");
        ArrayList<PatientPojo> list=new ArrayList<>();
        while(rs.next())
        {
            PatientPojo e=new PatientPojo();
            e.setP_id(rs.getString(1));
            e.setF_name(rs.getString(2));
             e.setS_name(rs.getString(3));
              e.setOpd(rs.getString(5));
               e.setGender(rs.getString(6));
                e.setM_status(rs.getString(7));
                 e.setAddress(rs.getString(9));
                  e.setCity(rs.getString(10));
                   e.setPhone_no(rs.getString(11));
             e.setDoctor_id(rs.getString(12));
              e.setAge(rs.getInt(4));
               e.setP_date(rs.getDate(8));
               
            list.add(e);
           
        }
        return list;       
    }

    public static boolean updatePatient(PatientPojo e)throws SQLException {
        
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("update pat"
                + "ient set p_id=?,f_name=?,s_name=?,age=?,opd=?,gender=?,m_status=?,p_date=?"
                + ",address=?,city=?,phone_no=?,doctor_id=? where p_id=?");
        ps.setString(1,e.getP_id());
        ps.setString(2,e.getF_name());
        ps.setString(3,e.getS_name());
        ps.setInt(4,e.getAge());
        ps.setString(5,e.getOpd());
        ps.setString(6,e.getGender());
        ps.setString(7,e.getM_status());
        ps.setDate(8,e.getP_date());
        ps.setString(9,e.getAddress());
        ps.setString(10,e.getCity());
        ps.setString(11,e.getPhone_no());
        ps.setString(12,e.getDoctor_id());
        ps.setString(13,e.getP_id());
        int re=ps.executeUpdate();
        return re==1;
    }

    public static ArrayList<String> getAllPatientId() throws SQLException{
        Statement st=DBConnection.getConnection().createStatement();
        ResultSet re=st.executeQuery("select P_ID from patient");
        ArrayList<String>pids=new ArrayList<>();
        while(re.next())
        {
            pids.add(re.getString(1));
        }
        return pids;
    }

    public static PatientPojo getPatientData(String pid) throws SQLException {
        PreparedStatement ps = DBConnection.getConnection().prepareStatement("select * from patient where P_ID =?");
        ps.setString(1,pid);
        ResultSet rs=ps.executeQuery();
       // System.out.println(pid);
        rs.next();
        PatientPojo e=new PatientPojo();
        
            
            e.setP_id(rs.getString(1));
            e.setF_name(rs.getString(2));
             e.setS_name(rs.getString(3));
              e.setOpd(rs.getString(5));
               e.setGender(rs.getString(6));
                e.setM_status(rs.getString(7));
                 e.setAddress(rs.getString(9));
                  e.setCity(rs.getString(10));
                   e.setPhone_no(rs.getString(11));
             e.setDoctor_id(rs.getString(12));
              e.setAge(rs.getInt(4));
               e.setP_date(rs.getDate(8));
                       
        //System.out.println(e);
        return e;       
    }

    public static boolean removePatient(String str) throws SQLException{
        Connection con=DBConnection.getConnection();
            
                    PreparedStatement ps=con.prepareStatement("delete from patient where p_id=?");
                    ps.setString(1,str);
                    int j=ps.executeUpdate();
                     return j==1;
    }

    public static HashMap<String, String> getPatientsList() throws SQLException{
        Connection conn=DBConnection.getConnection();
         String qry="select p_id,F_name from patient";
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(qry);
        
        HashMap<String,String> patients =new HashMap<>();
        while(rs.next())
        {
            String id=rs.getString(1);
            String name=rs.getString(2);
            patients.put(id,name);
        }
        return patients;
     
    }

    public static ArrayList<PatientPojo> getPatientOf(String docid)throws SQLException {
         PreparedStatement ps=DBConnection.getConnection().prepareStatement("select * from patient where doctor_id=?");
         ps.setString(1, docid);
         ResultSet rs=ps.executeQuery();
        ArrayList<PatientPojo> list=new ArrayList<>();
        while(rs.next())
        {
            PatientPojo e=new PatientPojo();
            e.setP_id(rs.getString(1));
            e.setF_name(rs.getString(2));
             e.setS_name(rs.getString(3));
              e.setOpd(rs.getString(5));
               e.setGender(rs.getString(6));
                e.setM_status(rs.getString(7));
                 e.setAddress(rs.getString(9));
                  e.setCity(rs.getString(10));
                   e.setPhone_no(rs.getString(11));
             e.setDoctor_id(rs.getString(12));
              e.setAge(rs.getInt(4));
               e.setP_date(rs.getDate(8));
               
            list.add(e);
           
        }
        return list;       
    
    }
    
}
