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

import pojo.Room;

/**
 *
 * @author Anand
 */
public class RoomsDao {
        
    public static int countRoom()throws SQLException{
        Connection conn=dbconnection.getConnection();
         Statement st=conn.createStatement();
         ResultSet rs=st.executeQuery("Select count(*) from Rooms");
         int k=0;
         while(rs.next())
         {
             k=rs.getInt(1);
         }
        return k; 
    }
       
         public static String[]  getRoomName()throws SQLException
    {
         Connection conn=dbconnection.getConnection();
        int k=countRoom();
        String []rooms=new String[k];

         Statement st=conn.createStatement();
         ResultSet rs=st.executeQuery("select room_name from rooms order by room_name");
         k=0;
         while(rs.next())
         {
            rooms[k++]=rs.getString(1);
         }
                  
        
        return rooms;
  }       
         
    public static int countSemClass()throws SQLException{
        Connection conn=dbconnection.getConnection();
         Statement st=conn.createStatement();
         ResultSet rs=st.executeQuery("Select count(*) from Semester");
         int k=0;
         while(rs.next())
         {
             k=rs.getInt(1);
         }
        return k; 
    }
    
    public static Room[]  getAllRooms()throws SQLException
    {
         Connection conn=dbconnection.getConnection();
         Statement st=conn.createStatement();
         ResultSet rs=st.executeQuery("Select count(room_id) from rooms");
         
         int k=0;
         while(rs.next())
         {
             k=rs.getInt(1);
         }
         Room []ra=new Room[k];
         st=conn.createStatement();
         rs=st.executeQuery("Select room_id,room_name,capacity from rooms");
         k=0;
         while(rs.next())
         {
             ra[k++]=new Room(rs.getInt(1),rs.getString(2),rs.getInt(3));
         }
                  
         return ra;
  }
    
    public static int  AddRoom(Room r)throws SQLException
    {
         Connection conn=dbconnection.getConnection();
        String select="insert into Rooms (Room_name,Capacity)  values(?,?) ";
        PreparedStatement ps =conn.prepareStatement(select);
        ps.setString(1,r.getRname());
        ps.setInt(2,r.getCap());
        int flag=ps.executeUpdate();
        //0 flase
        //1 true
        
           return flag;
  }    
    
        
    
}
