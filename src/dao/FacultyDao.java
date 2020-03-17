/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbutil.dbconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import pojo.Faculty;

/**
 *
 * @author Anand
 */
public class FacultyDao {
    

    public static String[]  getFaculty()throws SQLException
    {
         Connection conn=dbconnection.getConnection();
        int k=countFaculty();
        String []fac=new String[k];

         Statement st=conn.createStatement();
         ResultSet rs=st.executeQuery("select faculty_id,fname,lname from Faculty order by fname");
         k=0;
         while(rs.next())
         {
            fac[k++]=rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3);
         }
                  
        
        return fac;
  }
     public static String[]  getFacultyName()throws SQLException
    {
         Connection conn=dbconnection.getConnection();
        int k=countFaculty();
        String []fac=new String[k];

         Statement st=conn.createStatement();
         ResultSet rs=st.executeQuery("select fname,lname from Faculty order by fname");
         k=0;
         while(rs.next())
         {
            fac[k++]=rs.getString(1)+" "+rs.getString(2);
         }
                  
        
        return fac;
  }       
    
    public static int countFaculty()throws SQLException{
        Connection conn=dbconnection.getConnection();
         Statement st=conn.createStatement();
         ResultSet rs=st.executeQuery("Select count(*) from Faculty");
         int k=0;
         while(rs.next())
         {
             k=rs.getInt(1);
         }
        return k; 
    }

    public static int countFreeFaculty()throws SQLException{
        Connection conn=dbconnection.getConnection();
         Statement st=conn.createStatement();
         ResultSet rs=st.executeQuery("Select count(faculty_id) from Faculty where faculty_id not in(select distinct fid from module)");
         int k=0;
         while(rs.next())
         {
             k=rs.getInt(1);
         }
        return k; 
    }    
    
    
  public static String getFacNameByFacCode(int fcode)throws SQLException{
         Connection conn=dbconnection.getConnection();
         String select="select fname,lname from faculty where faculty_id=?";
        PreparedStatement ps =conn.prepareStatement(select);
        ps.setInt(1,fcode);
        String fname="";
        ResultSet rs=ps.executeQuery();
        if(rs.next())
        {
            fname=rs.getString(1)+" "+rs.getString(2);
            
        }
    return fname;
    }
    
    public static Faculty[]  getAllFaculty()throws SQLException
    {
         Connection conn=dbconnection.getConnection();
         Statement st=conn.createStatement();
         ResultSet rs=st.executeQuery("Select count(faculty_id) from faculty");
 
         int k=0;
         while(rs.next())
         {
             k=rs.getInt(1);
         }
         Faculty []fa=new Faculty[k];
         st=conn.createStatement();
         rs=st.executeQuery("Select faculty_id,fname,lname,email from faculty");
         k=0;
         while(rs.next())
         {
             fa[k++]=new Faculty(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
         }
                  
         return fa;
  }
    
    public static int  AddFaculty(Faculty f)throws SQLException
    {
         Connection conn=dbconnection.getConnection();
        String select="insert into faculty (fname,lname,email,password)  values(?,?,?,?) ";
        PreparedStatement ps =conn.prepareStatement(select);
        ps.setString(1,f.getFname());
        ps.setString(2,f.getLname());
        ps.setString(3,f.getEmail());
        ps.setString(4,f.getPassword());

        int flag=ps.executeUpdate();
        //0 flase
        //1 true
        
           return flag;
  }    
    
    
}
