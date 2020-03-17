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
import pojo.User;

/**
 *
 * @author Anand
 */
public class UserDao {
    
    public static String validateUser(User user)throws SQLException
    {
         
       Connection conn=dbconnection.getConnection();
        String select="select fname,lname from faculty where email=? and password=? ";
        PreparedStatement ps =conn.prepareStatement(select);
        ps.setString(1,user.getUserid());
        ps.setString(2,user.getPassword());
        
        ResultSet rs=ps.executeQuery();
        String userName=null;

        if(rs.next())
        {
            userName=rs.getString(1)+" "+rs.getString(2);
            
        }
        
           return userName;
    }
    
}
