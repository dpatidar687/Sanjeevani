package Sanjeevani.dbutil;

import java.sql.*;
import javax.swing.JOptionPane;

public class DBConnection
{
    private static Connection conn;
    static{
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            conn=DriverManager.getConnection("jdbc:oracle:thin:@//DeepakLenovo:1900/xe","myhms","student");
            JOptionPane.showMessageDialog(null,"connection done successfully");
        }
        catch(ClassNotFoundException cnfe)
        {
            JOptionPane.showMessageDialog(null,"Cannot load Driver"+cnfe);
            cnfe.printStackTrace();
        }
        catch (SQLException sqlex)
        {
            JOptionPane.showMessageDialog(null,"problem in DB!"+sqlex);
            sqlex.printStackTrace();
        }
        
    }
    public static Connection getConnection()
    {
        return conn;
    }
    public static void closeConnection()
    {
        try{
            if(conn!=null){
            conn.close();
            JOptionPane.showMessageDialog(null,"connection closed successfully");
            }
        }
        catch (SQLException sqlex){
            JOptionPane.showMessageDialog(null,"problem in closing connection"+sqlex);
            sqlex.printStackTrace();
        }
    }
}

