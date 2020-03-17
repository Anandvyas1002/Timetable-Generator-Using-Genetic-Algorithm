/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimetableGA;

import dao.SaveTTDao;
import dao.TimeSlotDao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.swing.UnsupportedLookAndFeelException;

import dbutil.dbconnection;
import pojo.SaveTT;
import pojo.TimeSlotData;
/**
 *
 * @author Anand
 */
public class GenerateGeneticTT {
	public  String getTT()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException ,SQLException{
		
		Timetable timetable = createTimetable();
	
		GeneticAlgorithm ga = new GeneticAlgorithm(100, 0.01, 0.9, 2, 5);
	
		Population population = ga.initPopulation(timetable);
		
		ga.evalPopulation(population, timetable);
		int generation = 1;

		while (ga.isTerminationConditionMet(generation, 1000) == false && ga.isTerminationConditionMet(population) == false) {
			Individual[] individuals = population.getIndividuals();
			System.out.println("***************Generation" + generation + "***************");
			int i = 1;
			for (Individual individual : individuals) {
				System.out.println("Chromosome no." + i + ": " + individual.getFitness());
				System.out.println(individual.toString() + "\n");
				i++;
			}
			timetable.createClasses(population.getFittest(0));
			System.out.println("G" + generation + " Best fitness: " + population.getFittest(0).getFitness());
			System.out.println("Clashes: " + timetable.calcClashes());
			population = ga.crossoverPopulation(population);
			population = ga.mutatePopulation(population, timetable);
			ga.evalPopulation(population, timetable);
			generation++;
		}
		System.out.println("******************************Generation" + generation + "******************************");
		int i = 1;
		Individual[] individuals = population.getIndividuals();
		for (Individual individual : individuals) {
			System.out.println("Chromosome no." + i + ": " + individual.getFitness());
			System.out.println(individual.toString() + "\n");
			i++;
		}
		// ´òÓ¡×îºó½á¹û£¬°üÀ¨½ø»¯´úÊýÓë×îÖÕÊÊÅäÖµfinal fitness£¬³åÍ»´ÎÊýclashes
		timetable.createClasses(population.getFittest(0));
		System.out.println();
		System.out.println("Solution found in " + generation + " generations");
		System.out.println("Final solution fitness: " + population.getFittest(0).getFitness());
		System.out.println("Clashes: " + timetable.calcClashes());
		// Êä³ö¿Î³Ì±í
                                         int c=timetable.calcClashes();
		System.out.println();
		Class classes[] = timetable.getClasses();
		int classIndex = 1;

//		Group[] groups = timetable.getGroupsAsArray();
//		HashMap<Integer, TimetableWin> winds = new HashMap<Integer, TimetableWin>();
//		for (Group group : groups) {
//			TimetableWin timetableWin = new TimetableWin();
//			timetableWin.setTitle(timetableWin.getTitle() + " Group-" + group.getGroupId());
//			winds.put(group.getGroupId(), timetableWin);
//		}
                SaveTTDao.deleteTimeTables();
		for (Class bestClass : classes) {
                    try{
			System.out.println("Class " + classIndex + ":");
			System.out.println("Course: " + timetable.getModule(bestClass.getModuleId()).getcourseName());
			int groupId = timetable.getGroup(bestClass.getGroupId()).getGroupId();
			System.out.println("Group: " + groupId);
			System.out.println("Room: " + timetable.getRoom(bestClass.getRoomId()).getRoomNumber());
			System.out.println("Lecturer: " + timetable.getlecturer(bestClass.getlecturerId()).getLecturerName());
                                                            int tsId=bestClass.getTimeslotId();
                                                            System.out.println(bestClass.getTimeslotId()+"Time: "+ timetable.getTimeslot(bestClass.getTimeslotId()).getTimeslot());
                                                               SaveTT data=new SaveTT(classIndex,timetable.getModule(bestClass.getModuleId()).getcourseName(),groupId,timetable.getRoom(bestClass.getRoomId()).getRoomNumber(),timetable.getlecturer(bestClass.getlecturerId()).getLecturerName(),tsId);
                                                               SaveTTDao.addTT(data);
//			winds.get(groupId).fillClass(bestClass, timetable);
			System.out.println("-----");
			classIndex++;
                    }catch(Exception e){
                        System.out.println("=================="+e.getMessage());
                    }
                    
                    }
                return generation+"/"+c;
	}
private  Timetable createTimetable() throws SQLException {
		// Create timetable
		Timetable timetable = new Timetable();
		// Set up rooms
		
		Connection conn=dbconnection.getConnection();
        String Qry="Select room_id,room_name,capacity from rooms";
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(Qry);
        while(rs.next())
        { 
        	timetable.addRoom(rs.getInt(1),rs.getString(2),rs.getInt(3));
        }
		
		// Set up timeslots
		// ÏÂÃæ²ÎÊýÎªÊä³öÍ¼ÐÎ½çÃæµÄÄ¬ÈÏÅäÖÃ£¬Èç¹ûÐÞ¸Ä£¬¿ÉÒÔ²Î¿¼ÃüÁîÐÐµÄÊä³ö
		String[] days = { "Mon", "Tue", "Wed", "Thu", "Fri"};
                                          String[] slots = { "09:00 - 10:00", "10:00 - 11:00", "11:00 - 12:00", "13:00 - 14:00", "14:00 - 15:00","15:00 - 16:00"};  
                                          int totalDays=days.length;
                                          int totalSlots=slots.length;
                                          TimeSlotDao.deleteTimeSlots();
		for (int i = 0; i < totalDays; i++) {
                                                    for(int j=0;j<totalSlots;j++){
                                                              timetable.addTimeslot((j+1) + i * totalSlots, days[i] + slots[j]);  
                                                              TimeSlotData ts=new TimeSlotData((j+1) + i * totalSlots, i+1,j+1,days[i] , slots[j]);
                                                              TimeSlotDao.addTimeSlot(ts);
                                                    }
//			timetable.addTimeslot(1 + i * 6, days[i] + "/9:00 - 10:00");
//			timetable.addTimeslot(2 + i * 6, days[i] + "/10:00 - 11:00");
//			timetable.addTimeslot(3 + i * 6, days[i] + "/11:00 - 12:00");
//			// ÖÐÎçÐÝÏ¢Ê±¼äÕâÀïÉèÖÃÎª12:00-13:00 -¡·µ±È»ÕâÀï¿ÉÒÔ¸ù¾ÝÐèÇóµ÷Õû
//			timetable.addTimeslot(4 + i * 6, days[i] + "/13:00 - 14:00");
//			timetable.addTimeslot(5 + i * 6, days[i] + "/14:00 - 15:00");
//			timetable.addTimeslot(6 + i * 6, days[i] + "/15:00 - 16:00");
		}
		// Set up lecturers
		Qry="select faculty_id,fname,lname from faculty";
		st=conn.createStatement();
		rs=st.executeQuery(Qry);
		while(rs.next()) {
			timetable.addlecturer(rs.getInt(1), rs.getString(2)+" "+rs.getString(3));
		}
		
		// Set up modules and define the lecturers that teach them
		
		Qry="select subcode,subname from subjects";
		st=conn.createStatement();
		rs=st.executeQuery(Qry);
		while(rs.next()) {
			String scode=rs.getString(1);
			String sname=rs.getString(2);
//			System.out.println(scode+" "+sname);
			String Qry2="select count(m.fid) from module m where m.subcode='"+scode+"'";
	        Statement st2=conn.createStatement();
	        ResultSet rs2=st2.executeQuery(Qry2);
	        int n=0;
	        while(rs2.next()) {
	        	n=rs2.getInt(1);
	        }
//	        System.out.println(n);
	        int ar[]=new int[n];
	      
			Qry2="select m.mid,m.fid from module m where m.subcode='"+scode+"'";
	        st2=conn.createStatement();
	        rs2=st2.executeQuery(Qry2);
	        int k=0,mid=0;
	        while(rs2.next()) {
	        	mid=rs2.getInt(1);
	        	ar[k++]=rs2.getInt(2);
	        }
	        timetable.addModule(mid,scode , sname, ar);
			
		}
//		=======
// Set up student groups and the modules they take.
// the first argument GroupID stands for different grousp of students, for example, IOT students take different courses from SE students
		
	Qry="select semid,sem,capacity from semester where sem in(select distinct sem from module )";
	st=conn.createStatement();
	rs=st.executeQuery(Qry);
	while(rs.next()) {
                        int semid=rs.getInt(1);
                        int sem=rs.getInt(2);
                        int cap=rs.getInt(3);
                        String Qry2="select sum(s.lpw) from subjects s where s.sem="+sem+" and s.sid in (select distinct mid from module where sem="+sem+")";
	        Statement st2=conn.createStatement();
	        ResultSet rs2=st2.executeQuery(Qry2);
	        int n=0;
	        while(rs2.next()) {
	        	n=rs2.getInt(1);
	        }
//	        System.out.println(n);
	        int ar[]=new int[n];
	      
                            Qry2="select s.sid, s.lpw from subjects s where s.sem="+sem+" and s.sid in (select distinct mid from module where sem="+sem+")";
	        st2=conn.createStatement();
	        rs2=st2.executeQuery(Qry2);
	        int k=0,lpw=0,sid=0;
	        while(rs2.next()) {
	        	sid=rs2.getInt(1);
	        	lpw=rs2.getInt(2);
	        	for(int i=0;i<lpw;i++) {
	        		ar[k++]=sid;
	        	}
	        }
                
	    	timetable.addGroup(semid, cap, ar);
	    				
		}
		
		return timetable;
	}    
    
}
