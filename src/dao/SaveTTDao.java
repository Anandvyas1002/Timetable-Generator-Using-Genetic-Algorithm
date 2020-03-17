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
import pojo.SaveTT;

/**
 *
 * @author Anand
 */
public class SaveTTDao {
    public static void addTT(SaveTT tt) throws SQLException{
         Connection conn=dbconnection.getConnection();
        String select="insert into timetable (class_id,sub_name,sem,batch,room_name,fac_name,day_no,slot_no)  values(?,?,?,?,?,?,?,?) ";
        PreparedStatement ps =conn.prepareStatement(select);
        ps.setInt(1,tt.getClassid());
        ps.setString(2,tt.getSubName());
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select sem,batch from semester where semid="+tt.getGroup());
    int sem=0;
    String batch="";
    while(rs.next()) {
                            sem=rs.getInt(1);
                                batch=rs.getString(2);
            }
        ps.setInt(3,sem);
        ps.setString(4,batch);
        ps.setString(5,tt.getrName());
        ps.setString(6,tt.getfName());
         st=conn.createStatement();
         rs=st.executeQuery("select day_no,slot_no from timeslot where id="+tt.getTime());
    int dn=0,sn=0;
    while(rs.next()) {
                            dn=rs.getInt(1);
                                sn=rs.getInt(2);
            }
        ps.setInt(7,dn);
        ps.setInt(8,sn);
        
        int flag=ps.executeUpdate();
        
}
    
    public static void deleteTimeTables() throws SQLException{
                Connection conn=dbconnection.getConnection();
         Statement st=conn.createStatement();
         st.executeUpdate("delete  from timetable");
     
    }
    
    
}
