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
import pojo.Subject;

/**
 *
 * @author Anand
 */
public class SubjectDao {

  public static String getSubNameBySubCode(String subCode)throws SQLException{
         Connection conn=dbconnection.getConnection();
         String select="select subname from subjects where subcode=?";
        PreparedStatement ps =conn.prepareStatement(select);
        ps.setString(1,subCode);
        String sname="";
        ResultSet rs=ps.executeQuery();
        if(rs.next())
        {
            sname=rs.getString(1);
            
        }
    return sname;
    }
    
    public static int  getSidBySubCode(String subCode)throws SQLException
    {
         Connection conn=dbconnection.getConnection();
         String select="select sid from subjects where subcode=?";
        PreparedStatement ps =conn.prepareStatement(select);
        ps.setString(1,subCode);
        int k=0;
        ResultSet rs=ps.executeQuery();
        if(rs.next())
        {
            k=rs.getInt(1);
            
        }
    return k;
    }
        


    public static String[]  getSubCodesBySem(int sem)throws SQLException
    {
         Connection conn=dbconnection.getConnection();
         String select="select count(subcode) from subjects where sem=?";
        PreparedStatement ps =conn.prepareStatement(select);
        ps.setInt(1,sem);
        int k=0;
        ResultSet rs=ps.executeQuery();
        if(rs.next())
        {
            k=rs.getInt(1);
            
        }
        String []sub=new String[k];

         Statement st=conn.createStatement();
         rs=st.executeQuery("select subcode,subname from subjects where sem="+sem+" order by subname");
         k=0;
         while(rs.next())
         {
            sub[k++]=rs.getString(1)+" "+rs.getString(2);
         }
                  
        
        return sub;
  }
        
        
        public static int countSubject()throws SQLException{
        Connection conn=dbconnection.getConnection();
         Statement st=conn.createStatement();
         ResultSet rs=st.executeQuery("Select count(subcode) from subjects");
         int k=0;
         while(rs.next())
         {
             k=rs.getInt(1);
         }
        return k; 
    }
    
    
    public static int countFreeSubject()throws SQLException{
        Connection conn=dbconnection.getConnection();
         Statement st=conn.createStatement();
         ResultSet rs=st.executeQuery("Select count(subcode) from subjects where subcode not in(select distinct subcode from module)");
         int k=0;
         while(rs.next())
         {
             k=rs.getInt(1);
         }
        return k; 
    }    
    
    
    
    public static Subject[]  getAllSubjects()throws SQLException
    {
         Connection conn=dbconnection.getConnection();
         Statement st=conn.createStatement();
         ResultSet rs=st.executeQuery("Select count(subcode) from subjects");
         
         int k=0;
         while(rs.next())
         {
             k=rs.getInt(1);
         }
         Subject []sa=new Subject[k];
         st=conn.createStatement();
         rs=st.executeQuery("Select subcode,subname,sem,lpw from Subjects order by sem");
         k=0;
         while(rs.next())
         {
             sa[k++]=new Subject(0,rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
         }
                  
         return sa;
  }
    
    public static int  AddSubject(Subject s)throws SQLException
    {
         Connection conn=dbconnection.getConnection();
        String select="insert into subjects (subcode,subname,sem,lpw)  values(?,?,?,?) ";
        PreparedStatement ps =conn.prepareStatement(select);
        ps.setString(1,s.getSubCode());
        ps.setString(2,s.getSubName());
        ps.setInt(3,s.getSem());
        ps.setInt(4,s.getLpw());
        int flag=ps.executeUpdate();
        //0 flase
        //1 true
        
           return flag;
  }    
    
    
}
