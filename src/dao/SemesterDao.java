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
import pojo.Semester;

/**
 *
 * @author Anand
 */
public class SemesterDao {
    public static Semester[]  getAllSemester()throws SQLException
    {
         Connection conn=dbconnection.getConnection();
         Statement st=conn.createStatement();
         ResultSet rs=st.executeQuery("Select count(id) from Semester");
         
         int k=0;
         while(rs.next())
         {
             k=rs.getInt(1);
         }
         Semester []sa=new Semester[k];
         st=conn.createStatement();
         rs=st.executeQuery("Select semid,sem,batch,capacity from semester order by semid");
         k=0;
         while(rs.next())
         {
             sa[k++]=new Semester(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4));
         }
                  
         return sa;
  }
    
    public static int  AddSemester(Semester s)throws SQLException
    {
         Connection conn=dbconnection.getConnection();
        String select="insert into Semester (semid,sem,batch,Capacity)  values(?,?,?,?) ";
        PreparedStatement ps =conn.prepareStatement(select);
        ps.setInt(1,s.getSemid());
        ps.setInt(2,s.getSem());
        ps.setString(3,s.getBatch());
        ps.setInt(4,s.getCap());
        int flag=ps.executeUpdate();
        //0 flase
        //1 true
        
           return flag;
  }    
    
}
