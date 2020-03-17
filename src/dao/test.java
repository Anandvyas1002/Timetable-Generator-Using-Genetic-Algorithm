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

/**
 *
 * @author Anand
 */
public class test {
    public static void main(String[] args)throws SQLException {
        Connection conn=dbconnection.getConnection();
         String Qry="Select semid,capacity,sem from semester where sem=7";
         Statement st=conn.createStatement();
         ResultSet rs=st.executeQuery(Qry);
       
        while(rs.next())
        { 
        	       	  int sid=rs.getInt(1);
    	  int cap=rs.getInt(2);
    	  int sem=rs.getInt(3);

    	  String q2="select sum(lecture_per_week) from subject where sem="+sem;
    	  Statement s2=conn.createStatement();
    	  ResultSet r2=s2.executeQuery(q2);
    	  r2.next();
    	  int s=r2.getInt(1);
    	 
    	  int ar[]=new int[s];
    	  
    	  q2="select distinct s.sub_code,s.lecture_per_week,d.detail_id from subject s,dept_details d where s.sub_code=d.sub_code and s.sem ="+sem;
    	  s2=conn.createStatement();
    	  r2=s2.executeQuery(q2);
    	  int k=0;
    	  
    	  
    	  while(r2.next()) {
    		  int lpw=r2.getInt(2);
    		  int mid=r2.getInt(3);
    		  for(int i=0;i<lpw;i++) {
    			  ar[k++]=mid;
    		  }
    	  }
          for(int x: ar){
              System.out.print(x+" ");
          }
    	       System.out.println("");
    	  System.out.println(sid+" "+cap);
  			
        }
		
    }
    
}
