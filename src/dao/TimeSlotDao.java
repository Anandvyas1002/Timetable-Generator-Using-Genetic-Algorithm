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
import pojo.TimeSlotData;

/**
 *
 * @author Anand
 */
public class TimeSlotDao {
    
        public static String[]  getTs()throws SQLException
    {
         Connection conn=dbconnection.getConnection();
                  Statement st=conn.createStatement();
         String select="select count(distinct time) from timeslot order by time";
        int k=0;
        ResultSet rs=st.executeQuery(select);
        if(rs.next())
        {
            k=rs.getInt(1);
            
        }
        String []ts=new String[k];

         st=conn.createStatement();
         rs=st.executeQuery("select distinct time from timeslot order by time");
         k=0;
         while(rs.next())
         {
            ts[k++]=rs.getString(1);
         }
                  
        
        return ts;
  }
        
    
    public static void addTimeSlot(TimeSlotData ts) throws SQLException{
                Connection conn=dbconnection.getConnection();
        String select="insert into timeslot (id,day_no,slot_no,day_name,time)  values(?,?,?,?,?) ";
        PreparedStatement ps =conn.prepareStatement(select);
        ps.setInt(1,ts.getId());
        ps.setInt(2,ts.getDayNo());
        ps.setInt(3,ts.getSlotNo());
        ps.setString(4,ts.getDay());
        ps.setString(5,ts.getTime());
        int flag=ps.executeUpdate();
        //0 flase
        //1 true
        
        
    }
    public static void deleteTimeSlots() throws SQLException{
                Connection conn=dbconnection.getConnection();
         Statement st=conn.createStatement();
         st.executeUpdate("delete  from timeslot");
     
    }
    
}
