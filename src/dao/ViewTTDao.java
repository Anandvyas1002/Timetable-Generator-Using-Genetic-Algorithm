/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbutil.dbconnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import pojo.viewTimetable;


/**
 *
 * @author Anand
 */
public class ViewTTDao {
    public static viewTimetable  getSemTTData(int d,int s,int sem,String batch)throws SQLException
    {
         Connection conn=dbconnection.getConnection();
         Statement st=conn.createStatement();
         String s2="Select sub_name,sem,batch,room_name,fac_name,day_no,slot_no from timetable where sem="+sem+" and batch='"+batch+"' and day_no="+d+" and slot_no="+s;
//         ResultSet rs=st.executeQuery("Select sub_name,sem,batch,room_name,fac_name,day_no,slot_no  from timetable where sem="+sem+" and batch="+batch+" and day_no="+d+" and slot_no="+s);
         ResultSet rs=st.executeQuery(s2);
         viewTimetable tt=null;
         int k=0;
         while(rs.next())
         {
             tt=new viewTimetable(rs.getString(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7));
      }
   
       
                  
         return tt;
  }

public static viewTimetable  getFacTTData(int d,int s,String facname)throws SQLException
    {
         Connection conn=dbconnection.getConnection();
         Statement st=conn.createStatement();
         String s2="Select sub_name,sem,batch,room_name,fac_name,day_no,slot_no from timetable where fac_name='"+facname+"' and day_no="+d+" and slot_no="+s;
//         ResultSet rs=st.executeQuery("Select sub_name,sem,batch,room_name,fac_name,day_no,slot_no  from timetable where sem="+sem+" and batch="+batch+" and day_no="+d+" and slot_no="+s);
         ResultSet rs=st.executeQuery(s2);
         viewTimetable tt=null;
         int k=0;
         while(rs.next())
         {
             tt=new viewTimetable(rs.getString(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7));
      }
   
       
                  
         return tt;
  }
public static viewTimetable  getRoomTTData(int d,int s,String roomname)throws SQLException
    {
         Connection conn=dbconnection.getConnection();
         Statement st=conn.createStatement();
         String s2="Select sub_name,sem,batch,room_name,fac_name,day_no,slot_no from timetable where room_name='"+roomname+"' and day_no="+d+" and slot_no="+s;
//         ResultSet rs=st.executeQuery("Select sub_name,sem,batch,room_name,fac_name,day_no,slot_no  from timetable where sem="+sem+" and batch="+batch+" and day_no="+d+" and slot_no="+s);
         ResultSet rs=st.executeQuery(s2);
         viewTimetable tt=null;
         int k=0;
         while(rs.next())
         {
             tt=new viewTimetable(rs.getString(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7));
      }
   
         return tt;
  }

    
    
}
