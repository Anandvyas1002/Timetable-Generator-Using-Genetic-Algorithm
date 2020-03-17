/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimetableGA;

/**
 *
 * @author Anand
 */
public class Course {
    	private final int courseId;
	private final String courseCode;
	private final String course;
	private final int professorIds[];

	public Course(int courseId, String courseCode, String course, int professorIds[]) {
		this.courseId = courseId;
		this.courseCode = courseCode;
		this.course = course;
		this.professorIds = professorIds;
	}

	
	public int getcourseId() {
		return this.courseId;
	}

	
	public String getcourseCode() {
		return this.courseCode;
	}

	public String getcourseName() {
		return this.course;
	}

	public int getRandomProfessorId() {
		int professorId = professorIds[(int) (professorIds.length * Math.random())];
		return professorId;
	}
    
}
