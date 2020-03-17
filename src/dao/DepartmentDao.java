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
import pojo.Department;

/**
 *
 * @author Anand
 */
public class DepartmentDao {
    
        public static Department[]  getAllLectures()throws SQLException
    {
         Connection conn=dbconnection.getConnection();
         Statement st=conn.createStatement();
         ResultSet rs=st.executeQuery("Select count(*) from module");
 
         int k=0;
         while(rs.next())
         {
             k=rs.getInt(1);
         }
         Department []da=new Department[k];
         st=conn.createStatement();
         rs=st.executeQuery("Select subcode,fid,sem from module order by mid");
         k=0;
         while(rs.next())
         {
             da[k++]=new Department(0,0,rs.getString(1),rs.getInt(2),rs.getInt(3));
         }
                  
         return da;
  }
    
      
    public static int  AddLecture(Department d)throws SQLException
    {
         Connection conn=dbconnection.getConnection();
        String select="insert into module (mid,subcode,fid,sem)  values(?,?,?,?) ";
        PreparedStatement ps =conn.prepareStatement(select);
        ps.setInt(1,d.getMid());
        ps.setString(2,d.getSubCode());
        ps.setInt(3,d.getFid());
        ps.setInt(4,d.getSem());
        int flag=ps.executeUpdate();
        //0 flase
        //1 true
        
           return flag;
  }    
    
  
    
    public static int[] getSemester() throws SQLException{
         Connection conn=dbconnection.getConnection();
         Statement st=conn.createStatement();
         ResultSet rs=st.executeQuery("Select count(distinct sem) from semester");
 
         int k=0;
         while(rs.next())
         {
             k=rs.getInt(1);
         }
         int []sem=new int[k];
         st=conn.createStatement();
         rs=st.executeQuery("Select distinct sem from semester order by sem");
         k=0;
         while(rs.next())
         {
             sem[k++]=rs.getInt(1);
         }
                  
         return sem;        
        
    }
}
